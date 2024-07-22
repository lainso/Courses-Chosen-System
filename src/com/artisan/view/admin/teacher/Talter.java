/*
 * Created by JFormDesigner on Fri Oct 14 15:41:47 CST 2022
 */

package com.artisan.view.admin.teacher;

import javax.swing.*;

import com.artisan.Controller.dao.adminDao;
import com.artisan.model.user;
import com.artisan.util.DbUtil;
import com.artisan.util.StringUtil;
import net.miginfocom.swing.*;

import java.awt.event.ActionEvent;
import java.sql.Connection;

/**
 * @author a
 */
public class Talter extends JFrame {
    public Talter() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        passwordField1 = new JPasswordField();
        button1 = new JButton();
        button2 = new JButton();
        label4 = new JLabel();
        label5 = new JLabel();

        //======== this ========
        setTitle("\u6559\u5e08\u4fe1\u606f\u4fee\u6539 / \u5220\u9664");
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
            "[]"));

        //---- label1 ----
        label1.setText("\u6559\u5e08\u59d3\u540d");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 2f));
        contentPane.add(label1, "cell 3 1");
        contentPane.add(textField1, "cell 4 1 7 1");

        //---- label2 ----
        label2.setText("    \u5de5\u53f7");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 2f));
        contentPane.add(label2, "cell 3 3");
        contentPane.add(textField2, "cell 4 3 7 1");

        //---- label3 ----
        label3.setText("    \u5bc6\u7801");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 2f));
        contentPane.add(label3, "cell 3 5");
        contentPane.add(passwordField1, "cell 4 5 7 1");

        //---- button1 ----
        button1.setText("\u4fee\u6539");
        button1.addActionListener(e -> button1(e));
        contentPane.add(button1, "cell 5 7");

        //---- button2 ----
        button2.setText("\u5220\u9664");
        button2.addActionListener(e -> button2(e));
        contentPane.add(button2, "cell 7 7");
        contentPane.add(label4, "cell 5 8");

        //---- label5 ----
        label5.setText("    \u5220\u9664\u6559\u5e08\u4fe1\u606f\u8f93\u5165\u5de5\u53f7\u5373\u53ef");
        label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 1f));
        contentPane.add(label5, "cell 5 9 3 1");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JPasswordField passwordField1;
    private JButton button1;
    private JButton button2;
    private JLabel label4;
    private JLabel label5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    private void resetValue(){
        this.textField1.setText("");
        this.textField2.setText("");
        this.passwordField1.setText("");
    }

    // 修改教师信息按钮
    private void button1(ActionEvent evt){
        String uname = this.textField1.getText();
        int uid = Integer.parseInt(this.textField2.getText());
        String upass = new String(this.passwordField1.getPassword());
        if(StringUtil.isEmpty(uname)){JOptionPane.showMessageDialog(null,"请输入需要修改的教师名字");}
        if(StringUtil.IisEmpty(uid)){JOptionPane.showMessageDialog(null,"请输入需要修改的教师工号");}
        if(StringUtil.isEmpty(upass)){JOptionPane.showMessageDialog(null,"请输入需要修改的教师密码");}
        user user = new user(uid,uname,upass,null,1);
        Connection con = null;
        DbUtil db = new DbUtil();
        adminDao ad = new adminDao();
        try {
            con = db.getCon();
            int snum = ad.updatet(con,user);
            if(snum==1){
                JOptionPane.showMessageDialog(null,"修改教师信息成功");
                this.resetValue();
            }else {JOptionPane.showMessageDialog(null,"修改教师信息失败");}
        }catch (Exception e){e.printStackTrace();JOptionPane.showMessageDialog(null,"修改教师信息失败");}
        finally {
            try{
                db.closeCon(con);
            }catch (Exception e){e.printStackTrace();}
        }
    }

    // 删除教师信息按钮
    private void button2(ActionEvent evt){
        String uname = this.textField1.getText();
        int uid = Integer.parseInt(this.textField2.getText());
        String upass = new String(this.passwordField1.getPassword());
        if(StringUtil.IisEmpty(uid)){JOptionPane.showMessageDialog(null,"请输入需要删除的教师工号");}
        int n = JOptionPane.showConfirmDialog(null,"确认删除该教师信息吗？");
        Connection con = null;
        adminDao ad = new adminDao();
        DbUtil db = new DbUtil();
        try {
            con = db.getCon();
            int m = ad.deletet(con,uid);
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
//        Talter t = new Talter();
//        t.setVisible(true);
//    }
}
