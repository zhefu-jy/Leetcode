package Sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 179. 最大数
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * 示例 1：
 *
 * 输入：nums = [10,2]
 * 输出："210"
 * 示例 2：
 *
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 */
public class leetcode01 {
    public static void main(String[] args) {
        int []nums=new int[]{3,30,34,5,9};
        System.out.println(largestNumber(nums));
    }
    public  static String largestNumber(int[] nums) {
        String[] s = new String[nums.length];
        for (int i = 0; i < s.length; i++) {
            s[i]=String.valueOf(nums[i]);
        }

        Arrays.sort(s, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            builder.append(s[i]);
        }


        String s1 = builder.toString();
        if(s1.charAt(0)=='0'){
            return "0";
        }
        return s1;


    }
}
