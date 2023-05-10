package cn.hl.leetcode.editor.en;
//You are a professional robber planning to rob houses along a street. Each 
//house has a certain amount of money stashed, the only constraint stopping you from 
//robbing each of them is that adjacent houses have security systems connected and 
//it will automatically contact the police if two adjacent houses were broken 
//into on the same night. 
//
// Given an integer array nums representing the amount of money of each house, 
//return the maximum amount of money you can rob tonight without alerting the 
//police. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,1]
//Output: 4
//Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//Total amount you can rob = 1 + 3 = 4.
// 
//
// Example 2: 
//
// 
//Input: nums = [2,7,9,3,1]
//Output: 12
//Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 
//(money = 1).
//Total amount you can rob = 2 + 9 + 1 = 12.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
// Related Topics Array Dynamic Programming 👍 11408 👎 247

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HouseRobber198 {
    public static void main(String[] args) {
        Solution solution = new HouseRobber198().new Solution();
        int[] nums = new int[]{2, 7, 9, 3, 1};
        int res = solution.rob(nums);
        System.out.println(res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * dp[i] = max(dp[i-1], dp[i-2] + nums[i])
         */
        public int rob(int[] nums) {
            int[] dp = new int[nums.length + 1];
            dp[0] = 0;
            dp[1] = nums[0];
            for (int i = 2; i <= nums.length; i++) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
            }
            List<Integer> robIndex = new ArrayList<>();
            int l = nums.length;
            while (l > 0) {
                int curr = nums[l - 1];
                if (l - 2 > 0) {
                    curr += dp[l - 2];
                }
                if (curr == dp[l]) {
                    robIndex.add(l - 1);
                    l -= 2;
                } else {
                    l -= 1;
                }
            }
            Collections.reverse(robIndex);
            System.out.println(robIndex);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < robIndex.size(); i++) {
                if (i != robIndex.size() - 1) {
                    sb.append(nums[robIndex.get(i)]).append("+");
                } else {
                    sb.append(nums[robIndex.get(i)]).append("=");
                }
            }
            sb.append(dp[nums.length]);
            System.out.println(sb);
            return dp[nums.length];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}