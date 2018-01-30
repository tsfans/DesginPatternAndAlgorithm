package cn.hl.gof.abstractfactory.phonecontroller;

public class WindowsControllerFactory implements ControllerFactory{

	@Override
	public OperationController createOperationController() {
		return new WindowsOperCon();
	}

	@Override
	public InterfaceController createInterfaceController() {
		return new WindowsInterCon();
	}

	
}
