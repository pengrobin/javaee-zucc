package cn.edu.zucc.pb.ormapping.db;

import java.sql.Connection;

public class DataBaseManager {
    private static final String jdbcUrl="jdbc:mysql://localhost:3306/javaee?useUnicode=true&characterEncoding=utf-8";
    private static final String dbUser="root";
    private static final String dbPwd="123456";
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws java.sql.SQLException{
        return java.sql.DriverManager.getConnection(jdbcUrl, dbUser, dbPwd);
    }
}
