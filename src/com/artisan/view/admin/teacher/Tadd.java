/*
 * Created by JFormDesigner on Fri Oct 14 15:57:56 CST 2022
 */

package com.artisan.view.admin.teacher;

import com.artisan.Controller.dao.adminDao;
import com.artisan.model.user;
import com.artisan.util.DbUtil;
import com.artisan.util.StringUtil;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import javax.swing.*;

/**
 * @author 1
 */
public class Tadd extends JFrame {
    public Tadd() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        formattedTextField1 = new JFormattedTextField();
        formattedTextField2 = new JFormattedTextField();
        button1 = new JButton();
        button2 = new JButton();
        passwordField1 = new JPasswordField();

        //======== this ========
        setTitle("\u6dfb\u52a0\u6559\u5e08\u4fe1\u606f");
        setMinimumSize(new Dimension(330, 280));
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u6559\u5e08\u59d3\u540d");
        contentPane.add(label1);
        label1.setBounds(65, 50, label1.getPreferredSize().width, 30);

        //---- label2 ----
        label2.setText("\u8d26\u53f7");
        contentPane.add(label2);
        label2.setBounds(75, 90, label2.getPreferredSize().width, 30);

        //---- label3 ----
        label3.setText("\u5bc6\u7801");
        contentPane.add(label3);
        label3.setBounds(75, 130, label3.getPreferredSize().width, 30);
        contentPane.add(formattedTextField1);
        formattedTextField1.setBounds(130, 55, 120, 25);
        contentPane.add(formattedTextField2);
        formattedTextField2.setBounds(130, 95, 120, 25);

        //---- button1 ----
        button1.setText("\u786e\u8ba4");
        button1.addActionListener(e -> button1(e));
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(70, 185), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("\u91cd\u7f6e");
        button2.addActionListener(e -> button2(e));
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(180, 185), button2.getPreferredSize()));
        contentPane.add(passwordField1);
        passwordField1.setBounds(130, 135, 120, 25);

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
    private JLabel label2;
    private JLabel label3;
    private JFormattedTextField formattedTextField1;
    private JFormattedTextField formattedTextField2;
    private JButton button1;
    private JButton button2;
    private JPasswordField passwordField1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    private void resetValue(){
        this.formattedTextField1.setText("");
        this.formattedTextField2.setText("");
        this.passwordField1.setText("");
    }

    // 添加教师页面的确认按钮逻辑
    private void button1(ActionEvent evt){
        String uname = this.formattedTextField1.getText();
        int uid = Integer.parseInt(this.formattedTextField2.getText());
        String upass = new String(this.passwordField1.getPassword());
        if(StringUtil.isEmpty(uname)){JOptionPane.showMessageDialog(null,"教师名不能为空");}
        if (StringUtil.IisEmpty(uid)){JOptionPane.showMessageDialog(null,"教师工号不能为空");}
        if (StringUtil.isEmpty(upass)){JOptionPane.showMessageDialog(null,"教师密码不能为空");}
        user user = new user(uid,uname,upass,null,1);
        Connection con = null;
        DbUtil db = new DbUtil();
        adminDao ad = new adminDao();
        try {
            con = db.getCon();
            int n = ad.addt(con,user);
            if (n==1){
                JOptionPane.showMessageDialog(null,"成功添加教师信息");
                resetValue();
            }else {
                JOptionPane.showMessageDialog(null, "添加教师信息失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "添加教师信息失败");
        }finally {
            try {
                db.closeCon(con);
            }catch (Exception e){e.printStackTrace();}
        }
    }

    // 添加教师信息的重置按钮逻辑
    private void button2(ActionEvent evt){this.resetValue();}
}
