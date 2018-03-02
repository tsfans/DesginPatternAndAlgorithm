package cn.hl.gof.adapter;

/**
 * 对象适配器
 * @author HULIN
 */
public class EncodeObjectAdapter implements Encoder{

	private EncodeModule encode;
	
	public EncodeObjectAdapter() {
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
