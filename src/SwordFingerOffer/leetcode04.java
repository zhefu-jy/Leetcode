package SwordFingerOffer;

import java.util.Arrays;

/**
 * 剑指 Offer II 119. 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 示例 1：
 *
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 *
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 */
public class leetcode04 {
    public static void main(String[] args) {
        int []nums=new int[]{100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));

    }
    public static int longestConsecutive(int[] nums) {
         int []dp=new int[nums.length];
         int max=Integer.MIN_VALUE;
         Arrays.sort(nums);
         dp[0]=1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]==nums[i-1]+1){
                dp[i]=dp[i-1]+1;
                max=Math.max(dp[i],max);
            }else if(nums[i]==nums[i-1]){
                dp[i]=dp[i-1];
            }
            else{
                dp[i]=1;
            }
        }
        return max;

    }
}
