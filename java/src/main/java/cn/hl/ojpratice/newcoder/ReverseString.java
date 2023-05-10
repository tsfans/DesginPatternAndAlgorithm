package cn.hl.ojpratice.newcoder;

/**
 * 反转字符串
 * 
 * @author HULIN
 */
public class ReverseString {

	public String reverse(String str) {
		if(str==null || str.length()<=1) {
			return str;
		}
		return reverse(str.substring(1))+str.charAt(0);
	}
	
	public String reverse2(String str) {
		StringBuffer sb = new StringBuffer();
		for(int i=str.length()-1;i>=0;i--) {
			sb.append(str.charAt(i));
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		ReverseString r = new ReverseString();
		String str = "this is a test!";
		System.out.println(r.reverse(str));
		System.out.println(r.reverse2(str));
	}
	
}
