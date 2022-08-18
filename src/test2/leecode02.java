package test2;

public class leecode02 {
    public static void main(String[] args) {
        int []nums=new int[]{10,9,2,5,3,7,101,18};
        int len=nums.length;
        int []dp=new int[len];
        dp[0]=1;
        int max=1;
         for(int i=1;i<len;i++) {
           dp[i] = 1;
           for (int j = 0; j < i; j++) {
               if (nums[j] < nums[i]) {
                   System.out.println("当前比较的数是"+nums[j]+"和"+nums[i]);
                   dp[i] = Math.max(dp[i], dp[j] + 1);


               }
           }
           max = Math.max(max, dp[i]);
         }
        System.out.println(max);


    }
}
