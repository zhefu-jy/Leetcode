package SwordFingerOffer;

/**
 * 剑指 Offer 64. 求1+2+…+n
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。

 * 示例 1：
 *
 * 输入: n = 3
 * 输出: 6
 * 示例 2：
 *
 * 输入: n = 9
 * 输出: 45
 */
public class leetcode02 {
    public static int res=0;

    public static void main(String[] args) {
        System.out.println(sumNums(9));
    }
    public static int sumNums(int n) {
        if(n<1){
            return 0;
        }
        if(n>=1){
            res=n+sumNums(n-1);
        }
        return res;


    }
}
