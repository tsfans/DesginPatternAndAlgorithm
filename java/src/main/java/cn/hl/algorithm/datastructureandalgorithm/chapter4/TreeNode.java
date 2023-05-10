package cn.hl.algorithm.datastructureandalgorithm.chapter4;

/**
 * 树的一般实现
 * @author HULIN
 */
public class TreeNode<T> {
	
	T element;
	TreeNode<T> firstChild;
	TreeNode<T> nextSibling;
	
	public TreeNode(T element,TreeNode<T> firstChild,TreeNode<T> nextSibling) {
		this.element = element;
		this.firstChild = firstChild;
		this.nextSibling = nextSibling;
	}

}
