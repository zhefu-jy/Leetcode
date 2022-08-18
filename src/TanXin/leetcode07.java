package TanXin;

import java.util.Arrays;

public class leetcode07 {
    public static void main(String[] args) {
        int []nums=new int[]{-4,-2,-3};
        int k=4;
        System.out.println(largestSumAfterKNegations(nums, k));

    }

    public  static  int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int res=0;
        if(nums[0]>=0){
            if(k%2==0){
                return ArraySum(nums);
            }else{
                return ArraySum(nums)-2*nums[0];
            }
        }else{
            for (int i = 0; i <nums.length; i++) {
                if(k>0 && nums[i]<0){
                    k--;
                    nums[i]=-nums[i];
                    continue;
                }
                if(k>0 && nums[i]>=0){
                    Arrays.sort(nums);
                    if(k%2==0){
                       break;
                    }else{

                       nums[0]=-nums[0];
                       k=0;
                       break;
                    }
                }

            }

            if(k%2==1){
                Arrays.sort(nums);
                nums[0]=-nums[0];
            }
            return ArraySum(nums);
        }

    }

    public static  int ArraySum(int []nums){
        int res=0;
        for (int num : nums) {
            res+=num;
        }
        return  res;
    }
}
