package medium

import (
	"fmt"
	"reflect"
	"testing"
	"tsfans/practice/common/util"
)

func TestAddTwoNumbers(t *testing.T) {
	l1 := util.ArrToListNode([]int{2, 4, 3})
	l2 := util.ArrToListNode([]int{5, 6, 4})
	expected := []int{7, 0, 8}
	actual := util.ListNodeToArr(addTwoNumbers(l1, l2))
	fmt.Println(actual)
	if !reflect.DeepEqual(expected, actual) {
		t.Errorf("Test failed, expected: '%v', got:  '%v'", expected, actual)
	}
}

func TestLengthOfLongestSubstring(t *testing.T) {
	s := "abcabcbb"
	expected := 3
	actual := lengthOfLongestSubstring(s)
	fmt.Println(actual)
	if expected != actual {
		t.Errorf("Test failed, expected: '%v', got:  '%v'", expected, actual)
	}
}

func TestLongestPalindrome(t *testing.T) {
	s := "babad"
	expected := "bab"
	actual := longestPalindrome(s)
	fmt.Println(actual)
	if expected != actual {
		t.Errorf("Test failed, expected: '%v', got:  '%v'", expected, actual)
	}
}

func TestZigzagConversion(t *testing.T) {
	s := "PAYPALISHIRING"
	expected := "PAHNAPLSIIGYIR"
	actual := zigzagConversion(s, 3)
	fmt.Println(actual)
	if expected != actual {
		t.Errorf("Test failed, expected: '%v', got:  '%v'", expected, actual)
	}
}

func TestReverseInteger(t *testing.T) {
	x := -2147483412
	expected := -2143847412
	actual := reverseInteger(x)
	fmt.Println(actual)
	if expected != actual {
		t.Errorf("Test failed, expected: '%v', got:  '%v'", expected, actual)
	}
}
