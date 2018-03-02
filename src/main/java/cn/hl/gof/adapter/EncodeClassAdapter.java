package cn.hl.gof.adapter;

/**
 * 类适配器
 * @author HULIN
 */
public class EncodeClassAdapter extends EncodeModule implements Encoder{

	@Override
	public void encodePassword(String password) {
		encode(password);
	}
	@Override
	public void encodeEmail(String email) {
		encode(email);
	}
}
