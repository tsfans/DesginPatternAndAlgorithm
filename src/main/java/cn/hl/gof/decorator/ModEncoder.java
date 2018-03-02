package cn.hl.gof.decorator;

public class ModEncoder extends DecorateEncoder{

	public ModEncoder(Encoder encoder) {
		super(encoder);
	}
	
	@Override
	public String encode(String str) {
		return modEncode(super.encode(str));
	}
	
	private String modEncode(String str) {
		return "mod encode["+str+"]";
	}

}
