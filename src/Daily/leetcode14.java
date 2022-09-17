package Daily;

public class leetcode14 {
    public static void main(String[] args) {
        int []nums=new int[]{10,5,2,6};
        int k=100;
        System.out.println(numSubarrayProductLessThanK(nums, k));
    }
    public  static  int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1){
            return 0;
        }
         int res=0;
         int cur=1;
        for (int i = 0,j=0; i < nums.length ; i++) {
            cur*=nums[i];
            while (cur>=k){
                cur/=nums[j++];
            }
            res+=i-j+1;
        }
        return res;
    }
}
