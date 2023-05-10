package cn.hl.gof.structure7.decorator;

public class ReverseEncoder extends DecorateEncoder{

	public ReverseEncoder(Encoder encoder) {
		super(encoder);
	}
	@Override
	public String encode(String str) {
		return reverseEncode(super.encode(str));
	}
	
	private String reverseEncode(String str) {
		return "reverse encode["+str+"]";
	}

}
