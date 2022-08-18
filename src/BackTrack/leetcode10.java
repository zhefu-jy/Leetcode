package BackTrack;

import java.util.*;

/**
 * 491. 递增子序列
 * 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
 *
 * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [4,6,7,7]
 * 输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
 * 示例 2：
 *
 * 输入：nums = [4,4,3,2,1]
 * 输出：[[4,4]]
 */
public class leetcode10 {
    public static void main(String[] args) {
        int []nums=new int[]{4,6,7,7};
        List<List<Integer>> res=new ArrayList<>();
        Deque<Integer> path=new LinkedList<>();
        int begin=0;
        backTrack(res,path,begin,nums);

        System.out.println(res);
    }

    private static void backTrack(List<List<Integer>> res, Deque<Integer> path, int begin, int[] nums) {
        if(path.size()>=2){
            res.add(new ArrayList<>(path));
        }
        int[] used = new int[201];
        for (int i = begin; i <nums.length ; i++) {
            if(!path.isEmpty() && nums[i]<path.getLast() || used[nums[i]+100]==1)
            {
                continue;
            }
            used[nums[i]+100]=1;
            path.add(nums[i]);
            backTrack(res,path,i+1,nums);
            path.removeLast();

        }

    }
}
