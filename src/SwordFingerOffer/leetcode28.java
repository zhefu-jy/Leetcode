package SwordFingerOffer;

import java.util.*;

/**
 * 剑指 Offer II 007. 数组中和为 0 的三个数
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a ，b ，c ，使得 a + b + c = 0 ？请找出所有和为 0 且 不重复 的三元组。
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
public class leetcode28 {
    public static void main(String[] args) {
        int []nums=new int[]{-1,0,1,2,-1,-4};
        System.out.println(threeSum2(nums));
        System.out.println(threeSum(nums));

    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        if(nums.length<3){
            return res;
        }
        for (int i = 0; i <nums.length; i++) {
            if(i>=1 &&  nums[i]==nums[i-1]){
                continue;
            }
            int target=-nums[i];
            int third=nums.length-1;

            for (int j = i+1; j <nums.length ; j++) {
                if(j > i+1 && nums[j]==nums[j-1]){
                    continue;
                }
                while(j<third && nums[j]+nums[third] >target){
                    --third;
                }
                if(third==j){
                    break;
                }

                if(nums[j]+nums[third]==target){
                    List<Integer> path=new ArrayList<>();
                    path.add(nums[i]);
                    path.add(nums[j]);
                    path.add(nums[third]);
                    res.add(path);

                }

            }
        }
        return res;

    }

    //回溯

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res=new ArrayList<>();
        if(nums.length<3){
            return res;
        }
        Arrays.sort(nums);
        List<Integer> path=new ArrayList<>();
        dfs(res,path,0,nums);

        return res;

    }

    private static void dfs(List<List<Integer>> res,List<Integer> path, int index, int[] nums) {
        if(path.size()==3){
            if(getSum(path)==0) {
                res.add(new ArrayList<>(path));
                return;
            }else{
                return;
            }
        }
        for (int i = index; i < nums.length ; i++) {
            if(i>index && nums[i]==nums[i-1]){
                continue;
            }
            path.add(nums[i]);
            dfs(res,path,i+1,nums);
            path.remove(path.size()-1);
        }

    }

    public static  int getSum(List<Integer> path){
        int res=0;
        for (Integer integer : path) {
            res+=integer;
        }
        return res;
    }

}
