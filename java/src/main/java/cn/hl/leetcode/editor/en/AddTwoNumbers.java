package cn.hl.leetcode.editor.en;
//You are given two non-empty linked lists representing two non-negative 
//integers. The digits are stored in reverse order, and each of their nodes contains a 
//single digit. Add the two numbers and return the sum as a linked list. 
//
// You may assume the two numbers do not contain any leading zero, except the 
//number 0 itself. 
//
// 
// Example 1: 
//
// 
//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [7,0,8]
//Explanation: 342 + 465 = 807.
// 
//
// Example 2: 
//
// 
//Input: l1 = [0], l2 = [0]
//Output: [0]
// 
//
// Example 3: 
//
// 
//Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//Output: [8,9,9,9,0,0,0,1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in each linked list is in the range [1, 100]. 
// 0 <= Node.val <= 9 
// It is guaranteed that the list represents a number that does not have 
//leading zeros. 
// 
// Related Topics Linked List Math Recursion 👍 16230 👎 3470

public class AddTwoNumbers{
      public static void main(String[] args) {
          Solution solution = new AddTwoNumbers().new Solution();
          ListNode l1 = new ListNode(2);
          ListNode l2 = new ListNode(4);
          ListNode l3 = new ListNode(3);
          ListNode l4 = new ListNode(5);
          ListNode l5 = new ListNode(6);
          ListNode l6 = new ListNode(4);
          l1.next = l2;
          l2.next = l3;
          l4.next = l5;
          l5.next = l6;
          ListNode result = solution.addTwoNumbers(l1, l4);
          while (result != null){
              System.out.println(result.val);
              result = result.next;
          }
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        boolean plus = false;
        while(l1 != null || l2 != null){
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            int v3 = v1 + v2;
            if(plus) v3++;
            plus = v3 >= 10 ? true : false;
            current.next = new ListNode(v3 % 10);
            current = current.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if(plus){
            current.next = new ListNode(1);
        }
        return head.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
  }