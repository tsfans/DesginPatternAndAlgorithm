package cn.hl.algorithm.datastructureandalgorithm.chapter4;

/**
 * 二叉树的一般实现
 * @author HULIN
 */
public class BinaryNode<T> {

	T element;
	BinaryNode<T> left;
	BinaryNode<T> right;
	
	public BinaryNode(T element,BinaryNode<T> left,BinaryNode<T> right) {
		this.element = element;
		this.left = left;
		this.right = right;
	}
}
