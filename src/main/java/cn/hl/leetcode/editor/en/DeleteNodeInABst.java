package cn.hl.leetcode.editor.en;
//Given a root node reference of a BST and a key, delete the node with the 
//given key in the BST. Return the root node reference (possibly updated) of the BST. 
//
// Basically, the deletion can be divided into two stages: 
//
// 
// Search for a node to remove. 
// If the node is found, delete the node. 
// 
//
// 
// Example 1: 
//
// 
//Input: root = [5,3,6,2,4,null,7], key = 3
//Output: [5,4,6,2,null,null,7]
//Explanation: Given key to delete is 3. So we find the node with value 3 and 
//delete it.
//One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
//Please notice that another valid answer is [5,2,6,null,4,null,7] and it's 
//also accepted.
//
// 
//
// Example 2: 
//
// 
//Input: root = [5,3,6,2,4,null,7], key = 0
//Output: [5,3,6,2,4,null,7]
//Explanation: The tree does not contain a node with value = 0.
// 
//
// Example 3: 
//
// 
//Input: root = [], key = 0
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 10⁴]. 
// -10⁵ <= Node.val <= 10⁵ 
// Each node has a unique value. 
// root is a valid binary search tree. 
// -10⁵ <= key <= 10⁵ 
// 
//
// 
// Follow up: Could you solve it with time complexity O(height of tree)? 
// Related Topics Tree Binary Search Tree Binary Tree 👍 4857 👎 146

public class DeleteNodeInABst {
    public static void main(String[] args) {
        Solution solution = new DeleteNodeInABst().new Solution();

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
         * 删除bst元素,需要维护bst合法性
         */
        public TreeNode deleteNode(TreeNode root, int key) {
            // base case
            if (root == null) {
                return null;
            }
            // 找到结果,删除
            if (key == root.val) {
                // 删除后需要root的子节点来替换root
                // left为null则用right
                if (root.left == null) {
                    return root.right;
                }
                // right为null则用left
                if (root.right == null) {
                    return root.left;
                }
                // left,right都不为null,那么应该应该用max(left)或min(right)
                TreeNode maxLeft = findMax(root.left);
                // 直接修改root的值
                root.val = maxLeft.val;
                // 然后删除maxLeft
                root.left = deleteNode(root.left, maxLeft.val);
            }
            // 比root小,去左子树找
            if (key < root.val) {
                root.left = deleteNode(root.left, key);
            }
            // 比root大,去右子树找
            if (key > root.val) {
                root.right = deleteNode(root.right, key);
            }
            return root;
        }

        private TreeNode findMin(TreeNode root) {
            while (root.left != null) root = root.left;
            return root;
        }

        private TreeNode findMax(TreeNode root) {
            // 最后一个不为空的右子节点即为最大值
            while (root.right != null) {
                root = root.right;
            }
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}