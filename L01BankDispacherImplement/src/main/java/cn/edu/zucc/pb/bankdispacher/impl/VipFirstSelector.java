package cn.edu.zucc.pb.bankdispacher.impl;

import java.util.List;

/**
 * Vip优先选择器，队列中如果有vip，优先处理，其他按照到达时间顺序处理
 * @author pengbin
 * @version 1.0
 * @date 2020-02-24 16:21
 */
public class VipFirstSelector implements IUserSelector {
    public UserEvent select(List<UserEvent> events) {
        //实现vip优先算法的用户选择器
        for (UserEvent e: events) {
            if(e.getCategory() == EUserCategory.VIP){
                return e;
            }
        }
        //没有vip用户时时间优先
        if(events.size() >= 1){
            return events.get(0);
        }

        return null;
    }
}
