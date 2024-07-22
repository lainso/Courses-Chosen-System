// 业勤：已完成

package com.artisan.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.AbstractList;

public class DbUtil {

    private String dbUrl="jdbc:mysql://localhost:3306/student?serverTimezone=Asia/Shanghai&useSSL=false";
    private String dbUserName="root";
    private String dbPassword="Lyq123456!!";
    private String jdbcName="com.mysql.cj.jdbc.Driver";

    // 连接数据库
    public Connection getCon() throws Exception{
        Class.forName(jdbcName);
        Connection con = DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
        return con;
    }

    // 关闭数据库
    public void closeCon(Connection con) throws Exception{
        if(con!=null){
            con.close();
        }
    }

    // 测试数据库连接
    public static void main(String[] args) {
        DbUtil db = new DbUtil();
        try {
            db.getCon();
            System.out.println("succeed!");
        } catch (Exception e){
            System.out.println("failed!");
            System.out.println("Error Info:");
            e.printStackTrace();
        }

    }
}
