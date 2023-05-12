package easy

import (
	"fmt"
	"reflect"
	"testing"
)

func TestTwoSum(t *testing.T) {
	nums := []int{2, 7, 11, 15}
	target := 9
	expected := []int{0, 1}
	actual := twoSum(nums, target)
	fmt.Println(actual)
	if !reflect.DeepEqual(expected, actual) {
		t.Errorf("Test failed, expected: '%v', got:  '%v'", expected, actual)
	}
}
