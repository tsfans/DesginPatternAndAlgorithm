package cn.hl.gof.proxy.dynamicproxy;

public class RealObject implements ProxyInterface {
	
	@Override
	public void say() {
		System.out.println("I am realObject,i am saying!");
	}
	
	public void talk() {
		System.out.println("I am realObject,i am talking!");
	}
}
