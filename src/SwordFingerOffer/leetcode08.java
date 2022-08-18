package SwordFingerOffer;

import java.util.*;

/**
 * 剑指 Offer II 081. 允许重复选择元素的组合
 * 给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，找出 candidates 中所有可以使数字和为目标数 target 的唯一组合。
 *
 * candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是不同的。
 * 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。
 * 示例 1：
 *
 * 输入: candidates = [2,3,6,7], target = 7
 * 输出: [[7],[2,2,3]]
 * 示例 2：
 *
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 * 示例 3：
 *
 * 输入: candidates = [2], target = 1
 * 输出: []
 * 示例 4：
 *
 * 输入: candidates = [1], target = 1
 * 输出: [[1]]
 * 示例 5：
 *
 * 输入: candidates = [1], target = 2
 * 输出: [[1,1]]
 */
public class leetcode08 {
    public static void main(String[] args) {
        int []candidates=new int[]{2};
        int target=1;
        System.out.println(combinationSum(candidates, target));

    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        Deque<Integer> path=new LinkedList<>();
        Arrays.sort(candidates);
        int begin=0;
        int sum=0;
        backTrack(res,path,candidates,begin,target,sum);
        return res;

    }

    private static void backTrack(List<List<Integer>> res, Deque<Integer> path, int[] candidates, int begin, int target,int sum) {
          if(sum>target) {
              return;
          }
          if(sum==target){
              res.add(new ArrayList<>(path));
              return;
            }
        for (int i = begin; i <candidates.length ; i++) {
            path.add(candidates[i]);
            backTrack(res,path,candidates,i,target,sum+candidates[i]);
            path.removeLast();
        }
    }
}
