package BackTrack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 78. 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。

 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 * 提示：
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 * 通过次数477,983提交次数592,733
 */
public class leetcode08 {
    public static void main(String[] args) {
        int []nums=new int[]{0};
        List<List<Integer>> res=new ArrayList<>();
        Deque<Integer> path=new LinkedList<>();
        int begin=0;
        backTrack(res,path,begin,nums);
        System.out.println(res);


    }
    public static void backTrack(List<List<Integer>> res,Deque<Integer> path,int begin,int []nums){
        res.add(new ArrayList<>(path));
        for (int i = begin; i <nums.length ; i++) {
            path.add(nums[i]);
            backTrack(res,path,i+1,nums);
            path.removeLast();
        }
    }
}
