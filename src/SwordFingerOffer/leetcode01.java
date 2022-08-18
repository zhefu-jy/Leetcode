package SwordFingerOffer;

/**
 * 剑指 Offer II 105. 岛屿的最大面积
 * 给定一个由 0 和 1 组成的非空二维数组 grid ，用来表示海洋岛屿地图。
 *
 * 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 *
 * 找到给定的二维数组中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。

 * 示例 1:

 * 输入: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],
                 [0,0,0,0,0,0,0,1,1,1,0,0,0],
                 [0,1,1,0,1,0,0,0,0,0,0,0,0],
                 [0,1,0,0,1,1,0,0,1,0,1,0,0],
                 [0,1,0,0,1,1,0,0,1,1,1,0,0],
                 [0,0,0,0,0,0,0,0,0,0,1,0,0],
                 [0,0,0,0,0,0,0,1,1,1,0,0,0],
                 [0,0,0,0,0,0,0,1,1,0,0,0,0]
               ]
 * 输出: 6
 * 解释: 对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。
 * 示例 2:
 *
 * 输入: grid = [[0,0,0,0,0,0,0,0]]
 * 输出: 0
 */
public class leetcode01 {
    public  static  int max=0;
    public static void main(String[] args) {
        int [][]grid=new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0}
        ,{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(maxAreaOfIsland(grid));
    }
    public static int maxAreaOfIsland(int[][] grid) {

        int res=0;
        int row=grid.length;
        int column=grid[0].length;
        for (int i = 0; i <grid.length; i++) {
            for (int j = 0; j <grid[0].length ; j++) {
                if(grid[i][j]==1){
                    dfs(i,j,row,column,grid);
                    res=Math.max(max,res);
                    max=0;
                }
            }
        }
        return res;

    }

    private static void dfs(int i, int j,  int row,int column,int [][]grid) {
        if(i<0 || i>=row || j<0 || j>=column || grid[i][j]!=1){
            return;
        }
        max++;
        grid[i][j]=-1;
        dfs(i+1,j,row,column,grid);
        dfs(i-1,j,row,column,grid);
        dfs(i,j+1,row,column,grid);
        dfs(i,j-1,row,column,grid);

    }
}
