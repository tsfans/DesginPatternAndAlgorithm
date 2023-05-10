package cn.hl.ojpratice.newcoder;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转， 
 * 该数组的最小值为1。
 *  NOTE：给出的所有元素都大于0， 若数组大小为0，请返回0。
 * 
 * @author HULIN
 */
public class MinNumberInRotateArray {

	/**
	 * 采用二分法解答这个问题，
	 * mid = low + (high - low)/2
	 * 需要考虑三种情况：
	 * (1)array[mid] > array[high]:
	 * 出现这种情况的array类似[3,4,5,6,0,1,2]，此时最小数字一定在mid的右边。
	 * low = mid + 1
	 * (2)array[mid] == array[high]:
	 * 出现这种情况的array类似 [1,0,1,1,1] 或者[1,1,1,0,1]，此时最小数字不好判断在mid左边
	 * 还是右边,这时只好一个一个试 ，
	 * high = high - 1
	 * (3)array[mid] < array[high]:
	 * 出现这种情况的array类似[2,2,3,4,5,6,6],此时最小数字一定就是array[mid]或者在mid的左
	 * 边。因为右边必然都是递增的。
	 * high = mid
	 * 注意这里有个坑：如果待查询的范围最后只剩两个数，那么mid 一定会指向下标靠前的数字
	 * 比如 array = [4,6]
	 * array[low] = 4 ;array[mid] = 4 ; array[high] = 6 ;
	 * 如果high = mid - 1，就会产生错误， 因此high = mid
	 * 但情形(1)中low = mid + 1就不会错误
	 * 
	 * @param array
	 * @return
	 */
	public int minNumberInRotateArray(int[] array) { 
		if(array.length==0) {
			return 0;
		}
		int low = 0;
		int high = array.length-1;
		while(low<high) {
			int mid = low+(high-low)/2;
			if(array[mid]>array[high]) {
				low = mid + 1;
			}else if(array[mid]==array[high]) {
				high--;
			}else {
				high = mid;
			}
		}
		return array[low];
	}
	
	public static void main(String[] args) {
		MinNumberInRotateArray a = new MinNumberInRotateArray();
		int[] array = {6501,6828,6963,7036,7422,7674,8146,8468,8704,8717,9170,9359,9719,9895,9896,9913,9962,154,293,334,492,1323,1479,1539,1727,1870,1943,2383,2392,2996,3282,3812,3903,4465,4605,4665,4772,4828,5142,5437,5448,5668,5706,5725,6300,6335};
		System.out.println(a.minNumberInRotateArray(array));
	}
}
