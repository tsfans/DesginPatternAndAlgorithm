package cn.hl.leetcode.editor.en;
//Given the root of a complete binary tree, return the number of the nodes in 
//the tree. 
//
// According to Wikipedia, every level, except possibly the last, is completely 
//filled in a complete binary tree, and all nodes in the last level are as far 
//left as possible. It can have between 1 and 2ʰ nodes inclusive at the last level h.
// 
//
// Design an algorithm that runs in less than O(n) time complexity. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,3,4,5,6]
//Output: 6
// 
//
// Example 2: 
//
// 
//Input: root = []
//Output: 0
// 
//
// Example 3: 
//
// 
//Input: root = [1]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 5 * 10⁴]. 
// 0 <= Node.val <= 5 * 10⁴ 
// The tree is guaranteed to be complete. 
// 
// Related Topics Binary Search Tree Depth-First Search Binary Tree 👍 4473 👎 3
//02

public class CountCompleteTreeNodes {
    public static void main(String[] args) {
        Solution solution = new CountCompleteTreeNodes().new Solution();

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

        /**
         * 完全二叉树: 每一层都是紧凑靠左排列的
         * 完美二叉树: 每层都是是满的，像一个稳定的三角形,其节点数=2的h次方-1,h为树的高度
         * 完全二叉树的左半部一定是完美二叉树,因此可以借助此特性降低时间复杂度
         * 时间复杂度为O(logN*logN)
         */
        public int countNodes(TreeNode root) {
            // base case
            if (root == null) {
                return 0;
            }
            TreeNode l = root, r = root;
            int lh = 0, rh = 0;
            // 计算左子树高度
            while (l != null) {
                l = l.left;
                lh++;
            }
            // 计算右子树高度
            while (r != null) {
                r = r.right;
                rh++;
            }
            // 左右高度相等则为完美二叉树
            if (lh == rh) {
                return (int) Math.pow(2, lh) - 1;
            }
            // 否则使用正常递归计算高度
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}