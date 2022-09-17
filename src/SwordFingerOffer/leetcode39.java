package SwordFingerOffer;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer II 016. 不含重复字符的最长子字符串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长连续子字符串 的长度。
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子字符串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子字符串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 * 输入: s = ""
 * 输出: 0
 */
public class leetcode39 {
    public static void main(String[] args) {
        String s="pwwkew";
        System.out.println(lengthOfLongestSubstring(s));


    }
    public  static  int lengthOfLongestSubstring(String s) {
        Set<Character> set=new HashSet<>();
        int  res=0;
        for (int l = 0,r=0; r < s.length(); r++) {
            char c=s.charAt(r);
            while (set.contains(c)){
                set.remove(s.charAt(l++));
            }
            set.add(c);
            res=Math.max(res,r-l+1);
        }
        return res;

    }
}
