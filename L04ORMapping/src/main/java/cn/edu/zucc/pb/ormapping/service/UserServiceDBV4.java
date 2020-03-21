package cn.edu.zucc.pb.ormapping.service;

import cn.edu.zucc.pb.ormapping.dao.DaoFactory;
import cn.edu.zucc.pb.ormapping.dao.DaoV4;
import cn.edu.zucc.pb.ormapping.dao.IDaoV4;
import cn.edu.zucc.pb.ormapping.dao.IUserDao;
import cn.edu.zucc.pb.ormapping.entity.DepartmentEntity;
import cn.edu.zucc.pb.ormapping.entity.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceDBV4 implements ILogin{

    @Override
    public boolean login(String userid, String password) {
        IDaoV4<UserEntity> dao = new DaoV4<UserEntity>();
        IDaoV4<DepartmentEntity> daoDepart = new DaoV4<DepartmentEntity>();

        UserEntity user = dao.getEntity(userid, UserEntity.class.getName());
        if(user != null && user.getPassword().equals(password)){
            return true;
        }

        return false;
    }
}
