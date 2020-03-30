package cn.edu.zucc.pb.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DynamicServiceProxy implements InvocationHandler {
    private Object svcImpl;

    public DynamicServiceProxy(Object obj) {
        this.svcImpl = obj;
    }

    public Object invoke(Object proxy, Method method, Object[] args) {
        System.out.println("log:dynamic proxy invoke:" + method.getName());
        Object result = null;
        try {
            result = method.invoke(svcImpl, args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return result;
    }
}