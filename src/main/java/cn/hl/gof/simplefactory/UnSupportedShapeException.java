package cn.hl.gof.simplefactory;

public class UnSupportedShapeException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public UnSupportedShapeException(String msg) {
		super(msg);
	}

}
