package test2;

import java.util.ArrayList;

/**
 * https://leetcode.cn/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 * 剑指 Offer 46. 把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * 示例 1:
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *
 */
public class leecode04 {
    public static void main(String[] args) {
       // int num=12258;
        int  num=12;
        String s=String.valueOf(num);
        if(s.length()<2){
            System.out.println(s.length());
        }
        int len=s.length();
        char [] chars=s.toCharArray();
        int []dp=new int[len+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=1;i<len;i++){
            dp[i+1]=dp[i];
            int x=10*(chars[i-1]-'0')+(chars[i]-'0');
            if(x>9 && x<26){
                dp[i+1]=dp[i]+dp[i-1];
            }
        }
        System.out.println(dp[len]);


    }
}
