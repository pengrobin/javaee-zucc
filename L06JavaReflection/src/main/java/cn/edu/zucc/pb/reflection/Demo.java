package cn.edu.zucc.pb.reflection;

/**
 * @author pengbin
 * @ref code from https://www.geeksforgeeks.org/reflection-in-java/
 * @version 1.0
 * @date 2020-03-30 09:55
 */
public class Demo {
    // creating a private field
    private String s;

    // creating a public constructor
    public Demo() { s = "Demo from reflection"; }

    // Creating a public method with no arguments
    public void method1() {
        System.out.println("The string is " + s);
    }

    // Creating a public method with int as argument
    public void method2(int n) {
        System.out.println("The number is " + n);
    }

    // creating a private method
    private void method3() {
        System.out.println("Private method invoked");
    }
}
