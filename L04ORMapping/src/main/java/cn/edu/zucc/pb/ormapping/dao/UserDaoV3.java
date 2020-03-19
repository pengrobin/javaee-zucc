package cn.edu.zucc.pb.ormapping.dao;

import cn.edu.zucc.pb.ormapping.db.DataBaseManager;
import cn.edu.zucc.pb.ormapping.entity.UserEntity;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDaoV3 implements IUserDao{
    public UserEntity getUser(String userid){
        Connection conn=null;
        UserEntity user = new UserEntity();
        try {
            conn = DataBaseManager.getConnection();
            String sql="select userid, name, password" +
                    " from user" +
                    " where userid = '" + userid + "'";
            System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " SQL:" + sql);
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            java.sql.ResultSet rs=pst.executeQuery();
            if(rs.next()){
                String name = rs.getString(2);
                String pwd = rs.getString(3);
                user.setName(name);
                user.setUserid(userid);
                user.setPassword(pwd);
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
        return user;
    }
}
