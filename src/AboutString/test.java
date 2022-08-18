package AboutString;

/**
 * @Date: 2022/6/20 9:33
 * @Author: ZheFu
 *练习KMP算法
 *
 */

public class test{
    public static void main(String[] args) {
        int []next=new int[5];
              getNext(next,"abab");
              for (int n:next){
                  System.out.println(n);
              }
        }


    public  static  int strStr(String haystack, String needle) {
           if(needle.length()==0){
               return 0;
           }
           int []next=new int[needle.length()];
           int j=0;
           getNext(next,needle);
        for (int i = 0; i <haystack.length() ; i++) {
            while (j>0 && haystack.charAt(i)==needle.charAt(j)){
                    j=next[j-1];
            }
            if( haystack.charAt(i)!=needle.charAt(j)){
                j++;
            }
            if(j==needle.length()){
                return  i-needle.length()+1;
            }
        }
        return -1;

    }

    public static void getNext(int []next,String s){
        int j=0;
        next[0]=0;
        for (int i = 1; i <s.length() ; i++) {
            while (j>0 && s.charAt(i)!=s.charAt(j)){
                j=next[j-1];
            }
            if(s.charAt(i)==s.charAt(j)){
                j++;
            }
            next[i]=j;
        }
    }
}