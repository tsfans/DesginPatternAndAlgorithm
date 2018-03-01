package cn.hl.gof.proxy.dynamicproxy;

/**
 * 静态代理实现
 * @author HULIN
 * @date 2018年3月1日下午4:52:55
 */
public class StaticProxy implements ProxyInterface{

	private RealObject ro;
	
	public StaticProxy(RealObject ro) {
		this.ro = ro;
	}
	
	@Override
	public void say() {
		before();
		ro.say();
		after();
	}
	
	private void before() {
		System.out.println("StaticProxy before method invoke");
	}
	private void after() {
		System.out.println("StaticProxy after method invoke");
	}

}
