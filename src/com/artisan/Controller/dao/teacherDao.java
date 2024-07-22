// 业勤：已完成

package com.artisan.Controller.dao;

import com.artisan.model.records;
import com.artisan.model.user;
import com.artisan.util.StringUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class teacherDao {
    // 增加考勤记录
    public int add(Connection con,records records)throws Exception{
        String sql = "insert into records value(null,?,?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1,records.getCname());
        pstmt.setInt(2,records.getUid());
        pstmt.setString(3, records.getRtime());
        pstmt.setString(4,records.getRcondition());
        return pstmt.executeUpdate();
    }

    // 查询考勤记录
    public ResultSet list(Connection con, records records, user user)throws Exception{
        StringBuffer sb = new StringBuffer(
                "select uclass,user.uid,rid,rtime,uname,cname,rcondition from records,user where (records.uid)=(user.uid)");
        if(StringUtil.isNotEmpty(records.getRtime())){
            sb.append(" and rtime like '%" + records.getRtime() + "%'");
        }
        if(StringUtil.classNotEmpty(user.getUclass())){
            sb.append(" and uclass like '%" + user.getUclass() + "%'");
        }
        if(StringUtil.isNotEmpty(user.getUname())){
            sb.append(" and uname like '%" + user.getUname() + "%'");
        }
        if (StringUtil.IisNotEmpty(records.getUid())){
            sb.append(" and records.uid like '%" + records.getUid() + "%'");
        }
        PreparedStatement pstmt = con.prepareStatement(sb.toString());
        return pstmt.executeQuery();
    }

    public ResultSet countall(Connection con)throws Exception{
        String sql =
                "select count(case rcondition when '出勤' then 0 end ) as '出勤次数', count(case rcondition when '请假' then 1 end ) as '请假次数', count(case rcondition when '旷课' then 2 end ) as '旷课次数', count(case rcondition when '迟到' then 3 end ) as '迟到次数', count(case rcondition when '早退' then 4 end ) as '早退次数' from records;";
        PreparedStatement pstmt = con.prepareStatement(sql);
        return pstmt.executeQuery();
    }

    public ResultSet count(Connection con, user user)throws Exception{
        String sql =
                "select count(case rcondition when '出勤' then 0 end ) as '出勤次数', count(case rcondition when '请假' then 1 end ) as '请假次数', count(case rcondition when '旷课' then 2 end ) as '旷课次数', count(case rcondition when '迟到' then 3 end ) as '迟到次数', count(case rcondition when '早退' then 4 end ) as '早退次数' from records where uid=?;";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1,user.getUid());
        return pstmt.executeQuery();
    }

    public ResultSet list2(Connection con, records records)throws Exception{
        StringBuffer sb = new StringBuffer(
                "select uclass,user.uid,rid,rtime,uname,cname,rcondition from records,user where (records.uid)=(user.uid)");
        if(StringUtil.isNotEmpty(records.getRtime())){
            sb.append(" and rtime like '%" + records.getRtime() + "%'");
        }
        if (StringUtil.IisNotEmpty(records.getUid())){
            sb.append(" and records.uid like '%" + records.getUid() + "%'");
        }
        if(StringUtil.isNotEmpty(records.getRcondition())){
            sb.append("and rcondition like '%" + records.getRcondition() + "%'");
        }
        PreparedStatement pstmt = con.prepareStatement(sb.toString());
        return pstmt.executeQuery();
    }

    // 修改考勤记录
    public int update(Connection con,records records)throws Exception{
        String sql = "update records set uid=?, cname=?, rtime=?, rcondition=? where rid=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1,records.getUid());
        pstmt.setString(2, records.getCname());
        pstmt.setString(3, records.getRtime());
        pstmt.setString(4, records.getRcondition());
        pstmt.setInt(5,records.getRid());
        return pstmt.executeUpdate();
    }

    // 删除考勤记录
    public int delete(Connection con,int rid)throws Exception{
        String sql = "delete from records where rid=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1,rid);
        return pstmt.executeUpdate();
    }

}
