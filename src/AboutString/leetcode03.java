package AboutString;

import java.util.Arrays;
import java.util.Collections;

/**
 * @Date: 2022/6/18 21:52
 * @Author: ZheFu
 *
 * 151. 颠倒字符串中的单词
 * 给你一个字符串 s ，颠倒字符串中 单词 的顺序。
 *
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 *
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 *
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "the sky is blue"
 * 输出："blue is sky the"
 * 示例 2：
 *
 * 输入：s = "  hello world  "
 * 输出："world hello"
 * 解释：颠倒后的字符串中不能存在前导空格和尾随空格。
 * 示例 3：
 *
 * 输入：s = "a good   example"
 * 输出："example good a"
 * 解释：如果两个单词间有多余的空格，颠倒后的字符串需要将单词间的空格减少到仅有一个。
 */
public class leetcode03 {
    public static void main(String[] args) {
        String s = reverseWords2(" the  sky    is blue");
        System.out.println(s);
    }

    public static String reverseWords(String s) {
        String trim = s.trim();
        String[] s1 = trim.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = s1.length-1; i >=0; i--) {
            if(s1[i].length()!=0){
                builder.append(s1[i]+" ");
            }
        }
        return builder.toString();
    }



        public static  String reverseWords2(String s) {
            String[] words = s.trim().split(" +");
            for (String word : words) {
                System.out.println(word);
            }
            Collections.reverse(Arrays.asList(words));
            return String.join(" ", words);
        }

}
