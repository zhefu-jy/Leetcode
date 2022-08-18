package test1;

import java.util.*;

/**
 * 49. ��ĸ��λ�ʷ���
 * ����һ���ַ������飬���㽫 ��ĸ��λ�� �����һ�𡣿��԰�����˳�򷵻ؽ���б�
 *
 * ��ĸ��λ�� ������������Դ���ʵ���ĸ�õ���һ���µ��ʣ�����Դ�����е���ĸͨ��ǡ��ֻ��һ�Ρ�
 *
 *
 *
 * ʾ�� 1:
 *
 * ����: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * ���: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * ʾ�� 2:
 *
 * ����: strs = [""]
 * ���: [[""]]
 * ʾ�� 3:
 *
 * ����: strs = ["a"]
 * ���: [["a"]]
 */

public class leecode06 {
    public static void main(String[] args) {
        String []strs=new String[]{"eat","tea","tan","ate","nat","bat"};
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = String.valueOf(chars);
            if(map.containsKey(s)){
                ArrayList<String> strings = map.get(s);
                strings.add(str);
            }
        }

        System.out.println(map.values());
    }
}
