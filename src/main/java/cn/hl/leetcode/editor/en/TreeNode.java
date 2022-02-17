package cn.hl.leetcode.editor.en;

public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        preOrder(this, sb);
        String res = sb.substring(0, sb.length() > 1 ? sb.length() - 1 : 1);
        res = res + "]";
        return res;
    }

    public static void preOrder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(root.val + ",");
        preOrder(root.left, sb);
        preOrder(root.right, sb);
    }

}
