package TanXin;

/**
 * 45. 跳跃游戏 II
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 假设你总是可以到达数组的最后一个位置。
 * 示例 1:
 *
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 示例 2:
 *
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 */
public class leetcode06 {
    public static void main(String[] args) {
        int []nums=new int[]{2,3,1,1,4};
        System.out.println(jump(nums));

    }
    public static int jump(int[] nums) {
        int position=nums.length-1;
        int count=0;
        while (position>0){
            for (int i = 0; i <position ; i++) {
                int temp=i+nums[i];
                if(temp>=position){
                    position=i;
                    count++;
                    break;
                }
            }
        }
        return count;

    }
}
