package cn.hl.gof.singleton;

import java.io.Serializable;

/**
 * 
 * <p>单例模式私有静态类实现,Initialization Demand Holder (IoDH)</p>
 * <p>可通过反射生成新的实例</p>
 * @author HULIN
 * @date 2018年1月29日下午5:34:08
 * @version 1.0.0
 */
public class Singleton implements Serializable{

	private static final long serialVersionUID = 1L;

	private Singleton() {}
	
	private static class HolderClass {
		private static final Singleton instance = new Singleton();
	}
	
	public static Singleton getInstance() {
		return HolderClass.instance;
	}
	
	private Object readResolve() {
		return HolderClass.instance;
	}
	
}
