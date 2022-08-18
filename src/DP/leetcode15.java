package DP;

import java.util.Map;

public class leetcode15 {
    public static void main(String[] args) {
       int[] nums =new int[] {1,2,3};
        int res1 = rob(nums, 0, nums.length - 2);
        int res2 = rob(nums, 1, nums.length - 1);
        System.out.println(Math.max(res1,res2));


    }

    public static int rob(int[] nums,int left,int right) {
       int []dp=new int[nums.length];
       dp[left]=nums[left];
       dp[left+1]=Math.max(nums[left],nums[left+1]);
        for (int i = left+2; i <=right ; i++) {
                dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
       return  dp[right];
    }
}
