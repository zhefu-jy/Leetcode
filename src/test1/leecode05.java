package test1;

import java.util.LinkedList;
import java.util.List;

/**
 * 17. �绰�������ĸ���
 *
 * ����һ������������?2-9?���ַ����������������ܱ�ʾ����ĸ��ϡ��𰸿��԰� ����˳�� ���ء�
 *
 * �������ֵ���ĸ��ӳ�����£���绰������ͬ����ע�� 1 ����Ӧ�κ���ĸ��
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
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
