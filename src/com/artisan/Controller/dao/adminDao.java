/*
* 录入老师信息:addt()
* 修改老师信息：updatet()
* 删除老师信息：deletet()
* 查询老师信息：listt()

* 录入学生信息:adds()
* 修改学生信息：updates()
* 删除学生信息：deletes()
* 查询学生信息：lists()
* */
package com.artisan.Controller.dao;

import com.artisan.model.course;
import com.artisan.model.user;
import com.artisan.util.StringUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class adminDao {

    // 录入老师信息
    public int addt(Connection con, user user) throws Exception{
        String sql="insert into user values(?,?,?,null,1)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1,user.getUid());
        pstmt.setString(2,user.getUname());
        pstmt.setString(3, user.getUpass());
        return pstmt.executeUpdate();
    }

    // 查询所有老师信息
    public ResultSet listt(Connection con,user user) throws Exception{
        StringBuffer sb = new StringBuffer("select * from user where utype=1");
        if (StringUtil.isNotEmpty(user.getUname())){
            sb.append(" and uname like '%" + user.getUname() + "%'");
        }
        if(StringUtil.IisNotEmpty(user.getUid())){
            sb.append(" and uid like '%" + user.getUid() + "%'");
        }
        PreparedStatement pstmt = con.prepareStatement(sb.toString());
        return pstmt.executeQuery();
        }

    // 删除老师信息
    public int deletet(Connection con,int uid)throws Exception{
        String sql="delete from user where (uid=? and utype=1)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1,uid);
        return pstmt.executeUpdate();
    }

    // 修改老师信息
    public int updatet(Connection con,user user)throws Exception{
        String sql = "update user set uname=?,upass=? where (uid=? and utype=1)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1,user.getUname());
        pstmt.setString(2,user.getUpass());
        pstmt.setInt(3,user.getUid());
        return pstmt.executeUpdate();
    }

    // 录入学生信息
    public int adds(Connection con,user user)throws Exception{
        String sql="insert into user values(?,?,?,?,2)";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setInt(1,user.getUid());
        pstmt.setString(2,user.getUname());
        pstmt.setString(3,user.getUpass());
        pstmt.setString(4,user.getUclass());
        return pstmt.executeUpdate();
    }

    //查询学生信息
    public ResultSet lists(Connection con,user user) throws Exception{
        StringBuffer sb = new StringBuffer("select * from user where utype=2");
        if (StringUtil.isNotEmpty(user.getUname())){
            sb.append(" and uname like '%" + user.getUname() + "%'");
        }
        if(StringUtil.IisNotEmpty(user.getUid())){
            sb.append(" and uid like '%" + user.getUid() + "%'");
        }
        if(StringUtil.isNotEmpty(user.getUclass())){
            sb.append(" and uclass like '%" + user.getUclass() + "%'");
        }
        PreparedStatement pstmt = con.prepareStatement(sb.toString());
        return pstmt.executeQuery();
    }

    public ResultSet lists2(Connection con,user user) throws Exception{
        StringBuffer sb = new StringBuffer("select * from user where utype=2 group by uclass");
        PreparedStatement pstmt = con.prepareStatement(sb.toString());
        return pstmt.executeQuery();
    }

    //修改学生信息
    public int updates(Connection con,user user)throws Exception{
        String sql = "update user set uname=?,upass=? where (uid=? and utype=2)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1,user.getUname());
        pstmt.setString(2,user.getUpass());
        pstmt.setInt(3,user.getUid());
        return pstmt.executeUpdate();
    }

    //删除学生信息
    public int deletes(Connection con,int uid)throws Exception{
        String sql="delete from user where (uid=? and utype=2)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1,uid);
        return pstmt.executeUpdate();
    }

    //录入课程信息
    public int addc(Connection con, course course)throws Exception{
        String sql="insert into course values(?)";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,course.getCname());
        return  pstmt.executeUpdate();
    }

    //查询课程信息
    public ResultSet listc(Connection con,course course)throws Exception{
        StringBuffer sb=new StringBuffer("select cname from course");
        if (StringUtil.isNotEmpty(course.getCname())){
            sb.append(" where cname like '%" + course.getCname() + "%'");
        }
        PreparedStatement pstmt = con.prepareStatement(sb.toString());
        return pstmt.executeQuery();
    }

    // 修改课程信息
    public int updatec(Connection con, course course) throws Exception{
        String sql = "update course set cname=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1,course.getCname());
        return pstmt.executeUpdate();
    }

    // 删除课程信息
    public int deletec(Connection con, String cname)throws Exception{
        String sql = "delete from course where cname=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1,cname);
        return pstmt.executeUpdate();
    }

}
