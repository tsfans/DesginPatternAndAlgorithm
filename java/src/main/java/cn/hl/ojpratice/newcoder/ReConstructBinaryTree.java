package cn.hl.ojpratice.newcoder;

import java.util.Arrays;

import cn.hl.ojpratice.common.TreeNode;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历（根左右DLR）和中序遍历（左根右或右根左）的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * 
 * @author HULIN
 */
public class ReConstructBinaryTree {

	public TreeNode reConstructBinaryTree(int[] pre,int[] in) {
		if(pre.length==0 || in.length==0) {
			return null;
		}
		//前序第一个必然为根节点
		TreeNode head = new TreeNode(pre[0]);
		for(int i=0;i<in.length;i++) {
			if(in[i]==pre[0]) {
				/**
				 * 前序: pre_left[1,i+1),pre_right[i+1,length)
				 * 中序: in_left[0,i),in_right[i+1,length)
				 */
				head.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i+1),Arrays.copyOfRange(in, 0, i));
				head.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i+1, pre.length),Arrays.copyOfRange(in, i+1, in.length));
			}
		}
		return head;
	}
	
	public void prePrint(TreeNode t) {
		if(t==null) {
			return;
		}
		System.out.print(t.val+",");
		prePrint(t.left);
		prePrint(t.right);
	}
	
	public static void main(String[] args) {
		int[] pre = {1,2,4,7,3,5,6,8};
		int[] in = {4,7,2,1,5,3,8,6};
		ReConstructBinaryTree rct = new ReConstructBinaryTree();
		TreeNode node = rct.reConstructBinaryTree(pre, in);
		rct.prePrint(node);
	}
	
	
}
