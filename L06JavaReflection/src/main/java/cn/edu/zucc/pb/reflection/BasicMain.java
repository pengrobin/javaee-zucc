package cn.edu.zucc.pb.reflection;

import java.lang.reflect.*;

/**
 * you could add -verbose:class to jvm start parameter to view the classloader
 * @author pengbin
 * @version 1.0
 * @date 2020-03-30 10:06
 */
public class BasicMain {
    public static void main(String args[]) {
        try {
            Class c = Class.forName("java.lang.String");
            Method m[] = c.getDeclaredMethods();
            for (int i = 0; i < m.length; i++)
                System.out.println(m[i].toString());
        } catch (Throwable e) {
            System.err.println(e);
        }
    }
}
