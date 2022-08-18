package DP;

/**
 * 494. 目标和
 * 给你一个整数数组 nums 和一个整数 target 。
 *
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。

 * 示例 1：
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * 示例 2：
 *
 * 输入：nums = [1], target = 1
 * 输出：1
 * 提示：
 *
 * 1 <= nums.length <= 20
 * 0 <= nums[i] <= 1000
 * 0 <= sum(nums[i]) <= 1000
 * -1000 <= target <= 1000
 */
public class leetcode07 {
    public static void main(String[] args) {
       int []nums=new int[]{1,1,1,1,1};
       int target=3;
      //  System.out.println(findTargetSumWays(nums, target));
        int targetSumWays1 = findTargetSumWays1(nums, target);
        System.out.println(targetSumWays1);
    }
    /**
     * @Date: 2022/7/28 10:14
     * @Author: ZheFu
     * 动态规划
     * left-(sum-left)=target
     * left=(sum+target)/2
     */
    public static int findTargetSumWays1(int[] nums, int target) {
        int sum=0;
        for (int num : nums) {
            sum+=num;
        }
        if((sum+target)%2==1){
            return 0;
        }

        int size=(sum+target)/2;
        if(size<0){
            size=-1*size;
        }

        int []dp=new int[size+1];
        dp[0]=1;
        for (int i = 0; i <nums.length ; i++) {
            for (int j = size; j >=nums[i] ; j--) {
                dp[j]+=dp[j-nums[i]];
            }
        }

        return  dp[size];

    }


    /**
     * @Date: 2022/7/28 8:41
     * @Author: ZheFu
     *回溯
     */
    public static int res=0;
    
    public  static  int findTargetSumWays(int[] nums, int target) {
        int index=0;//遍历索引
        int temp=0; //累加结果
        backTrack(nums,target,temp,index);
       return  res;
    }

    private static void backTrack(int[] nums, int target,  int temp,int index) {
        if(index==nums.length){
            if(temp==target){
                res++;
            }
        }else{
            backTrack(nums,target,temp-nums[index],index+1);
            backTrack(nums,target,temp+nums[index],index+1);
        }
    }
    

}
