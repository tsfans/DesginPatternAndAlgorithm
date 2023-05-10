package cn.hl.leetcode.editor.en;
//Given the root of a Binary Search Tree (BST), convert it to a Greater Tree 
//such that every key of the original BST is changed to the original key plus the 
//sum of all keys greater than the original key in BST. 
//
// As a reminder, a binary search tree is a tree that satisfies these 
//constraints: 
//
// 
// The left subtree of a node contains only nodes with keys less than the 
//node's key. 
// The right subtree of a node contains only nodes with keys greater than the 
//node's key. 
// Both the left and right subtrees must also be binary search trees. 
// 
//
// 
// Example 1: 
//
// 
//Input: root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
//Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
// 
//
// Example 2: 
//
// 
//Input: root = [0,null,1]
//Output: [1,null,1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 10⁴]. 
// -10⁴ <= Node.val <= 10⁴ 
// All the values in the tree are unique. 
// root is guaranteed to be a valid binary search tree. 
// 
//
// 
// Note: This question is the same as 1038: https://leetcode.com/problems/
//binary-search-tree-to-greater-sum-tree/ 
// Related Topics Tree Depth-First Search Binary Search Tree Binary Tree 👍 3118
// 👎 148

public class ConvertBstToGreaterTree {
    public static void main(String[] args) {
        Solution solution = new ConvertBstToGreaterTree().new Solution();

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

        int sum;

        /**
         * bst中序遍历为升序,调整遍历顺序: 右->根->左遍历为降序
         * 因此累加每个节点的值即可转换为累加树
         */
        public TreeNode convertBST(TreeNode root) {
            // base case
            if (root == null) {
                return root;
            }
            convertBST(root.right);
            // 维护降序列表累加值
            sum += root.val;
            // 更新当前节点为累加值
            root.val = sum;
            convertBST(root.left);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}