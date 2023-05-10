package cn.hl.gof.creation5.abstractfactory.phonecontroller;

import cn.hl.gof.util.XMLUtil;

public class PhoneControllerTest {
	
	public static void main(String[] args) {
		ControllerFactory factory = (ControllerFactory) XMLUtil.getBeanByPatternName("phoneController");
		OperationController oc = factory.createOperationController();
		InterfaceController ic = factory.createInterfaceController();
		oc.show();
		ic.show();
	}
	
}
