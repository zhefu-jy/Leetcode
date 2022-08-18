package DP;
/**
 * @Date: 2022/8/2 10:11
 * @Author: ZheFu
 * 309. 最佳买卖股票时机含冷冻期
 * 给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。​
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 示例 1:
 *
 * 输入: prices = [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 * 示例 2:
 *
 * 输入: prices = [1]
 * 输出: 0
 *
 *
 * 提示：
 *
 * 1 <= prices.length <= 5000
 * 0 <= prices[i] <= 1000
 *
 */
public class leetcode20 {

    /**
     * @Date: 2022/8/2 10:20
     * @Author: ZheFu
     *
     * 状态总结
     *
     * 状态一：买入股票状态（今天买入股票，或者是之前就买入了股票然后没有操作）
     * 卖出股票状态，这里就有两种卖出股票状态
     * 状态二：两天前就卖出了股票，度过了冷冻期，一直没操作，今天保持卖出股票状态
     * 状态三：今天卖出了股票
     * 状态四：今天为冷冻期状态，但冷冻期状态不可持续，只有一天！
     * j的状态为：
     *
     * 0：状态一
     * 1：状态二
     * 2：状态三
     * 3：状态四
     */
    public static void main(String[] args) {
        int []prices=new int[]{1,2,3,0,2};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int [][]dp=new int[prices.length][4];
        dp[0][0]=-prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] =Math.max(dp[i-1][0],Math.max(dp[i - 1][3], dp[i - 1][1])-prices[i]);
            dp[i][1] =Math.max(dp[i-1][1],dp[i-1][3]);
            dp[i][2] =dp[i-1][0]+prices[i];
            dp[i][3] = dp[i-1][2];
        }

        return Math.max(dp[prices.length- 1][3],Math.max(dp[prices.length - 1][1], dp[prices.length- 1][2]));

    }
}
