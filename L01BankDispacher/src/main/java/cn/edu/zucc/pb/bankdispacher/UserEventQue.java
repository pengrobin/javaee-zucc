package cn.edu.zucc.pb.bankdispacher;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 用户排队队列
 * @author pengbin
 * @version 1.0
 * @date 2020-02-24 16:07
 */
public class UserEventQue {
    private static int SEQ = 0;

    //队列
    private List<UserEvent> events = new ArrayList<UserEvent>();

    //单例模式使用UserEventQue
    private static UserEventQue instance = new UserEventQue();
    private UserEventQue(){}
    public static UserEventQue getInstance(){
        return instance;
    }

    /**
     * 分配一个用户事件，对应比如用户在叫号机上按一下
     * @param category 来的用户类别
     * @return
     */
    public UserEvent nextUserArrive(EUserCategory category){
        UserEvent event = new UserEvent();
        event.setArriveTime(new Date());
        event.setCategory(category);
        //保证线程安全；TODO: 思考，这里为什么需要保证线程安全
        synchronized (UserEventQue.class){
            event.setSeq(SEQ++);
            events.add(event);
        }

        return event;
    }

    /**
     * 分派一个用户到窗口处理
     * @return
     */
    public UserEvent dispatchUser(){
        //使用工厂类动态加载算法实现类
        IUserSelector selector = UserSelectorFactory.getSelector();
        if(selector != null){
            //保证线程安全；TODO: 思考，这里为什么需要保证线程安全
            synchronized (UserEventQue.class){
                UserEvent event = selector.select(events);
                //TODO 移除队列中选中的event
                return event;
            }
        }

        return null;
    }
}
