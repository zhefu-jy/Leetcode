package SwordFingerOffer;

import java.util.Arrays;
import java.util.Comparator;

public class leetcode18 {
    public static void main(String[] args) {
        String []word=new String[]{"time", "me", "bell"};
        System.out.println(minimumLengthEncoding(word));

    }

    public  static int minimumLengthEncoding(String[] words) {
        int len=0;
        Trie trie = new Trie();
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length()-o1.length();
            }
        });
        for (String word : words) {
            len+=trie.insert(word);

        }
        return len;

    }

   static   class TrieNode{
        TrieNode[] next;

        public TrieNode() {
            next = new TrieNode[26];
        }
    }

    static  class Trie{
        TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public int insert(String s){
            TrieNode cur=root;
            boolean isNew=false;

            for (int i = s.length()-1; i >=0; i--) {
                char c=s.charAt(i);
                 if(cur.next[c-'a']==null){
                     isNew=true;
                     cur.next[c-'a']=new TrieNode();
                 }
                 cur=cur.next[c-'a'];

            }

            return isNew ? s.length()+1:0;


        }
    }

}
