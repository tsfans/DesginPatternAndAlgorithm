package cn.hl.ojpratice.newcoder;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 * 
 * 借用一个辅助栈,遍历压栈数组,记录弹栈数组下标(从0开始),此时为4
 * 1压入栈中,
 * 栈顶1!=4,继续压入2,
 * 栈顶2!=4,继续压入3,
 * 栈顶3!=4,继续压入4,
 * 栈顶4==4,弹出4,弹栈下标+1,此时为5,
 * 栈顶3!=5,继续压入5,
 * 栈顶5==5,弹出5,弹栈下标+1,此时为3,
 * 栈顶3==3,弹出3,弹栈下标+1,此时为2,
 * ...
 * 最后栈为空,返回true,所以序列4,5,3,2,1是该压栈序列对应的一个弹出序列
 * 
 * 同理分析序列4,3,5,1,2
 * 1压入栈中,
 * 栈顶1!=4,继续压入2,
 * 栈顶2!=4,继续压入3,
 * 栈顶3!=4,继续压入4,
 * 栈顶4==4,弹出4,弹栈下标+1,此时为3,
 * 栈顶3==3,弹出3,弹栈下标+1,此时为5,
 * 2!=5,继续压入5,
 * 栈顶5==5,弹出5,弹栈下标+1,此时为1
 * 栈顶2!=1,同时压栈数组已遍历完毕
 * 最终栈不为空,返回false,所以序列4,3,5,1,2不是该压栈序列对应的一个弹出序列
 * 
 * @author HULIN
 */
public class PopOrder {

	
	public boolean IsPopOrder(int [] pushA,int [] popA) {
		if(pushA.length==0 || popA.length==0) return false;
		Stack<Integer> stack = new Stack<>();
		int popIndex = 0;
		for(int i=0;i<pushA.length;i++) {
			stack.push(pushA[i]);
			while(!stack.isEmpty() && stack.peek()==popA[popIndex]) {
				stack.pop();
				popIndex++;
			}
		}
		return stack.isEmpty();
    }
	
	public static void main(String[] args) {
		int[] pushA = {1,2,3,4,5};
		int[] popA = {4,3,5,1,2};
		PopOrder po = new PopOrder();
		System.out.println(po.IsPopOrder(pushA, popA));
		
	}
}
