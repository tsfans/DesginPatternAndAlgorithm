package cn.hl.leetcode.editor.en;
//You are given the root of a binary search tree (BST) and an integer val. 
//
// Find the node in the BST that the node's value equals val and return the 
//subtree rooted with that node. If such a node does not exist, return null. 
//
// 
// Example 1: 
//
// 
//Input: root = [4,2,7,1,3], val = 2
//Output: [2,1,3]
// 
//
// Example 2: 
//
// 
//Input: root = [4,2,7,1,3], val = 5
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 5000]. 
// 1 <= Node.val <= 10⁷ 
// root is a binary search tree. 
// 1 <= val <= 10⁷ 
// 
// Related Topics Tree Binary Search Tree Binary Tree 👍 2462 👎 139

public class SearchInABinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new SearchInABinarySearchTree().new Solution();

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
         * 利用bst结构特性进行查找
         */
        public TreeNode searchBST(TreeNode root, int val) {
            // base case
            if (root == null) {
                return null;
            }
            // 找到结果,直接返回
            if (root.val == val) {
                return root;
            }
            // 比root小,去左子树找
            if (val < root.val) {
                return searchBST(root.left, val);
            }
            // 比root大,去右子树找
            if (val > root.val) {
                return searchBST(root.right, val);
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}