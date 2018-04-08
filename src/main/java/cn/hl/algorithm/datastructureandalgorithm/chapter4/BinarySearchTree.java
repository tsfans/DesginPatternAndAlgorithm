package cn.hl.algorithm.datastructureandalgorithm.chapter4;

import cn.hl.algorithm.datastructureandalgorithm.chapter3.UnderflowException;

/**
 * 二叉查找树实现
 * 对于每个节点X,其左树的每项均小于X中的项,其右树中的项均大于X中的项
 * @author HULIN
 */
public class BinarySearchTree<T extends Comparable<? super T>> {

	/**
	 * 实际存储元素的二叉树
	 */
	private BinaryTree<T> root;
	
	public BinarySearchTree() {
		root = null;
	}
	/**
	 * 清空二叉树
	 */
	public void makeEmpty() {
		root = null;
	}
	/**
	 * 测试树是否为空
	 * @return
	 */
	public boolean isEmpty() {
		return root==null;
	}
	/**
	 * 测试树中是否含有该元素
	 * @param x
	 * @return
	 */
	public boolean contains(T x) {
		return contains(x,root);
	}
	private boolean contains(T x,BinaryTree<T> tree) {
		if(tree == null) {
			return false;
		}
		int compareResult = x.compareTo(tree.element);
		if(compareResult<0) {
			//递归左树
			return contains(x,tree.left);
		}else if(compareResult>0) {
			//递归右树
			return contains(x,tree.right);
		}else {
			return true;
		}
	}
	/**
	 * 查找树中元素最小值
	 * @return
	 */
	public T findMin() {
		checkUnderflow();
		return findMin(root).element;
	}
	/**
	 * 查找树t中的最小元素
	 * @param t
	 * @return
	 */
	private BinaryTree<T> findMin(BinaryTree<T> t){
		if(t==null) {
			return null;
		}
		while(t.left!=null) {
			t = t.left;
		}
		return t;
	}
	/**
	 * 查找树中元素最大值
	 * @return
	 */
	public T findMax() {
		checkUnderflow();
		return findMax(root).element;
	}
	/**
	 * 查找树t中的最大元素
	 * @param t
	 * @return
	 */
	private BinaryTree<T> findMax(BinaryTree<T> t){
		if(t==null) {
			return null;
		}
		while(t.right!=null) {
			t = t.right;
		}
		return t;
	}
	/**
	 * 查找空树中的元素将抛出异常
	 */
	private void checkUnderflow() {
		if(isEmpty()) {
			throw new UnderflowException();
		}
	}
	/**
	 * 向树中插入一个元素
	 * @param x
	 */
	public void insert(T x) {
		root = insert(x,root);
	}
	/**
	 * 将元素x插入二叉树t中,遵循左小右大的原则
	 * 当树中有相同元素时,不做任何操作
	 * @param x
	 * @param t
	 * @return
	 */
	private BinaryTree<T> insert(T x,BinaryTree<T> t){
		if(t==null) {
			return new BinaryTree<T>(x,null,null);
		}
		int compareResult = x.compareTo(t.element);
		if(compareResult<0) {
			t.left = insert(x,t.left);
		}else if(compareResult>0) {
			t.right = insert(x,t.right);
		}
		return t;
	}
	/**
	 * 从树中移除该元素
	 * @param x
	 */
	public void remove(T x) {
		root = remove(x,root);
	}
	/**
	 * 从二叉树t中删除元素x
	 * @param x
	 * @param t
	 * @return
	 */
	private BinaryTree<T> remove(T x,BinaryTree<T> t){
		if(t==null) {
			return t;
		}
		int compareResult = x.compareTo(t.element);
		//递归查找元素x
		if(compareResult<0) {
			t.left = remove(x,t.left);
		}
		else if(compareResult>0) {
			t.right = remove(x,t.right);
		}else if(t.left!=null && t.right!=null) {
			//x节点有双子节点时,用右树中的最小值代替x,并删除右树中的最小值
			t.element = findMin(t.right).element;
			t.right = remove(t.element,t.right);
		}else {
			//单子节点时直接删除
			t = t.left!=null?t.left:t.right;
		}
		return t;
	}
	/**
	 * 打印二叉树
	 */
	public void printTree() {
		printTree(root);
	}
	private void printTree(BinaryTree<T> t) {
		if(t==null)
			return;
		System.out.println(t.element);
		printTree(t.left);
		printTree(t.right);
	}
	
	
	
	
	
	
	
	
	
	
	
	private static class BinaryTree<T>{
		T element;
		BinaryTree<T> left;
		BinaryTree<T> right;
		public BinaryTree(T element) {
			this(element,null,null);
		}
		public BinaryTree(T element,BinaryTree<T> left,BinaryTree<T> right) {
			this.element = element;
			this.left = left;
			this.right = right;
		}
	}
}
