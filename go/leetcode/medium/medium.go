package medium

import (
	"tsfans/practice/common/util"
)

/**
 * 2.Add Two Numbers https://leetcode.com/problems/add-two-numbers/
 * Time complexity: O(max(m,n))
 * Space complexity: O(max(m,n))
 */
func addTwoNumbers(l1 *util.ListNode, l2 *util.ListNode) *util.ListNode {
	if l1 == nil {
		return l2
	}
	if l2 == nil {
		return l1
	}
	var head, pre, curr *util.ListNode
	for {
		if l1 == nil && l2 == nil {
			// if the last node is 0, remove it
			if curr.Val == 0 {
				pre.Next = nil
			}
			break
		}
		if l1 == nil {
			l1 = &util.ListNode{Val: 0}
		}
		if l2 == nil {
			l2 = &util.ListNode{Val: 0}
		}
		if curr == nil {
			curr = &util.ListNode{Val: 0}
			head = curr
		}
		// add the two values
		curr.Val += l1.Val + l2.Val
		if curr.Val >= 10 {
			// if the sum is greater than 10, carry 1
			curr.Val -= 10
			curr.Next = &util.ListNode{Val: 1}
		} else {
			curr.Next = &util.ListNode{Val: 0}
		}
		pre = curr
		curr = curr.Next
		l1 = l1.Next
		l2 = l2.Next
	}
	return head
}

/**
 * 3. Longest Substring Without Repeating Characters https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
func lengthOfLongestSubstring(s string) int {
	if len(s) == 0 {
		return 0
	}
	var maxLen int
	var m = make(map[byte]int)
	// use two pointers to represent a window
	for i, j := 0, 0; j < len(s); j++ {
		if v, ok := m[s[j]]; ok {
			// if the char is in the map, move the left pointer to the right of the char
			if v > i {
				i = v
			}
		}
		if j-i+1 > maxLen {
			// update the maxLen
			maxLen = j - i + 1
		}
		// update the map
		m[s[j]] = j + 1
	}
	return maxLen
}
