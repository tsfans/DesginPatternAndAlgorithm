package cn.hl.algorithm.datastructureandalgorithm.chapter2;


/**
 * 幂运算
 * 时间复杂度为O(logN)
 * @author HULIN
 */
public class Pow {

	public static long pow(long x,int n) {
		if(n==0) {
			return 1;
		}
		if(n%2==0) {
			return pow(x*x,n/2);
		}else {
			return pow(x*x,n/2)*x;
		}
	}
	public static void main(String[] args) {
		System.out.println(pow(2312,6));
	}
}
