package SwordFingerOffer;

import java.util.*;

/**
 * 剑指 Offer II 084. 含有重复元素集合的全排列
 * 给定一个可包含重复数字的整数集合 nums ，按任意顺序 返回它所有不重复的全排列。
 * 示例 1：
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * 示例 2：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class leetcode37 {
    public static void main(String[] args) {
        int []nums=new int[]{1,1,2};
        System.out.println(permuteUnique(nums));


    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        if(nums.length==0){
            return res;
        }
        Arrays.sort(nums);
        int len=nums.length;
        boolean []used=new boolean[len];
        Deque<Integer> path=new ArrayDeque<>();
        backTrack(nums,path,res,0,len,used);
        return  res;

    }

    private static void backTrack(int[] nums, Deque<Integer> path, List<List<Integer>> res, int index, int len, boolean[] used) {
        if(path.size()==len){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len ; i++) {
            if(i>0 && nums[i]==nums[i-1] && used[i-1]==false){
                continue;
            }
            if(used[i]==false) {
                path.add(nums[i]);
                used[i] = true;
                backTrack(nums, path, res, i + 1, len, used);
                used[i] = false;
                path.removeLast();
            }
        }

    }
}
