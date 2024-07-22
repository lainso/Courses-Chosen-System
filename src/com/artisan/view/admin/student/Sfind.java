/*
 * Created by JFormDesigner on Fri Oct 14 16:10:42 CST 2022
 */

package com.artisan.view.admin.student;

import com.artisan.Controller.dao.adminDao;
import com.artisan.model.user;
import com.artisan.util.DbUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

/**
 * @author 1
 */
public class Sfind extends JFrame {
    public Sfind() {
        initComponents();
        table1.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"学号","学生姓名","学生班级","密码"}
        ));
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        formattedTextField1 = new JFormattedTextField();
        button1 = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label2 = new JLabel();

        //======== this ========
        setMinimumSize(new Dimension(362, 200));
        setTitle("\u67e5\u8be2\u5b66\u751f\u4fe1\u606f");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u5b66\u751f\u59d3\u540d");
        contentPane.add(label1);
        label1.setBounds(40, 50, label1.getPreferredSize().width, 30);
        contentPane.add(formattedTextField1);
        formattedTextField1.setBounds(100, 50, 120, 30);

        //---- button1 ----
        button1.setText("\u67e5\u8be2");
        button1.addActionListener(e -> Tfind(e));
        contentPane.add(button1);
        button1.setBounds(285, 50, button1.getPreferredSize().width, 30);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(30, 110, 360, 85);
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(405, 220), label2.getPreferredSize()));

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
    private JFormattedTextField formattedTextField1;
    private JButton button1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    // 根据学生姓名查询，展示学生信息
    private void Tfind(ActionEvent act){
        String uname = this.formattedTextField1.getText();
        user fuser = new user();
        fuser.setUname(uname);
        this.getData(fuser);
    }

    private void getData(user user){
        DefaultTableModel dtm = (DefaultTableModel) table1.getModel();
        dtm.setRowCount(10);
        Vector v = new Vector();
        Connection con = null;
        DbUtil db = new DbUtil();
        try {
            con = db.getCon();
            adminDao ad = new adminDao();
            ResultSet rs = ad.lists(con,user);
            while (rs.next()){
                v.add(rs.getInt("uid"));
                v.add(rs.getString("uname"));
                v.add(rs.getString("uclass"));
                v.add(rs.getString("upass"));
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
//    public static void main(String[] args) {
//        Sfind t = new Sfind();
//        t.setVisible(true);
//    }
}
