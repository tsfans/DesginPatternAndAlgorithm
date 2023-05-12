package util

func ArrToListNode(arr []int) *ListNode {
	if arr == nil || len(arr) == 0 {
		return nil
	}
	head := &ListNode{Val: arr[0]}
	cur := head
	for i := 1; i < len(arr); i++ {
		cur.Next = &ListNode{Val: arr[i]}
		cur = cur.Next
	}
	return head
}

func ListNodeToArr(head *ListNode) []int {
	if head == nil {
		return nil
	}
	var arr []int
	for head != nil {
		arr = append(arr, head.Val)
		head = head.Next
	}
	return arr
}

type ListNode struct {
	Val  int
	Next *ListNode
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}
