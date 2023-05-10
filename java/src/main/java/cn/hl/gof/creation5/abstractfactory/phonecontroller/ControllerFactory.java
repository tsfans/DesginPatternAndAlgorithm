package cn.hl.gof.creation5.abstractfactory.phonecontroller;

public interface ControllerFactory {

	OperationController createOperationController();
	
	InterfaceController createInterfaceController();
}
