package cn.hl.ojpratice.newcoder;

/**
 * 
 * 给定一个double类型的浮点数base和int类型的整数exponent。
 * 求base的exponent次方。
 * 
 * @author HULIN
 */
public class Power {

	public double pow(double base, int exponent) {
		if(base==0) {
			return 0;
		}
		if(exponent>=0) {
			return power(base,exponent);
		}else {
			return 1/(power(base,exponent*-1));
		}
	}
	
	private double power(double base,int exponent) {
		if(exponent==0) {
			return 1;
		}
		if(exponent%2==0) {
				return power(base*base,exponent/2);
		}else {
				return power(base*base,exponent/2)*base;
		}
	}
	
	public static void main(String[] args) {
		Power pow = new Power();
		System.out.println(pow.pow(2, -3));
	}
}
