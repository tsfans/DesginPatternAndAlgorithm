package cn.hl.algorithm.datastructureandalgorithm.chapter2;

/**
 * 折半查找
 * 时间复杂度为N(logN)
 * @author HULIN
 */
public class BinarySearch {

	public static <T extends Comparable<? super T>> int binarySearch(T[] arr,T x) {
		int low = 0,high = arr.length-1;
		while(low<=high) {
			int mid = (low+high)/2;
			if(arr[mid].compareTo(x) > 0) {
				high = mid-1;
			}else if(arr[mid].compareTo(x) < 0) {
				low = mid+1;
			}else {
				return mid;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		Integer[] arr = {-3,-2,-1,0,1,2,3};
		System.out.println(binarySearch(arr, 5));
	}
}
