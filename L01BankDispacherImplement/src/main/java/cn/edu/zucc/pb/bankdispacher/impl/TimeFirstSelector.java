package cn.edu.zucc.pb.bankdispacher.impl;

import java.util.List;

/**
 * 时间优先选择器，按照到达时间顺序处理
 * @author pengbin
 * @version 1.0
 * @date 2020-02-24 16:21
 */
public class TimeFirstSelector implements IUserSelector {
    public UserEvent select(List<UserEvent> events) {
        //实现到达时间优先算法的用户选择器
        if(events.size() >= 1){
            return events.get(0);
        }
        return null;
    }
}
