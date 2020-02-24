package cn.edu.zucc.pb.bankdispacher;

import java.util.List;

/**
 * @author pengbin
 * @version 1.0
 * @date 2020-02-24 16:18
 */
public interface IUserSelector {
    UserEvent select(List<UserEvent> events);
}
