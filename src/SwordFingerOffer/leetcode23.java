package SwordFingerOffer;

public class leetcode23 {
    public static void main(String[] args) {
        int []coins=new int[]{1,2,5};
        int amount=11;
        System.out.println(coinChange(coins, amount));

    }
    public  static  int coinChange(int[] coins, int amount) {
        // dp[n]  表示构成n元的最少硬币数目  递推公式 dp[n]=Math.min(dp[n],dp[n-coins[i]]+1)
        int []dp=new int[amount+1];
        int max=amount+1;
        for (int i = 0; i < dp.length; i++) {
            dp[i]=max;
        }
        dp[0]=0;
        for (int i = 1; i <=amount ; i++) {
            for (int j = 0; j <coins.length ; j++) {
                if(coins[j]<=i ){
                    dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
                }

            }
        }
        return dp[amount] >amount ? -1 : dp[amount];


    }
}
