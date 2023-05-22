package medium

import (
	"fmt"
	"math"
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

/**
 * 5. Longest Palindromic Substring https://leetcode.com/problems/longest-palindromic-substring/
 * Time complexity: O(n^2)
 * Space complexity: O(1)
 */
func longestPalindrome(s string) string {
	// base case
	if len(s) <= 1 {
		return s
	}
	res := ""
	for i := 0; i < len(s); i++ {
		// odd case, like "aba", middle char is s[i]
		tmp := palindrome(s, i, i)
		if len(tmp) > len(res) {
			res = tmp
		}
		// even case, like "abba", middle chars are s[i] and s[i+1]
		tmp = palindrome(s, i, i+1)
		if len(tmp) > len(res) {
			res = tmp
		}
	}
	return res
}

func palindrome(s string, l, r int) string {
	// expand the window
	for l >= 0 && r < len(s) && s[l] == s[r] {
		l--
		r++
	}
	// return the substring
	return s[l+1 : r]
}

/**
 * 6. Zigzag Conversion https://leetcode.com/problems/zigzag-conversion/
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
func zigzagConversion(s string, numRows int) string {
	if numRows == 1 {
		return s
	}
	var res string
	var rows = make([]string, numRows)
	var i, flag int
	for _, v := range s {
		rows[i] += string(v)
		if i == 0 {
			// move down to next row while on top
			flag = 1
		} else if i == numRows-1 {
			// move up to previous row while on bottom
			flag = -1
		}
		i += flag
	}
	for _, v := range rows {
		res += v
	}
	return res
}

/**
 * 7. Reverse Integer https://leetcode.com/problems/reverse-integer/
 */
func reverseInteger(x int) int {
	if x == 0 {
		return x
	}
	neg := x < 0
	if neg {
		x = -x
	}
	for x%10 == 0 {
		x = x / 10
	}
	xs := fmt.Sprintf("%d", x)
	chars := []byte(xs)
	for i := 0; i < len(xs)/2; i++ {
		chars[i], chars[len(chars)-i-1] = chars[len(chars)-i-1], chars[i]
	}
	out := isOutInt32(string(chars), neg)
	if out {
		return 0
	} else {
		var res int
		for i, v := range chars {
			mul := math.Pow(10, float64(len(chars)-i-1))
			res += int(v-'0') * int(mul)
		}
		if neg {
			return -res
		}
		return res
	}
}

func isOutInt32(s string, neg bool) bool {
	var limit string
	if neg {
		// remove negative symbol
		limit = fmt.Sprintf("%d", math.MinInt32)[1:]
	} else {
		limit = fmt.Sprintf("%d", math.MaxInt32)
	}
	// if the length of s is greater than limit, return false
	if len(s) > len(limit) {
		return true
	}
	// if the length of s is less than limit, return true
	if len(s) < len(limit) {
		return false
	}
	for i := range s {
		if s[i] > limit[i] {
			return true
		}
		if s[i] < limit[i] {
			return false
		}
	}
	return false
}
