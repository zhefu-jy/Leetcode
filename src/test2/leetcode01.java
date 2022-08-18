package test2;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 剑指 Offer 05. 替换空格
 */
public class leetcode01 {
    public static void main(String[] args) {
        String s="We are happy.";
        String replace="%20";
        StringBuilder builder = new StringBuilder();
        for (int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                builder.append(replace);
                continue;
            }
            builder.append(s.charAt(i));

        }
        String s1 = builder.toString();
        System.out.println(s1);


        ArrayList<Integer> list = new ArrayList<>();
        Integer[] array = (Integer[]) list.toArray();

        Stack stack=new Stack();

    }
}
