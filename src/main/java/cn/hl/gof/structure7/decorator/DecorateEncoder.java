package cn.hl.gof.structure7.decorator;

public abstract class DecorateEncoder implements Encoder{

	private Encoder encoder;
	
	public DecorateEncoder(Encoder encoder) {
		this.encoder = encoder;
	}
	
	@Override
	public String encode(String str) {
		return encoder.encode(str);
	}
}
