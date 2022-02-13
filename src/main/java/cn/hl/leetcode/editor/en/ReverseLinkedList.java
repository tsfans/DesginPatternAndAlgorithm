package cn.hl.leetcode.editor.en;
//Given the head of a singly linked list, reverse the list, and return the 
//reversed list. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4,5]
//Output: [5,4,3,2,1]
// 
//
// Example 2: 
//
// 
//Input: head = [1,2]
//Output: [2,1]
// 
//
// Example 3: 
//
// 
//Input: head = []
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is the range [0, 5000]. 
// -5000 <= Node.val <= 5000 
// 
//
// 
// Follow up: A linked list can be reversed either iteratively or recursively. 
//Could you implement both? 
// Related Topics Linked List Recursion 👍 10535 👎 181

public class ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();

        System.out.println();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode reverseList2(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode last = reverseList(head.next);
            // A(head)->B->NULL => A(head)->B->A => B->A->NULL
            head.next.next = head;
            head.next = null;
            return last;
        }

        public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode next = null;
            for (ListNode l = head; l != null; l = next) {
                // A(head)->B->C->NULL => NULL<-A B->C->NULL
                next = l.next;
                l.next = prev;
                prev = l;
            }
            return prev;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}