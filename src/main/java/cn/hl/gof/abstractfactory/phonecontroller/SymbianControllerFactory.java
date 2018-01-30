package cn.hl.gof.abstractfactory.phonecontroller;

public class SymbianControllerFactory implements ControllerFactory{

	@Override
	public OperationController createOperationController() {
		return new SymbianOperCon();
	}

	@Override
	public InterfaceController createInterfaceController() {
		return new SymbianInterCon();
	}

	
}
