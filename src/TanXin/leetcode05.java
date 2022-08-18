package TanXin;

public class leetcode05 {
    public static void main(String[] args) {
        int []nums=new int[]{2,3,1,1,4};
    }
    public static boolean canJump(int[] nums) {

       int range=0;
        for (int i = 0; i <=range ; i++) {
            range=Math.max(range,nums[i]+i);
            if(range>=nums.length-1){
                return true;
            }
        }
        return  false;
    }

}
