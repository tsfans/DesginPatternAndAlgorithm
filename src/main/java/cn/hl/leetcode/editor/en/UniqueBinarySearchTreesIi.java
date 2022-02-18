package cn.hl.leetcode.editor.en;
//Given an integer n, return all the structurally unique BST's (binary search 
//trees), which has exactly n nodes of unique values from 1 to n. Return the answer 
//in any order. 
//
// 
// Example 1: 
//
// 
//Input: n = 3
//Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]
//]
// 
//
// Example 2: 
//
// 
//Input: n = 1
//Output: [[1]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 8 
// 
// Related Topics Dynamic Programming Backtracking Tree Binary Search Tree 
//Binary Tree 👍 4437 👎 292

import java.util.LinkedList;
import java.util.List;

public class UniqueBinarySearchTreesIi {
    public static void main(String[] args) {
        Solution solution = new UniqueBinarySearchTreesIi().new Solution();

        System.out.println();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {


        public List<TreeNode> generateTrees(int n) {
            if (n == 0) {
                return new LinkedList<>();
            }
            return build(1, n);
        }

        /**
         * 1、穷举root节点的所有可能
         * 2、递归构造出左右子树的所有合法 BST
         * 3、给root节点穷举所有左右子树的组合
         */
        private List<TreeNode> build(int lo, int hi) {
            List<TreeNode> res = new LinkedList<>();
            // base case
            if (lo > hi) {
                res.add(null);
                return res;
            }
            // 1、穷举 root 节点的所有可能
            for (int i = lo; i <= hi; i++) {
                // 2、递归构造出左右子树的所有合法 BST
                List<TreeNode> leftTree = build(lo, i - 1);
                List<TreeNode> rightTree = build(i + 1, hi);
                // 3、给root节点穷举所有左右子树的组合
                for (TreeNode left : leftTree) {
                    for (TreeNode right : rightTree) {
                        TreeNode root = new TreeNode(i);
                        root.left = left;
                        root.right = right;
                        res.add(root);
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}