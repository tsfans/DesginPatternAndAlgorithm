package cn.hl.ojpratice.newcoder;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，
 * 请你输出斐波那契数列的第n项。
 * n<=39
 * f(n)=f(n-1)+f(n-2)
 * @author HULIN
 */
public class FibonacciArray {

	//0 1 1 2 3 5
	public int Fibonacci(int n) {
		int f = 0;
		int s = 1;
		while(n>=1) {
			s = f + s;
			f = s - f;
			n--;
		}
		return f;
	}
	
	public static void main(String[] args) {
		FibonacciArray f = new FibonacciArray();
		System.out.println(f.Fibonacci(3));
	}
}
