/*
 * Created by JFormDesigner on Fri Oct 21 09:21:43 CST 2022
 */

package com.artisan.view.teacher.records;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.*;

import com.artisan.Controller.dao.teacherDao;
import com.artisan.model.user;
import com.artisan.util.DbUtil;

/**
 * @author a
 */
public class Rcount extends JFrame {
    public Rcount() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        label2 = new JLabel();

        //======== this ========
        setTitle("\u5b66\u751f\u8003\u52e4\u4fe1\u606f\u7edf\u8ba1");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u5b66\u751f\u5b66\u53f7");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 3f));
        contentPane.add(label1);
        label1.setBounds(49, 25, 68, 30);
        contentPane.add(textField1);
        textField1.setBounds(122, 25, 118, textField1.getPreferredSize().height);

        //---- button1 ----
        button1.setText("\u7edf\u8ba1");
        button1.addActionListener(e -> button1(e));
        contentPane.add(button1);
        button1.setBounds(269, 25, 93, button1.getPreferredSize().height);

        //---- button2 ----
        button2.setText("\u7edf\u8ba1\u5168\u90e8");
        button2.addActionListener(e -> button2(e));
        contentPane.add(button2);
        button2.setBounds(391, 25, 93, button2.getPreferredSize().height);
        contentPane.add(label2);
        label2.setBounds(514, 95, 19, label2.getPreferredSize().height);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField textField1;
    private JButton button1;
    private JButton button2;
    private JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

//    public static void main(String[] args) {
//        Rcount r = new Rcount();
//        r.setVisible(true);
//    }

    private void button2(ActionEvent evt){
        Vector v = new Vector();
        Connection con = null;
        DbUtil db = new DbUtil();
        try {
            con = db.getCon();
            teacherDao td = new teacherDao();
            ResultSet rs = td.countall(con);
            while (rs.next()){
                v.add(rs.getInt("出勤次数"));
                v.add(rs.getString("请假次数"));
                v.add(rs.getString("旷课次数"));
                v.add(rs.getString("迟到次数"));
                v.add(rs.getString("早退次数"));
            }
            JOptionPane.showMessageDialog(null, "统计所有学生考勤情况如下：\n"
                    + "出勤次数：" + v.get(0) + "\n请假次数：" + v.get(1) + "\n旷课次数：" + v.get(2) +
                    "\n迟到次数：" + v.get(3) + "\n早退次数：" + v.get(4));
        }catch (Exception e){e.printStackTrace();}
        finally {try {db.closeCon(con);}
        catch (Exception e){e.printStackTrace();}}
    }

    private void button1(ActionEvent evt){
        int uid = Integer.parseInt(this.textField1.getText());
        user user = new user();
        user.setUid(uid);
        Vector v = new Vector();
        Connection con = null;
        DbUtil db = new DbUtil();
        try {
            con = db.getCon();
            teacherDao td = new teacherDao();
            ResultSet rs = td.count(con, user);
            while (rs.next()){
                v.add(rs.getInt("出勤次数"));
                v.add(rs.getString("请假次数"));
                v.add(rs.getString("旷课次数"));
                v.add(rs.getString("迟到次数"));
                v.add(rs.getString("早退次数"));
            }
            JOptionPane.showMessageDialog(null, "统计学号为"+uid+"的学生考勤情况如下：\n"
                    + "出勤次数：" + v.get(0) + "\n请假次数：" + v.get(1) + "\n旷课次数：" + v.get(2) +
                    "\n迟到次数：" + v.get(3) + "\n早退次数：" + v.get(4));
        }catch (Exception e){e.printStackTrace();}
        finally {try {db.closeCon(con);}
        catch (Exception e){e.printStackTrace();}}
    }
}
