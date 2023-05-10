package cn.hl.leetcode.editor.en;
//Given the root of a binary search tree, and an integer k, return the kᵗʰ 
//smallest value (1-indexed) of all the values of the nodes in the tree. 
//
// 
// Example 1: 
//
// 
//Input: root = [3,1,4,null,2], k = 1
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: root = [5,3,6,2,4,null,null,1], k = 3
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is n. 
// 1 <= k <= n <= 10⁴ 
// 0 <= Node.val <= 10⁴ 
// 
//
// 
// Follow up: If the BST is modified often (i.e., we can do insert and delete 
//operations) and you need to find the kth smallest frequently, how would you 
//optimize? 
// Related Topics Tree Depth-First Search Binary Search Tree Binary Tree 👍 5747
// 👎 113

public class KthSmallestElementInABst {
    public static void main(String[] args) {
        Solution solution = new KthSmallestElementInABst().new Solution();

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

        int res;
        int count;

        /**
         * bst的中序遍历为升序,中序第k个元素即为第k小的元素
         */
        public int kthSmallest(TreeNode root, int k) {
            traverseInOrder(root, k);
            return res;
        }

        private void traverseInOrder(TreeNode root, int k) {
            // base case
            if (root == null) {
                return;
            }
            traverseInOrder(root.left, k);
            count++;
            // 找到结果返回
            if (count == k) {
                res = root.val;
                return;
            }
            // 比k大无需再遍历
            if (count > k) {
                return;
            }
            traverseInOrder(root.right, k);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}