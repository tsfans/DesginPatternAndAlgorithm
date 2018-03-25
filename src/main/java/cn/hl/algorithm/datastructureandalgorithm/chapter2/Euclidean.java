package cn.hl.algorithm.datastructureandalgorithm.chapter2;

/**
 * 欧几里德算法(辗转相除法求最大公约数)
 * 时间复杂度为O(logN)
 * (a,b)*[a,b]=ab
 * @author HULIN
 */
public class Euclidean {

	public static long gcd1(long x,long y) {
		while(y!=0) {
			long rem = x%y;
			x = y;
			y = rem;
		}
		return x;
	}
	
	public static long gcd2(long x,long y) {
		if(x<0||y<0) {
			return -1;
		}
		if(y==0) {
			return x;
		}
		return gcd2(y,x%y);
	}
	
	public static void main(String[] args) {
		long x = 1989L;
		long y = 1590L;
		System.out.println(gcd1(x,y));
		System.out.println(gcd2(x,y));
	}
}
