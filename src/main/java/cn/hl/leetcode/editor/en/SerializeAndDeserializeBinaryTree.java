package cn.hl.leetcode.editor.en;
//Serialization is the process of converting a data structure or object into a 
//sequence of bits so that it can be stored in a file or memory buffer, or 
//transmitted across a network connection link to be reconstructed later in the same or 
//another computer environment. 
//
// Design an algorithm to serialize and deserialize a binary tree. There is no 
//restriction on how your serialization/deserialization algorithm should work. You 
//just need to ensure that a binary tree can be serialized to a string and this 
//string can be deserialized to the original tree structure. 
//
// Clarification: The input/output format is the same as how LeetCode 
//serializes a binary tree. You do not necessarily need to follow this format, so please be 
//creative and come up with different approaches yourself. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,3,null,null,4,5]
//Output: [1,2,3,null,null,4,5]
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
// The number of nodes in the tree is in the range [0, 10⁴]. 
// -1000 <= Node.val <= 1000 
// 
// Related Topics String Tree Depth-First Search Breadth-First Search Design 
//Binary Tree 👍 6056 👎 237

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {
        Codec solution = new SerializeAndDeserializeBinaryTree().new Codec();
        String data = "1,2,#,4,#,#,3,#,#,";
        TreeNode res = solution.deserialize(data);
        System.out.println(res);
        String str = solution.serialize(res);
        System.out.println(str);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public class Codec {

        private String SEP = ",";

        private String NULL = "#";

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            serializeTraverse(root, sb);
            return sb.toString();
        }

        /**
         * 层级遍历序列化
         */
        private String serializeTraverse(TreeNode root, StringBuilder sb) {
            if (root == null) {
                return null;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node == null) {
                    sb.append(NULL).append(SEP);
                    continue;
                }
                sb.append(node.val).append(SEP);
                queue.offer(node.left);
                queue.offer(node.right);
            }
            return sb.toString();
        }

        /**
         * 后序遍历序列化
         */
        private void serializePostOrder(TreeNode root, StringBuilder sb) {
            // base case
            if (root == null) {
                sb.append(NULL).append(SEP);
                return;
            }
            serializePostOrder(root.left, sb);
            serializePostOrder(root.right, sb);
            sb.append(root.val).append(SEP);
        }

        /**
         * 前序遍历序列化
         */
        private void serializePreOrder(TreeNode root, StringBuilder sb) {
            // base case
            if (root == null) {
                sb.append(NULL).append(SEP);
                return;
            }
            sb.append(root.val).append(SEP);
            serializePreOrder(root.left, sb);
            serializePreOrder(root.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            // 需要判断空串
            if (data == null || data.isEmpty()) {
                return null;
            }
            String[] nodes = data.split(SEP);
            return deserializeTraverse(nodes);
        }

        /**
         * 层级遍历反序列化
         */
        private TreeNode deserializeTraverse(String[] nodes) {
            if (nodes == null || nodes.length == 0) {
                return null;
            }
            // 第一个元素是root
            TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));
            // 队列 q 记录父节点，将 root 加入队列
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            for (int i = 1; i < nodes.length; ) {
                // 队列中存的都是父节点
                TreeNode parent = queue.poll();
                // 父节点左侧值
                String leftVal = nodes[i++];
                if (NULL.equals(leftVal)) {
                    parent.left = null;
                } else {
                    TreeNode left = new TreeNode(Integer.valueOf(leftVal));
                    parent.left = left;
                    queue.offer(left);
                }
                // 父节点右侧值
                String rightVal = nodes[i++];
                if (NULL.equals(rightVal)) {
                    parent.right = null;
                } else {
                    TreeNode right = new TreeNode(Integer.valueOf(rightVal));
                    parent.right = right;
                    queue.offer(right);
                }
            }
            return root;
        }

        private TreeNode deserializePostOrder(LinkedList<String> list) {
            // base case
            if (list.isEmpty()) {
                return null;
            }
            // 后序最后一个元素为root
            String rootVal = list.removeLast();
            if (NULL.equals(rootVal)) {
                return null;
            }
            TreeNode root = new TreeNode(Integer.valueOf(rootVal));
            // 按后序顺序倒着构造跟右左
            root.right = deserializePostOrder(list);
            root.left = deserializePostOrder(list);
            return root;
        }

        private TreeNode deserializePreOrder(LinkedList<String> list) {
            // base case
            if (list.isEmpty()) {
                return null;
            }
            // 前序第一个元素为root
            String rootVal = list.removeFirst();
            if (NULL.equals(rootVal)) {
                // 空节点直接返回
                return null;
            }
            // 按前序顺序构造根左右
            TreeNode root = new TreeNode(Integer.valueOf(rootVal));
            root.left = deserializePreOrder(list);
            root.right = deserializePreOrder(list);
            return root;
        }

    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}