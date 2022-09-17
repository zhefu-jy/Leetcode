package SwordFingerOffer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 剑指 Offer II 083. 没有重复元素集合的全排列
 * 给定一个不含重复数字的整数数组 nums ，返回其 所有可能的全排列 。可以 按任意顺序 返回答案。
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 *
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：[[1]]
 */
public class leetcode36 {
    public static void main(String[] args) {
        int []nums=new int[]{1,2,3};
        System.out.println(permute(nums));


    }

    public static  List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        if(nums.length==0){
            return res;
        }
        int len=nums.length;
        boolean []used=new boolean[len];
        Deque<Integer> path=new ArrayDeque<>();
        dfs(nums,path,res,0,len,used);
        return  res;


    }

    private static void dfs(int[] nums, Deque<Integer> path, List<List<Integer>> res, int begin, int len,boolean []used) {
        if(path.size()==len){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len ; i++) {
            if(used[i]){
                continue;
            }
            path.add(nums[i]);
            used[i]=true;
            dfs(nums,path,res,i+1,len,used);
            used[i]=false;
            path.removeLast();
        }
    }
}
