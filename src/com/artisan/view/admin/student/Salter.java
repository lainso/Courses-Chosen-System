/*
 * Created by JFormDesigner on Fri Oct 14 15:41:47 CST 2022
 */

package com.artisan.view.admin.student;

import com.artisan.Controller.dao.adminDao;
import com.artisan.model.user;
import com.artisan.util.DbUtil;
import com.artisan.util.StringUtil;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;

/**
 * @author a
 */
public class Salter extends JFrame {
    public Salter() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        textField1 = new JTextField();
        label6 = new JLabel();
        textField3 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        passwordField1 = new JPasswordField();
        label4 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        label5 = new JLabel();

        //======== this ========
        setTitle("\u5b66\u751f\u4fe1\u606f\u4fee\u6539 / \u5220\u9664");
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- label1 ----
        label1.setText("\u5b66\u751f\u59d3\u540d");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 2f));
        contentPane.add(label1, "cell 3 1");
        contentPane.add(textField1, "cell 4 1 7 1");

        //---- label6 ----
        label6.setText("    \u73ed\u7ea7");
        label6.setFont(label6.getFont().deriveFont(label6.getFont().getSize() + 3f));
        contentPane.add(label6, "cell 3 3");
        contentPane.add(textField3, "cell 4 3 7 1");

        //---- label2 ----
        label2.setText("    \u5b66\u53f7");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 2f));
        contentPane.add(label2, "cell 3 5");
        contentPane.add(textField2, "cell 4 5 7 1");

        //---- label3 ----
        label3.setText("    \u5bc6\u7801");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 2f));
        contentPane.add(label3, "cell 3 7");
        contentPane.add(passwordField1, "cell 4 7 7 1");
        contentPane.add(label4, "cell 5 8");

        //---- button1 ----
        button1.setText("\u4fee\u6539");
        button1.addActionListener(e -> button1(e));
        contentPane.add(button1, "cell 5 9");

        //---- button2 ----
        button2.setText("\u5220\u9664");
        button2.addActionListener(e -> button2(e));
        contentPane.add(button2, "cell 7 9");

        //---- label5 ----
        label5.setText("    \u63d0\u793a\uff1a\u5220\u9664\u5b66\u751f\u4fe1\u606f\u8f93\u5165\u5b66\u53f7\u5373\u53ef");
        label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 1f));
        contentPane.add(label5, "cell 4 11 4 1");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField textField1;
    private JLabel label6;
    private JTextField textField3;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JPasswordField passwordField1;
    private JLabel label4;
    private JButton button1;
    private JButton button2;
    private JLabel label5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    private void resetValue(){
        this.textField1.setText("");
        this.textField2.setText("");
        this.textField3.setText("");
        this.passwordField1.setText("");
    }

    // 修改学生信息按钮
    private void button1(ActionEvent evt){
        String uname = this.textField1.getText();
        int uid = Integer.parseInt(this.textField2.getText());
        String upass = new String(this.passwordField1.getPassword());
        String uclass = new String(this.textField3.getText());
        if(StringUtil.isEmpty(uname)){JOptionPane.showMessageDialog(null,"请输入需要修改的学生名字");}
        if(StringUtil.IisEmpty(uid)){JOptionPane.showMessageDialog(null,"请输入需要修改的学生学号");}
        if(StringUtil.isEmpty(upass)){JOptionPane.showMessageDialog(null,"请输入需要修改的学生密码");}
        if(StringUtil.isEmpty(uclass)){JOptionPane.showMessageDialog(null,"请输入需要修改的学生班级");}
        user user = new user(uid,uname,upass,uclass,2);
        Connection con = null;
        DbUtil db = new DbUtil();
        adminDao ad = new adminDao();
        try {
            con = db.getCon();
            int snum = ad.updates(con,user);
            if(snum==1){
                JOptionPane.showMessageDialog(null,"修改学生信息成功");
                this.resetValue();
            }else {JOptionPane.showMessageDialog(null,"修改学生信息失败");}
        }catch (Exception e){e.printStackTrace();JOptionPane.showMessageDialog(null,"修改学生信息失败");}
        finally {
            try{
                db.closeCon(con);
            }catch (Exception e){e.printStackTrace();}
        }
    }

    // 删除学生信息按钮
    private void button2(ActionEvent evt){
        int uid = Integer.parseInt(this.textField2.getText());
        if(StringUtil.IisEmpty(uid)){JOptionPane.showMessageDialog(null,"请输入需要删除的学生学号");}
        int n = JOptionPane.showConfirmDialog(null,"确认删除该学生信息吗？");
        Connection con = null;
        adminDao ad = new adminDao();
        DbUtil db = new DbUtil();
        try {
            con = db.getCon();
            int m = ad.deletes(con,uid);
            if(m==1){
                JOptionPane.showMessageDialog(null,"删除成功");
                this.resetValue();
            }else {JOptionPane.showMessageDialog(null,"删除失败");}
        }catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"删除失败");
        }finally{
            try {db.closeCon(con);}
            catch (Exception e){e.printStackTrace();}
        }
    }

//    public static void main(String[] args) {
//        Salter s = new Salter();
//        s.setVisible(true);
//    }
}
