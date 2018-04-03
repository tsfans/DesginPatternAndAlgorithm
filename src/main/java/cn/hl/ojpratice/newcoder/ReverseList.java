package cn.hl.ojpratice.newcoder;

import cn.hl.ojpratice.common.ListNode;

/**
 * 输入一个链表，反转链表后，输出链表的所有元素。
 * pre > head > next
 * pre < head    |
 *        |      |
 * 		 pre  > head > next
 * 
 * @author HULIN
 */
public class ReverseList {

	public ListNode reverseList(ListNode head) {
		if(head==null) {
			return null;
		}
		ListNode pre = null;
		ListNode next = null;
		while(head!=null) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
    }
}
