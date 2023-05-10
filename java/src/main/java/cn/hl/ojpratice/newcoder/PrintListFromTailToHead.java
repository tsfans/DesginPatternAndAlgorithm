package cn.hl.ojpratice.newcoder;

import java.util.ArrayList;
import java.util.Stack;

import cn.hl.ojpratice.common.ListNode;

public class PrintListFromTailToHead {

	/**
	 * 
	 * 输入一个链表，从尾到头打印链表每个节点的值
	 * 
	 * @date 2017年12月26日下午5:22:15
	 * @param listNode
	 * @return
	 */
	static ArrayList<Integer> printListFromTailToHead(ListNode listNode){
		ArrayList<Integer> array = new ArrayList<Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		while(listNode!=null) {
			stack.push(listNode.val);
			listNode = listNode.next;
		}
		while (!stack.isEmpty()) {
			array.add(stack.pop());
		}
		return array;
	}
	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		ArrayList<Integer> array = printListFromTailToHead(node);
        for(Integer i:array) {
        	System.out.println(i);
        }
	}
}
