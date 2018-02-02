package cn.hl.gof.adapter;

import cn.hl.gof.util.XMLUtil;

public class AdapterTest {

	public static void main(String[] args) {
		Encoder encoder = (Encoder) XMLUtil.getBeanByPatternName("adapter");
		encoder.encodePassword("123456");
		encoder.encodeEmail("123@qq.com");
	}
}
