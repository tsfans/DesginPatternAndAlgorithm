package cn.hl.gof.builder;

import cn.hl.gof.util.XMLUtil;

public class BuilderTest {

	public static void main(String[] args) {
		PlayerBuilder pb = (PlayerBuilder) XMLUtil.getBeanByPatternName("builder");
		PlayerController pc = new PlayerController();
		VideoPlayer vp = pc.construct(pb);
		System.out.println(vp.toString());
	}
}
