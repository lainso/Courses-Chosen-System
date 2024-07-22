/*
 * Created by JFormDesigner on Mon Oct 17 15:52:19 CST 2022
 */

package com.artisan.view.admin.course;

import javax.swing.*;

import com.artisan.Controller.dao.adminDao;
import com.artisan.model.course;
import com.artisan.util.DbUtil;
import net.miginfocom.swing.*;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

/**
 * @author a
 */
public class Cfind extends JFrame {
    public Cfind() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();

        //======== this ========
        setTitle("\u67e5\u8be2\u8bfe\u7a0b\u4fe1\u606f");
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
            "[]"));

        //---- label1 ----
        label1.setText("\u8bfe\u7a0b\u540d\u5b57");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 3f));
        contentPane.add(label1, "cell 1 1 11 1,alignx label,growx 0");
        contentPane.add(textField1, "cell 1 1 11 1");

        //---- button1 ----
        button1.setText("\u67e5\u8be2");
        button1.addActionListener(e -> Cfind(e));
        contentPane.add(button1, "cell 5 3 4 1");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField textField1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    private void Cfind(ActionEvent evt){
        String cname = this.textField1.getText();
        course course = new course();
        course.setCname(cname);
        this.getData(course);
    }

    private void getData(course course) {
        Vector v = new Vector();
        Connection con = null;
        DbUtil db = new DbUtil();
        try {
            con = db.getCon();
            adminDao ad = new adminDao();
            ResultSet rs = ad.listc(con,course);
            while (rs.next()){
                v.add(rs.getString("cname"));
            }
            for(int k=0; k<(v.toArray().length); k++){
                JOptionPane.showMessageDialog(null,"找到课程信息如下：\n" +
                        "课程名字：" + v.get(k));
            }
        }
        catch (Exception e){e.printStackTrace();}
        finally {try {db.closeCon(con);}
        catch (Exception e){e.printStackTrace();}}
    }
//    public static void main(String[] args) {
//        Cfind c = new Cfind();
//        c.setVisible(true);
//    }
}
