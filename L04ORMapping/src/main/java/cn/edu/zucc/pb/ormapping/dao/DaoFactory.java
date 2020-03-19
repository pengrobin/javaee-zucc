package cn.edu.zucc.pb.ormapping.dao;

/**
 * @author pengbin
 * @version 1.0
 * @date 2020-03-19 09:58
 */
public class DaoFactory {
    public static IUserDao getUserDao(){
        return new UserDaoV3();
    }

    public static IDepartmentDao getDepartmentDao(){
        return new DepartmentDaoV3();
    }
}
