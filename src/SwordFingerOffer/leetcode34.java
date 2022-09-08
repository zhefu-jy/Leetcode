package SwordFingerOffer;

/**
 * 剑指 Offer II 003. 前 n 个数字二进制中 1 的个数
 * 给定一个非负整数 n ，请计算 0 到 n 之间的每个数字的二进制表示中 1 的个数，并输出一个数组。
 * 示例 1:
 *
 * 输入: n = 2
 * 输出: [0,1,1]
 * 解释:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 示例 2:
 *
 * 输入: n = 5
 * 输出: [0,1,1,2,1,2]
 * 解释:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 *           10的二进制表示1010
 *            5的二进制表示101
 *            只需要考虑10的最末位是1 还是  0
 */
public class leetcode34 {
    public static void main(String[] args) {
        int n=5;
        countBits(n);


    }
    public  static  int[] countBits(int n) {
        int []dp=new int[n+1];
        dp[0]=0;
        if(n==0){
            return dp;
        }
        dp[1]=1;
        for (int i = 2; i <= n; i++) {
            dp[i]=dp[i>>1]+(i&1);
        }
        return dp;

    }
}
