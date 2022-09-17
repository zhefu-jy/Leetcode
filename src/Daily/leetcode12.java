package Daily;

import java.util.HashMap;

public class leetcode12 {
    public static void main(String[] args) {
        int []nums=new int[]{0,1,0};
        System.out.println(findMaxLength(nums));
    }

    public static int findMaxLength(int[] nums) {
        //将0 看做-1  就可以将问题化简为  子数组和为0的最大长度
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0){
                nums[i]=-1;
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int maxLen=0,sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            //如果当前前缀和不存在map中就put进去
            //但是如果containsKey  在这之间就一定出现过和为0的子数组了，就更新长度    比如[-1,1,1,1,1,1,-1,-1]
            //在索引为5之前  map都不containsKey  在6  7出 出现和为0的情况 就更新长度
            if(map.containsKey(sum)){
                maxLen=Math.max(maxLen,i-map.get(sum));
            }else{
                map.put(sum,i);
            }

        }
        return maxLen;

    }
}
