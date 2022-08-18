package DP;
/**
 * @Date: 2022/7/8 11:23
 * @Author: ZheFu
 *
 * * 背包最大重量为4。
 *  *
 *  * 物品为：
 *  *
 *  *        重量	 价值
 *  * 物品0	    1	  15
 *  * 物品1	   3	  20
 *  * 物品2	   4	  30
 *  * 问背包能背的物品最大价值是多少？
 *
 */
public class leetcode04 {
    public static void main(String[] args) {
        //转换为一维dp数组
        int []value=new int[]{15,20,30};
        int []weight=new int[]{10,3,4};
        int bagSize=4;
        OneDPTest(value,weight,bagSize);
    }

    private static void OneDPTest( int []value,int []weight,int bagSize){
        int []dp=new int[bagSize+1];
        dp[0]=0;
        for (int i = 0; i <value.length ; i++) {
            for (int j = bagSize; j >=weight[i] ; j--) {
                dp[j]=Math.max(dp[j],dp[j-weight[i]]+value[i]);
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(dp[i]);
        }

    }
}
