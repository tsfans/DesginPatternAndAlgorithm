package cn.hl.ojpratice.newcoder;

import cn.hl.ojpratice.common.TreeNode;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。
 * （ps：我们约定空树不是任意一个树的子结构）
 * 
 * 1.子树的意思是包含了一个节点，就得包含这个节点下的所有节点，
 * 一棵大小为n的二叉树有n个子树，就是分别以每个节点为根的子树。
 * 2.子结构的意思是包含了一个节点，可以只取左子树或者右子树，或者都不取。
 * 
 * @author HULIN
 */
public class IsSubTree {

	public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1==null || root2==null) {
        	return false;
        }
        /**
         * 从根节点开始,递归匹配根节点,左子树,右子树是否包含树2
         * 任意一个包含即返回true
         */
		return doesTree1HasTree2(root1,root2)
				|| doesTree1HasTree2(root1.left,root2)
				|| doesTree1HasTree2(root1.right,root2);
    }
	private boolean doesTree1HasTree2(TreeNode tree1,TreeNode tree2) {
		//树2节点为空,树1是否为空都返回true
		if(tree2==null) return true;
		//树2节点不为空而树1节点为空则返回false
		if(tree1==null) return false;
		if(tree1.val == tree2.val) {
			//根节点相等时,左右子树都必须相等才能返回true
			return doesTree1HasTree2(tree1.left,tree2.left) &&
					doesTree1HasTree2(tree1.right,tree2.right);
		}else {
			return false;
		}
	}
}
