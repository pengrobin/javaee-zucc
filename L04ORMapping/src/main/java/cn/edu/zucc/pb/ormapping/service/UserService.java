package cn.edu.zucc.pb.ormapping.service;

import cn.edu.zucc.pb.ormapping.view.User;
import org.springframework.stereotype.Service;

/**
 * @author pengbin
 * @version 1.0
 * @date 2020-03-11 17:53
 */
@Service
public class UserService {
    public User findById(String id) {
        //这里是简单示例，所以直接创建一个这样的user返回,不执行具体的查询
        User ret = new User();
        ret.setName("张三");
        ret.setUserid(id);
        ret.setPassword("123456");

        return ret;
    }
}
