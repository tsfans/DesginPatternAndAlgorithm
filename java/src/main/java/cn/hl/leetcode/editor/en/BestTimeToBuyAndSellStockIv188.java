package cn.hl.leetcode.editor.en;
//You are given an integer array prices where prices[i] is the price of a given 
//stock on the iᵗʰ day, and an integer k. 
//
// Find the maximum profit you can achieve. You may complete at most k 
//transactions. 
//
// Note: You may not engage in multiple transactions simultaneously (i.e., you 
//must sell the stock before you buy again). 
//
// 
// Example 1: 
//
// 
//Input: k = 2, prices = [2,4,1]
//Output: 2
//Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 
//4-2 = 2.
// 
//
// Example 2: 
//
// 
//Input: k = 2, prices = [3,2,6,5,0,3]
//Output: 7
//Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 
//6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3
//-0 = 3.
// 
//
// 
// Constraints: 
//
// 
// 0 <= k <= 100 
// 0 <= prices.length <= 1000 
// 0 <= prices[i] <= 1000 
// 
// Related Topics Array Dynamic Programming 👍 3591 👎 150

import java.util.Arrays;

public class BestTimeToBuyAndSellStockIv188 {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockIv188().new Solution();
        int k = 2;
        int[] prices = new int[]{0, 8, 5, 7, 4, 7};
        int res = solution.maxProfit2(k, prices);
        System.out.println(res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * dp[i][k][0]
         * i-第i天的价格
         * k-当天允许的最大交易次数,一次交易=buy+sell,因此buy时k-1
         * 0-未持有股票,1-持有股票
         * base case
         * dp[-1][k][0] = dp[i][0][0] = 0 无股票可交易或不允许交易,不持有股票,利润为0
         * dp[-1][k][1] = dp[i][0][1] = -Infinity 无股票可交易或不允许交易,持有股票,利润为负(设为-Infinity方便后续取最大值)
         * 列出状态转移方程
         * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
         * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
         * 此题中k=随机值,因此分为两种情况
         * 1.k > n/2 此时跟k=+Infinity无区别,可认为k与k-1没区别,利润是一样的,k>n/2后利润只跟股票数n有关
         * 状态方程为
         * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
         * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]) = max(dp[i-1][k][1], dp[i-1][k][0] - prices[i])
         * 最终解只依赖dp[i-1][k][0]和dp[i-1][k][1]
         * TC=O(N),SC=O(1)
         * 2.k <= n/2
         * 需要嵌套遍历k,状态方程为
         * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
         * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
         * base case为
         * int[] dp_ik0 = new int[k+1] 初始化为0
         * int[] dp_ik1 = new int[k+1] 初始化为Integer.MIN_VALUE
         * TC=O(Nk),SC=O(k)
         */
        public int maxProfit2(int k, int[] prices) {
            if (k >= prices.length >>> 2) {
                // 等同于k=+Infinity
                int dp_ik0 = 0, dp_ik1 = Integer.MIN_VALUE;
                for (int price : prices) {
                    dp_ik0 = Math.max(dp_ik0, dp_ik1 + price);
                    dp_ik1 = Math.max(dp_ik1, dp_ik0 - price);
                }
                return dp_ik0;
            }
            // base case
            int[] dp_ik0 = new int[k + 1];
            int[] dp_ik1 = new int[k + 1];
            Arrays.fill(dp_ik1, Integer.MIN_VALUE);
            // 嵌套遍历k
            for (int price : prices) {
                for (int j = k; j > 0; j--) {
                    dp_ik0[j] = Math.max(dp_ik0[j], dp_ik1[j] + price);
                    dp_ik1[j] = Math.max(dp_ik1[j], dp_ik0[j - 1] - price);
                }
            }

            // 交易次数最多且不持有股票时收益最大
            return dp_ik0[k];
        }

        public int maxProfit(int k, int[] prices) {
            if (k >= prices.length >>> 1) {
                int T_ik0 = 0, T_ik1 = Integer.MIN_VALUE;

                for (int price : prices) {
                    int T_ik0_old = T_ik0;
                    T_ik0 = Math.max(T_ik0, T_ik1 + price);
                    T_ik1 = Math.max(T_ik1, T_ik0_old - price);
                }

                return T_ik0;
            }

            int[] T_ik0 = new int[k + 1];
            int[] T_ik1 = new int[k + 1];
            Arrays.fill(T_ik1, Integer.MIN_VALUE);

            for (int price : prices) {
                for (int j = k; j > 0; j--) {
                    T_ik0[j] = Math.max(T_ik0[j], T_ik1[j] + price);
                    T_ik1[j] = Math.max(T_ik1[j], T_ik0[j - 1] - price);
                }
            }

            return T_ik0[k];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}