package BackTrack;

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
public class leetcode14 {
    public static void main(String[] args) {
        int []nums=new  int[]{3,30,34,5,9};
        int index=0;
        int len=nums.length;
        StringBuilder  stringBuilder=new StringBuilder();
        StringBuilder  maxValue=new StringBuilder();
        dfs(nums,len,index,stringBuilder,maxValue);
        System.out.println(maxValue.toString());

    }

    private static void dfs(int[] nums, int len, int index, StringBuilder stringBuilder, StringBuilder maxValue) {
        if(index>=len){
            return;
        }

        for (int i = index; i <len ; i++) {
            stringBuilder.append(nums[i]);
            maxValue = getMaxValue(stringBuilder, maxValue);
            dfs(nums,len,i+1,stringBuilder,maxValue);
          stringBuilder=new StringBuilder(stringBuilder.substring(0,stringBuilder.length()-String.valueOf(nums[i]).length()));
        }
    }

    private static StringBuilder getMaxValue(StringBuilder stringBuilder, StringBuilder maxValue) {
        if(maxValue.length()<stringBuilder.length()){
            return stringBuilder;
        }

        String s = stringBuilder.toString();
        String s1 = maxValue.toString();
        for (int i = 0; i <s.length() ; i++) {
            if(s.charAt(i)-'0' < s1.charAt(i)-'0'){
                return maxValue;
            }else if(s.charAt(i)-'0' > s1.charAt(i)-'0'){
                return stringBuilder;
            }else{
                continue;
            }
        }
        return stringBuilder;
    }


}
