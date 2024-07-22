/*
 * Created by JFormDesigner on Mon Oct 17 16:26:43 CST 2022
 */

package com.artisan.view.admin.course;

import javax.swing.*;

import com.artisan.Controller.dao.adminDao;
import com.artisan.util.DbUtil;
import com.artisan.util.StringUtil;
import net.miginfocom.swing.*;

import java.awt.event.ActionEvent;
import java.sql.Connection;

/**
 * @author a
 */
public class Calter extends JFrame {
    public Calter() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        textField1 = new JTextField();
        button2 = new JButton();

        //======== this ========
        setTitle("\u8bfe\u7a0b\u4fe1\u606f\u5220\u9664");
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

        //---- button2 ----
        button2.setText("\u5220\u9664");
        button2.addActionListener(e -> button2(e));
        contentPane.add(button2, "cell 5 3 3 1");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField textField1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    private void resetValue(){
        this.textField1.setText("");
    }

    // 删除课程信息
    private void button2(ActionEvent evt){
        String cname = this.textField1.getText();
        if(StringUtil.isEmpty(cname)){JOptionPane.showMessageDialog(null,"请输入需要删除的课程名");}
        int n = JOptionPane.showConfirmDialog(null,"确认删除课程信息吗？");
        Connection con = null;
        adminDao ad = new adminDao();
        DbUtil db = new DbUtil();
        try {
            con = db.getCon();
            int m = ad.deletec(con,cname);
            if(m==1){
                JOptionPane.showMessageDialog(null,"删除课程信息成功");
                this.resetValue();
            }else {JOptionPane.showMessageDialog(null,"删除课程信息失败");}
        }catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"删除课程信息失败");
        }
        finally {try {db.closeCon(con);}
        catch (Exception e){e.printStackTrace();}}
    }

//    // 修改课程信息
//    private void button1(ActionEvent evt){
//        String cname = this.textField1.getText();
//        if(StringUtil.isEmpty(cname)){JOptionPane.showMessageDialog(null,"课程名不能为空");}
//        course course = new course(cname);
//        Connection con = null;
//        DbUtil db = new DbUtil();
//        adminDao ad = new adminDao();
//        try{
//            con = db.getCon();
//            int n = ad.updatec(con,course);
//            if(n==1){
//                JOptionPane.showMessageDialog(null,"修改课程信息成功");
//                this.resetValue();
//            }else {
//                JOptionPane.showMessageDialog(null,"修改课程信息失败");
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(null,"修改课程信息失败");
//        }
//        finally {try {db.closeCon(con);}
//        catch (Exception e){e.printStackTrace();}}
//    }

//    public static void main(String[] args) {
//        Calter c = new Calter();
//        c.setVisible(true);
//    }
}
