package cn.hl.leetcode.editor.en;
//Given the root of a binary tree, return all duplicate subtrees. 
//
// For each kind of duplicate subtrees, you only need to return the root node 
//of any one of them. 
//
// Two trees are duplicate if they have the same structure with the same node 
//values. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,3,4,null,2,4,null,null,4]
//Output: [[2,4],[4]]
// 
//
// Example 2: 
//
// 
//Input: root = [2,1,1]
//Output: [[1]]
// 
//
// Example 3: 
//
// 
//Input: root = [2,2,2,3,null,3,null]
//Output: [[2,3],[3]]
// 
//
// 
// Constraints: 
//
// 
// The number of the nodes in the tree will be in the range [1, 10^4] 
// -200 <= Node.val <= 200 
// 
// Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 👍 29
//59 👎 284

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees {
    public static void main(String[] args) {
        Solution solution = new FindDuplicateSubtrees().new Solution();

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

        private String SEP = ",";

        private String NULL = "#";

        /**
         * 重复节点 = 两个节点的子树一样
         * 遍历所有节点,将其子树序列化后保存到map中,从而获取节点出现次数
         */
        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            List<TreeNode> res = new ArrayList<>();
            Map<String, Integer> nodeCount = new HashMap<>();
            traverse(root, res, nodeCount);
            return res;
        }

        private String traverse(TreeNode root, List<TreeNode> res, Map<String, Integer> nodeCount) {
            // base case
            if (root == null) {
                return NULL;
            }
            // 固定顺序保存(非中序)
            String left = traverse(root.left, res, nodeCount);
            String right = traverse(root.right, res, nodeCount);
            StringBuilder sb = new StringBuilder();
            sb.append(root.val).append(SEP).append(left).append(SEP).append(right);
            String subTree = sb.toString();
            Integer frequency = nodeCount.getOrDefault(subTree, 0);
            if (frequency == 1) {
                // 找到重复节点,多次出现的节点保留一次即可
                res.add(root);
            }
            // 出现次数+1
            nodeCount.put(subTree, frequency + 1);
            return subTree;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}