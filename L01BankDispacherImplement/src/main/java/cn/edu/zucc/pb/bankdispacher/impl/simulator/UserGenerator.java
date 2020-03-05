package cn.edu.zucc.pb.bankdispacher.impl.simulator;

import cn.edu.zucc.pb.bankdispacher.impl.BankDsipatcherUtils;
import cn.edu.zucc.pb.bankdispacher.impl.EUserCategory;
import cn.edu.zucc.pb.bankdispacher.impl.UserEventQue;
import org.apache.commons.lang3.RandomUtils;

/**
 * 测试用仿真程序，模拟用户的到达
 * @author pengbin
 * @version 1.0
 * @date 2020-02-24 16:36
 */
public class UserGenerator {
    /**
     * 模拟产生n个用户
     * @param nCount 产生的用户数，参数小于零一直产生
     */
    public void start(int nCount){
        BankDsipatcherUtils.log("UserGenerator started.");

        boolean bExit = false;
        int index = 0;
        while(!bExit){
            //等待一点时间
            waitSomeTime();

            //产生一个用户,按照Vip:Enterprise:Private=1:2:7方式产生
            int rand = RandomUtils.nextInt(1, 11);
            if(rand == 1){
                UserEventQue.getInstance().nextUserArrive(EUserCategory.VIP);
            } else if(rand == 2 || rand == 3){
                UserEventQue.getInstance().nextUserArrive(EUserCategory.ENTERPRISE);
            } else {
                UserEventQue.getInstance().nextUserArrive(EUserCategory.PRIVATE);
            }
            index++;

            if(nCount > 0 && index > nCount){
                bExit = true;
            }
        }
        UserEventQue.getInstance().close();
        BankDsipatcherUtils.log("UserGenerator done.");
    }

    private void waitSomeTime(){
        try {
            Thread.sleep(RandomUtils.nextInt(100, 200));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return;
    }

}
