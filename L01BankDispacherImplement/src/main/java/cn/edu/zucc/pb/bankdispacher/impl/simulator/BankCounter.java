package cn.edu.zucc.pb.bankdispacher.impl.simulator;

import cn.edu.zucc.pb.bankdispacher.impl.BankDsipatcherUtils;
import cn.edu.zucc.pb.bankdispacher.impl.EUserCategory;
import cn.edu.zucc.pb.bankdispacher.impl.UserEvent;
import cn.edu.zucc.pb.bankdispacher.impl.UserEventQue;
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
        BankDsipatcherUtils.log("couter open.");

        //柜台下班的控制
        while(!UserEventQue.getInstance().isClosed()){
            UserEvent userEvent = UserEventQue.getInstance().dispatchUser();

            if(userEvent != null){
                BankDsipatcherUtils.log("couter deal with event:" + userEvent.getSeq() + userEvent.getCategory());
                //等待一点时间,模拟在办理或者等待
                waitSomeTime(userEvent.getCategory());
            } else {
                //BankDsipatcherUtils.log("nothing to deal with...");
                waitSomeTime(null);
            }
        }

        BankDsipatcherUtils.log("couter closed.");
    }

    private void waitSomeTime(EUserCategory category){
        int nBase = 100;
        if(category != null){
            switch (category){
                case VIP:
                    nBase = 200;
                    break;
                case PRIVATE:
                    nBase = 100;
                    break;
                case ENTERPRISE:
                    nBase = 400;
                    break;
            }
        }
        try {
            Thread.sleep(RandomUtils.nextInt(nBase, 3*nBase));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return;
    }

}
