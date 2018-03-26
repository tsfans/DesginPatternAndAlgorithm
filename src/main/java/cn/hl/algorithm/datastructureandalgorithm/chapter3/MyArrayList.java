package cn.hl.algorithm.datastructureandalgorithm.chapter3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * ArrayList实现
 * 1.保持基础数组、数组的容量、当前项数
 * 2.允许改变基础数据的容量,通过获取一个新数组,将老数组拷贝到新数组,允许虚拟机回收老数组
 * 3.提供get、set实现
 * 4.提供基本方法:size、isEmpty、clear、remove、两种add,数组满时add将扩容
 * 5.提供一个实现Iterator的类,提供next、hasNext和remove等方法的实现,MyArrayList的迭代器方法
 * 直接返回Iterator实现类的实例
 * @author HULIN
 */
public class MyArrayList<E> implements Iterable<E>{

	/**
	 * 默认初始容量
	 */
	private static final int DEFAULT_CAPACITY = 10;
	
	/**
	 * 当前元素的数量
	 */
	private int theSize;
	
	/**
	 * 存储元素的数组
	 */
	private E[] theItems;
	
	public MyArrayList() {
		doClear();
	}
	/**
	 * 清空数组
	 */
	public void clear() {
		doClear();
	}
	/**
	 * 初始化数组
	 */
	private void doClear() {
		theSize = 0;
		ensureCapacity(DEFAULT_CAPACITY);
	}
	/**
	 * 返回当前元素的数量
	 * @return
	 */
	public int size() {
		return theSize;
	}
	/**
	 * 返回数组中元素是否为0
	 * @return
	 */
	public boolean isEmpty() {
		return theSize == 0;
	}
	/**
	 * 将数组长度减为与当前元素数相同,避免空间浪费
	 */
	public void trimToSize() {
		ensureCapacity(size());
	}
	/**
	 * 返回指定位置的元素
	 * @param index
	 * @return
	 */
	public E get(int index) {
		if(index<0 || index>=size()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return theItems[index];
	}
	/**
	 * 替换指定位置的元素并返回被替换的元素
	 * @param index
	 * @param newVal
	 * @return
	 */
	public E set(int index,E newVal) {
		if(index<0 || index>=size()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		E old = theItems[index];
		theItems[index] = newVal;
		return old;
	}
	/**
	 * 数组扩容
	 * @param newCapacity
	 */
	@SuppressWarnings("unchecked")
	private void ensureCapacity(int newCapacity) {
		if(newCapacity < theSize) {
			return;
		}
		E[] old = theItems;
		theItems = (E[]) new Object[newCapacity];
		for(int i=0;i<size();i++) {
			theItems[i] = old[i];
		}
	}
	/**
	 * 在表末尾插入一个元素并返回是否成功,无需移动元素
	 * @param x
	 * @return
	 */
	public boolean add(E x) {
		add(size(),x);
		return true;
	}
	/**
	 * 在指定位置插入一个元素,该位置之后的元素将依次后移一位
	 * @param index
	 * @param x
	 */
	public void add(int index,E x) {
		if(theItems.length == size()) {
			ensureCapacity(size()*2+1);
		}
		for(int i=theSize;i>index;i--) {
			theItems[i] = theItems[i-1];
		}
		theItems[index] = x;
		theSize++;
	}
	/**
	 * 移除指定位置的元素并返回被移除的元素
	 * @param index
	 * @return
	 */
	public E remove(int index) {
		if(index<0 || index>=size()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		E removedItem = theItems[index];
		for(int i=index;i<size()-1;i++) {
			theItems[i] = theItems[i+1];
		}
		theSize--;
		return removedItem;
	}
	
	@Override
	public Iterator<E> iterator() {
		return new ArrayListIterator();
	}
	
	private class ArrayListIterator implements Iterator<E>{

		/**
		 * 当前位置表示要查看的下一元素的下标
		 */
		private int current = 0;
		
		@Override
		public boolean hasNext() {
			return current<size();
		}

		@Override
		public E next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			return theItems[current++];
		}
		/**
		 * 移除当前位置的元素
		 */
		public void remove() {
			MyArrayList.this.remove(--current);
		}
		
	}

	
}
