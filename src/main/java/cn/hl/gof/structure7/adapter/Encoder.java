package cn.hl.gof.structure7.adapter;

/**
 * 目标接口
 * @author HULIN
 */
public interface Encoder {

	void encodePassword(String password);
	
	void encodeEmail(String email);
}
