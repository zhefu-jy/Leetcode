package test1;

import java.util.ArrayList;
import java.util.HashSet;

/**
 ��ָ Offer II 005. ���ʳ��ȵ����˻�
 ����һ���ַ������� words������㵱�����ַ��� words[i] �� words[j] ��������ͬ�ַ�ʱ�����ǳ��ȵĳ˻������ֵ�������ַ�����ֻ����Ӣ���Сд��ĸ�����û�в�������ͬ�ַ���һ���ַ��������� 0��

 ʾ�� 1:

 ����: words = ["abcw","baz","foo","bar","fxyz","abcdef"]
 ���: 16
 ����: ����������Ϊ "abcw", "fxyz"�����ǲ�������ͬ�ַ����ҳ��ȵĳ˻����
 ʾ�� 2:

 ����: words = ["a","ab","abc","d","cd","bcd","abcd"]
 ���: 4
 ����: ����������Ϊ "ab", "cd"��
 ʾ�� 3:

 ����: words = ["a","aa","aaa","aaaa"]
 ���: 0
 ����: �������������������ʡ�
 4194311  33554435
 */
public class leecode01 {
    public static void main(String[] args) {
        String[] words = {"abcw", "baz", "foo", "bar", "fxyz", "abcdef"};
        int max=0;
        int len = words.length;
        int [] nums = new int [len];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <words[i].length() ; j++) {
                nums[i]|=(1<<words[i].charAt(j)-'a');
            }
        }
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j <nums.length ; j++) {
                if((nums[i]& nums[j])==0){
                   max=Math.max(max,words[i].length()*words[j].length());
                }
            }

        }
       // return max;
    }
}
