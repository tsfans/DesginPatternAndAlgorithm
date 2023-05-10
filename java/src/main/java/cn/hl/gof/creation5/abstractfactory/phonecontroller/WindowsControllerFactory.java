package cn.hl.gof.creation5.abstractfactory.phonecontroller;

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
