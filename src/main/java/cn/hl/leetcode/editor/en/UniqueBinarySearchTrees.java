package cn.hl.leetcode.editor.en;
//Given an integer n, return the number of structurally unique BST's (binary 
//search trees) which has exactly n nodes of unique values from 1 to n. 
//
// 
// Example 1: 
//
// 
//Input: n = 3
//Output: 5
// 
//
// Example 2: 
//
// 
//Input: n = 1
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 19 
// 
// Related Topics Math Dynamic Programming Tree Binary Search Tree Binary Tree ?
//? 6722 👎 268

public class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        Solution solution = new UniqueBinarySearchTrees().new Solution();

        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * bst数量=左子树组合数*右子树组合数
         */
        public int numTrees(int n) {
            if (n == 0) return 0;
            memo = new int[n + 1][n + 1];
            return count(1, n);
        }

        // 借助备忘录减少重复查找
        int[][] memo;

        /**
         * 对于[lo,hi]的区间递归求解组合数
         */
        private int count(int lo, int hi) {
            // base case
            if (lo > hi) {
                return 1;
            }
            // 先检查备忘录, 有结果则直接返回
            if (memo[lo][hi] != 0) return memo[lo][hi];
            int res = 0;
            for (int i = lo; i <= hi; i++) {
                int leftCount = count(lo, i - 1);
                int rightCount = count(i + 1, hi);
                res += leftCount * rightCount;
            }
            // 保存结果到备忘录
            memo[lo][hi] = res;
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}