package cn.hl.gof.singleton;

/**
 * 
 * <p>枚举实现单例模式,线程安全，可防止反射和反序列化</p>
 * @author HULIN
 * @date 2018年3月1日下午4:38:09
 */
public class EnumSingleTon {

	private EnumSingleTon() {}
	
	public static EnumSingleTon getInstance() {
		return SingleTonEnum.INSTANCE.getInstance();
	}
	
	private static enum SingleTonEnum{
		
		INSTANCE;
		
		private EnumSingleTon singleTon;
		
		private SingleTonEnum() {
			singleTon = new EnumSingleTon();
		}
		
		public EnumSingleTon getInstance() {
			return singleTon;
		}
	}
}
