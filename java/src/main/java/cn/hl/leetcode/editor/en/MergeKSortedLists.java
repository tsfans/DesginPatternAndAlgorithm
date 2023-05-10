package cn.hl.leetcode.editor.en;
//You are given an array of k linked-lists lists, each linked-list is sorted in 
//ascending order. 
//
// Merge all the linked-lists into one sorted linked-list and return it. 
//
// 
// Example 1: 
//
// 
//Input: lists = [[1,4,5],[1,3,4],[2,6]]
//Output: [1,1,2,3,4,4,5,6]
//Explanation: The linked-lists are:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//merging them into one sorted list:
//1->1->2->3->4->4->5->6
// 
//
// Example 2: 
//
// 
//Input: lists = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: lists = [[]]
//Output: []
// 
//
// 
// Constraints: 
//
// 
// k == lists.length 
// 0 <= k <= 10⁴ 
// 0 <= lists[i].length <= 500 
// -10⁴ <= lists[i][j] <= 10⁴ 
// lists[i] is sorted in ascending order. 
// The sum of lists[i].length will not exceed 10⁴. 
// 
// Related Topics Linked List Divide and Conquer Heap (Priority Queue) Merge 
//Sort 👍 11066 👎 443

import java.util.Arrays;
import java.util.Comparator;

public class MergeKSortedLists {
	public static void main(String[] args) {

		Solution solution = new MergeKSortedLists().new Solution();
		ListNode l1 = ListNode.toListNode(new int[] {1,4,5});
		ListNode l2 = ListNode.toListNode(new int[] {1,3,4});
		ListNode l3 = ListNode.toListNode(new int[] { 2, 6 });
		ListNode[] lists = new ListNode[] { l1, l2, l3 };
		ListNode res = solution.mergeKLists(lists);
		System.out.println(res);
	}

	// leetcode submit region begin(Prohibit modification and deletion)
	/**
	 * Definition for singly-linked list. public class ListNode { int val; ListNode
	 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
	 * ListNode next) { this.val = val; this.next = next; } }
	 */
	class Solution {
		public ListNode mergeKLists(ListNode[] lists) {
			MinHeap<ListNode> pq = new MinHeap<>(lists.length, (n1, n2) -> n1.val - n2.val);
			for (ListNode l1 : lists) {
				if (l1 != null) {
					pq.add(l1);
				}
			}
			ListNode dummy = new ListNode(0);
			ListNode p = dummy;
			while (pq.size() > 0) {
				ListNode next = pq.pop();
				p.next = next;
				p = p.next;
				if (next.next != null) {
					pq.add(next.next);
				}
			}
			return dummy.next;
		}
	}

	/**
	 * 最小堆
	 */
	class MinHeap<E> {

		private E[] array;

		private int size;

		private Comparator<E> comparator;

		MinHeap(int capacity, Comparator<E> comparator) {
			array = (E[]) new Object[capacity];
			this.comparator = comparator;
		}

		public void add(E e) {
			if(e == null){
				return;
			}
			int i = size;
			if (i >= array.length) {
				grow();
			}
			// 添加新元素到底部并上浮到正确位置
			array[i] = e;
			size++;
			swimUp(i);
		}

		public E pop() {
			if (size == 0) {
				return null;
			}
			E tail = array[size - 1];
			E top = array[0];
			// 头尾互换后删除尾部并将头沉到正确位置
			array[0] = tail;
			array[size - 1] = null;
			size--;
			if (size > 1) {
				sinkDown(0);
			}
			return top;
		}

		public int size() {
			return size;
		}

		private void grow() {
			int oldCapacity = array.length;
			// Double size if small; else grow by 50%
			int growth = oldCapacity < 64 ? oldCapacity + 2 : oldCapacity >> 1;
			int newCapacity = oldCapacity + growth > Integer.MAX_VALUE ? Integer.MAX_VALUE : oldCapacity + growth;
			array = Arrays.copyOf(array, newCapacity);
		}

		private void swimUp(int target) {
			while (target > 0 && lessThan(target, parent(target))) {
				swap(target, parent(target));
				target = parent(target);
			}
		}

		private void sinkDown(int target) {
			// 左子节点存在
			while (left(target) < size) {
				int old = left(target);
				if (right(target) < size && lessThan(right(target), old)) {
					// 右子节点也存在则取小的一个
					old = right(target);
				}
				if (lessThan(target, old)) {
					// 比最小子节点小则位置正确
					break;
				}
				swap(target, old);
				target = old;
			}
		}

		private void swap(int i, int j) {
			E tmp = array[i];
			array[i] = array[j];
			array[j] = tmp;
		}

		private boolean lessThan(int i, int j) {
			return this.comparator.compare(array[i], array[j]) < 0;
		}

		private int parent(int i) {
			return (i - 1) / 2;
		}

		private int left(int i) {
			return i * 2 + 1;
		}

		private int right(int i) {
			return i * 2 + 2;
		}

	}

	// leetcode submit region end(Prohibit modification and deletion)

}