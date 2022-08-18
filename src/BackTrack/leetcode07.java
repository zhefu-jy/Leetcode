package BackTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. 复原 IP 地址
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 * 示例 1：
 *
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 *
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 示例 3：
 *
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]

 * 提示：
 *
 * 1 <= s.length <= 20
 * s 仅由数字组成
 */
public class leetcode07 {
    public static void main(String[] args) {
       String s = "25525511135";
        List<String> res=new ArrayList<>();
        if(s.length()>12){
            System.out.println(res);
        }
        int startIndex=0;
        int pointNum=0;
        backTrack(s,res,startIndex,pointNum);
        System.out.println(res);
    }

    public static void backTrack(String s,List<String> res,int startIndex,int pointNum){
        if(pointNum==3){
            if(isValid(s,startIndex,s.length()-1)){
                res.add(s);

            }
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if(isValid(s,startIndex,i)){
                s=s.substring(0,i+1)+"."+s.substring(i+1);
                pointNum++;
                backTrack(s,res,i+2,pointNum);
                s=s.substring(0,i+1)+s.substring(i+2);
                pointNum--;
            }else{
                break;
            }
        }
    }

    private static boolean isValid(String s,int startIndex,int endIndex) {
        int num=0;
        if(startIndex>endIndex){
            return false;
        }
        //以0开头  且不是单位  为false
        if(s.charAt(startIndex)=='0' && startIndex!=endIndex){
            return false;
        }
        for (int i = startIndex; i <= endIndex; i++) {
            if(s.charAt(i)<'0' || s.charAt(i)>'9'){
                return false;
            }
            num=num*10+s.charAt(i)-'0';
            if(num>255){
                return false;
            }

        }
        return true;

    }
}
