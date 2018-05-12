package cn.hl.ojpratice.common;


/**
 * 二叉树
 * 
 * @author HULIN
 */
public class TreeNode {

	public int val;
	
	public TreeNode left;
	
	public TreeNode right;
	
	public TreeNode(int val){
		this.val = val;
	}
	
	public TreeNode(TreeNode left, int val, TreeNode right) {
	  this.val = val;
	  this.left = left;
	  this.right = right;
	}
}
