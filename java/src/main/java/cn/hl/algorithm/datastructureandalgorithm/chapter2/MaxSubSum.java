package cn.hl.algorithm.datastructureandalgorithm.chapter2;

/**
 * 求解最大子序列和,均为负数则返回0
 * @author HULIN
 */
public class MaxSubSum {

	/**
	 * for循环穷举所有可能
	 * 时间复杂度为O(N^3)
	 * @param arr
	 * @return
	 */
	public static int maxSubSum1(int [] arr) {
		int maxSum = 0;
		for(int i =0;i<arr.length;i++) {
			for(int j=i;j<arr.length;j++) {
				int thisSum = 0;
				for(int k=i;k<=j;k++) {
					thisSum += arr[k];
				}
				if(thisSum>maxSum) {
					maxSum = thisSum;
				}
			}
		}
		return maxSum;
	}
	
	/**
	 * 穷举改进
	 * 时间复杂度为O(N^2)
	 * @param arr
	 * @return
	 */
	public static int maxSubSum2(int[] arr) {
		int maxSum = 0;
		for(int i=0;i<arr.length;i++) {
			int thisSum = 0;
			for(int j=i;j<arr.length;j++) {
				thisSum += arr[j];
				if(thisSum>maxSum) {
					maxSum = thisSum;
				}
			}
		}
		return maxSum;
	}
	/**
	 * 分治求解,递归得到左右子集最大和,循环得到左边界最大和与右边界最大和，
	 * 相加后与左右最大和比较返回最大值
	 * 时间复杂度为O(NlogN)
	 * @param arr
	 * @param left
	 * @param right
	 * @return
	 */
	public static int maxSubSum3(int[] arr,int left,int right) {
		if(left == right) {
			if(arr[left] > 0) {
				return arr[left];
			}else {
				return 0;
			}
		}
		int center = (left+right)/2;
		int maxLeftSum = maxSubSum3(arr,left,center);
		int maxRightSum = maxSubSum3(arr,center+1,right);
		int maxLeftBorderSum = 0,leftBorderSum = 0;
		for(int i=center;i>=left;i--) {
			leftBorderSum += arr[i];
			if(leftBorderSum > maxLeftBorderSum) {
				maxLeftBorderSum = leftBorderSum;
			}
		}
		int maxRightBorderSum = 0,rightBorderSum = 0;
		for(int j=center+1;j<=right;j++) {
			rightBorderSum += arr[j];
			if(rightBorderSum > maxRightBorderSum) {
				maxRightBorderSum = rightBorderSum;
			}
		}
		return max(maxLeftSum,maxRightSum,maxLeftBorderSum+maxRightBorderSum);
	}
	/**
	 * 返回三个数中的最大值
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	private static int max(int a,int b,int c) {
		if(a>b) {
			return a>c?a:c;
		}else {
			return b>c?b:c;
		}
	}
	
	/**
	 * 最优解
	 * 时间复杂度为O(N)
	 * @param arr
	 * @return
	 */
	public static int maxSubSum4(int[] arr) {
		int maxSum=0,thisSum=0;
		for(int i=0;i<arr.length;i++) {
			thisSum += arr[i];
			if(thisSum>maxSum) {
				maxSum = thisSum;
			}else if(thisSum<0) {
				thisSum = 0;
			}
		}
		return maxSum;
	}
	
	public static void main(String[] args) {
		int[] arr = {4,-3,5,-2,-1,2,6,-2};
		System.out.println("maxSubSum1 : "+maxSubSum1(arr));
		System.out.println("maxSubSum2 : "+maxSubSum2(arr));
		System.out.println("maxSubSum3 : "+maxSubSum3(arr,0,arr.length-1));
		System.out.println("maxSubSum4 : "+maxSubSum4(arr));
	}
}
