package cn.hl.leetcode.editor.en;
//Given a binary tree root, return the maximum sum of all keys of any sub-tree 
//which is also a Binary Search Tree (BST). 
//
// Assume a BST is defined as follows: 
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
//
// 
//Input: root = [1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]
//Output: 20
//Explanation: Maximum sum in a valid Binary search tree is obtained in root 
//node with key equal to 3.
// 
//
// Example 2: 
//
// 
//
// 
//Input: root = [4,3,null,1,2]
//Output: 2
//Explanation: Maximum sum in a valid Binary search tree is obtained in a 
//single root node with key equal to 2.
// 
//
// Example 3: 
//
// 
//Input: root = [-4,-2,-5]
//Output: 0
//Explanation: All values are negatives. Return an empty BST.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 4 * 10⁴]. 
// -4 * 10⁴ <= Node.val <= 4 * 10⁴ 
// 
// Related Topics Dynamic Programming Tree Depth-First Search Binary Search 
//Tree Binary Tree 👍 964 👎 116

public class MaximumSumBstInBinaryTree {
    public static void main(String[] args) {
        Solution solution = new MaximumSumBstInBinaryTree().new Solution();
        TreeNode root = new TreeNode(1);
        int res = solution.maxSumBST(root);
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

        /**
         * 二叉搜索子树的最大键值和
         */
        public int maxSumBST(TreeNode root) {
            traverse(root);
            return max;
        }

        int max;

        /**
         * 1.是否为bst: 左右子树均为bst && maxLeft < root < minRight
         * 2.满足的话求和,sum = sumLeft + sumRight + root.val
         * 3.更新结果
         * PS: 使用后序遍历,借助数组保存子树结果,一次遍历即可,时间复杂度O(N)
         */
        public int[] traverse(TreeNode root) {
            // base case
            if (root == null) {
                // 空节点也是bst,maxLeft=Integer.MIN_VALUE,minRight=Integer.MAX_VALUE,sum=0
                return new int[]{1, Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
            }
            int[] left = traverse(root.left);
            int[] right = traverse(root.right);

            // 后序遍历位置
            // 借助数组保存子树结果0=是否为bst;1=子树最大值;2=子树最小值;3=子树节点和
            int[] res = new int[4];
            // 是否为bst: 左右子树均为bst && max(left) < root < min(right)
            if (left[0] == 1 && right[0] == 1 && root.val > left[1] && root.val < right[2]) {
                // 0=是否为bst
                res[0] = 1;
                // 1=子树最大值,需要考虑NULL节点,其最大值为Integer.MIN_VALUE
                res[1] = Math.max(right[1], root.val);
                // 2=子树最小值,需要考虑NULL节点,其最小值为Integer.MAX_VALUE
                res[2] = Math.min(left[2], root.val);
                // 3=子树节点和
                res[3] = left[3] + right[3] + root.val;
                // 更新结果
                max = Math.max(res[3], max);
                return res;
            }
            // 非bst则继续遍历
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}