package Daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 166. 分数到小数
 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数 。
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 *
 * 如果存在多个答案，只需返回 任意一个 。
 * 对于所有给定的输入，保证 答案字符串的长度小于 104 。
 * 示例 1：
 *
 * 输入：numerator = 1, denominator = 2
 * 输出："0.5"
 * 示例 2：
 *
 * 输入：numerator = 2, denominator = 1
 * 输出："2
 *
 * 示例 3：
 * 输入：numerator = 4, denominator = 333
 * 输出："0.(012)"
 */
public class leetcode16 {
    public static void main(String[] args) {
        int numerator = -50, denominator = 8;
        System.out.println(fractionToDecimal(numerator, denominator));


    }
    public  static  String fractionToDecimal(int numerator, int denominator) {
        StringBuilder res=new StringBuilder();
        ArrayList<Integer> list=new ArrayList<>();
        long num1=(long)numerator;
        long num2=(long)denominator;
        if(num1 % num2==0){
            return String.valueOf(num1/num2);
        }
        if((numerator < 0 && denominator > 0) || (numerator > 0 && denominator< 0)){
            res.append("-");
        }
        
         num1=Math.abs(num1);
         num2=Math.abs(num2);
        long integerPart=num1/num2;
        res.append(integerPart);
        res.append(".");

        //小数部分
        StringBuffer fractionPart = new StringBuffer();
        Map<Long, Integer> remainderIndexMap = new HashMap<Long, Integer>();
        long remainder = num1 % num2;
        int index = 0;
        while (remainder!=0 && !remainderIndexMap.containsKey(remainder)){
            remainderIndexMap.put(remainder,index);
            remainder*=10;
            fractionPart.append(remainder/num2);
            remainder%=denominator;
            index++;
        }
        if (remainder != 0) { // 有循环节
            int insertIndex = remainderIndexMap.get(remainder);
            fractionPart.insert(insertIndex, '(');
            fractionPart.append(')');
        }
        res.append(fractionPart.toString());

        return res.toString();

    }
}
