package test1;

import java.util.LinkedList;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 *
 * 给定一个仅包含数字?2-9?的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leecode05 {
    public static void main(String[] args) {
        String digits="23";
       String []s=new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> res=new LinkedList<>();
        if(digits.length()==0){
            //return res;
        }
        if(digits.length()==1){
            char [] arr=s[Integer.valueOf(digits)].toCharArray();
            for (char c : arr) {
                res.add(String.valueOf(c));
            }
        }

       if(digits.length()==2){
            char []arr1=s[Integer.valueOf(digits.charAt(0)-'0')].toCharArray();
            char []arr2=s[Integer.valueOf(digits.charAt(1)-'0')].toCharArray();
            for (char c : arr1) {
                for (char c1 : arr2) {
                    StringBuilder builder = new StringBuilder();
                    builder.append(c);
                    builder.append(c1);
                    res.add(builder.toString());
                }
            }
        }

        if(digits.length()==3){
            char []arr1=s[Integer.valueOf(digits.charAt(0)-'0')].toCharArray();
            char []arr2=s[Integer.valueOf(digits.charAt(1)-'0')].toCharArray();
            char []arr3=s[Integer.valueOf(digits.charAt(1)-'0')].toCharArray();
            for (char c : arr1) {
                for (char c1 : arr2) {
                    for (char c2 : arr3) {
                        StringBuilder builder = new StringBuilder();
                        builder.append(c);
                        builder.append(c1);
                        builder.append(c2);
                        res.add(builder.toString());
                    }
                }
            }
        }

        if(digits.length()==4){
            char []arr1=s[Integer.valueOf(digits.charAt(0)-'0')].toCharArray();
            char []arr2=s[Integer.valueOf(digits.charAt(1)-'0')].toCharArray();
            char []arr3=s[Integer.valueOf(digits.charAt(1)-'0')].toCharArray();
            char []arr4=s[Integer.valueOf(digits.charAt(1)-'0')].toCharArray();
            for (char c : arr1) {
                for (char c1 : arr2) {
                    for (char c2 : arr3) {
                        for (char c3 : arr4) {


                            StringBuilder builder = new StringBuilder();
                            builder.append(c);
                            builder.append(c1);
                            builder.append(c2);
                            builder.append(c3);
                            res.add(builder.toString());
                        }
                    }
                }
            }
        }
        System.out.println(res);


    }
}
