package cn.hl.gof.structure7.decorator;

public class ShiftEncoder implements Encoder{

	@Override
	public String encode(String str) {
		return "shift encode["+str+"]";
	}

}
