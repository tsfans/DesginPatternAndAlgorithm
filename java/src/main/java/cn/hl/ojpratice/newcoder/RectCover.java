package cn.hl.ojpratice.newcoder;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 
 * @author HULIN
 */
public class RectCover {

	/**
	 * f(n)=f(n-1)+f(n-2)
	 * f(1)=1,f(2)=2
	 * 
	 * @param target
	 * @return
	 */
	public int rectCover(int target) {
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
}
