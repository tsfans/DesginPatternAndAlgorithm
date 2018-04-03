package cn.hl.ojpratice.newcoder;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。
 * 其中负数用补码表示。
 * 
 * @author HULIN
 */
public class NumberOf1 {

	public int numberOf1(int n) {
		String s = Integer.toBinaryString(n);
		int count = 0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='1') {
				count++;
			}
		}
		return count;
	}
	public int numberOf1II(int n) {
		int count = 0;
		while(n!= 0){
			count++;
			n = n & (n - 1);
		}
		return count;
	}
	public int numberOf1III(int n) {
		int flag = 1;
		int count = 0;
		while(flag!= 0){
			if((n&flag)!=0) {
				count++;
			}
			flag = flag << 1;
		}
		return count;
	}
}
