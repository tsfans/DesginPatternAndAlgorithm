package cn.hl.ojpratice.newcoder;

/**
 * @author HULIN
 * @date 2018年5月19日
 */
public class TailZeroOfFactorial {

	/**
	 * 求阶乘末尾有几个零,只需计算有多少个因数5 
	 */
	public static void test(long n) {
		long count = 0L;
		long temp = n/5;
		while(temp != 0) {
			count += temp;
			temp = temp/5;
		}
		System.out.println("count:"+count);
	}
	
	public static void main(String[] args) {
		test(100000000);
	}
}
