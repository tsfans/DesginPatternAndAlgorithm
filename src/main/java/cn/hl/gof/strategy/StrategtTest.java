package cn.hl.gof.strategy;

import cn.hl.gof.util.XMLUtil;

public class StrategtTest {

	public static void main(String[] args) {
		Plane p = (Plane) XMLUtil.getBeanByPatternName("strategy");
		PlaneSimulator ps = new PlaneSimulator();
		ps.setPlane(p);
		ps.flySimlate();
	}

}
