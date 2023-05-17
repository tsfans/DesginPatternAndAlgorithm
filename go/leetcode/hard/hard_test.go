package hard

import (
	"fmt"
	"testing"
)

func TestFindMedianSortedArrays(t *testing.T) {
	nums1 := []int{1,3}
	nums2 := []int{2}
	expected := float64(2)
	actual := findMedianSortedArrays(nums1, nums2)
	fmt.Printf("actual=%v", actual)
	if actual != expected {
		t.Errorf("Test failed, expected: '%v', got:  '%v'", expected, actual)
	}
}
