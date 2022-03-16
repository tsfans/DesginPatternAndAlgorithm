package cn.hl.gof.creation5.singleton;

public class SingletonTest {

	
	public static void main(String[] args) {
		EagerSingleton instance1 = EagerSingleton.getInstance();
		EagerSingleton instance2 = EagerSingleton.getInstance();
		LazySingleton instance3 = LazySingleton.getInstance();
		LazySingleton instance4 = LazySingleton.getInstance();
		StaticClassSingleton instance5 = StaticClassSingleton.getInstance();
		StaticClassSingleton instance6 = StaticClassSingleton.getInstance();
		EnumSingleton instance7 = EnumSingleton.getInstance();
		EnumSingleton instance8 = EnumSingleton.getInstance();
		System.out.println("EagerSingleton:"+(instance1==instance2));
		System.out.println("LazySingleton:"+(instance3==instance4));
		System.out.println("StaticClassSingleton:"+(instance5==instance6));
		System.out.println("EnumSingleTon:"+(instance7==instance8));
	}
}
