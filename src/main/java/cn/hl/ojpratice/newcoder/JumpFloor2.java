package cn.hl.ojpratice.newcoder;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 
 * @author HULIN
 */
public class JumpFloor2 {

	/**
	 * f(n)=f(n-1)+f(n-2)+...+f(2)+f(1)+f(0);
	 * f(n-1)=f(n-2)+f(n-3)+...+f(2)+f(1)+f(0);
	 * f(n)=2*f(n-1)
	 * 
	 * @param target
	 * @return
	 */
	public int jumpFloor(int target) {
		if(target==0) {
			return 0;
		}
		int f = 1;
		while(target>1) {
			f = f * 2;
			target--;
		}
		return f;
	}
	
	public static void main(String[] args) {
		JumpFloor2 j = new JumpFloor2();
		System.out.println(j.jumpFloor(5));
	}
}
