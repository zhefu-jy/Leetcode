package AboutString;

public class test2 {
    public static void main(String[] args) {
      String  s="aba";
      String s1="abab";
      int []next=new int[s.length()];
      int []next2=new int[s1.length()];
      getNext(next,s);
      getNext(next2,s1);
        for (int i : next) {

            System.out.println(i);
        }
        for (int i:next2){
            System.out.println(i);
        }
    }


    public static boolean repeatedSubstringPattern(String s) {
        if(s.length()==1){
            return false;
        }
        int []next=new int[s.length()];
        getNext(next,s);
        System.out.println(next[s.length()-1]);
        System.out.println(s.length()/(next[s.length()-1]));
        if(next[s.length()-1]>0 && s.length()%(next[s.length()-1])==0){
            return true;
        }
        return false;

    }
    public  static void getNext(int []next,String s){
        int j=0;
        next[0]=0;
        for(int i=1;i<s.length();i++){
            while(j>0 && s.charAt(i)!=s.charAt(j)){
                j=next[j-1];
            }
            if(s.charAt(i)==s.charAt(j)){
                j++;
            }
            next[i]=j;
        }
    }
}
