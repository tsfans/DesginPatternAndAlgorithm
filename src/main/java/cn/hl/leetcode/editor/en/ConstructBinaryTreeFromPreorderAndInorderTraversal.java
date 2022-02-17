package cn.hl.leetcode.editor.en;
//Given two integer arrays preorder and inorder where preorder is the preorder 
//traversal of a binary tree and inorder is the inorder traversal of the same tree,
// construct and return the binary tree. 
//
// 
// Example 1: 
//
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// Example 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
// Constraints: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder and inorder consist of unique values. 
// Each value of inorder also appears in preorder. 
// preorder is guaranteed to be the preorder traversal of the tree. 
// inorder is guaranteed to be the inorder traversal of the tree. 
// 
// Related Topics Array Hash Table Divide and Conquer Tree Binary Tree 👍 7668 ?
//? 195

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        int[] preOrder = new int[]{3, 9, 20, 15, 7};
        int[] inOrder = new int[]{9, 3, 15, 20, 7};
        TreeNode res = solution.buildTree(preOrder, inOrder);
        System.out.println(res);
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return buildTreeNode(preorder, 0, preorder.length - 1,
                    inorder, 0, inorder.length - 1);
        }

        /**
         * 先构建root节点,再递归构建左右子树
         * 关键在于找到左右字树的索引边界
         *
         * @param preOrder 前序遍历数组
         * @param preStart 前序遍历数组索引起点
         * @param preEnd   前序遍历数组索引终点
         * @param inOrder  中序遍历数组
         * @param inStart  中序遍历数组索引起点
         * @param inEnd    中序遍历数组索引起点
         * @return 原二叉树
         */
        private TreeNode buildTreeNode(int[] preOrder, int preStart, int preEnd,
                                       int[] inOrder, int inStart, int inEnd) {
            // base case
            if (preStart > preEnd) {
                return null;
            }
            // 前序数组第一个元素为root
            int rootVal = preOrder[preStart];
            // 找到root在中序中的索引
            int rootIndex = inStart;
            for (; rootIndex <= inEnd; rootIndex++) {
                if (inOrder[rootIndex] == rootVal) {
                    break;
                }
            }

            // 构建root节点
            TreeNode root = new TreeNode(rootVal);
            // 左子树长度
            int left = rootIndex - inStart;
            /**
             * 前序: 根->左->右
             * 中序: 左->根->右
             */
            // 递归构建左子树
            root.left = buildTreeNode(preOrder, preStart + 1, preStart + left,
                    inOrder, inStart, rootIndex - 1);
            // 递归构建右子树
            root.right = buildTreeNode(preOrder, preStart + left + 1, preEnd,
                    inOrder, rootIndex + 1, inEnd);

            return root;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}