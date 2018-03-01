package cn.hl.gof.singleton;

public class SingletonTest {

	
	public static void main(String[] args) {
		EagerSingleton instance1 = EagerSingleton.getInstance();
		EagerSingleton instance2 = EagerSingleton.getInstance();
		LazySingleton instance3 = LazySingleton.getInstance();
		LazySingleton instance4 = LazySingleton.getInstance();
		Singleton instance5 = Singleton.getInstance();
		Singleton instance6 = Singleton.getInstance();
		EnumSingleTon instance7 = EnumSingleTon.getInstance();
		EnumSingleTon instance8 = EnumSingleTon.getInstance();
		System.out.println("EagerSingleton:"+(instance1==instance2));
		System.out.println("LazySingleton:"+(instance3==instance4));
		System.out.println("Singleton:"+(instance5==instance6));
		System.out.println("EnumSingleTon:"+(instance7==instance8));
	}
}
