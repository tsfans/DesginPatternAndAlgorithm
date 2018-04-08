package cn.hl.algorithm.datastructureandalgorithm.chapter4;

/**
 * AVL平衡树实现
 * @author HULIN
 */
public class AvlTree<T extends Comparable<? super T>> {

	/**
	 * 实际存储元素的avl树
	 */
	private AvlNode<T> root;
	/**
	 * 平衡条件:左右子树高度差最大为1
	 */
	private static final int ALLOWED_IMBALANCE = 1;
	
	public AvlTree() {
		root = null;
	}
	/**
	 * 清空avl树,移除所有元素
	 */
	public void makeEmpty() {
		root = null;
	}
	/**
	 * 判断avl树是否为空
	 * 是则返回true,否则返回false
	 * @return
	 */
	public boolean isEmpty() {
		return root==null;
	}
	
	/**
	 * 返回树中最小的元素
	 * @return
	 */
	public T findMin() {
		return findMin(root).data;
	}
	
	/**
	 * 返回树中最大的元素
	 * @return
	 */
	public T findMax() {
		return findMax(root).data;
	}
	
	/**
	 * 向树中插入元素x
	 * @param x
	 */
	public void insert(T x) {
		root = insert(x,root);
	}
	
	/**
	 * 移除树中元素x
	 * @param x
	 */
	public void remove(T x) {
		root = remove(x,root);
	}
	
	/**
	 * 查看树中是否包含元素x
	 * 是则返回true,否则返回false
	 * @param x
	 * @return
	 */
	public boolean contains(T x) {
		return contains(x,root);
	}
	
	/**
	 * 从小到大打印树中元素(中序遍历)
	 */
	public void printTree() {
		midPrint(root);
	}
	/**
	 * 中序遍历
	 * @param t
	 */
	private void midPrint(AvlNode<T> t) {
		if(t==null) return;
		midPrint(t.left);
		System.out.println(t.data);
		midPrint(t.right);
	}
	/**
	 * 返回节点高度,如果节点为null返回-1
	 * @param t
	 * @return
	 */
	private int height(AvlNode<T> t) {
		return t==null?-1:t.height;
	}
	
	/**
	 * 对节点做平衡操作
	 * @param t
	 * @return
	 */
	private AvlNode<T> balance(AvlNode<T> t){
		if(t == null) {
			return t;
		}
		if(height(t.left) - height(t.right) > ALLOWED_IMBALANCE) {
			/**
			 * 节点的左树高度大于右树时:
			 * 如果左树的左子节点高度大于左树的右子节点高度,
			 * 则属于左-左情况,插入发生在外部,
			 * 只需要对节点的左树进行一次单旋转;
			 * 否则属于左-右情况,插入发生在内部,
			 * 需要对节点的左树进行双旋转
			 */
			if(height(t.left.left) >= height(t.left.right)) {
				t = rotateWithLeftChild(t);
			}else {
				t = doubleWithLeftChild(t);
			}
		}
		else if(height(t.right) - height(t.left) > ALLOWED_IMBALANCE) {
			/**
			 * 同理,节点的右树高度大于左树时:
			 * 右-右情况,对节点的右树进行一次单旋转;
			 * 右-左情况,对节点的右树进行双旋转
			 */
			if(height(t.right.right) >= height(t.right.left)) {
				t = rotateWithRightChild(t);
			}else {
				t = doubleWithRightChild(t);
			}
		}
		//更新旋转后的节点高度
		t.height = Math.max(height(t.left), height(t.right))+1;
		return t;
	}
	/**
	 * 对左子节点进行单旋转
	 * @param t
	 * @return
	 */
	private AvlNode<T> rotateWithLeftChild(AvlNode<T> t){
		AvlNode<T> left = t.left;
		t.left = left.right;
		left.right = t;
		//更新旋转后的节点高度
		t.height = Math.max(height(t.left), height(t.right))+1;
		left.height = Math.max(height(left.left), t.height)+1;
		return left;
	}
	/**
	 * 对右子节点进行单旋转
	 * @param t
	 * @return
	 */
	private AvlNode<T> rotateWithRightChild(AvlNode<T> t){
		AvlNode<T> right = t.right;
		t.right = right.left;
		right.left = t;
		//更新旋转后的节点高度
		t.height = Math.max(height(t.left), height(t.right))+1;
		right.height = Math.max(t.height, height(right.right))+1;
		return right;
	}
	/**
	 * 对左子节点进行双旋转
	 * @param t
	 * @return
	 */
	private AvlNode<T> doubleWithLeftChild(AvlNode<T> t){
		t.left = rotateWithRightChild(t.left);
		return rotateWithLeftChild(t);
	}
	/**
	 * 对右子节点进行双旋转
	 * @param t
	 * @return
	 */
	private AvlNode<T> doubleWithRightChild(AvlNode<T> t){
		t.right = rotateWithLeftChild(t.right);
		return rotateWithRightChild(t);
	}
	
	/**
	 * 查找树中的最小节点
	 * @param t
	 * @return
	 */
	private AvlNode<T> findMin(AvlNode<T> t){
		if(t==null) {
			return t;
		}
		while(t.left!=null) {
			t = t.left;
		}
		return t;
	}
	
	/**
	 * 查找树中的最大节点
	 * @param t
	 * @return
	 */
	private AvlNode<T> findMax(AvlNode<T> t){
		if(t==null) {
			return t;
		}
		while(t.right!=null) {
			t = t.right;
		}
		return t;
	}
	
	/**
	 * 将元素x插入到avl树中
	 * 插入后avl树应保持平衡
	 * @param x
	 * @param t
	 * @return
	 */
	private AvlNode<T> insert(T x,AvlNode<T> t){
		if(t==null) {
			return new AvlNode<>(x);
		}
		int compareResult = x.compareTo(t.data);
		if(compareResult<0) {
			t.left = insert(x,t.left);
		}else if(compareResult>0) {
			t.right = insert(x,t.right);
		}
		//重复元素不做操作
		else ;
		return balance(t);
	}
	
	/**
	 * 从avl树t中移除元素x
	 * @param x
	 * @param t
	 * @return
	 */
	private AvlNode<T> remove(T x,AvlNode<T> t){
		if(t==null) return t;
		int compareResult = x.compareTo(t.data);
		//递归查找元素x
		if(compareResult<0) {
			t.left = remove(x,t.left);
		}else if(compareResult>0) {
			t.right = remove(x,t.right);
		}else if(t.left!=null && t.right!=null) {
			//x节点有双子节点时,用右树中的最小值代替x,并删除右树中的最小值
			t.data = findMin(t.right).data;
			t.right = remove(t.data,t.right);
		}else {
			//单子节点时直接删除
			t = t.left!=null?t.left:t.right;
		}
		return balance(t);
	}
	
	/**
	 * 查看树t中是否包含元素x
	 * 是则返回true,否则返回false
	 * @param x
	 * @param t
	 * @return
	 */
	private boolean contains(T x,AvlNode<T> t) {
		if(t==null) return false;
		int compareResult = x.compareTo(t.data);
		if(compareResult<0) {
			return contains(x,t.left);
		}else if(compareResult>0) {
			return contains(x,t.right);
		}else {
			return true;
		}
	}
	
	
	private static class AvlNode<T>{
		
		T data;
		
		AvlNode<T> left;
		
		AvlNode<T> right;
		
		int height;
		
		AvlNode(T data){
			this(data,null,null);
		}
		
		AvlNode(T data,AvlNode<T> left,AvlNode<T> right){
			this.data = data;
			this.left = left;
			this.right = right;
			this.height = 0;
		}
	}
	
	
	
	
	public static void main(String[] args) {
		AvlTree<Integer> at = new AvlTree<>();
		at.insert(1);
		at.insert(5);
		at.insert(3);
		at.insert(6);
		at.insert(2);
		at.insert(4);
		at.insert(10);
		at.printTree();
		at.remove(4);
		at.printTree();
		
		
	}
}
