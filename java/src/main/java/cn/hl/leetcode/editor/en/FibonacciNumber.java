package cn.hl.leetcode.editor.en;
//The Fibonacci numbers, commonly denoted F(n) form a sequence, called the 
//Fibonacci sequence, such that each number is the sum of the two preceding ones, 
//starting from 0 and 1. That is, 
//
// 
//F(0) = 0, F(1) = 1
//F(n) = F(n - 1) + F(n - 2), for n > 1.
// 
//
// Given n, calculate F(n). 
//
// 
// Example 1: 
//
// 
//Input: n = 2
//Output: 1
//Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
// 
//
// Example 2: 
//
// 
//Input: n = 3
//Output: 2
//Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
// 
//
// Example 3: 
//
// 
//Input: n = 4
//Output: 3
//Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
// 
//
// 
// Constraints: 
//
// 
// 0 <= n <= 30 
// 
// Related Topics Math Dynamic Programming Recursion Memoization 👍 2924 👎 254

public class FibonacciNumber {
    public static void main(String[] args) {
        Solution solution = new FibonacciNumber().new Solution();

        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * F(0) = 0, F(1) = 1
         * F(n) = F(n - 1) + F(n - 2), for n > 1
         * 保存前两个结果即可,时间复杂度O(N),空间复杂度O(1)
         */
        public int fib(int n) {
            // base case
            if (n == 0) return 0;
            if (n == 1) return 1;
            int res0 = 0, res1 = 1;
            int res = 0;
            for (int i = 2; i <= n; i++) {
                // F(n) = F(n - 1) + F(n - 2)
                res = res0 + res1;
                // 滚动更新结果
                res0 = res1;
                res1 = res;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}