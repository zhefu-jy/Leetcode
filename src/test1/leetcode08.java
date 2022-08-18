package test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode08 {
    public static void main(String[] args) {
        String s="cbaebabacd";
        String p="abc";
        char[] chars = p.toCharArray();

        Arrays.sort(chars);

        String temp = String.valueOf(chars);
        List<Integer> res=new ArrayList<>();
        for (int i = 0; i <=s.length()-p.length() ; i++) {
            String sub = s.substring(i, i + p.length());
            char[] array = sub.toCharArray();
            Arrays.sort(array);
            String s1 = String.valueOf(array);
           if(s1.equals(temp)){
                res.add(i);
            }

        }

        System.out.println(res);
    }
}
