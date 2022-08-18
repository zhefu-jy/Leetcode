package DP;

/**
 * 647. 回文子串
 * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 *
 * 回文字符串 是正着读和倒过来读一样的字符串。
 *
 * 子字符串 是字符串中的由连续字符组成的一个序列。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
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
public class leetcode29 {
    public static void main(String[] args) {
        String s="aaa";
        System.out.println(countSubstrings(s));
        System.out.println(countSubstrings2(s));


    }

    public static int countSubstrings(String s) {
        boolean [][]dp=new boolean[s.length()][s.length()];
        for (int j = 0; j <s.length() ; j++) {
            for (int i = 0; i <=j ; i++) {
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
        int ans=0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (dp[i][j]) ans++;
            }
        }
        return ans;

    }




    public static int countSubstrings2(String s) {
        boolean [][]dp=new boolean[s.length()][s.length()];
        for (int i = 0; i <s.length() ; i++) {
            for (int j = 0; j <=i ; j++) {
                if(s.charAt(i)==s.charAt(j)){
                    if(i-j<3){
                        dp[i][j]=true;
                    }else{
                        dp[i][j]=dp[i-1][j+1];
                    }
                }else{
                    dp[i][j]=false;
                }

            }
        }
        int ans=0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (dp[i][j]) ans++;
            }
        }
        return ans;

    }

}
