package SwordFingerOffer;

/**
 * 剑指 Offer II 070. 排序数组中只出现一次的数字
 * 给定一个只包含整数的有序数组 nums ，每个元素都会出现两次，唯有一个数只会出现一次，请找出这个唯一的数字。
 *
 * 你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。
 * 示例 1:
 *
 * 输入: nums = [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums =  [3,3,7,7,10,11,11]
 * 输出: 10
 */
public class leetcode21 {
    public static void main(String[] args) {
        int []nums=new int[]{1,1,2,3,3,4,4,8,8};
        System.out.println(singleNonDuplicate2(nums));


    }
    public static int singleNonDuplicate(int[] nums) {
        int res=0;
        for (int i = 0; i < nums.length; i++) {
            res=res ^ nums[i];
        }
        return res;

    }

    public  static  int singleNonDuplicate2(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            //mid ^1  mid是奇数 mid-1  mid是偶数  mid+1
            if (nums[mid] == nums[mid ^ 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }
}
