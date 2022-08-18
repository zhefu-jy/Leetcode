package BackTrack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 131. 分割回文串
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 *
 * 回文串 是正着读和反着读都一样的字符串。
 * 示例 1：
 *
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 示例 2：
 *
 * 输入：s = "a"
 * 输出：[["a"]]
 *
 * 提示：
 * 1 <= s.length <= 16
 * s 仅由小写英文字母组成
 */
public class leetcode06 {
    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> res = new ArrayList<>();
        Deque<String> path = new LinkedList<>();
        int index = 0;
        backTrack(res, path, s, index);
        System.out.println(res);


    }

    public static void backTrack(List<List<String>> res, Deque<String> path, String s, int index) {
        if (index >= s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (checkPalindrome(s, index, i)) {
               String temp=s.substring(index,i+1);
                path.add(temp);
            }else{
                continue;
            }
            backTrack(res, path, s, i + 1);
            path.removeLast();

        }

    }


    public static boolean checkPalindrome(String s, int start, int end) {
        for (int i =start, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;

    }

}
