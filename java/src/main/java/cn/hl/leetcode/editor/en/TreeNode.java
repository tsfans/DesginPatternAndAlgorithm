package cn.hl.leetcode.editor.en;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TreeNode {

	public int val;

	public TreeNode left;

	public TreeNode right;

	public TreeNode() {
	}

	public TreeNode(int val) {
		this.val = val;
	}

	public TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		List<Integer> res = new ArrayList<>();
		preOrder(this, res);
		return res.toString();
	}

	public static void preOrder(TreeNode root, List<Integer> res) {
		if (root == null) {
			return;
		}
		res.add(root.val);
		preOrder(root.left, res);
		preOrder(root.right, res);
	}

	public static void preOrder2(TreeNode root, List<Integer> res) {
		if (root == null) {
			return;
		}
		Deque<TreeNode> stack = new LinkedList<>();
		TreeNode curr = root;
		while (curr != null || !stack.isEmpty()) {
			// step1访问当前节点，将左子节点入栈
			while (curr != null) {
				res.add(curr.val);
				stack.push(curr);
				curr = curr.left;
			}

			// step2左子节点到null，弹出当前节点进行处理
			if (!stack.isEmpty()) {
				curr = stack.poll();
				// 当前节点置位右子节点，继续step1
				curr = curr.right;
			}
		}
	}

	public static void inOrder(TreeNode root, List<Integer> res) {
		if (root == null) {
			return;
		}
		inOrder(root.left, res);
		res.add(root.val);
		inOrder(root.right, res);
	}

	public static void inOrder2(TreeNode root, List<Integer> res) {
		if (root == null) {
			return;
		}
		Deque<TreeNode> stack = new LinkedList<>();
		TreeNode curr = root;
		while (curr != null || !stack.isEmpty()) {
			// step1 将左子节点入栈
			while (curr != null) {
				stack.push(curr);
				curr = curr.left;
			}

			// step2左子节点到null，弹出当前节点并访问
			if (!stack.isEmpty()) {
				curr = stack.pop();
				res.add(curr.val);
				// 当前节点置位右子节点，继续step1
				curr = curr.right;
			}
		}
	}

	public static void postOrder(TreeNode root, List<Integer> res) {
		if (root == null) {
			return;
		}
		postOrder(root.left, res);
		postOrder(root.right, res);
		res.add(root.val);
	}

	public static void postOrder2(TreeNode root, List<Integer> res) {
		if (root == null) {
			return;
		}
		Deque<TreeNode> stack = new LinkedList<>();
		stack.push(root);
		// 上一次访问的节点
		TreeNode pre = null;
		// 当前节点
		TreeNode curr;
		while (!stack.isEmpty()) {
			curr = stack.peek();
			if ((curr.left == null && curr.right == null) || (pre != null && (pre == curr.left || pre == curr.right))) {
				// 如果栈顶节点不存在子节点，或者其子节点已被访问过，则直接访问该节点
				res.add(curr.val);
				stack.poll();
				// 更新上次访问的节点
				pre = curr;
			} else {
				// 如果存在子节点且子节点未被访问过，则将其右子节点、左子节点依次入栈
				if (curr.right != null) {
					stack.push(curr.right);
				}
				if (curr.left != null) {
					stack.push(curr.left);
				}
			}
		}
	}

	public static void main(String[] args) {
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n2 = new TreeNode(2, n4, n5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n3 = new TreeNode(3, n6, n7);
		TreeNode n1 = new TreeNode(1, n2, n3);
		/**
		 * 1 </br>
		 * 2 3 </br>
		 * 4 5 6 7 </br>
		 */
		List<Integer> res = new ArrayList<>();
		postOrder(n1, res);
		List<Integer> res2 = new ArrayList<>();
		postOrder2(n1, res2);
		System.out.println(res.equals(res2));
	}

}
