package DP;
/**
 * @Date: 2022/8/26 20:25
 * @Author: ZheFu
 *221. 最大正方形
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。

 * 示例 1：
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：4
 * 示例 2：
 *
 *
 * 输入：matrix = [["0","1"],["1","0"]]
 * 输出：1
 * 示例 3：
 *
 * 输入：matrix = [["0"]]
 * 输出：0
 *
 */
public class leetcode31 {
    public static void main(String[] args) {
        char  [][]matrix=new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        char  [][]matrix1=new char[][]{{'0','1'},{'1','0'}};
        System.out.println(maximalSquare(matrix));
        System.out.println(maximalSquare(matrix1));

    }

    public static int maximalSquare(char[][] matrix) {
        if(matrix.length==1 && matrix[0].length==1){
            return matrix[0][0]=='1'? 1:0;
        }
        int row=matrix.length;
        int column=matrix[0].length;
        //dp[i][j]表示 以 (i, j) 为右下角，且只包含 1 的正方形的边长最大值  递推公式为 dp[i][j]=Math,min(dp[i-1][j-1],dp[i][j-1],dp[i-1][j])+1
        int [][]dp=new int[row][column];
        int max=0;

        for (int i = 0; i < row; i++) {
            if(matrix[i][0]=='1'){
                dp[i][0]=1;
                max=1;
            }
        }

        for (int i = 0; i <column ; i++) {
            if(matrix[0][i]=='1'){
                dp[0][i]=1;
                max=1;
            }
        }
        for (int i = 1; i <row ; i++) {
            for (int j = 1; j <column ; j++) {
                if(matrix[i][j]=='1'){
                    dp[i][j]=Math.min(Math.min(dp[i-1][j-1],dp[i][j-1]),dp[i-1][j])+1;
                    max=Math.max(max,dp[i][j]);
                }
            }
        }
        return max*max;

    }
}
