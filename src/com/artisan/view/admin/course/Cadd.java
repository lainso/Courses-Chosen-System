/*
 * Created by JFormDesigner on Mon Oct 17 15:24:50 CST 2022
 */

package com.artisan.view.admin.course;

import javax.swing.*;

import com.artisan.Controller.dao.adminDao;
import com.artisan.model.course;
import com.artisan.util.DbUtil;
import com.artisan.util.StringUtil;
import net.miginfocom.swing.*;

import java.awt.event.ActionEvent;
import java.sql.Connection;

/**
 * @author a
 */
public class Cadd extends JFrame {
    public Cadd() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        setTitle("\u6dfb\u52a0\u8bfe\u7a0b\u4fe1\u606f");
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
        label1.setText("\u8bfe\u7a0b\u540d\u5b57");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 3f));
        contentPane.add(label1, "cell 1 1 11 1,alignx label,growx 0");
        contentPane.add(textField1, "cell 1 1 11 1");

        //---- button1 ----
        button1.setText("\u6dfb\u52a0");
        button1.addActionListener(e -> Button1(e));
        contentPane.add(button1, "cell 4 3 3 1");

        //---- button2 ----
        button2.setText("\u91cd\u7f6e");
        button2.addActionListener(e -> Button2(e));
        contentPane.add(button2, "cell 8 3 3 1");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField textField1;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    private void resetValue(){
        this.textField1.setText("");
    }

    // 添加按钮
    private void Button1(ActionEvent evt){
        String cname = this.textField1.getText();
        if(StringUtil.isEmpty(cname)){JOptionPane.showMessageDialog(null,"请输入需要添加的课程名");}
        course course = new course(cname);
        Connection con = null;
        DbUtil db = new DbUtil();
        adminDao ad = new adminDao();
        try {
            con = db.getCon();
            int n = ad.addc(con,course);
            if(n==1){
                JOptionPane.showMessageDialog(null,"添加课程信息成功");
            }else {JOptionPane.showMessageDialog(null,"添加课程信息失败");}
            resetValue();
        }
        catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "添加课程信息失败");
        }
        finally {try {db.closeCon(con);}
        catch (Exception e){e.printStackTrace();}
        }
    }

    // 重置按钮
    private void Button2(ActionEvent evt){this.resetValue();}

//    public static void main(String[] args) {
//        Cadd c = new Cadd();
//        c.setVisible(true);
//    }

}
