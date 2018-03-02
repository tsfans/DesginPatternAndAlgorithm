package cn.hl.gof.singleton;

/**
 * 
 * <p>枚举实现单例模式,线程安全，可防止反射和反序列化</p>
 * @author HULIN
 * @date 2018年3月1日下午4:38:09
 */
public class EnumSingleton {

	private EnumSingleton() {}
	
	public static EnumSingleton getInstance() {
		return SingleTonEnum.INSTANCE.getInstance();
	}
	
	private static enum SingleTonEnum{
		
		INSTANCE;
		
		private EnumSingleton singleTon;
		
		private SingleTonEnum() {
			singleTon = new EnumSingleton();
		}
		
		public EnumSingleton getInstance() {
			return singleTon;
		}
	}
}
