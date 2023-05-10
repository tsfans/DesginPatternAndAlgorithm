package cn.hl.leetcode.editor.en;
//Given a binary tree, find its minimum depth. 
//
// The minimum depth is the number of nodes along the shortest path from the 
//root node down to the nearest leaf node. 
//
// Note: A leaf is a node with no children. 
//
// 
// Example 1: 
//
// 
//Input: root = [3,9,20,null,null,15,7]
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: root = [2,null,3,null,4,null,5,null,6]
//Output: 5
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 10⁵]. 
// -1000 <= Node.val <= 1000 
// 
// Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 👍 37
//39 👎 927

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree111 {
    public static void main(String[] args) {
        Solution solution = new MinimumDepthOfBinaryTree111().new Solution();

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
         * bfs
         */
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            Queue<TreeNode> q = new LinkedList<>();
            // 添加起点
            q.add(root);
            // 一个节点高度是1
            int h = 1;
            while (!q.isEmpty()) {
                // 提前记录当前队列长度
                int size = q.size();
                // 当前队列中的所有节点往相邻节点前进
                for (int i = 0; i < size; i++) {
                    TreeNode curr = q.poll();
                    // 判断是否到终点: 左右子节点均为空
                    if (curr.left == null && curr.right == null) {
                        return h;
                    }
                    if (curr.left != null) {
                        q.add(curr.left);
                    }
                    if (curr.right != null) {
                        q.add(curr.right);
                    }
                }
                // 更新前进步数
                h++;
            }
            return h;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}