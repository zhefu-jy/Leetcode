package DP;

/**
 * 背包问题
 * 背包最大重量为4。
 *
 * 物品为：
 *
 *        重量	 价值
 * 物品0	    1	  15
 * 物品1	   3	  20
 * 物品2	   4	  30
 * 问背包能背的物品最大价值是多少？
 */
public class leetcode03 {
    public static void main(String[] args) {
        int []value=new int[]{15,20,30};
        int []weight=new int[]{1,3,4};
        int bagSize=4;
        testweightbagproblem(value,weight,bagSize);


    }
    public static void testweightbagproblem(int []value,int []weight,int bagSize){
        int [][]dp=new int[weight.length+1][bagSize+1];
        for (int i = 0; i < dp.length ; i++) {
            dp[i][0]=0;
        }
        for (int i = 1; i <dp.length ; i++) {
            for (int j = 1; j <dp[0].length ; j++) {
                if(weight[i-1]>j){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-weight[i-1]]+value[i-1]);
                }
            }
        }
        //打印dp数组
        for (int i = 0; i < dp.length; i++){
            for (int j = 0; j <dp[0].length; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.print("\n");
        }
    }


    public static void testweightbagproblem1(int []value,int []weight,int bagSize){
        int [][]dp=new int[value.length+1][bagSize+1];
        for (int i = 0; i <dp.length; i++) {
            dp[i][0]=0;
        }
        for (int i = 1; i <dp.length ; i++) {
            for (int j = 1; j <dp[0].length ; j++) {
                if(weight[i]>j){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-weight[i-1]]+value[i-1]);
                }
            }
        }
    }
}
