package AboutString;
/**
 * @Date: 2022/6/19 21:41
 * @Author: ZheFu
 *
 * 28. 实现 strStr()
 * 实现 strStr() 函数。
 *
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 *
 * 说明：
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
 *
 *
 *
 * 示例 1：
 *
 * 输入：haystack = "hello", needle = "ll"
 * 输出：2
 * 示例 2：
 *
 * 输入：haystack = "aaaaa", needle = "bba"
 * 输出：-1
 */
public class leetcode06 {
    public static void main(String[] args) {
        strStr("aabaabaaf","aabaaf");
    }

    //前缀表（不减一）Java实现
    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int[] next = new int[needle.length()];
        getNext(next, needle);

        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && needle.charAt(j) != haystack.charAt(i))
                j = next[j - 1];
            if (needle.charAt(j) == haystack.charAt(i))
                j++;
            if (j == needle.length())
                return i - needle.length() + 1;
        }
        return -1;

    }

    private static void getNext(int[] next, String s) {
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(j) != s.charAt(i))
                j = next[j - 1];
            if (s.charAt(j) == s.charAt(i))
                j++;
            next[i] = j;
        }
    }
}
