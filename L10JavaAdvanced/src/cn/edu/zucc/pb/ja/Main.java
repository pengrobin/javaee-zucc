package cn.edu.zucc.pb.ja;

import java.lang.reflect.Method;

/**
 * @author pengbin
 * @version 1.0
 * @date 2020-04-22 20:23
 */
public class Main {
    public static void main(String[] args) {
        //演示Stream
        StreamDemo streamDemo = new StreamDemo();
        logCodeMemo(StreamDemo.class, "demo");
        streamDemo.demo();

        //演示Lambda
        logCodeMemo(LambdaDemo.class, "demo");
        LambdaDemo lambdaDemo = new LambdaDemo();
        lambdaDemo.demo();

        //演示小练习
        logCodeMemo(LastDemo.class, "demo");
        LastDemo lastDemo = new LastDemo();
        lastDemo.demo();
    }

    private static void logCodeMemo(Class clazz, String methodName){
        Method method = null;
        try {
            method = clazz.getMethod(methodName);
            CodeMemo codeMemo = method.getAnnotation(CodeMemo.class);
            if(codeMemo!=null){
                System.out.println("调用方法："
                        + clazz.getName() + "." + method.getName()
                        + "[作者:" + codeMemo.name()
                        + "日期:" + codeMemo.date()
                        + "方法说明:" + codeMemo.intro()
                        + "]-->");
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}
