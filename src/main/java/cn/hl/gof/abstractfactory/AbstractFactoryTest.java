package cn.hl.gof.abstractfactory;

import cn.hl.gof.util.XMLUtil;

public class AbstractFactoryTest {

	public static void main(String[] args) {
		String path = XMLUtil.getPath(AbstractFactoryTest.class, "config.xml");
		String className = XMLUtil.getValue(path, "className");
		SkinFactory factory = (SkinFactory) XMLUtil.getBean(className);
		Button b = factory.createButton();
		TextField t = factory.createTextField();
		ComboBox c = factory.createComboBox();
		b.display();
		t.display();
		c.display();
	}
}
