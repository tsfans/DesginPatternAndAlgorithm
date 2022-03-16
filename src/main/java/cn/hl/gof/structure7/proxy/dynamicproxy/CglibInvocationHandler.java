package cn.hl.gof.structure7.proxy.dynamicproxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * Cglib动态代理实现
 * @author HULIN
 * @date 2018年3月1日下午4:55:36
 */
public class CglibInvocationHandler implements MethodInterceptor{
	
	private static CglibInvocationHandler handler = new CglibInvocationHandler();

	private CglibInvocationHandler() {}
	
	public static CglibInvocationHandler instance() {
		return handler;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getProxy(Class<T> clazz) {
		return (T)Enhancer.create(clazz, this);
	}
	
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		before();
		Object result = proxy.invokeSuper(obj, args);
		after();
		return result;
	}

	private void before() {
		System.out.println("CglibInvocationHandler before method invoke");
	}
	private void after() {
		System.out.println("CglibInvocationHandler after method invoke");
	}
}
