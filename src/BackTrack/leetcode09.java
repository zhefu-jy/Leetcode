package BackTrack;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 90. 子集 II
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * 示例 1：
 *
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 */
public class leetcode09 {
    public static void main(String[] args) {
        int []nums=new int[]{1,1,2,2};
        List<List<Integer>> res=new ArrayList<>();
        Deque<Integer> path=new LinkedList<>();
        int begin=0;
        Arrays.sort(nums);
        backTrack(res,path,begin,nums);
        System.out.println(res);

    }

    public static void backTrack(List<List<Integer>> res, Deque<Integer> path,int begin,int []nums){
        res.add(new ArrayList<>(path));
        for (int i = begin; i <nums.length ; i++) {
            if(i>begin && nums[i]==nums[i-1]){
               continue;
            }
            path.add(nums[i]);
            backTrack(res,path,i+1,nums);
            path.removeLast();
        }
    }
}
