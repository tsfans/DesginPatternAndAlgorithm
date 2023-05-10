package cn.hl.leetcode.editor.en;
//Given two integer arrays, preorder and postorder where preorder is the 
//preorder traversal of a binary tree of distinct values and postorder is the postorder 
//traversal of the same tree, reconstruct and return the binary tree. 
//
// If there exist multiple answers, you can return any of them. 
//
// 
// Example 1: 
//
// 
//Input: preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
//Output: [1,2,3,4,5,6,7]
// 
//
// Example 2: 
//
// 
//Input: preorder = [1], postorder = [1]
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// 1 <= preorder.length <= 30 
// 1 <= preorder[i] <= preorder.length 
// All the values of preorder are unique. 
// postorder.length == preorder.length 
// 1 <= postorder[i] <= postorder.length 
// All the values of postorder are unique. 
// It is guaranteed that preorder and postorder are the preorder traversal and 
//postorder traversal of the same binary tree. 
// 
// Related Topics Array Hash Table Divide and Conquer Tree Binary Tree 👍 1748 ?
//? 80

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndPostorderTraversal().new Solution();

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
         * 通过前序和后序重构二叉树, 可能有多个结果, 返回任一即可
         *
         * @param preorder  前序数组
         * @param postorder 后序数组
         * @return 原二叉树
         */
        public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
            return build(preorder, 0, preorder.length - 1,
                    postorder, 0, postorder.length - 1);
        }

        /**
         * 先构建root节点,再递归构建左右子树
         * 关键在于找到左右字树的索引边界
         * 可以假设前序第二个元素为root.left,在此前提下确定左右子树索引
         *
         * @param preOrder 前序遍历数组
         * @param preStart 前序遍历数组索引起点
         * @param preEnd   前序遍历数组索引终点
         * @param postOrder 后序遍历数组
         * @param postStart 后序遍历数组索引起点
         * @param postEnd   后序遍历数组索引起点
         * @return 原二叉树
         */
        private TreeNode build(int[] preOrder, int preStart, int preEnd,
                               int[] postOrder, int postStart, int postEnd) {
            // base case
            if (preStart > preEnd) {
                return null;
            }
            if (preStart == preEnd) {
                // 只有一个元素是根节点
                return new TreeNode(preOrder[preStart]);
            }
            // 前序第一个是root
            int rootVal = preOrder[preStart];
            // 假设前序第二个是root.left(因为root.left可能为null,所以说会有多种结果&&所以前面需要提前处理preStart==preEnd的base case)
            int leftVal = preOrder[preStart + 1];
            // leftVal在后序中的位置用以分割左右子树索引
            int leftIndex = postStart;
            for (; leftIndex < postEnd; leftIndex++) {
                if (postOrder[leftIndex] == leftVal) {
                    break;
                }
            }
            // 构建root节点
            TreeNode root = new TreeNode(rootVal);
            // 左子树长度
            int left = leftIndex - postStart + 1;
            /**
             * 前序: 根->左->右
             * 后序: 左->右->根
             */
            // 递归构建左右子树
            root.left = build(preOrder, preStart + 1, preStart + left,
                    postOrder, postStart, leftIndex);
            root.right = build(preOrder, preStart + left + 1, preEnd,
                    postOrder, leftIndex + 1, postEnd - 1);
            return root;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}