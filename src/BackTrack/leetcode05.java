package BackTrack;

import java.util.*;

/**
 * 40. 组合总和 II
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 *
 * 注意：解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 *
 *
 * 提示:
 *
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 */
public class leetcode05 {
    public static void main(String[] args) {
        int []candidates=new int[]{10,1,2,7,6,1,5};
        int target=8;
        List<List<Integer>>  res=new ArrayList<>();
        Deque<Integer> path=new LinkedList<>();
        Arrays.sort(candidates);
        int sum=0;
        int index=0;
        backTrack(res,path,candidates,target,sum,index);
        System.out.println(res);



}
    public static void backTrack(List<List<Integer>>  res, Deque<Integer> path, int []candidates, int target, int sum, int index){
        if(sum==target && !res.contains(path)) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i <candidates.length ; i++) {
            if(sum+candidates[i]>target){
                break;
            }
            path.add(candidates[i]);
            backTrack(res,path,candidates,target,sum+candidates[i],i+1);
            path.removeLast();
        }

    }
}
