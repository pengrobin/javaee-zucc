package cn.edu.zucc.pb.ormapping.service;

import cn.edu.zucc.pb.ormapping.dao.UserDaoV2;
import cn.edu.zucc.pb.ormapping.entity.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceDBV2 implements ILogin{

    @Override
    public boolean login(String userid, String password) {
        UserDaoV2 dao = new UserDaoV2();

        UserEntity user = dao.getUser(userid);
        if(user != null && user.getPassword() != null && user.getPassword().equals(password)){
            return true;
        }

        return false;
    }
}
