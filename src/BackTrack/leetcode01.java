package BackTrack;
  //回溯

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 77. 组合
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 * 示例 1：
 *
 * 输入：n = 4, k = 2
 * 输出：
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * 示例 2：
 *
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 */
public class leetcode01 {
    public static void main(String[] args) {
        List<List<Integer>> res=new ArrayList<>();
        int n=4;
        int k=2;
        Deque<Integer> temp=new LinkedList<>();
        int begin=1;
        backTrack(res,temp,begin,n,k);
        System.out.println(res);
    }

    public static void backTrack(List<List<Integer>> res,  Deque<Integer> temp,int begin,int n, int k) {
        if(temp.size()==k){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = begin; i <=n ; i++) {
            temp.add(i);
            backTrack(res,temp,i+1,n,k);
            temp.removeLast();
        }

    }
}
