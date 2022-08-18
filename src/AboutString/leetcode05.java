package AboutString;
/**
 * @Date: 2022/6/19 10:49
 * @Author: ZheFu
 *28. 实现 strStr()
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
public class leetcode05 {
    public static void main(String[] args) {
        System.out.println(strStr("aaaaa", "bba"));
    }
    public static int strStr(String haystack, String needle) {
        if(needle.length()==0 || needle==null){
            return 0;
        }
        int index=0;
        int res=0;
        for(int i=0;i<haystack.length();i++){
            if(haystack.charAt(i)!=needle.charAt(index)){
                continue;
            }
            index++;
            res=i;
            for(int j=i+1;j<haystack.length();j++){
                if(haystack.charAt(j)==needle.charAt(index)){

                    if(index==needle.length()-1){
                        return res;
                    }else {
                        index++;
                    }
                }else{
                    break;
                }
            }
        }

        return -1;
    }
}
