package cn.edu.zucc.pb.cgproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {
    private Object svcImpl;

    public CglibProxy() {
    }

    public Object getInstance(final Object target) {
        this.svcImpl = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.svcImpl.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    public Object intercept(Object object, Method method, Object[] args,
                            MethodProxy methodProxy) throws Throwable {
        System.out.println("log:cglib proxy invoke:" + method.getName());
        Object result = null;
        try {
            result = methodProxy.invokeSuper(object, args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return result;
    }
}