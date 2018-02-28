package cn.hl.gof.proxy.dynamicproxy;

public class DynamicProxyTest {

	public static void main(String[] args) {
		ProxyInterface ro = new RealObject();
		ProxyInterface pi = (ProxyInterface)JDKInvocationHandler.getProxy(ProxyInterface.class, ro);
		RealObject ro1 = (RealObject)CglibInvocationHandler.instance().getProxy(RealObject.class);
		ro.say();
		pi.say();
		ro1.say();
		ro1.talk();
	}
}
