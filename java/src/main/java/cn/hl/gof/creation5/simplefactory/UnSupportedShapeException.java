package cn.hl.gof.creation5.simplefactory;

public class UnSupportedShapeException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public UnSupportedShapeException(String msg) {
		super(msg);
	}

}
