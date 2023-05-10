package cn.hl.algorithm.datastructureandalgorithm.chapter3;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 栈的数组简单实现
 * @author HULIN
 */
public class ArrayStack<E> {

	/**
	 * 默认初始容量
	 */
	private static final int DEFAULT_CAPACITY = 10;
	/**
	 * 存储元素的数组
	 */
	private E[] elementData;
	/**
	 * 记录栈中元素的数量
	 */
	private int elementCount;
	
	public ArrayStack() {
		doClear();
	}
	/**
	 * 将一个元素压入栈中并返回该元素
	 * @param x
	 * @return
	 */
	public E push(E x) {
		addElement(x);
		return x;
	}
	/**
	 * 弹出最后插入栈中的元素并删除该元素
	 * @return
	 */
	public E pop() {
		E old = top();
		removeElementAt(size()-1);
		return old;
	}
	/**
	 * 返回栈中元素的数量
	 * @return
	 */
	public int size() {
		return elementCount;
	}
	/**
	 * 测试栈中元素数量是否为0
	 * @return
	 */
	public boolean isEmpty() {
		return size()==0;
	}
	/**
	 * 返回最后插入栈中元素但不删除该元素
	 * @return
	 */
	public E top() {
		if(size()==0) {
			throw new EmptyStackException();
		}
		return elementAt(size()-1);
	}
	/**
	 * 查看栈中是否存在该元素
	 * @param x
	 * @return
	 */
	public boolean contains(E x) {
		return indexOf(x,0) >= 0;
	}
	/**
	 * 清空栈
	 */
	public void clear() {
		doClear();
	}
	/**
	 * 初始化数组
	 */
	@SuppressWarnings("unchecked")
	private void doClear() {
		elementCount = 0;
		elementData = (E[]) new Object[DEFAULT_CAPACITY];
	}
	/**
	 * 返回在[index,elementCount-1]区间内第一次出现该元素的索引
	 * @param x
	 * @param index
	 * @return
	 */
	private int indexOf(E x,int index) {
		if(x==null) {
			for(int i=index;i<elementCount;i++) {
				if(elementData[i]==null) {
					return i;
				}
			}
		}else {
			for(int i=index;i<elementCount;i++) {
				if(x.equals(elementData[i])) {
					return i;
				}
			}
		}
		return -1;
	}
	/**
	 * 向数组末尾插入一个元素
	 * @param x
	 */
	private void addElement(E x) {
		ensureCapacity(elementCount+1);
		elementData[elementCount++] = x;
	}
	/**
	 * 确保数组容量足够,不足时进行扩容
	 * @param capacity
	 */
	private void ensureCapacity(int minCapacity) {
		if(minCapacity - elementData.length > 0) {
			elementData = Arrays.copyOf(elementData, elementData.length*2+1);
		}
	}
	/**
	 * 返回指定索引处的元素
	 * @param index
	 * @return
	 */
	private E elementAt(int index) {
		checkIndex(index);
		return elementData[index];
	}
	/**
	 * 移除指定索引处的元素
	 * @param index
	 */
	private void removeElementAt(int index) {
		checkIndex(index);
		//index后面元素的数量
		int j = elementCount-index-1;
		if(j>0) {
			//将index后的元素全都往前移一位
			System.arraycopy(elementData, index+1, elementData, index, j);
		}
		elementCount--;
		elementData[elementCount] = null;
		
	}
	/**
	 * 检查栈下标是否越界
	 * @param index
	 */
	private void checkIndex(int index) {
		if(index<0 || index>=elementCount) {
			throw new ArrayIndexOutOfBoundsException();
		}
	}
}
