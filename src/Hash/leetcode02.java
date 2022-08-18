package Hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Date: 2022/6/14 22:12
 * @Author: ZheFu
 *242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 */
public class leetcode02 {
    public static void main(String[] args) {
        String s = "rat";
        String t = "car";
        HashMap<Object, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
        }
        Set<Map.Entry<Object, Integer>> entries = map.entrySet();
        for (Map.Entry<Object, Integer> entry : entries) {
            if (entry.getValue() != 0) {
                System.out.println(false);
            }


        }
        System.out.println(true);
    }
}
