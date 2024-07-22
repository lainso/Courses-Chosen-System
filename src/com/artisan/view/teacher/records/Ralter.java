/*
 * Created by JFormDesigner on Tue Oct 18 08:09:03 CST 2022
 */

package com.artisan.view.teacher.records;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.artisan.Controller.dao.teacherDao;
import com.artisan.model.records;
import com.artisan.util.DbUtil;
import com.artisan.util.StringUtil;

/**
 * @author a
 */
public class Ralter extends JFrame {
    public Ralter() {
        initComponents();
        table1.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"考勤记录id","课程名","学生学号","学生班级","学生姓名","考勤时间","考勤状态"}
        ));
        this.getData(new records());
        textField3.setEditable(false);
        textPane1.setEditable(false);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        textField1 = new JTextField();
        label5 = new JLabel();
        textField5 = new JTextField();
        label3 = new JLabel();
        textField3 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        label4 = new JLabel();
        textField4 = new JTextField();
        button1 = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        scrollPane2 = new JScrollPane();
        textPane1 = new JTextPane();
        label6 = new JLabel();

        //======== this ========
        setTitle("\u8003\u52e4\u4fe1\u606f\u4fee\u6539");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u5b66\u751f\u5b66\u53f7");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 3f));
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(35, 25), label1.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(110, 20, 158, textField1.getPreferredSize().height);

        //---- label5 ----
        label5.setText("\u8003\u52e4\u72b6\u6001");
        label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 3f));
        contentPane.add(label5);
        label5.setBounds(new Rectangle(new Point(315, 25), label5.getPreferredSize()));
        contentPane.add(textField5);
        textField5.setBounds(395, 20, 158, textField5.getPreferredSize().height);

        //---- label3 ----
        label3.setText("\u8003\u52e4\u8bb0\u5f55id");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 3f));
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(575, 25), label3.getPreferredSize()));
        contentPane.add(textField3);
        textField3.setBounds(665, 20, 85, textField3.getPreferredSize().height);

        //---- label2 ----
        label2.setText("\u8bfe\u7a0b\u540d\u5b57");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 3f));
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(35, 85), label2.getPreferredSize()));
        contentPane.add(textField2);
        textField2.setBounds(110, 80, 158, textField2.getPreferredSize().height);

        //---- label4 ----
        label4.setText("\u8003\u52e4\u65f6\u95f4");
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 3f));
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(315, 85), label4.getPreferredSize()));
        contentPane.add(textField4);
        textField4.setBounds(395, 80, 158, textField4.getPreferredSize().height);

        //---- button1 ----
        button1.setText("\u4fee\u6539");
        button1.addActionListener(e -> button1(e));
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(585, 80), button1.getPreferredSize()));

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    clicked(e);
                }
            });
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(30, 150, 742, 140);

        //======== scrollPane2 ========
        {

            //---- textPane1 ----
            textPane1.setText("\u63d0\u793a\uff1a\u9009\u4e2d\u8868\u683c\u6570\u636e\u53ef\u81ea\u52a8\u586b\u5145");
            scrollPane2.setViewportView(textPane1);
        }
        contentPane.add(scrollPane2);
        scrollPane2.setBounds(670, 75, 115, 45);
        contentPane.add(label6);
        label6.setBounds(775, 300, label6.getPreferredSize().width, 0);

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
    private JLabel label5;
    private JTextField textField5;
    private JLabel label3;
    private JTextField textField3;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label4;
    private JTextField textField4;
    private JButton button1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JScrollPane scrollPane2;
    private JTextPane textPane1;
    private JLabel label6;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    private void getData(records rd){
        DefaultTableModel dtm = (DefaultTableModel) table1.getModel();
        dtm.setRowCount(25);
        Vector v = new Vector();
        Connection con = null;
        DbUtil db = new DbUtil();
        try {
            con = db.getCon();
            teacherDao td = new teacherDao();
            ResultSet rs = td.list2(con, rd);
            while (rs.next()){
                v.add(rs.getInt("rid"));
                v.add(rs.getString("cname"));
                v.add(rs.getInt("uid"));
                v.add(rs.getString("uclass"));
                v.add(rs.getString("uname"));
                v.add(rs.getString("rtime"));
                v.add(rs.getString("rcondition"));
            }
            for (int row=0; row<(v.toArray().length)/7; row++){
                for (int col = 0; col<7; col++){
                    dtm.setValueAt(v.get(7*row+col),row,col);
                }
            }
        }catch (Exception e){e.printStackTrace();}
        finally {try {db.closeCon(con);}
        catch (Exception e){e.printStackTrace();}}
    }

    private void button1(ActionEvent evt){
        int rid = Integer.parseInt(this.textField3.getText());
        int uid = Integer.parseInt(this.textField1.getText());
        String canme = this.textField2.getText();
        String rtime = this.textField4.getText();
        String rcondition = this.textField5.getText();
        if(StringUtil.IisEmpty(uid)){JOptionPane.showMessageDialog(null,"学生学号不能为空");}
        if(StringUtil.isEmpty(canme)){JOptionPane.showMessageDialog(null,"课程名字不能为空");}
        if(StringUtil.isEmpty(rtime)){JOptionPane.showMessageDialog(null,"考勤时间不能为空");}
        if(StringUtil.isEmpty(rcondition)){JOptionPane.showMessageDialog(null,"考勤状态不能为空");}

        records records = new records(rid,canme,uid,rtime,rcondition);
        Connection con = null;
        DbUtil db = new DbUtil();
        teacherDao td = new teacherDao();
        try {
            con = db.getCon();
            int n = td.update(con,records);
            if(n==1){
                JOptionPane.showMessageDialog(null,"考勤信息修改成功");
                this.getData(new records());
                resetValue();
            }else {JOptionPane.showMessageDialog(null,"考勤记录修改失败");}
        }catch (Exception e){e.printStackTrace();}
        finally {
            try {
                db.closeCon(con);
            }catch (Exception e){e.printStackTrace();}
        }
    }

    private void resetValue() {
        this.textField1.setText("");
        this.textField2.setText("");
        this.textField3.setText("");
        this.textField4.setText("");
        this.textField5.setText("");
    }

    private void clicked(MouseEvent met){
        int row = this.table1.getSelectedRow();
        this.textField1.setText(String.valueOf (table1.getValueAt(row,2)));
        this.textField2.setText((String) table1.getValueAt(row,1));
        this.textField3.setText(String.valueOf (table1.getValueAt(row,0)));
        this.textField4.setText((String) table1.getValueAt(row,5));
        this.textField5.setText((String) table1.getValueAt(row,6));
    }


//    public static void main(String[] args) {
//        Ralter r = new Ralter();
//        r.setVisible(true);
//    }
}
