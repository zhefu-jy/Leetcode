package Hash;

import java.util.HashMap;

/**
 * 454. 四数相加 II
 * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
 *
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
 * 输出：2
 * 解释：
 * 两个元组如下：
 * 1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
 * 示例 2：
 *
 * 输入：nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
 * 输出：1
 *
 */
public class leetcode06 {
    public static void main(String[] args) {
        int []nums1={1,2};
        int []nums2={-2,-1};
        int []nums3={-1,2};
        int []nums4={0,2};
        HashMap<Integer,Integer> map=new HashMap<>();
        int res=0;
        for(int x:nums1){
            for(int y:nums2){
                int temp=x+y;
                map.put(temp,map.getOrDefault(temp,0)+1);
            }
        }
        for(int x:nums3){
            for(int y:nums4){
               int temp=0-(x+y);
               if(map.containsKey(temp)){
                   res=res+map.get(temp);
               }
            }
        }
        System.out.println(res);
    }
}
