package SwordFingerOffer;

public class leetcode17 {
    public static void main(String[] args) {

    }
}

class  TrieNode{
    boolean isEnd;
    TrieNode[] next;

    public TrieNode() {
        next = new TrieNode[26];
    }
}

class Trie {

    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root=new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur=root;

        for(char ch:word.toCharArray()){
            if(cur.next[ch-'a']==null){
                cur.next[ch-'a']=new TrieNode();
            }
           cur=cur.next[ch-'a'];
        }
        cur.isEnd=true;

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur=root;
        for(char ch:word.toCharArray()){
            if(cur.next[ch-'a']==null){
                return false;
            }
            cur=cur.next[ch-'a'];
        }
        return cur.isEnd;

    }
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur=root;
        for(char ch:prefix.toCharArray()){
            if(cur.next[ch-'a']==null){
                return false;
            }
            cur=cur.next[ch-'a'];
        }
        return true;

    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
