package cn.hl.gof.singleton;
/**
 * 
 * <p>单例模式double-check懒汉实现,线程安全，略微影响性能</p>
 * @author HULIN
 * @date 2018年1月29日下午5:25:39
 * @version 1.0.0
 */
public class LazySingleton {

	private volatile static LazySingleton instance = null;
	
	private LazySingleton() {}
	
	public static LazySingleton getInstance() {
		if(instance == null) {
			synchronized(LazySingleton.class) {
				if(instance == null) {
					instance = new LazySingleton();
				}
			}
		}
		return instance;
	} 
}
