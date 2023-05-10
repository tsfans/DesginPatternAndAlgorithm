package cn.hl.leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListNode {

    public int val;

    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public int[] toArray() {
        ListNode head = this;
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static ListNode toListNode(int[] array) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        for (int i = 0; i < array.length; i++) {
            current.next = new ListNode(array[i]);
            current = current.next;
        }
        return head.next;
    }

    @Override
    public String toString() {
        return toString(this.toArray());
    }

    public static String toString(int[] array) {
        Integer[] arr = Arrays.stream(array).boxed().toArray(Integer[]::new);
        return toString(arr);
    }

    public static String toString(Object[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i != array.length - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "pwwkew";
        int[] chars = new int[128];
        char c = str.charAt(0);
        chars[c]++;
        chars[0]++;
        System.out.println(ListNode.toString(chars));
        System.out.println(ListNode.toListNode(chars));
    }

}
