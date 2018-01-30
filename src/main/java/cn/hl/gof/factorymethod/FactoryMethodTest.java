package cn.hl.gof.factorymethod;

import cn.hl.gof.util.XMLUtil;

public class FactoryMethodTest {

	public static void main(String[] args) {
		String path = XMLUtil.getPath(FactoryMethodTest.class, "config.xml");
		String className = XMLUtil.getValue(path, "className");
		ReaderFactory factory = (ReaderFactory) XMLUtil.getBean(className);
		ImageReader reader = factory.getReader();
		reader.readImage();
	}
}
