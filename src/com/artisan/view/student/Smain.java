/*
 * Created by JFormDesigner on Mon Oct 17 08:32:22 CST 2022
 */

package com.artisan.view.student;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.artisan.Controller.dao.studentDao;
import com.artisan.model.records;
import com.artisan.util.DbUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

/**
 * @author a
 */
public class Smain extends JFrame {
    public Smain() {
        initComponents();
        table1.setModel(new DefaultTableModel(
            new Object[][]{},
            new String[]{"学号","课程名","考勤时间","考勤状态"}
        ));
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();
        label2 = new JLabel();
        textField2 = new JTextField();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label3 = new JLabel();

        //======== this ========
        setTitle("\u5b66\u751f\u8003\u52e4\u7cfb\u7edf-\u5b66\u751f\u7aef");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u5b66\u53f7");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 3f));
        contentPane.add(label1);
        label1.setBounds(96, 25, label1.getPreferredSize().width, 30);
        contentPane.add(textField1);
        textField1.setBounds(132, 25, 176, textField1.getPreferredSize().height);

        //---- button1 ----
        button1.setText("\u67e5\u8be2");
        button1.addActionListener(e -> button1(e));
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(385, 25), button1.getPreferredSize()));

        //---- label2 ----
        label2.setText("\u65e5\u671f");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 3f));
        contentPane.add(label2);
        label2.setBounds(96, 60, label2.getPreferredSize().width, 30);
        contentPane.add(textField2);
        textField2.setBounds(132, 60, 176, textField2.getPreferredSize().height);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(24, 104, 461, 86);
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(505, 220), label3.getPreferredSize()));

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
    private JLabel label2;
    private JTextField textField2;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

//    public static void main(String[] args) {
//        Smain s = new Smain();
//        s.setVisible(true);
//    }

    private void button1(ActionEvent e){
        int uid = Integer.parseInt(this.textField1.getText());
        String rtime = this.textField2.getText();
        records rd = new records();
        rd.setRtime(rtime);
        rd.setUid(uid);
        this.getData(rd);
    }

    private void getData(records rd) {
        DefaultTableModel dtm = (DefaultTableModel) table1.getModel();
        dtm.setRowCount(5);
        Vector v = new Vector();
        Connection con = null;
        DbUtil db = new DbUtil();
        try {
            con = db.getCon();
            studentDao sd = new studentDao();
            ResultSet rs = sd.listt(con, rd);
            while (rs.next()){
                v.add(rs.getInt("uid"));
                v.add(rs.getString("cname"));
                v.add(rs.getString("rtime"));
                v.add(rs.getString("rcondition"));
            }
            for (int row=0; row<(v.toArray().length)/4; row++){
                for (int col = 0; col<4; col++){
                    dtm.setValueAt(v.get(4*row+col),row,col);
                }
            }
        }catch (Exception e){e.printStackTrace();}
        finally {try {db.closeCon(con);}
        catch (Exception e){e.printStackTrace();}}
    }
}
