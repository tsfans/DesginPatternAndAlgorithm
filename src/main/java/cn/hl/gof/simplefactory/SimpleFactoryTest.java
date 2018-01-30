package cn.hl.gof.simplefactory;

import cn.hl.gof.util.XMLUtil;

public class SimpleFactoryTest {

	
	public static void main(String[] args) {
		String type = XMLUtil.getValue(XMLUtil.getPath(SimpleFactoryTest.class,"config.xml"), "toolType");
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
