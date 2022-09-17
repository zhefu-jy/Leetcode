package SwordFingerOffer;

import java.util.HashMap;

/**
 * 剑指 Offer II 010. 和为 k 的子数组
 * 给定一个整数数组和一个整数 k ，请找到该数组中和为 k 的连续子数组的个数。

 * 示例 1：
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2
 * 解释: 此题 [1,1] 与 [1,1] 为两种不同的情况
 *
 * 示例 2：
 * 输入:nums = [1,2,3], k = 3
 * 输出: 2
 */
public class leetcode40 {
    public static void main(String[] args) {
        int []nums=new int[]{1,1,1};
        int k=2;
        System.out.println(subarraySum1(nums, k));


    }
    /**
     * @Date: 2022/9/9 11:06
     * @Author: ZheFu
     *
     * 暴力
     */
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;

                }
            }
        }
        return count;
    }

    /**
     * 哈希+前缀和
     * @param nums   数组
     * @param k      目标值
     * @return
     */
    public static int subarraySum1(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int res=0;
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            if(map.containsKey(sum-k)){
                res=res+map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return res;
    }
}
