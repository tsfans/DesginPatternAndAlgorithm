package hard

import "math"

/**
 * 4.Median of Two Sorted Arrays https://leetcode.com/problems/median-of-two-sorted-arrays/
 * always binary search on the shorter array
 * Time complexity: O(log(min(m,n)))
 * Space complexity: O(1)
 */
func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {
	// always binary search on the shorter array
	if len(nums1) > len(nums2) {
		return findMedianSortedArrays(nums2, nums1)
	}
	m := len(nums1)
	n := len(nums2)
	left := 0
	right := m
	for left < right {
		shorterIdx := (left + right) / 2
		longerIdx := (m+n)/2 - shorterIdx
		if nums1[shorterIdx] < nums2[longerIdx-1] {
			left = shorterIdx + 1
		} else {
			right = shorterIdx
		}
	}
	shorterIdx := left
	longerIdx := (m+n)/2 - shorterIdx

	var shorterLeft, shorterRight, longerLeft, longerRight int
	if shorterIdx == 0 {
		shorterLeft = math.MinInt
	} else {
		shorterLeft = nums1[shorterIdx-1]
	}
	if shorterIdx == m {
		shorterRight = math.MaxInt
	} else {
		shorterRight = nums1[shorterIdx]
	}
	if longerIdx == 0 {
		longerLeft = math.MinInt
	} else {
		longerLeft = nums2[longerIdx-1]
	}
	if longerIdx == n {
		longerRight = math.MaxInt
	} else {
		longerRight = nums2[longerIdx]
	}
	if (m+n)%2 == 0 {
		// if the total length is even, the median is the average of the two numbers
		return math.Max(float64(shorterLeft), float64(longerLeft))*0.5 + math.Min(float64(shorterRight), float64(longerRight))*0.5
	}
	return math.Min(float64(shorterRight), float64(longerRight))
}
