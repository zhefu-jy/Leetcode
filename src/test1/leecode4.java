package test1;

import com.sun.org.apache.xml.internal.utils.StringToIntTable;

/**
 * ����һ��������СдӢ����ĸ�� '?' �ַ����ַ��� s�����㽫���е� '?' ת��Ϊ����Сд��ĸ��ʹ���յ��ַ����������κ� �����ظ� ���ַ���
 *
 * ע�⣺�� ���� �޸ķ� '?' �ַ���
 *
 * ��Ŀ����������֤ �� '?' �ַ� ֮�⣬�����������ظ����ַ���
 *
 * ���������ת������������ת�����󷵻����յ��ַ���������ж������������뷵�������κ�һ��������֤�����ڸ�����Լ�������£������Ǵ��ڵġ�
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
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
