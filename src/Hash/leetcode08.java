package Hash;

import java.util.*;

/**
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 *
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：[]
 */
public class leetcode08 {
    public static void main(String[] args) {
        int []nums={-1,0,1,2,-1,-4};
        int n=nums.length;
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        if(nums.length<3){
            System.out.println(res);
        }
        for (int first= 0; first < n; first++) {
            if(first>0 && nums[first]==nums[first-1])
            {
                continue;
            }
            int third=n-1;
            int target=-nums[first];

            for (int second = first+1; second <n ; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                while (second<third && nums[second]+nums[third]>target){
                    --third;
                }
                if(second==third){
                    break;
                }
                if(nums[second]+nums[third]==target){
                 /*   ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                   */
                   res.add(Arrays.asList(nums[first], nums[second], nums[third]));

                }

            }

        }
        System.out.println(res);


    }
}
