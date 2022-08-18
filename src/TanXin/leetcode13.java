package TanXin;

import java.util.ArrayList;
import java.util.List;

/**
 * 763. 划分字母区间
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。

 * 示例：
 *
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 */
public class leetcode13 {
    public static void main(String[] args) {
        String S="ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(S));
        int x=1;
        int y=2;



    }
    public  static  List<Integer> partitionLabels(String s) {
      int []last=new int[26];
        for (int i = 0; i <s.length() ; i++) {
            last[s.charAt(i)-'a']=i;
        }
        int start=0,end=0;
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            end=Math.max(end,last[s.charAt(i)-'a']);
            if(end==i){
                list.add(end-start+1);
                start=end+1;
            }
        }
        return list;

    }
}
