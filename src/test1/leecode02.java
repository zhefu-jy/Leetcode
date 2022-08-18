package test1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class leecode02 {
    public static void main(String[] args) {
        int []nums=new int[]{4,3,2,7,8,3,2,1};
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
            if(nums[Math.abs(nums[i])-1]<0) {
                res.add(Math.abs(nums[i]));
            }else {
                nums[Math.abs(nums[i])-1]*=-1;
            }
        }


        System.out.println(res);

    }
}
