package SwordFingerOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 剑指 Offer II 015. 字符串中的所有变位词
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 变位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 变位词 指字母相同，但排列不同的字符串。
 * 示例 1：
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的变位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的变位词。
 *  示例 2：
 *
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的变位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的变位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的变位词。
 */
public class leetcode35 {
    public static void main(String[] args) {
        String s="abab";
        String p="ab";
        System.out.println(findAnagrams(s, p));


    }

    public  static  List<Integer> findAnagrams(String s, String p) {
        List<Integer> res=new ArrayList<>();
        if(p.length()>s.length()){
            return  res;
        }
        int []count1=new int[26];
        int []count2=new int[26];
        for (int i = 0; i <p.length(); i++) {
            count1[s.charAt(i)-'a']++;
            count2[p.charAt(i)-'a']++;
        }

        if(Arrays.equals(count1,count2)){
            res.add(0);
        }
        for (int i = 0; i < s.length()-p.length() ; i++) {
            count1[s.charAt(i)-'a']--;
            count1[s.charAt(i+p.length())-'a']++;
            if(Arrays.equals(count1,count2)){
                res.add(i+1);
            }
        }
        return res;
    }
}
