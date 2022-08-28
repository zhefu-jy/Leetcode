package Daily;

/**
 * 剑指 Offer II 020. 回文子字符串的个数
 * 给定一个字符串 s ，请计算这个字符串中有多少个回文子字符串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 示例 2：
 *
 * 输入：s = "aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 */
public class leetcode08 {
    public static void main(String[] args) {
        String s="aaa";
        System.out.println(countSubstrings(s));


    }
    public static int countSubstrings(String s) {
        //dp[i][j] 表示从i到j 构成的子串是否回文
        boolean [][]dp=new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length() ; i++) {
            for (int j = i; j < s.length() ; j++) {
                if(s.charAt(i)==s.charAt(j)){
                    if(j-i<3){
                        dp[i][j]=true;
                    }else{
                        dp[i][j]=dp[i+1][j-1];
                    }
                }else{
                    dp[i][j]=false;
                }
            }
        }

        int res=0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length ;j++) {
                if(dp[i][j]){
                    res++;
                }
            }
        }
        return res;


    }
}
