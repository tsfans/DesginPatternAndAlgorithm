package cn.hl.gof.structure7.proxy.dynamicproxy;

public class ProxyTest {

	public static void main(String[] args) {
		ProxyInterface ro = new RealObject();
		ProxyInterface pi = JDKInvocationHandler.getProxy(ProxyInterface.class, ro);
		RealObject ro1 = CglibInvocationHandler.instance().getProxy(RealObject.class);
		ProxyInterface pi2 = new StaticProxy(ro);
		ro.say();
		pi.say();
		ro1.say();
		ro1.talk();
		pi2.say();
	}
}
