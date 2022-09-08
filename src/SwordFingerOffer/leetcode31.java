package SwordFingerOffer;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 剑指 Offer II 011. 0 和 1 个数相同的子数组
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 * 示例 1：
 * 输入: nums = [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。
 *
 * 示例 2：
 * 输入: nums = [0,1,0]
 * 输出: 2
 * 说明: [0, 1] (或 [1, 0]) 是具有相同数量 0 和 1 的最长连续子数组。
 */
public class leetcode31 {
    public static void main(String[] args) {
        int []nums=new int[]{0,1,1,1,1,1,0,0};
        System.out.println(findMaxLength(nums));

    }
    public static int findMaxLength(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0){
                nums[i]=-1;
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int maxLen=0,sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            if(map.containsKey(sum)){
                maxLen=Math.max(maxLen,i-map.get(sum));
            }else{
                map.put(sum,i);
            }

        }
        return maxLen;

    }
}
