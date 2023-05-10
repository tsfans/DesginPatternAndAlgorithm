package cn.hl.algorithm.datastructureandalgorithm.chapter3;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * LinkedList实现
 * 1.类本身,包含到两端的链、表的大小及一些方法
 * 2.Node类,私有嵌套类(静态内部类),一个节点包含数据、pre、next
 * 3.LinkedListIterator,私有内部类,实现Iterator接口,提供hasNext、next、remove方法
 * @author HULIN
 */
public class MyLinkedList<E> implements Iterable<E>{

	/**
	 * 表中元素数量
	 */
	private int size;
	/**
	 * 记录表中元素数量变化的次数
	 * The number of times this list has been <i>structurally modified</i>
	 */
	private int modCount;
	/**
	 * 头节点
	 */
	private Node<E> first;
	/**
	 * 尾节点
	 */
	private Node<E> last;
	
	public MyLinkedList() {
		doClear();
	}
	/**
	 * 清空链表
	 */
	public void clear() {
		doClear();
	}
	/**
	 * 返回表中元素数量
	 * @return
	 */
	public int size() {
		return size;
	}
	/**
	 * 返回表中元素是否为空
	 * @return
	 */
	public boolean isEmpty() {
		return size()==0;
	}
	/**
	 * 在表的尾部插入元素(即尾节点的前面)
	 * @param x
	 * @return
	 */
	public boolean add(E x) {
		add(size(),x);
		return true;
	}
	/**
	 * 在指定位置插入元素
	 * @param index
	 * @param x
	 */
	public void add(int index,E x) {
		//插入节点时可以插入到尾节点前面但不能是头节点前面
		addBefore(getNode(index,0,size()),x);
	}
	/**
	 * 返回指定位置的元素
	 * @param index
	 * @return
	 */
	public E get(int index) {
		return getNode(index).data;
	}
	/**
	 * 替换指定位置的元素
	 * @param index
	 * @param newVal
	 * @return
	 */
	public E set(int index,E newVal) {
		Node<E> p = getNode(index);
		E old = p.data;
		p.data = newVal;
		return old;
	}
	/**
	 * 移除指定位置的元素并返回被移除的元素
	 * @param index
	 * @return
	 */
	public E remove(int index) {
		return remove(getNode(index));
	}
	
	/**
	 * 移除指定节点并返回元素
	 * @param p
	 * @return
	 */
	private E remove(Node<E> p) {
		p.pre.next = p.next;
		p.next.pre = p.pre;
		size--;
		modCount++;
		return p.data;
	}
	/**
	 * 返回表中指定位置节点的值
	 * @param index
	 * @return
	 */
	private Node<E> getNode(int index){
		//头尾节点为空,不返回
		return getNode(index,0,size()-1);
	}
	/**
	 * 
	 * @param index 表的指定位置
	 * @param low  左端点
	 * @param high 右端点
	 * @return  两点间指定位置节点的值
	 */
	private Node<E> getNode(int index,int low,int high){
		Node<E> p;
		if(index<low || index>high) {
			throw new IndexOutOfBoundsException();
		}
		if(index<size()/2) {
			//在前半部分则从头节点开始从前往后遍历
			p = first.next;
			for(int i=0;i<index;i++) {
				p = p.next;
			}
		}else {
			//在后半部分则从尾节点开始从后往前遍历
			p = last;
			for(int i=size();i>index;i--) {
				p = p.pre;
			}
		}
		return p;
	}
	/**
	 * 在指定节点前添加一个节点
	 * @param p
	 * @param x
	 */
	private void addBefore(Node<E> p,E x) {
		//在p.pre与p之间添加新节点
		Node<E> newNode = new Node<E>(p.pre,x,p);
		//将p.pre的next指向newNode
		newNode.pre.next = newNode;
		//将p的pre指向newNode
		p.pre = newNode;
		size++;
		modCount++;
	}
	/**
	 * 连接头尾节点,设置大小为0
	 */
	private void doClear() {
		first = new Node<E>(null,null,null);
		last = new Node<E>(first,null,null);
		first.next = last;
		size = 0;
		modCount++;
	}
	
	@Override
	public Iterator<E> iterator() {
		return new LinkedListIterator();
	}
	
	private class LinkedListIterator implements Iterator<E>{

		private Node<E> current = first.next;
		private int expectedModCount = modCount;
		private boolean okToRemove = false;
		
		@Override
		public boolean hasNext() {
			return current!=last;
		}

		@Override
		public E next() {
			checkForComodification();
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			E nextItem = current.data;
			current = current.next;
			okToRemove = true;
			return nextItem;
		}
		public void remove() {
			checkForComodification();
			if(!okToRemove) {
				throw new IllegalStateException();
			}
			MyLinkedList.this.remove(current.pre);
			expectedModCount++;
			okToRemove = false;
		}
		final void checkForComodification() {
			if(modCount!=expectedModCount) {
				throw new ConcurrentModificationException();
			}
		}
	}
	
	/**
	 * 双向链表
	 * @author HULIN
	 */
	private static class Node<E> {
		E data;
		Node<E> pre;
		Node<E> next;
		Node(Node<E> pre,E data,Node<E> next){
			this.pre = pre;
			this.data = data;
			this.next = next;
		}
	}

}
