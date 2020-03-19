package cn.edu.zucc.pb.ormapping.service;

import cn.edu.zucc.pb.ormapping.dao.DaoFactory;
import cn.edu.zucc.pb.ormapping.dao.IUserDao;
import cn.edu.zucc.pb.ormapping.dao.UserDaoV2;
import cn.edu.zucc.pb.ormapping.entity.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceDBV3 implements ILogin{

    @Override
    public boolean login(String userid, String password) {
        IUserDao dao = DaoFactory.getUserDao();

        UserEntity user = dao.getUser(userid);
        if(user != null && user.getPassword() != null && user.getPassword().equals(password)){
            return true;
        }

        return false;
    }
}
