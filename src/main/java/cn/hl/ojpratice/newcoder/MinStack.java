package cn.hl.ojpratice.newcoder;

import java.util.Arrays;
import java.util.Stack;

/**
 * 利用辅助栈存储min,定义一个包含min函数的栈结构
 * 
 * @author HULIN
 */
public class MinStack {

	private Stack<Integer> minStack = new Stack<>();
	/**
	 * 栈中最小值
	 */
	private int min = Integer.MAX_VALUE;
	/**
	 * 存放元素的数组
	 */
	private Integer[] elements = new Integer[16];
	/**
	 * 栈中元素数量
	 */
	private int size;
	
	public void push(int node) {
		ensureCapacity(size+1);
		elements[size++] = node;
		if(node<min) {
			minStack.push(node);
			min = minStack.peek();
		}else {
			minStack.push(min);
		}
	}
	/**
	 * 数组扩容
	 * @param newSize
	 */
	private void ensureCapacity(int newSize) {
		int len = elements.length;
		if(newSize>len) {
			int newLen = len*2+1;
			elements = Arrays.copyOf(elements, newLen);
		}
	}

	public void pop() {
		if(size>0) {
			elements[size-1] =  null;
			size--;
			minStack.pop();
			min = minStack.peek();
		}
	}

	public int top() {
		if(size>0) {
			return elements[size-1];
		}
		return -1;
	}

	public int min() {
		if(size>0) {
			return min;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		MinStack ms = new MinStack();
		ms.push(3);
		ms.push(4);
		ms.push(0);
		ms.push(-1);
		ms.push(-1);
		ms.pop();
		ms.pop();
		System.out.println(ms.min());
	}
}
