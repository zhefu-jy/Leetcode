package SwordFingerOffer;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.*;

/**
 * 剑指 Offer II 033. 变位词组
 * 给定一个字符串数组 strs ，将 变位词 组合在一起。 可以按任意顺序返回结果列表。
 *
 * 注意：若两个字符串中每个字符出现的次数都相同，则称它们互为变位词。
 * 示例 1:
 *
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 示例 2:
 *
 * 输入: strs = [""]
 * 输出: [[""]]
 * 示例 3:
 *
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 */
public class leetcode42 {
    public static void main(String[] args) {
        String  []strs=new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        char[] chars = new char[]{'a','e','s'};

        System.out.println(groupAnagrams(strs));


    }
    public static List<List<String>> groupAnagrams(String[] strs) {
     Map<String,List<String>> map=new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);

            if(!map.containsKey(s)){
                map.put(s,new ArrayList<>());
            }
            map.get(s).add(strs[i]);
        }

        return new ArrayList<>(map.values());

    }
}
