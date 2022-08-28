package SwordFingerOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 57 - II. 和为s的连续正数序列
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 *
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 */
public class leetcode27 {
    public static void main(String[] args) {
        int target=15;
        int[][] result = findContinuousSequence(target);


    }
    public  static  int[][] findContinuousSequence(int target) {
        List<int []> res=new ArrayList<>();
        int left=1;
        int right=2;
        while(left < right){
            int temp=(right-left+1)*(left+right)/2;
            if(temp==target){
                int []arr=new int[right-left+1];
                for (int i = 0; i <right-left+1 ; i++) {
                    arr[i]=left+i;
                }
                res.add(arr);
                left++;
            }else if(target> temp){
                right++;
            }else{
                left++;
            }
        }
        return res.toArray(new int[res.size()][]);


    }
}
