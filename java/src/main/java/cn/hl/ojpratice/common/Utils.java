package cn.hl.ojpratice.common;

import java.util.List;

/**
 * 辅助工具类
 * 
 * @author HULIN
 */
public class Utils {

	/**
	 * 前序遍历二叉树
	 * @param t
	 */
	public static void prePrint(TreeNode t) {
		if(t==null) {
			return;
		}
		System.out.print(t.val+",");
		prePrint(t.left);
		prePrint(t.right);
	}
	/**
	 * 顺序输出链表
	 * @param head
	 */
	public static void print(ListNode head) {
		while(head!=null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
	/**
	 * 顺序输出数组
	 * @param array
	 */
	public static void printArray(int[] array) {
		for(int i:array) {
			System.out.print(i+",");
		}
	}
	
	public static void printArray(List<Integer> array) {
		for(int i:array) {
			System.out.print(i+",");
		}
	}
}
