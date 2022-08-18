package test1;

import com.sun.org.apache.xml.internal.utils.StringToIntTable;

/**
 * 给你一个仅包含小写英文字母和 '?' 字符的字符串 s，请你将所有的 '?' 转换为若干小写字母，使最终的字符串不包含任何 连续重复 的字符。
 *
 * 注意：你 不能 修改非 '?' 字符。
 *
 * 题目测试用例保证 除 '?' 字符 之外，不存在连续重复的字符。
 *
 * 在完成所有转换（可能无需转换）后返回最终的字符串。如果有多个解决方案，请返回其中任何一个。可以证明，在给定的约束条件下，答案总是存在的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leecode4 {
    public static void main(String[] args) {
        String s="j?qg??b";
        char[] chars = s.toCharArray();
        for (int i = 0; i <chars.length ; i++) {
            if(chars[i]=='?'){
               if(i!=0 && i!=chars.length-1){
                    int []used=new int[26];
                  if(chars[i-1]!='?'){
                    used[chars[i-1]-'a']=1;
                  }
                   if(chars[i+1]!='?') {
                       used[chars[i + 1] - 'a'] = 1;
                   }
                    for (int j = 0; j <used.length ; j++) {
                        if(used[j]!=1){
                            used[j]=1;
                            char x= (char) ('a'+j);
                            chars[i]=x;
                            break;
                        }
                    }
                }else if(i==0){
                    int []used=new int[26];
                    if(chars[1]!='?') {
                        used[chars[1] - 'a'] = 1;
                    }
                    for (int j = 0; j <used.length ; j++) {
                        if(used[j]!=1){
                            char x= (char) ('a'+j);
                            chars[i]=x;
                            break;
                        }
                    }
                }else{
                   int []used=new int[26];
                   if(chars[chars.length-1]!='?') {
                       used[chars[chars.length - 1] - 'a'] = 1;
                   }
                   for (int j = 0; j <used.length ; j++) {
                       if(used[j]!=1){
                           char x= (char) ('a'+j);
                           chars[i]=x;
                           break;
                       }
                   }
               }

            }
        }

        String s2 = String.valueOf(chars);
        System.out.println(s2);

    }
}
