package DP;
/**
 * @Date: 2022/8/4 9:07
 * @Author: ZheFu
 *718. 最长重复子数组
 * 给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
 * 示例 1：
 *
 * 输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
 * 输出：3
 * 解释：长度最长的公共子数组是 [3,2,1] 。
 * 示例 2：
 *
 * 输入：nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
 * 输出：5
 *
 *
 * 提示：
 *
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 100
 */
public class leetcode24 {
    public static void main(String[] args) {
        int []nums1=new int[]{1,2,3,2,1};
        int []nums2=new int[]{3,2,1,4,7};
        System.out.println(findLength(nums1, nums2));
        System.out.println(findLength2(nums1, nums2));
    }

    public static int findLength(int[] nums1, int[] nums2) {
        //dp[i][j]定义为以下标为i-1 和j-1组成的子数组  最长重复的值
        int [][]dp=new int[nums1.length+1][nums2.length+1];
        int res=0;
        for (int i = 1; i <nums1.length+1 ; i++) {
            for (int j = 1; j <nums2.length+1; j++) {
                if(nums1[i-1]==nums2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                res=Math.max(res,dp[i][j]);
            }
        }
        return  res;

    }

    public static int findLength2(int[] nums1, int[] nums2) {
        //dp[i][j]定义为以下标为i-1 和j-1组成的子数组  最长重复的值
        int [][]dp=new int[nums1.length][nums2.length];
        int res=0;
        for (int i = 0; i <nums2.length ; i++) {
            if(nums1[0]==nums2[i]){
                dp[0][i]=1;
                res=1;
            }
        }

        for (int i = 0; i <nums1.length ; i++) {
            if(nums2[0]==nums1[i]){
                dp[i][0]=1;
                res=1;
            }
        }


        for (int i = 1; i <nums1.length ; i++) {
            for (int j = 1; j <nums2.length; j++) {
                if(nums1[i]==nums2[j]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                res=Math.max(res,dp[i][j]);
            }
        }
        return  res;

    }
}
