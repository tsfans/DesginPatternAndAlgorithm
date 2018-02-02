package cn.hl.gof.adapter;

public class EncodeAdapter implements Encoder{

	private EncodeModule encode;
	
	public EncodeAdapter() {
		this.encode = new EncodeModule();
	}
	
	@Override
	public void encodePassword(String password) {
		encode.encode(password);
	}
	@Override
	public void encodeEmail(String email) {
		encode.encode(email);
	}
}
