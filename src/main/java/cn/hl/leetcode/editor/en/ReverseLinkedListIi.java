package cn.hl.leetcode.editor.en;
//Given the head of a singly linked list and two integers left and right where 
//left <= right, reverse the nodes of the list from position left to position 
//right, and return the reversed list. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4,5], left = 2, right = 4
//Output: [1,4,3,2,5]
// 
//
// Example 2: 
//
// 
//Input: head = [5], left = 1, right = 1
//Output: [5]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is n. 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//Follow up: Could you do it in one pass? Related Topics Linked List 👍 5544 👎 
//266

public class ReverseLinkedListIi {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedListIi().new Solution();
        ListNode l = ListNode.toListNode(new int[]{1, 2, 3, 4, 5});
        ListNode res = solution.reverseBetween(l, 1, 2);
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
        public ListNode reverseBetween(ListNode head, int left, int right) {
            int pos = 1;
            ListNode l = head;
            ListNode prev = null;
            ListNode next = null;
            // A(l1)->B(l2=left)->C->D(r1=right)->E(r2)->NULL
            ListNode l1 = null;
            ListNode l2 = null;
            ListNode r1 = null;
            ListNode r2 = null;
            for (; l != null; l = next) {
                next = l.next;
                if (pos >= left && pos <= right) {
                    if (pos == left) {
                        // 保存左边界节点
                        l1 = prev;
                        l2 = l;
                        if (prev != null) {
                            // 断开防止循环引用
                            prev.next = null;
                        }
                    }
                    if (pos == right) {
                        r1 = l;
                        r2 = l.next;
                    }
                    l.next = prev;
                }
                if(pos > right){
                    // 无需再迭代
                    break;
                }
                prev = l;
                pos++;
            }
            if (l1 != null) {
                l1.next = r1;
            }
            if (l2 != null) {
                l2.next = r2;
            }
            // 左边界为空则右边界为新的head
            return l1 == null ? r1 : head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}