package SwordFingerOffer;

/**
 * 剑指 Offer II 073. 狒狒吃香蕉
 * 狒狒喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。
 * 狒狒可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉，下一个小时才会开始吃另一堆的香蕉。
 * 狒狒喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。
 * 示例 1：
 *
 * 输入：piles = [3,6,7,11], h = 8
 * 输出：4
 * 示例 2：
 *
 * 输入：piles = [30,11,23,4,20], h = 5
 * 输出：30
 * 示例 3：
 *
 * 输入：piles = [30,11,23,4,20], h = 6
 * 输出：23
 *
 */
public class leetcode13 {
    /**
     * @Date: 2022/8/20 9:58
     * @Author: ZheFu
     *
     * 思路  二分
     */
    public static void main(String[] args) {
        int []piles=new int[]{30,11,23,4,20};
        int h=5;
        System.out.println(minEatingSpeed(piles, h));


    }
    public static int minEatingSpeed(int[] piles, int h) {
        int left=1;
        int max=-1;
        for (int pile : piles) {
            max=Math.max(max,pile);
        }
        int right=max;

        while (left<right){
            int mid=left+(right-left)/2;
            if(calTime(piles,mid)>h){
                left=mid+1;
            }else{
                right=mid;
            }

        }
        return left;
    }

    public static int calTime(int []piles,int mid){
        int res=0;
        for (int i = 0; i <piles.length ; i++) {
            if(piles[i]<=mid){
                res++;
            }else{
                res=res+(piles[i]/mid);
                int temp=piles[i]%mid;
                if(temp!=0){
                    res++;
                }
            }
        }
        return res;

    }

}
