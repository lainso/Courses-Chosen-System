// 业勤：已完成

package com.artisan.Controller.dao;


import com.artisan.model.records;
import com.artisan.util.StringUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class studentDao {
    // 查询学生所有考勤信息
    public ResultSet listt(Connection con,records records) throws Exception{
        StringBuffer sb = new StringBuffer("select uid,cname,rtime,rcondition from records where uid is not null");
        if (StringUtil.IisNotEmpty(records.getUid())){
            sb.append(" and uid like '%" + records.getUid() + "%'");
        }
        if(StringUtil.isNotEmpty(records.getRtime())){
            sb.append(" and rtime like '%" + records.getRtime() + "%'");
        }
        PreparedStatement pstmt = con.prepareStatement(sb.toString());
        return pstmt.executeQuery();
    }
}
