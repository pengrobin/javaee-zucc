package cn.edu.zucc.pb.bankdispacher.simulator;

import cn.edu.zucc.pb.bankdispacher.UserEvent;
import cn.edu.zucc.pb.bankdispacher.UserEventQue;
import org.apache.commons.lang3.RandomUtils;

/**
 * 银行柜台办理业务仿真程序
 * @author pengbin
 * @version 1.0
 * @date 2020-02-24 16:49
 */
public class BankCounter {
    /**
     * 模拟柜台开始办理业务
     */
    public void start(){
        //TODO 增加柜台下班的控制
        //while(true)柜台一直不下班
        while(true){
            UserEvent userEvent = UserEventQue.getInstance().dispatchUser();

            //等待一点时间,模拟在办理或者等待
            //TODO 实现不同业务类型等待不同时间
            waitSomeTime();
        }
    }

    private void waitSomeTime(){
        //随机2秒到12秒之间
        try {
            Thread.sleep(RandomUtils.nextInt(2000, 12000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return;
    }

}
