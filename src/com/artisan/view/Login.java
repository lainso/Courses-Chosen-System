package com.artisan.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import javax.swing.*;

import com.artisan.Controller.dao.loginDao;
import com.artisan.model.user;
import com.artisan.util.DbUtil;
import com.artisan.util.StringUtil;
import com.artisan.view.admin.Amain;
import com.artisan.view.student.Smain;
import com.artisan.view.teacher.Tmain;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Wed Oct 12 11:44:17 CST 2022
 */


/**
 * @author 1
 */
public class Login extends JFrame {
    public Login() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label3 = new JLabel();
        label1 = new JLabel();
        formattedTextField1 = new JFormattedTextField();
        label2 = new JLabel();
        passwordField1 = new JPasswordField();
        button1 = new JButton();

        //======== this ========
        setTitle("\u5b66\u751f\u8003\u52e4\u7cfb\u7edf-\u767b\u5f55");
        setMinimumSize(new Dimension(400, 300));
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "fill,hidemode 3,align center center",
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

        //---- label3 ----
        label3.setText("\u5b66\u751f\u8003\u52e4\u7cfb\u7edf");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 5f));
        contentPane.add(label3, "cell 6 2");

        //---- label1 ----
        label1.setText("\u8d26\u53f7");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 3f));
        contentPane.add(label1, "cell 4 4");
        contentPane.add(formattedTextField1, "cell 5 4 6 1");

        //---- label2 ----
        label2.setText("\u5bc6\u7801");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 3f));
        contentPane.add(label2, "cell 4 6");
        contentPane.add(passwordField1, "cell 5 6 6 1");

        //---- button1 ----
        button1.setText("\u767b\u5f55");
        button1.addActionListener(e -> loginButton(e));
        contentPane.add(button1, "cell 6 9");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    public static void main(String[] args) {
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    try {
                        Login l = new Login();
                        l.setVisible(true);
                        l.setDefaultCloseOperation(EXIT_ON_CLOSE);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            });
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label3;
    private JLabel label1;
    private JFormattedTextField formattedTextField1;
    private JLabel label2;
    private JPasswordField passwordField1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    // 登录
    private void loginButton(ActionEvent event){
        int uid = Integer.parseInt(this.formattedTextField1.getText());
        String upass = new String(this.passwordField1.getPassword());
        if (StringUtil.IisEmpty(uid)){
            JOptionPane.showMessageDialog(null,"用户名不能为空");
        }
        if(StringUtil.isEmpty(upass)){
            JOptionPane.showMessageDialog(null,"密码不能为空");
        }
        user user = new user(uid,upass);
        Connection con = null;
        try {
            DbUtil db = new DbUtil();
            con = db.getCon();
            loginDao ld = new loginDao();
            user cuser = ld.login(con,user);
            int ut = cuser.getUtype();
            if(cuser!=null){
                if(ut==0){
                    // 进入管理员主界面
                    dispose();
                    Amain a = new Amain();
                    a.setVisible(true);
                    a.setDefaultCloseOperation(EXIT_ON_CLOSE);
                }
                if(ut==1){
                    // 进入教师主界面
                    dispose();
                    Tmain a = new Tmain();
                    a.setVisible(true);
                    a.setDefaultCloseOperation(EXIT_ON_CLOSE);
                }
                if(ut==2){
                    // 进入学生主界面
                    dispose();
                    Smain a = new Smain();
                    a.setVisible(true);
                    a.setDefaultCloseOperation(EXIT_ON_CLOSE);
                }
            }else {
                JOptionPane.showMessageDialog(null,"登录失败！请检查用户名密码！");
                db.closeCon(con);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
