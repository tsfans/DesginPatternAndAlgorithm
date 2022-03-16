package cn.hl.gof.creation5.simplefactory;

import cn.hl.gof.util.XMLUtil;

public class SimpleFactoryTest {

	
	public static void main(String[] args) {
		String type = XMLUtil.getValue("simpleFactory");
		PaintingTools tool;
		try {
			tool = PaintingToolFactory.getTool(type);
			tool.draw();
			tool.erase();
		} catch (UnSupportedShapeException e) {
			e.printStackTrace();
		}
	}
}
