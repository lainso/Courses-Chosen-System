/*
 * Created by JFormDesigner on Wed Oct 19 22:21:28 CST 2022
 */

package com.artisan.view.teacher.records;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.artisan.Controller.dao.adminDao;
import com.artisan.Controller.dao.teacherDao;
import com.artisan.model.records;
import com.artisan.model.user;
import com.artisan.util.DbUtil;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

/**
 * @author a
 */
public class Rfind extends JFrame {
    public Rfind() {
        initComponents();
        combo1();
        table1.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"学生学号","学生班级","学生姓名","考勤时间","课程名","考勤状态"}
        ));
        this.getData(new records(), new user());
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        comboBox1 = new JComboBox();
        label2 = new JLabel();
        textField1 = new JTextField();
        label3 = new JLabel();
        textField2 = new JTextField();
        button1 = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label4 = new JLabel();

        //======== this ========
        setTitle("\u8003\u52e4\u4fe1\u606f\u67e5\u8be2");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u5b66\u751f\u73ed\u7ea7");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 3f));
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(31, 36), label1.getPreferredSize()));
        contentPane.add(comboBox1);
        comboBox1.setBounds(96, 32, 123, comboBox1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("\u5b66\u751f\u59d3\u540d");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 3f));
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(250, 36), label2.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(326, 33, 148, textField1.getPreferredSize().height);

        //---- label3 ----
        label3.setText("\u8003\u52e4\u65f6\u95f4");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 3f));
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(505, 40), label3.getPreferredSize()));
        contentPane.add(textField2);
        textField2.setBounds(570, 35, 123, textField2.getPreferredSize().height);

        //---- button1 ----
        button1.setText("\u67e5\u8be2");
        button1.addActionListener(e -> button1(e));
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(325, 260), button1.getPreferredSize()));

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(30, 85, 654, 157);
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(705, 315), label4.getPreferredSize()));

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
    private JComboBox comboBox1;
    private JLabel label2;
    private JTextField textField1;
    private JLabel label3;
    private JTextField textField2;
    private JButton button1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    private void combo1(){
        this.comboBox1.addItem("—请选择—");
        Connection con =null;
        user user = null;
        Vector v = new Vector();
        DbUtil db = new DbUtil();
        adminDao ad = new adminDao();
        try {
            con = db.getCon();
            ResultSet rs = ad.lists2(con,new user());
            while (rs.next()){
                v.add(rs.getString("uclass"));
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

    private void clearTable(){
        DefaultTableModel dtm = (DefaultTableModel) table1.getModel();
        for (int row=0; row<10; row++){
            for (int col = 0; col<6; col++){
                dtm.setValueAt(null,row,col);
            }
        }
    }

    private void getData(records rd, user user){
        DefaultTableModel dtm = (DefaultTableModel) table1.getModel();
        dtm.setRowCount(25);
        Vector v = new Vector();
        Connection con = null;
        DbUtil db = new DbUtil();
        try {
            con = db.getCon();
            teacherDao td = new teacherDao();
            ResultSet rs = td.list(con, rd, user);
            while (rs.next()){
                v.add(rs.getInt("uid"));
                v.add(rs.getString("uclass"));
                v.add(rs.getString("uname"));
                v.add(rs.getString("rtime"));
                v.add(rs.getString("cname"));
                v.add(rs.getString("rcondition"));
            }
            for (int row=0; row<(v.toArray().length)/6; row++){
                for (int col = 0; col<6; col++){
                    dtm.setValueAt(v.get(6*row+col),row,col);
                }
            }
        }catch (Exception e){e.printStackTrace();}
        finally {try {db.closeCon(con);}
        catch (Exception e){e.printStackTrace();}}
    }

//    public static void main(String[] args) {
//        Rfind r = new Rfind();
//        r.setVisible(true);
//    }

    private void button1(ActionEvent evt){
        clearTable();
        String uname = this.textField1.getText();
        String rtime = this.textField2.getText();
        String uclass = comboBox1.getSelectedItem().toString();
        records records = new records(rtime);
        user user = new user(uname,uclass);
        getData(records,user);
    }

}
