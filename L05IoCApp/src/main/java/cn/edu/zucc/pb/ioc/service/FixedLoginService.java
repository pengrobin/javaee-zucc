package cn.edu.zucc.pb.ioc.service;

/**
 * @author pengbin
 * @version 1.0
 * @date 2020-03-21 15:38
 */
public class FixedLoginService implements ILogin {
    public boolean login(String userid, String password) {
        if("admin".equalsIgnoreCase(userid)
                && "111111".equalsIgnoreCase(password)){
            return true;
        }

        return false;
    }
}
