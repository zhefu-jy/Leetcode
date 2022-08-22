package SwordFingerOffer;

import java.util.*;

/**
 * 剑指 Offer II 060. 出现频率最高的 k 个数字
 * 给定一个整数数组 nums 和一个整数 k ，请返回其中出现频率前 k 高的元素。可以按 任意顺序 返回答案。
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 */
public class leetcode19 {
    public static void main(String[] args) {
        int []nums=new int[]{1,1,1,2,2,3};
        int k=2;
        int[] ints = topKFrequent(nums, k);
        for (int i : ints) {
            System.out.println(i);
        }
    }

    /**
     * @Date: 2022/8/22 11:07
     * @Author: ZheFu
     *
     * 大根堆
     */
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });
        for (Map.Entry<Integer, Integer> entry : entries) {
            priorityQueue.offer(entry);
        }
        int []res=new int[k];
        for (int i = 0; i < res.length; i++) {
            res[i]=priorityQueue.poll().getKey();
        }
        return res;


    }
}
