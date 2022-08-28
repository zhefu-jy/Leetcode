package SwordFingerOffer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class leetcode25 {
    public static void main(String[] args) {
        String s="pwwkew";
        System.out.println(lengthOfLongestSubstring2(s));
        System.out.println(lengthOfLongestSubstring(s));

    }
    public  static  int lengthOfLongestSubstring(String s) {
        Set<Character> set=new HashSet<>();
        //记录结果
        int res=0;
        for (int l = 0,r=0; r < s.length();r++) {
            char c = s.charAt(r);
            //如果set集合包含重复的  就让l++  如果l++后 还是包含 就继续remove  比如 p w  时遇到w  首先移除p  然后w依然包含  继续remove w
            while (set.contains(c)){
                set.remove(s.charAt(l++));
            }
            set.add(c);
            res=Math.max(res,r-l+1);

        }
        return res;
    }

    //双指针
    public  static  int lengthOfLongestSubstring2(String s) {
        Map<Character,Integer> map=new HashMap<>();
        int i=-1;   //左指针
        int res=0;
        for (int j = 0; j < s.length(); j++) {
            char c=s.charAt(j);
            //如果包含重复元素 就移动左指针位置  左指针位置为 Math.max(i,map.get(c))
            if(map.containsKey(c)){
                i=Math.max(i,map.get(c));
            }
            //更新数据及索引
            map.put(s.charAt(j),j);
           //得出结果
            res=Math.max(res,j-i);
        }
        return res;

    }
}
