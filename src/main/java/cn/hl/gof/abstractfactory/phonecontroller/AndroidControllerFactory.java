package cn.hl.gof.abstractfactory.phonecontroller;

public class AndroidControllerFactory implements ControllerFactory{

	@Override
	public OperationController createOperationController() {
		return new AndroidOperCon();
	}

	@Override
	public InterfaceController createInterfaceController() {
		return new AndroidInterCon();
	}

	
}
