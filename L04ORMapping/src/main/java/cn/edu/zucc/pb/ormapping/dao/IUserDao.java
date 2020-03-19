package cn.edu.zucc.pb.ormapping.dao;

import cn.edu.zucc.pb.ormapping.entity.UserEntity;

/**
 * @author pengbin
 * @version 1.0
 * @date 2020-03-19 09:50
 */
public interface IUserDao {
    UserEntity getUser(String userid);
}
