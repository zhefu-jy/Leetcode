package SwordFingerOffer;

import java.util.Arrays;

/**
 * 一个偶数 可以分解为两个素数的和  求这两个素数的差值最小是  素数的值
 */
public class leetcode46 {
    public static void main(String[] args) {
        int target=20;
        System.out.println(Arrays.toString(getMin(target)));
    }

    public static int[] getMin(int num){
        int []res=new int[2];
        int left=num/2;
        int right=num/2;
        while (left + right ==num){
            if(isSu(left) && isSu(right)){
                res[0]=left;
                res[1]=right;
                return res;
            }else{
                left--;
                right++;
            }
        }
        return res;

    }


    public static  boolean isSu(int num){
        for (int i = 2; i <num ; i++) {
            if(num % i ==0){
                return false;
            }
        }
        return true;
    }
}
