package cn.hl.algorithm.datastructureandalgorithm.chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 删除表中的偶数
 * @author HULIN
 */
public class RemoveEvens {

	/**
	 * 对于ArrayList每次remove数组的项都要移动,其时间复杂度为O(N^2)
	 * 对于LinkedList,程序花费线性时间,复杂度为O(N)
	 * @param list
	 */
	public static void removeEvens(List<Integer> list) {
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()) {
			if(it.next()%2==0) {
				it.remove();
			}
		}
		for(Integer i:list) {
			System.out.print(i+",");
		}
	}
	public static void main(String[] args) {
		Integer[] arr = {1,5,1,2,5,76,21,23,6,2};
		ArrayList<Integer> al = new ArrayList<>(Arrays.asList(arr));
		LinkedList<Integer> ll = new LinkedList<>(Arrays.asList(arr));
		removeEvens(al);
		System.out.println();
		removeEvens(ll);
		MyArrayList<Integer> mal = new MyArrayList<>();
		mal.add(2);
		mal.add(-2);
		mal.add(3);
		mal.add(4);
		mal.add(-6);
		mal.add(7);
		mal.set(2, 10);
		mal.remove(3);
		mal.add(3, 20);
		System.out.println();
		for(Integer i:mal) {
			System.out.println(i);
		}
	}
}
