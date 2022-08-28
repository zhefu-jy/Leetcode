package Daily;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 678. 有效的括号字符串
 * 给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
 *
 * 任何左括号 ( 必须有相应的右括号 )。
 * 任何右括号 ) 必须有相应的左括号 ( 。
 * 左括号 ( 必须在对应的右括号之前 )。
 * * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
 * 一个空字符串也被视为有效字符串。
 * 示例 1:
 * 输入: "()"
 * 输出: True
 * 示例 2:
 *
 * 输入: "(*)"
 * 输出: True
 * 示例 3:
 *
 * 输入: "(*))"
 * 输出: True
 * 注意:
 *
 * 字符串大小将在 [1，100] 范围内。
 */
public class leetcode07 {
    public static void main(String[] args) {
        String s="(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*(((((**(**)";
        System.out.println(checkValidString(s));
        Deque<Integer> leftStack = new LinkedList<Integer>();
        leftStack.push(1);
        leftStack.push(1);
        leftStack.push(1);




    }

    public static boolean checkValidString(String s) {
        Deque<Integer> leftStack = new LinkedList<Integer>();
        Deque<Integer> asteriskStack = new LinkedList<Integer>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                //存储下标
                leftStack.push(i);
            } else if (c == '*') {
                //存储下标
                asteriskStack.push(i);
            } else {
                //遇到 ）  先pop （  再pop *
                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                } else if (!asteriskStack.isEmpty()) {
                    asteriskStack.pop();
                } else {
                    return false;
                }
            }
        }

        //结果可能还会剩余  （ *   因为存储的是索引位置  所以要要求  （ 的下标大于*的下标  ((*(
        //比如这种情况  左括号栈  数据为  0  1  3     星号栈为  2  但这种情况是不成立的
        while (!leftStack.isEmpty() && !asteriskStack.isEmpty()) {
            int leftIndex = leftStack.pop();
            int asteriskIndex = asteriskStack.pop();
            if (leftIndex > asteriskIndex) {
                return false;
            }
        }
        return leftStack.isEmpty();

    }

}
