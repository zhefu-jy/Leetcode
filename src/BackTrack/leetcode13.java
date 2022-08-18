package BackTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode13 {
    public static void main(String[] args) {
        int n=4;
        List<List<String>> res=new ArrayList<>();
        char[][] arr=new char[n][n];
        for (char[] chars : arr) {
            Arrays.fill(chars,'.');
        }
        backTrack(res,arr,0);
        System.out.println(res);

    }

    private static void backTrack(List<List<String>> res, char[][] arr, int row) {
        if(row==arr.length){
            res.add(Array2List(arr));
            return;
        }
        for (int col = 0; col < arr.length; col++) {
            if(isValid(arr,col,arr.length,row)){
                arr[row][col]='Q';
                backTrack(res,arr, row+1);
                arr[row][col]='.';
            }
        }
    }

    private static boolean isValid(char[][] arr, int col, int length, int row) {
        // 检查列
        for (int i=0; i<row; ++i) { // 相当于剪枝
            if (arr[i][col] == 'Q') {
                return false;
            }
        }

        // 检查45度对角线
        for (int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
            if (arr[i][j] == 'Q') {
                return false;
            }
        }

        // 检查135度对角线
        for (int i=row-1, j=col+1; i>=0 && j<=length-1; i--, j++) {
            if (arr[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public  static  List Array2List(char[][] chessboard) {
        List<String> list = new ArrayList<>();
        for (char[] c : chessboard) {
            list.add(String.copyValueOf(c));
        }
        return list;
    }
}
