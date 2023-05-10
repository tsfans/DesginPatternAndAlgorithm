package cn.hl.gof.creation5.factorymethod;

import cn.hl.gof.util.XMLUtil;

public class FactoryMethodTest {

	public static void main(String[] args) {
		ReaderFactory factory = (ReaderFactory) XMLUtil.getBeanByPatternName("factoryMethod");
		ImageReader reader = factory.getReader();
		reader.readImage();
	}
}
