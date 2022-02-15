package cn.hl.leetcode.editor.en;
//Given the head of a linked list, reverse the nodes of the list k at a time, 
//and return the modified list. 
//
// k is a positive integer and is less than or equal to the length of the 
//linked list. If the number of nodes is not a multiple of k then left-out nodes, in 
//the end, should remain as it is. 
//
// You may not alter the values in the list's nodes, only nodes themselves may 
//be changed. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4,5], k = 2
//Output: [2,1,4,3,5]
// 
//
// Example 2: 
//
// 
//Input: head = [1,2,3,4,5], k = 3
//Output: [3,2,1,4,5]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is n. 
// 1 <= k <= n <= 5000 
// 0 <= Node.val <= 1000 
// 
//
// 
// Follow-up: Can you solve the problem in O(1) extra memory space? 
// Related Topics Linked List Recursion 👍 6283 👎 470

public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        Solution solution = new ReverseNodesInKGroup().new Solution();
        ListNode head = ListNode.toListNode(new int[]{1, 2, 4, 5});
        ListNode res = solution.reverseKGroup(head, 2);
        System.out.println(res);
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

        /**
         * 递归反转
         * 时间复杂度O(N)
         * 空间复杂度O(N)
         */
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode start = head;
            ListNode end = head;
            for (int i = 0; i < k; i++) {
                // base case: 不足k个,不需要反转
                if (end == null) {
                    return head;
                }
                end = end.next;
            }
            // 反转前k个元素
            ListNode res = reverse(start, end);
            // 反转后start为尾节点,递归反转后续链表并连接起来
            start.next = reverseKGroup(end, k);
            return res;
        }

        /**
         * 反转区间 [a, b) 的元素，左闭右开
         */
        private ListNode reverse(ListNode head, ListNode end) {
            ListNode prev = null;
            ListNode curr = head;
            ListNode next = null;
            while (curr != end) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            // 返回反转后的头结点
            return prev;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}