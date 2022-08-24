package Daily;

import java.util.HashMap;
import java.util.Map;

/**
 * 395. 至少有 K 个重复字符的最长子串
 * 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "aaabb", k = 3
 * 输出：3
 * 解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 * 示例 2：
 *
 * 输入：s = "ababbc", k = 2
 * 输出：5
 * 解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 *
 */
public class leetcode03 {
    public static void main(String[] args) {
        String s="ababbc";
        int k=2;
        System.out.println(longestSubstring(s, k));
        //分治
        System.out.println(dfs(s, k));

    }

    public static int longestSubstring(String s, int k) {
        int max=-1;
        for (int i = 0; i <s.length()-1 ; i++) {
            for (int j = i+1; j < s.length(); j++) {
                if(j-i+1<k){
                    continue;
                }
                String substring = s.substring(i, j + 1);
                if(containsLongest(substring,k)){
                    max=Math.max(max,substring.length());
                }
            }
        }
        return  max;
    }

    private static boolean containsLongest(String substring, int k) {
        Map<Character,Integer> map=new HashMap<>();
        for (int i = 0; i <substring.length() ; i++) {
            char c=substring.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if(value<k){
                return false;
            }
        }
        return true;
    }


    public static  int dfs(String s,int k){
        int []charCount=new int[26];
        //统计每个字符出现的次数
        for (int i = 0; i <s.length() ; i++) {
            char c=s.charAt(i);
            charCount[c-'a']++;
        }
        //统计小于k的字符
        String split="";
        for (int i = 0; i < charCount.length; i++) {
            int count=charCount[i];
            if(count>0 && count<k){
                split=String.valueOf((char)(i+'a'));
                break;
            }
        }

        if(split.equals("")){
            //全部都>k
            return s.length();
        }
        String[] strings = s.split(split);
        int max=0;
        for (String string : strings) {
            int dfs = dfs(string, k);
            max=Math.max(max,dfs);

        }
        return max;


    }
}
