package cn.edu.zucc.pb.bankdispacher.impl;

import cn.edu.zucc.pb.bankdispacher.impl.simulator.BankCounter;
import cn.edu.zucc.pb.bankdispacher.impl.simulator.UserGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * 主控程序，让仿真程序和实际的调度程序运行起来
 * @author pengbin
 * @version 1.0
 * @date 2020-02-24 16:54
 */
public class Main {
    public static void main(String[] args) {
        //实现从配置文件 bank.properties加载counter.count配置项
        int counterCount = Integer.parseInt(BankDsipatcherUtils.readProperty("counter.count"));
        List<Thread> threads = new ArrayList<Thread>();

        //创建n个柜台，仿真银行开门
        for(int i = 0; i < counterCount; i++){
            Thread counterThread = new Thread("Counter-" + i){
                @Override
                public void run() {
                    BankCounter counter = new BankCounter();
                    counter.start();
                }
            };
            counterThread.start();
            threads.add(counterThread);
        }

        //开始启动用户产生仿真
        Thread userGenerator = new Thread("UserGenerator"){
            @Override
            public void run() {
                UserGenerator generator = new UserGenerator();
                //200个用户到达
                generator.start(200);
            }
        };
        userGenerator.start();
        threads.add(userGenerator);

        /**简单的等待子线程退出*/
        for(Thread t :threads){
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        BankDsipatcherUtils.log("Bank closed well.");
    }
}
