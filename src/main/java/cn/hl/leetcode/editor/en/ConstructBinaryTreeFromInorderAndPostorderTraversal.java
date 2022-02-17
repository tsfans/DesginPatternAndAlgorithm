package cn.hl.leetcode.editor.en;
//Given two integer arrays inorder and postorder where inorder is the inorder 
//traversal of a binary tree and postorder is the postorder traversal of the same 
//tree, construct and return the binary tree. 
//
// 
// Example 1: 
//
// 
//Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
//Output: [3,9,20,null,null,15,7]
// 
//
// Example 2: 
//
// 
//Input: inorder = [-1], postorder = [-1]
//Output: [-1]
// 
//
// 
// Constraints: 
//
// 
// 1 <= inorder.length <= 3000 
// postorder.length == inorder.length 
// -3000 <= inorder[i], postorder[i] <= 3000 
// inorder and postorder consist of unique values. 
// Each value of postorder also appears in inorder. 
// inorder is guaranteed to be the inorder traversal of the tree. 
// postorder is guaranteed to be the postorder traversal of the tree. 
// 
// Related Topics Array Hash Table Divide and Conquer Tree Binary Tree 👍 4122 ?
//? 69

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();

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
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            return build(inorder, 0, inorder.length - 1,
                    postorder, 0, postorder.length - 1);
        }

        /**
         * 先构建root节点,再递归构建左右子树
         * 关键在于找到左右字树的索引边界
         *
         * @param inOrder   中序遍历数组
         * @param inStart   中序遍历数组索引起点
         * @param inEnd     中序遍历数组索引起点
         * @param postOrder 后序遍历数组
         * @param postStart 后序遍历数组索引起点
         * @param postEnd   后序遍历数组索引起点
         * @return 原二叉树
         */
        private TreeNode build(int[] inOrder, int inStart, int inEnd,
                               int[] postOrder, int postStart, int postEnd) {
            // base case
            if (inStart > inEnd) {
                return null;
            }
            // 后序最后一个元素是root
            int rootVal = postOrder[postEnd];
            // 找到root在中序中的位置
            int rootIndex = inStart;
            for (; rootIndex < inEnd; rootIndex++) {
                if (inOrder[rootIndex] == rootVal) {
                    break;
                }
            }

            // 构建root节点
            TreeNode root = new TreeNode(rootVal);
            // 左子树长度, 辅助获取左右子树index
            int left = rootIndex - inStart;
            /**
             * 中序: 左->根->右
             * 后序: 左->右->根
             */
            // 递归构建左子树右子树
            root.left = build(inOrder, inStart, rootIndex - 1,
                    postOrder, postStart, postStart + left - 1);
            root.right = build(inOrder, rootIndex + 1, inEnd,
                    postOrder, postStart + left, postEnd - 1);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}