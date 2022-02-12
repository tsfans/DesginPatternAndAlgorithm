package cn.hl.leetcode.editor.en;
//Given the head of a linked list, remove the nᵗʰ node from the end of the list 
//and return its head. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4,5], n = 2
//Output: [1,2,3,5]
// 
//
// Example 2: 
//
// 
//Input: head = [1], n = 1
//Output: []
// 
//
// Example 3: 
//
// 
//Input: head = [1,2], n = 1
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is sz. 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
// Follow up: Could you do this in one pass? 
// Related Topics Linked List Two Pointers 👍 8749 👎 415

public class RemoveNthNodeFromEndOfList{
	public static void main(String[] args) {
		Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
		ListNode l1 = ListNode.toListNode(new int[] { 1, 2, 3, 4, 5 });
		ListNode res = solution.removeNthFromEnd(l1, 5);
		System.out.println(res);
	}
	//leetcode submit region begin(Prohibit modification and deletion)
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode() {}
	 *     ListNode(int val) { this.val = val; }
	 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 * }
	 */
	class Solution {
		public ListNode removeNthFromEnd(ListNode head, int n) {
			ListNode dummy = new ListNode(0);
			dummy.next = head;
			// 移除倒数第k个节点=找到倒数k+1个节点
			ListNode l = findNthFromEnd(dummy, n + 1);
			if (l.next != null) {
				l.next = l.next.next;
			}
			return dummy.next;
		}

		private ListNode findNthFromEnd(ListNode head, int i) {
			ListNode slow = head;
			ListNode fast = head;
			// 快指针先走i步
			for (; i > 1; i--) {
				fast = fast.next;
			}
			// 快指针到尾则慢指针位于倒数第i个节点
			while (fast.next != null) {
				slow = slow.next;
				fast = fast.next;
			}
			return slow;
		}
	}
	//leetcode submit region end(Prohibit modification and deletion)

}