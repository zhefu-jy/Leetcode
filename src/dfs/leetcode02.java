package dfs;
/**
 * @Date: 2022/7/23 21:01
 * @Author: ZheFu
 *
 * 面试题12. 矩阵中的路径
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。
 * 示例 1：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 */
public class leetcode02 {
    public static void main(String[] args) {
        char [][]board=new  char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        char [][] visited=new char[board.length][board[0].length];
        String word="ABCCED";
        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j <board[0].length ; j++) {
                boolean flag=backTrack(board,visited,word,i,j,0);
                if(!flag){
                    System.out.println(false);
                    return;
                }

            }

        }
        System.out.println(true);

    }

    private static boolean backTrack(char[][] board, char[][] visited, String word, int i, int j,int key) {
        if(i<0 || i>board.length || j<0 || j>board[0].length || visited[i][j]==1 || word.charAt(key)!=board[i][j]){
            return false;
        }
        if(key==word.length()-1){
            return true;
        }
        visited[i][j]='1';
        boolean res=false;
       res=backTrack(board,visited,word,i+1,j,key++)
        || backTrack(board,visited,word,i-1,j,key++)
        || backTrack(board,visited,word,i,j+1,key++)
        || backTrack(board,visited,word,i,j-1,key++);

        visited[i][j]='0';


        return  res;


    }
}
