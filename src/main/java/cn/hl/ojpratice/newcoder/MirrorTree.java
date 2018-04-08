package cn.hl.ojpratice.newcoder;

import cn.hl.ojpratice.common.TreeNode;
import cn.hl.ojpratice.common.Utils;

/**
 * 题目描述
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 输入描述:
 * 二叉树的镜像定义：源二叉树 
 *   	    8
 *   	   /  \
 *   	  6   10
 *   	 / \  / \
 *   	5  7 9 11
 *   	镜像二叉树
 *   	    8
 *   	   /  \
 *   	  10   6
 *   	 / \  / \
 *   	11 9 7  5
 * 
 * @author HULIN
 */
public class MirrorTree {

	public void Mirror(TreeNode root) {
		//根节点为空,直接返回
        if(root == null) {
        	return;
        }
        //交换左右节点
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        //递归左树,右树
        Mirror(root.left);
        Mirror(root.right);
        
    }
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);
		TreeNode t8 = new TreeNode(8);
		TreeNode t9 = new TreeNode(9);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.left = t6;
		t3.right = t7;
		t5.left = t8;
		t6.right = t9;
		Utils.prePrint(t1);
		System.out.println();
		MirrorTree m = new MirrorTree();
		m.Mirror(t1);
		Utils.prePrint(t1);
	}
}
