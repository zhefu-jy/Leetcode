package DP;
/**
 * @Date: 2022/8/26 20:42
 * @Author: ZheFu
 * 1277. 统计全为 1 的正方形子矩阵
 * 给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：matrix =
 * [
 *   [0,1,1,1],
 *   [1,1,1,1],
 *   [0,1,1,1]
 * ]
 * 输出：15
 * 解释：
 * 边长为 1 的正方形有 10 个。
 * 边长为 2 的正方形有 4 个。
 * 边长为 3 的正方形有 1 个。
 * 正方形的总数 = 10 + 4 + 1 = 15.
 * 示例 2：
 *
 * 输入：matrix =
 * [
 *   [1,0,1],
 *   [1,1,0],
 *   [1,1,0]
 * ]
 * 输出：7
 * 解释：
 * 边长为 1 的正方形有 6 个。
 * 边长为 2 的正方形有 1 个。
 * 正方形的总数 = 6 + 1 = 7.
 *
 */
public class leetcode32 {
    public static void main(String[] args) {
        int  [][]matrix=new int [][]{{0,1,1,1},{1,1,1,1},{0,1,1,1}};
        int  [][]matrix1=new int [][]{{1,0,1},{1,1,0},{1,1,0}};

     //   System.out.println(countSquares(matrix));
        System.out.println(countSquares(matrix1));

    }
    public static int countSquares(int[][] matrix) {
        int row=matrix.length;
        int column=matrix[0].length;
        int [][]dp=new int[row][column];
        int res=0;
        for (int i = 0; i <row ; i++) {
            if(matrix[i][0]==1){
                dp[i][0]=1;
                res++;
            }
        }
        for (int i = 0; i <column ; i++) {
            if(matrix[0][i]==1){
                dp[0][i]=1;
                res++;
            }
        }

        for (int i = 1; i <row ; i++) {
            for (int j = 1; j <column ; j++) {
                if(matrix[i][j]==1){
                    dp[i][j]=Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1])+1;
                    res=res+dp[i][j];
                }
            }
        }
        //如果matrix[0][0]==1 被重复计算了一次
        return matrix[0][0]==1? res-1:res;

    }
}
