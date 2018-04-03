package cn.hl.ojpratice.newcoder;

import cn.hl.ojpratice.common.ListNode;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，
 * 当然我们需要合成后的链表满足单调不减规则。
 * 
 * @author HULIN
 */
public class MergeList {

	public ListNode Merge(ListNode list1,ListNode list2) {
		if(list1==null) {
			return list2;
		}
		if(list2==null) {
			return list1;
		}
        if(list1.val>list2.val) {
        	list2.next = Merge(list1,list2.next);
        	return list2;
        }else {
        	list1.next = Merge(list1.next,list2);
        	return list1;
        }
    }
	
	public void print(ListNode head) {
		while(head!=null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(5);
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(4);
		ListNode n6 = new ListNode(6);
		n1.next = n2;
		n2.next = n3;
		n4.next = n5;
		n5.next = n6;
		MergeList m = new MergeList();
		m.print(m.Merge(n1, n4));
	}
	
}
