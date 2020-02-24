package cn.edu.zucc.pb.bankdispacher.simulator;

import cn.edu.zucc.pb.bankdispacher.EUserCategory;
import cn.edu.zucc.pb.bankdispacher.UserEventQue;
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
        boolean bExit = true;
        int index = 0;
        while(!bExit){
            //等待一点时间
            waitSomeTime();

            //产生一个用户
            //TODO 修改仿真用户到达的比例，按照Vip:Enterprise:Private=1:2:7方式产生
            switch (RandomUtils.nextInt(1, 4)){
                case 1:
                    UserEventQue.getInstance().nextUserArrive(EUserCategory.VIP);
                    break;
                case 2:
                    UserEventQue.getInstance().nextUserArrive(EUserCategory.PRIVATE);
                    break;
                default:
                    UserEventQue.getInstance().nextUserArrive(EUserCategory.ENTERPRISE);
                    break;
            }
            index++;

            if(nCount > 0 && index > nCount){
                bExit = true;
            }
        }
    }

    private void waitSomeTime(){
        //随机500毫秒到5000毫秒之间
        try {
            Thread.sleep(RandomUtils.nextInt(500, 5000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return;
    }

}
