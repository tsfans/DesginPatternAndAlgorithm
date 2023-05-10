package cn.hl.ojpratice.newcoder;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * 
 * @author HULIN
 */
public class MinNumInStack {

	private Stack<Integer> stack = new Stack<>();
	
	 public void push(int node) {
	        stack.push(node);
	    }
	    
	    public void pop() {
	        stack.pop();
	    }
	    
	    public int top() {
	        return stack.peek();
	    }
	    
	    public int min() {
	    	int[] arr = new int[stack.size()];
	    	int i = 0;
	    	int min = stack.peek();
	    	while(stack.size()>0) {
	    		arr[i] = stack.pop();
	    		if(arr[i]<min) {
	    			min = arr[i];
	    		}
	    		i++;
	    	}
	    	for(int j=arr.length-1;j>=0;j--) {
	    		stack.push(arr[j]);
	    	}
	        return min;
	    }
	    
	    
	    public static void main(String[] args) {
	    	MinNumInStack stack = new MinNumInStack();
	    	stack.push(1);
	    	stack.push(-2);
	    	stack.push(3);
	    	stack.push(-3);
	    	stack.push(-3);
	    	stack.pop();
	    	System.out.println(stack.top());
	    	System.out.println(stack.min());
		}
}
