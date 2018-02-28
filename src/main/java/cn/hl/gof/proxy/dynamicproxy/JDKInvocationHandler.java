package cn.hl.gof.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class JDKInvocationHandler implements InvocationHandler{

	private Object target;
	
	public JDKInvocationHandler(Object target) {
		this.target = target;
	}
	@SuppressWarnings("unchecked")
	public static <T> T getProxy(Class<T> clazz,Object o) {
		return (T)Proxy.newProxyInstance(clazz.getClassLoader(), new Class[] {clazz}, new JDKInvocationHandler(o));
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		before();
		Object result = method.invoke(target, args);
		after();
		return result;
	}

	private void before() {
		System.out.println("JDKInvocationHandler before method invoke");
	}
	private void after() {
		System.out.println("JDKInvocationHandler after method invoke");
	}
}
