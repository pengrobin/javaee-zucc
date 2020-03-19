package cn.edu.zucc.pb.ormapping.service;

import cn.edu.zucc.pb.ormapping.db.DataBaseManager;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author pengbin
 * @version 1.0
 * @date 2020-03-18 23:40
 */
@Service
public class UserServiceDBV1 implements ILogin{
    @Override
    public boolean login(String userid, String password) {
        Connection conn=null;
        try {
            conn = DataBaseManager.getConnection();
            String sql="select password" +
                    " from user" +
                    " where userid = '" + userid + "'";
            System.out.println("LoginServiceV1 SQL:" + sql);
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            java.sql.ResultSet rs=pst.executeQuery();
            if(rs.next()){
                String pwd = rs.getString(1);
                if(pwd.equals(password)){
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            if(conn!=null)
                try {
                    conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }
        return false;
    }
}
