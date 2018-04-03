package cn.hl.ojpratice.newcoder;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * 
 * @author HULIN
 */
public class TwoStackImplQueue {

	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	public void push(int node) {
		stack1.push(node);
	}

	public int pop() {
		if(stack2.isEmpty()) {
			while(!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		int top = stack2.pop();
		return top;
	}
	
	public static void main(String[] args) {
		TwoStackImplQueue queue = new TwoStackImplQueue();
		queue.push(1);
		queue.push(2);
		queue.push(3);
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		System.out.println(queue.pop());
	}
}
