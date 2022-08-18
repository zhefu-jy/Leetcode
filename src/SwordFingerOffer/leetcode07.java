package SwordFingerOffer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;



/**
 * 剑指 Offer II 080. 含有 k 个元素的组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 示例 1:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * 示例 2:
 *
 * 输入: n = 1, k = 1
 * 输出: [[1]]
 */
public class leetcode07 {
    public static void main(String[] args) {
        int  n=4,k=2;
        System.out.println(combine(n, k));

    }
    public  static  List<List<Integer>> combine(int n, int k) {
        int index=1;
        List<List<Integer>> res=new ArrayList<>();
        Deque<Integer> path=new LinkedList<>();
        backTrack(res,path,index,n,k);
        return res;


    }

    private static void backTrack(List<List<Integer>> res, Deque<Integer> path, int index, int n, int k) {
        if(path.size()==k){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i <=n; i++) {
            path.add(i);
            backTrack(res,path,i+1,n,k);
            path.removeLast();
        }
    }
}
