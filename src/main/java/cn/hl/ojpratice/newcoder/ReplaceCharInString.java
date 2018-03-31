package cn.hl.ojpratice.newcoder;

public class ReplaceCharInString {

	/**
	 * 
	 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
	 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
	 * 
	 * @date 2017年12月26日下午5:09:45
	 * @param str
	 * @return
	 */
	static String replace(String str) {
		StringBuffer sb = new StringBuffer();
        for(int i=0;i<str.length();i++) {
        	if(str.charAt(i)==' ') {
        		sb.append("%20");
        	}else {
        		sb.append(str.charAt(i));
        	}
        }
		return sb.toString();
	}
	public static void main(String[] args) {
		System.out.println(replace(" we are happy  ! "));
	}
}
