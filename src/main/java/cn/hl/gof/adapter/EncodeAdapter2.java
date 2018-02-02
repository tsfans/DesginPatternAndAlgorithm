package cn.hl.gof.adapter;

public class EncodeAdapter2 extends EncodeModule implements Encoder{

	@Override
	public void encodePassword(String password) {
		encode(password);
	}
	@Override
	public void encodeEmail(String email) {
		encode(email);
	}
}
