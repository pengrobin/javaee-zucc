package cn.edu.zucc.pb.bankdispacher.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author pengbin
 * @version 1.0
 * @date 2020-02-28 14:16
 */
public class BankDsipatcherUtils {
    public static String readProperty(String name){
        File file = new File(BankDsipatcherUtils.class.getResource("/bank.properties").getPath());
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(file));
            //实现从配置文件 bank.properties加载selector配置项
            String value = String.valueOf(properties.get(name));

            return value;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void log(String msg){
        System.out.println(Thread.currentThread().getName() + ":" + msg);
    }
}
