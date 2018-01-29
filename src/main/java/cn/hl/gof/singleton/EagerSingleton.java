package cn.hl.gof.singleton;
/**
 * 
 * <p>单例模式饿汉实现,线程不安全</p>
 * @author HULIN
 * @date 2018年1月29日下午5:19:26
 * @version 1.0.0
 */
public class EagerSingleton {

	private static final EagerSingleton instance = new EagerSingleton();
	private EagerSingleton() {}
	public static EagerSingleton getInstance() {
		return instance;
	}
}
