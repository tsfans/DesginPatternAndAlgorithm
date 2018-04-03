package cn.hl.ojpratice.newcoder;

import java.util.Stack;

import cn.hl.ojpratice.common.ListNode;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 
 * @author HULIN
 */
public class FindKthToTail {

	/**
	 * 将链表全部压入栈中,然后弹出第k个
	 * 
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode findKthToTail1(ListNode head,int k) {
		if(head==null || k<=0) {
			return null;
		}
		Stack<ListNode> s = new Stack<>();
		while(head!=null) {
			s.push(head);
			head = head.next;
		}
		while(k>0) {
			if(!s.isEmpty()) {
				head = s.pop();
			}else {
				return null;
			}
			k--;
		}
		return head;
	}
	
	/**
	 * 两个指针，先让第一个指针和第二个指针都指向头结点，
	 * 然后再让第一个指针走(k-1)步，到达第k个节点。
	 * 然后两个指针同时往后移动，当第一个结点到达末尾的时候，
	 * 第二个结点所在位置就是倒数第k个节点了
	 * 
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode findKthToTail2(ListNode head,int k) {
		if(head==null || k<=0) {
			return null;
		}
		ListNode f = head;
		ListNode s = head;
		for(int i=1;i<k;i++) {
			if(f.next!=null) {
				f = f.next;
			}else {
				return null;
			}
		}
		while(f.next!=null) {
			f = f.next;
			s = s.next;
		}
		return s;
	}
}
