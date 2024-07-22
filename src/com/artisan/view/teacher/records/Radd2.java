/*
 * Created by JFormDesigner on Tue Oct 18 08:24:55 CST 2022
 */

package com.artisan.view.teacher.records;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.*;

import com.artisan.Controller.dao.adminDao;
import com.artisan.Controller.dao.teacherDao;
import com.artisan.model.course;
import com.artisan.model.records;
import com.artisan.model.user;
import com.artisan.util.DbUtil;
import com.artisan.util.StringUtil;

/**
 * @author a
 */
public class Radd2 extends JFrame {
    public Radd2() {
        initComponents();
        combo1();
        combo2();
        combo3();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label2 = new JLabel();
        label3 = new JLabel();
        comboBox1 = new JComboBox();
        button1 = new JButton();
        label4 = new JLabel();
        textField2 = new JTextField();
        label5 = new JLabel();
        comboBox2 = new JComboBox();
        comboBox3 = new JComboBox();
        label6 = new JLabel();

        //======== this ========
        setTitle("\u8003\u52e4\u4fe1\u606f\u6dfb\u52a0");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label2 ----
        label2.setText("\u5b66\u751f\u5b66\u53f7");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 3f));
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(34, 37), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("\u8bfe\u7a0b\u540d\u5b57");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 3f));
        contentPane.add(label3);
        label3.setBounds(295, 37, 70, label3.getPreferredSize().height);
        contentPane.add(comboBox1);
        comboBox1.setBounds(372, 33, 108, comboBox1.getPreferredSize().height);

        //---- button1 ----
        button1.setText("\u6dfb\u52a0");
        button1.addActionListener(e -> button1(e));
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(493, 71), button1.getPreferredSize()));

        //---- label4 ----
        label4.setText("\u8003\u52e4\u65f6\u95f4");
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 3f));
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(34, 112), label4.getPreferredSize()));
        contentPane.add(textField2);
        textField2.setBounds(99, 109, 171, textField2.getPreferredSize().height);

        //---- label5 ----
        label5.setText("\u8003\u52e4\u72b6\u6001");
        label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 3f));
        contentPane.add(label5);
        label5.setBounds(295, 112, 70, label5.getPreferredSize().height);
        contentPane.add(comboBox2);
        comboBox2.setBounds(372, 108, 108, comboBox2.getPreferredSize().height);
        contentPane.add(comboBox3);
        comboBox3.setBounds(100, 35, 170, comboBox3.getPreferredSize().height);
        contentPane.add(label6);
        label6.setBounds(new Rectangle(new Point(580, 175), label6.getPreferredSize()));

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
    private JLabel label2;
    private JLabel label3;
    private JComboBox comboBox1;
    private JButton button1;
    private JLabel label4;
    private JTextField textField2;
    private JLabel label5;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JLabel label6;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    private void button1(ActionEvent evt){
        String rtime = this.textField2.getText();
        if(StringUtil.isEmpty(rtime)){
            JOptionPane.showMessageDialog(null,"考勤时间不能为空");
        }

        String uidd = (comboBox3.getSelectedItem()).toString();
        int uid = Integer.parseInt(uidd);

        String cname = (comboBox1.getSelectedItem()).toString();

        String rcondition = (comboBox2.getSelectedItem()).toString();

        records records = new records(cname,uid,rtime,rcondition);

        Connection con = null;
        DbUtil db = new DbUtil();
        teacherDao td = new teacherDao();
        try {
            con =db.getCon();
            int num = td.add(con,records);
            if(num==1){
                JOptionPane.showMessageDialog(null,"添加考勤信息成功");
                resetValue();
            }else {
                JOptionPane.showMessageDialog(null,"添加考勤信息失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"添加考勤信息失败");
        }finally {
            try {
                db.closeCon(con);
            }catch (Exception e){e.printStackTrace();}
        }
    }

    private void combo1(){
        this.comboBox1.addItem("—请选择—");
        Connection con =null;
        course records = null;
        Vector v = new Vector();
        DbUtil db = new DbUtil();
        adminDao ad = new adminDao();
        try {
            con = db.getCon();
            ResultSet rs = ad.listc(con,new course());
            while (rs.next()){
                v.add(rs.getString("cname"));
            }
            for (int i=0;i<(v.toArray().length);i++){
                this.comboBox1.addItem(v.get(i));
            }
        }catch (Exception e){e.printStackTrace();}
        finally {
            try {
                db.closeCon(con);
            }catch (Exception e){e.printStackTrace();}
        }
    }

    private void combo3(){
        this.comboBox3.addItem("—请选择—");
        Connection con =null;
        user user = null;
        Vector v = new Vector();
        DbUtil db = new DbUtil();
        adminDao ad = new adminDao();
        try {
            con = db.getCon();
            ResultSet rs = ad.lists(con,new user());
            while (rs.next()){
                v.add(rs.getString("uid"));
            }
            for (int i=0;i<(v.toArray().length);i++){
                this.comboBox3.addItem(v.get(i));
            }
        }catch (Exception e){e.printStackTrace();}
        finally {
            try {
                db.closeCon(con);
            }catch (Exception e){e.printStackTrace();}
        }
    }
    private void combo2(){
        this.comboBox2.addItem("—请选择—");
        this.comboBox2.addItem("出勤");
        this.comboBox2.addItem("请假");
        this.comboBox2.addItem("旷课");
        this.comboBox2.addItem("迟到");
        this.comboBox2.addItem("早退");
    }

    private void resetValue(){
        if(this.comboBox1.getItemCount()>0){
            this.comboBox1.setSelectedIndex(0);
        }
        if(this.comboBox2.getItemCount()>0){
            this.comboBox2.setSelectedIndex(0);
        }
    }

//    public static void main(String[] args) {
//        Radd2 r = new Radd2();
//        r.setVisible(true);
//    }
}
