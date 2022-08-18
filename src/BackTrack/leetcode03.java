package BackTrack;


import java.lang.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 示例 1：
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 *
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 *
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 */
public class leetcode03 {
    public static void main(String[] args) {
        String digits="23";
        List<String> res=new ArrayList<>();
        String  [] str=new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder builder=new StringBuilder();
        backTrack(res,digits,builder,str,0);
        System.out.println(res);


    }

    private static void backTrack(List<String> res, String digits,  StringBuilder builder,String[] str, int num) {
        if(num==digits.length()){
            res.add(builder.toString());
            return;
        }
        String s=str[digits.charAt(num)-'0'];
        for (int i = 0; i <s.length() ; i++) {
            builder.append(s.charAt(i));
            backTrack(res,digits,builder,str,num+1);
            builder.deleteCharAt(builder.length()-1);
        }
    }
}
