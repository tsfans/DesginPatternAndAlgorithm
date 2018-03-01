package cn.hl.gof.proxy.dynamicproxy;

public class ProxyTest {

	public static void main(String[] args) {
		RealObject ro = new RealObject();
		ProxyInterface pi = (ProxyInterface)JDKInvocationHandler.getProxy(ProxyInterface.class, ro);
		RealObject ro1 = (RealObject)CglibInvocationHandler.instance().getProxy(RealObject.class);
		ProxyInterface pi2 = new StaticProxy(ro);
		ro.say();
		pi.say();
		ro1.say();
		ro1.talk();
		pi2.say();
	}
}
