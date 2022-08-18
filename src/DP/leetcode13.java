package DP;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 139. 单词拆分
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 * 示例 1：
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 * 示例 2：
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
 * 注意，你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 * 提示：
 *
 * 1 <= s.length <= 300
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 20
 * s 和 wordDict[i] 仅有小写英文字母组成
 * wordDict 中的所有字符串 互不相同
 */
public class leetcode13 {
    public static void main(String[] args) {
        List<String>  wordDict=new ArrayList<>(Arrays.asList("apple", "pen"));
        String s="applepenapple";
        System.out.println(wordBreak(s, wordDict));
        System.out.println(wordBreak1(s, wordDict));


    }
    /**
     * @Date: 2022/7/30 11:09
     * @Author: ZheFu
     *动态规划
     */
    public  static boolean wordBreak1(String s, List<String> wordDict) {
        boolean [] valid=new boolean[s.length()+1];
         valid[0]=true;
         //先遍历物品 在遍历背包
        for (int i = 1; i <=s.length() ; i++) {
            for (int j = 0; j <i ; j++) {
                if(wordDict.contains(s.substring(j,i)) && valid[j]){
                    valid[j]=true;
                }
            }
        }
        return valid[s.length()];

    }




    /**
     * @Date: 2022/7/30 11:09
     * @Author: ZheFu
     * 回溯
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        StringBuilder str=new StringBuilder();
        ArrayList<Integer> list = new ArrayList<>();
        int res=0;
       backTrack(s, wordDict, str,list);
       return list.size()>0;

    }

    private static void backTrack(String s, List<String> wordDict, StringBuilder str,ArrayList<Integer> list) {
        if(str.toString().length()>s.length()){
            return;
        }
        if(str.toString().length()==s.length() && !str.toString().equals(s) ){
            return;
        }
        if(str.toString().equals(s)){
            list.add(new Integer(1));
            return;
        }
        for (int i = 0; i < wordDict.size(); i++) {
            str.append(wordDict.get(i));
            backTrack(s,wordDict,str,list);
            str.delete(str.length()-wordDict.get(i).length(),str.length());
        }

    }
}
