package TanXin;

public class leetcode02 {
    public static void main(String[] args) {
        int []nums=new int[]{1,17,5,10,13,15,10,5,16,8};
        System.out.println(wiggleMaxLength(nums));
        System.out.println(wiggleMaxLength2(nums));

    }

    public static int wiggleMaxLength(int[] nums) {
        if(nums.length<=1){
            return nums.length;
        }
        int curDiff=0;
        int preDiff=0;
        int count=1;
        for (int i = 1; i <nums.length ; i++) {
            curDiff=nums[i]-nums[i-1];

            if((curDiff>0 && preDiff<=0 )|| (curDiff<0 && preDiff>=0)){
                count++;
                preDiff=curDiff;
            }
        }
        return count;

    }

    public static int wiggleMaxLength2(int[] nums) {
        int [][]dp=new int[nums.length][2];
        dp[0][0]=dp[0][1]=1;
        for (int i = 1; i <nums.length ; i++) {
            dp[i][0]=dp[i][1]=1;

            for (int j = 0; j <i ; j++) {
               if(nums[i]>nums[j]){
                   dp[i][0]=Math.max(dp[i][0],dp[i][1]+1);
               }
               if(nums[i]<nums[j]){
                    dp[i][1]=Math.max(dp[i][1],dp[i][0]+1);
                }
            }

        }
        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }
}
