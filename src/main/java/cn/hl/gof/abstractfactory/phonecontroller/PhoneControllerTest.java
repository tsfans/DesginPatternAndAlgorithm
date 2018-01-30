package cn.hl.gof.abstractfactory.phonecontroller;

import cn.hl.gof.util.XMLUtil;

public class PhoneControllerTest {
	
	public static void main(String[] args) {
		String path = XMLUtil.getPath(PhoneControllerTest.class, "config.xml");
		String className = XMLUtil.getValue(path, "className");
		ControllerFactory factory = (ControllerFactory) XMLUtil.getBean(className);
		OperationController oc = factory.createOperationController();
		InterfaceController ic = factory.createInterfaceController();
		oc.show();
		ic.show();
	}
	
}
