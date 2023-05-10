package cn.hl.ojpratice.newcoder;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * @author HULIN
 */
public class JumpFloor {

	/**
	 * 对第n个台阶来说，只能从第n-1或n-2个台阶上跳上来
	 * 因此总的跳法 f(n)=f(n-1)+f(n-2)
	 * 形成一个f(1)=1,f(2)=2的斐波那契数列
	 * 1 2 3 5 8 13
	 * @param target
	 * @return
	 */
	public int jumpFloor(int target) {
		if(target==0) {
			return 0;
		}
		int f = 1;
		int s = 2;
		while(target>=2) {
			s += f;
			f = s - f;
			target--;
		}
		return f;
	}
	
	public static void main(String[] args) {
		JumpFloor j = new JumpFloor();
		System.out.println(j.jumpFloor(3));
	}
}
