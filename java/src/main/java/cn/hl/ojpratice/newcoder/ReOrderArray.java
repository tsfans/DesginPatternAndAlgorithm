package cn.hl.ojpratice.newcoder;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * 
 * @author HULIN
 */
public class ReOrderArray {

	public void reOrderArray(int[] array) {
		if(array.length==0 || array.length==1) {
			return;
		}
		//新建一个等长数组
		int[] arr = new int[array.length];
		int count = 0;
		for(int i=0;i<array.length;i++) {
			//将奇数放入新数组
			if(array[i]%2 !=0) {
				arr[count++] = array[i];
			}
		}
		for(int i=0;i<array.length;i++) {
			//将偶数放入新数组
			if(array[i]%2==0) {
				arr[count++] = array[i];
			}
		}
		//对原数组重新赋值
		for(int i=0;i<arr.length;i++) {
			array[i] = arr[i];
		}
	}
	
	public void print(int[] array) {
		for(int i:array) {
			System.out.println(i);
		}
	}
	
	public static void main(String[] args) {
		ReOrderArray r = new ReOrderArray();
		int [] array = {1,2,3,4,5};
		r.reOrderArray(array);
		r.print(array);
	}
}
