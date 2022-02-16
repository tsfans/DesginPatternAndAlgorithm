package cn.hl.leetcode.editor.en;
//You are given a perfect binary tree where all leaves are on the same level, 
//and every parent has two children. The binary tree has the following definition: 
//
// 
//struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//}
// 
//
// Populate each next pointer to point to its next right node. If there is no 
//next right node, the next pointer should be set to NULL. 
//
// Initially, all next pointers are set to NULL. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,3,4,5,6,7]
//Output: [1,#,2,3,#,4,5,6,7,#]
//Explanation: Given the above perfect binary tree (Figure A), your function 
//should populate each next pointer to point to its next right node, just like in 
//Figure B. The serialized output is in level order as connected by the next 
//pointers, with '#' signifying the end of each level.
// 
//
// Example 2: 
//
// 
//Input: root = []
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 2¹² - 1]. 
// -1000 <= Node.val <= 1000 
// 
//
// 
// Follow-up: 
//
// 
// You may only use constant extra space. 
// The recursive approach is fine. You may assume implicit stack space does not 
//count as extra space for this problem. 
// 
// Related Topics Linked List Tree Depth-First Search Breadth-First Search 
//Binary Tree 👍 5841 👎 217

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {
    public static void main(String[] args) {
        Solution solution = new PopulatingNextRightPointersInEachNode().new Solution();

        System.out.println();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

    class Solution {

        /**
         * 层序遍历连接右节点
         */
        public Node connect(Node root) {
            if (root == null) {
                return root;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);

            // 从上到下遍历二叉树的每一层
            while (queue.size() > 0) {
                int size = queue.size();
                // 从左到右遍历每一层的每个节点
                for (int i = 0; i < size; i++) {
                    Node node = queue.poll();
                    // 如果已经是最后一个元素则指向null,否则指向下一个节点
                    node.next = i == size - 1 ? null : queue.peek();
                    // 将下一层节点放入队列
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
            return root;
        }

        /**
         * 递归补齐右节点
         */
        public Node connect2(Node root) {
            if (root == null) {
                return root;
            }
            connect(root.left, root.right);
            return root;
        }

        private void connect(Node left, Node right) {
            // base case
            if (left == null) {
                // 完美二叉树子节点要么都不为空要么都为空
                return;
            }
            // left->right->null
            left.next = right;
            right.next = null;
            // left.left->left.right->right.left->right.right->null
            connect(left.left, left.right);
            connect(left.right, right.left);
            connect(right.left, right.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}