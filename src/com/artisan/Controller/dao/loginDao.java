// 业勤：已完成

package com.artisan.Controller.dao;

import com.artisan.model.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class loginDao {
    public  user login(Connection con, user user)throws Exception{
        user loginResult = null;
        String sql="select * from user where uid=? and upass=?";
        PreparedStatement pstmt =con.prepareStatement(sql);
        pstmt.setInt(1,user.getUid());
        pstmt.setString(2,user.getUpass());
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()){
            loginResult = new user();
            loginResult.setUid(rs.getInt("uid"));
            loginResult.setUpass(rs.getString("upass"));
            loginResult.setUtype(rs.getInt("utype"));
        }
        return loginResult;
    }
}
