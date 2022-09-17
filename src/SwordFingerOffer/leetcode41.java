package SwordFingerOffer;

/**
 * 剑指 Offer II 008. 和大于等于 target 的最短子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。

 * 示例 1：
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *
 * 示例 2：
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 *
 * 示例 3：
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 */
public class leetcode41 {
    public static void main(String[] args) {
        int []nums=new int[]{2,3,1,2,4,3};
        int target=7;
        System.out.println(minSubArrayLen(target, nums));
        System.out.println(minSubArrayLen2(target,nums));


    }

    /**
     * @Date: 2022/9/10 10:10
     * @Author: ZheFu
     * 暴力
     */
    public  static int minSubArrayLen(int target, int[] nums) {
        int res=Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum=0;
            for (int j = i; j <nums.length ; j++) {
                sum+=nums[j];
                if(sum>=target){
                    res=Math.min(res,j-i+1);
                    continue;
                }
            }
        }
        return res==Integer.MAX_VALUE ? 0:res ;

    }

    /**
     * @Date: 2022/9/10 10:28
     * @Author: ZheFu
     * 滑动窗口
     */
    public  static int minSubArrayLen2(int target, int[] nums) {
        int start=0,end=0;
        int res=Integer.MAX_VALUE;
        int sum=0;
        int index=0;
        while(end < nums.length){
            sum+=nums[end];
            while (sum>=target){
                res=Math.min(res,end-start+1);
                sum=sum-nums[start++];
            }
            end++;
        }

        return res==Integer.MAX_VALUE ? 0:res ;


    }
}
