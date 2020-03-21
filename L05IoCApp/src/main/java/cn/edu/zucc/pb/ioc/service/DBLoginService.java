package cn.edu.zucc.pb.ioc.service;

import cn.edu.zucc.pb.ioc.db.DataBaseManager;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author pengbin
 * @version 1.0
 * @date 2020-03-21 17:14
 */
public class DBLoginService implements ILogin{
        public boolean login(String userid, String password) {
            Connection conn=null;
            try {
                conn = DataBaseManager.getConnection();
                String sql="select password" +
                        " from user" +
                        " where userid = '" + userid + "'";
                System.out.println("DBLoginService SQL:" + sql);
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
                        e.printStackTrace();
                    }
            }
            return false;
        }
}
