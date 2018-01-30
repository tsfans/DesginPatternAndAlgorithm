package cn.hl.gof.abstractfactory.phonecontroller;

public interface ControllerFactory {

	OperationController createOperationController();
	
	InterfaceController createInterfaceController();
}
