package SwordFingerOffer;

import java.util.Arrays;

/**
 * 剑指 Offer II 014. 字符串中的变位词
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的某个变位词。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
 * 示例 1：
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * 示例 2：
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 */
public class leetcode32 {
    public static void main(String[] args) {
        String s1="adc";
        String s2="dcdadwqdq";
        System.out.println(checkInclusion(s1, s2));
        System.out.println(checkInclusion2(s1,s2));
    }
    public static boolean checkInclusion(String s1, String s2) {
        for (int i = 0; i <s2.length()-s1.length() ; i++) {
            String substring = s2.substring(i, i + s1.length());
            if(isSame(substring,s1)){
                return true;
            }
        }
        return false;


    }

    /**
     * 滑动窗口
     * @param s1
     * @param s2
     * @return
     */
    public static boolean checkInclusion2(String s1, String s2) {
        int []arr1=new int[26];
        int []arr2=new int[26];
        for (int i = 0; i <s1.length() ; i++) {
            arr1[s1.charAt(i)-'a']++;
            arr2[s2.charAt(i)-'a']++;
        }
        if(Arrays.equals(arr1,arr2)){
            return true;
        }
        for (int i = s1.length(); i < s2.length(); i++) {
            arr2[s2.charAt(i)-'a']++;
            arr2[s2.charAt(i-s1.length())-'a']--;
            if(Arrays.equals(arr1,arr2)){
                return true;
            }
        }
        return false;


    }

    private static boolean isSame(String substring,String s1) {
        int []count=new int[26];
        for (int i = 0; i <s1.length() ; i++) {
            count[s1.charAt(i)-'a']++;
        }
        for (int i = 0; i <substring.length() ; i++) {
            count[substring.charAt(i)-'a']--;
        }
        for (int i = 0; i < count.length; i++) {
            if(count[i]!=0){
                return false;
            }
        }
        return true;

    }
}
