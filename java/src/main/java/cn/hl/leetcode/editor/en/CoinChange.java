package cn.hl.leetcode.editor.en;
//You are given an integer array coins representing coins of different 
//denominations and an integer amount representing a total amount of money. 
//
// Return the fewest number of coins that you need to make up that amount. If 
//that amount of money cannot be made up by any combination of the coins, return -1.
// 
//
// You may assume that you have an infinite number of each kind of coin. 
//
// 
// Example 1: 
//
// 
//Input: coins = [1,2,5], amount = 11
//Output: 3
//Explanation: 11 = 5 + 5 + 1
// 
//
// Example 2: 
//
// 
//Input: coins = [2], amount = 3
//Output: -1
// 
//
// Example 3: 
//
// 
//Input: coins = [1], amount = 0
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 2³¹ - 1 
// 0 <= amount <= 10⁴ 
// 
// Related Topics Array Dynamic Programming Breadth-First Search 👍 10055 👎 246
//

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        Solution solution = new CoinChange().new Solution();

        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 使用dp表保存结果
        int[] dp;

        public int coinChange(int[] coins, int amount) {
            dp = new int[amount + 1];
            // 使用非结果的特殊值初始化数组
            Arrays.fill(dp, -2);
            return dpTraverse(coins, amount);
        }

        /**
         * 动态规划迭代遍历解法
         * dp定义: 对于金额amount来说,最少需要dp[amount]枚硬币凑出
         */
        private int dpTraverse(int[] coins, int amount) {
            // base case
            dp[0] = 0;
            // 遍历所有金额
            for (int i = 1; i < dp.length; i++) {
                // 遍历所有硬币
                for (int coin : coins) {
                    int remain = i - coin;
                    if (remain < 0 || dp[remain] == -2) {
                        continue;//无解
                    }
                    dp[i] = Math.min(dp[i] == -2 ? Integer.MAX_VALUE : dp[i], dp[remain] + 1);
                }
            }
            return dp[amount] == -2 ? -1 : dp[amount];
        }

        /**
         * 动态规划递归解法
         *
         * @param coins  可选的硬币
         * @param amount 要凑的金额
         * @return 最少需要的硬币数
         */
        private int dpRecursively(int[] coins, int amount) {
            // base case
            if (amount < 0) {
                return -1;
            }
            if (amount == 0) {
                return 0;
            }
            // 先查dp表
            if (dp[amount] != -2) {
                // 直接获取结果
                return dp[amount];
            }
            int res = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (amount - coin < 0) {
                    continue;// 无解
                }
                // 计算子问题
                int subProblem = dpRecursively(coins, amount - coin);
                // 无解则跳过
                if (subProblem == -1) {
                    continue;
                }
                // 更新结果
                res = Math.min(res, subProblem + 1);
            }
            // 保存结果
            dp[amount] = res == Integer.MAX_VALUE ? -1 : res;
            return dp[amount];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}