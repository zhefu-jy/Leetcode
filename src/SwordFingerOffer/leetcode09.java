package SwordFingerOffer;

import java.util.*;

/**
 * 剑指 Offer II 082. 含有重复元素集合的组合
 * 给定一个可能有重复数字的整数数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次，解集不能包含重复的组合。
 *
 *
 *
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
public class leetcode09 {
    public static void main(String[] args) {
        int []candidates=new int[]{10,1,2,7,6,1,5};
        int target=8;
        System.out.println(combinationSum2(candidates, target));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        Deque<Integer> path=new LinkedList<>();
        Arrays.sort(candidates);
        boolean []used=new boolean[candidates.length];
        int begin=0;
        int sum=0;
        backTrack(res,path,used,candidates,begin,target,sum);
        return res;

    }

    private static void backTrack(List<List<Integer>> res, Deque<Integer> path,  boolean []used,int[] candidates, int begin, int target, int sum) {
        if(sum>target) {
            return;
        }
        if(sum==target && !res.contains(path)){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i <candidates.length ; i++) {
            if(used[i]){
                continue;
            }
            used[i]=true;
            path.add(candidates[i]);
            backTrack(res,path,used,candidates,i,target,sum+candidates[i]);
            path.removeLast();
            used[i]=false;
        }
    }
}
