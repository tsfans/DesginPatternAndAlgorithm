package cn.hl.gof.creation5.abstractfactory;

import cn.hl.gof.util.XMLUtil;

public class AbstractFactoryTest {

	public static void main(String[] args) {
		SkinFactory factory = (SkinFactory) XMLUtil.getBeanByPatternName("abstractFactory");
		Button b = factory.createButton();
		TextField t = factory.createTextField();
		ComboBox c = factory.createComboBox();
		b.display();
		t.display();
		c.display();
	}
}
