package cn.hl.ojpratice.newcoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 统计字符串中字符出现的次数
 * 
 * @author HULIN
 */
public class CountCharInString {

	/**
	 * 将字符和出现的次数放入Map中
	 * key存在则+1,不存在则放入map,value为1
	 * @param str
	 */
	public void count(String str) {
		if(str==null || str.length()<=0) {
			return;
		}
		Map<Character,Integer> map = new HashMap<>();
		for(int i=0;i<str.length();i++) {
			if(map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), map.get(str.charAt(i))+1);
			}else {
				map.put(str.charAt(i), 1);
			}
		}
		for(Entry<Character,Integer> entry:map.entrySet()) {
			System.out.print(entry.getKey()+"="+entry.getValue());
		}
	}
	/**
	 * 将字符替换为空字符，旧字符串的长度减去新字符串的长度就是该字符出现的次数
	 * @param str
	 */
	public void count2(String str) {
		if(str==null || str.length()<=0) {
			return;
		}
		int count = 0;
		String s = "";
		String newStr = "";
		while(str.length()>0) {
			s = str.charAt(0)+"";
			newStr = str.replaceAll(s, "");
			count = str.length()-newStr.length();
			System.out.print(s+"="+count);
			str = newStr;
		}
			
	}
	
	public static void main(String[] args) {
		CountCharInString c = new CountCharInString();
		String str = "this is a test !";
		c.count(str);
		System.out.println();
		c.count2(str);
	}
}
