package cn.hl.algorithm.datastructureandalgorithm.chapter3;

/**
 * @author HULIN
 */
public class Test {

	public static void testArrayStack() {
		ArrayStack<Integer> stack = new ArrayStack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println(stack.top());
		System.out.println(stack.pop());
		System.out.println(stack.contains(2));
	}
	
	public static void main(String[] args) {
		testArrayStack();
	}
}
