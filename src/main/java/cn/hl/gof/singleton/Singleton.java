package cn.hl.gof.singleton;
/**
 * 
 * <p>单例模式最佳实现,Initialization Demand Holder (IoDH)</p>
 * @author HULIN
 * @date 2018年1月29日下午5:34:08
 * @version 1.0.0
 */
public class Singleton {

	private Singleton() {}
	
	private static class HolderClass {
		private static final Singleton instance = new Singleton();
	}
	
	public static Singleton getInstance() {
		return HolderClass.instance;
	}
	
}
