package com.artisan.view.teacher;

import com.artisan.view.teacher.records.Radd2;
import com.artisan.view.teacher.records.Ralter;
import com.artisan.view.teacher.records.Rcount;
import com.artisan.view.teacher.records.Rfind;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
/*
 * Created by JFormDesigner on Wed Oct 12 16:44:33 CST 2022
 */



/**
 * @author 1
 */
public class Tmain extends JFrame {
    public Tmain() {
        initComponents();
    }

    private void TaddButton(ActionEvent e) {
        // TODO add your code here
    }

    private void TfindButton(ActionEvent e) {
        // TODO add your code here
    }

    private void TalterButton(ActionEvent e) {
        // TODO add your code here
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        button1 = new JButton();
        button3 = new JButton();
        button2 = new JButton();
        button4 = new JButton();
        label1 = new JLabel();

        //======== this ========
        setTitle("\u5b66\u751f\u8003\u52e4\u7cfb\u7edf-\u6559\u5e08\u7aef");
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

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("\u8003\u52e4\u4fe1\u606f\u7ba1\u7406");

                //---- button1 ----
                button1.setText("\u6dfb\u52a0");
                button1.addActionListener(e -> {
			TaddButton(e);
			RaddButton(e);
		});
                menu1.add(button1);

                //---- button3 ----
                button3.setText("\u4fee\u6539");
                button3.addActionListener(e -> {
			TalterButton(e);
			RfindButton(e);
			RalterButton(e);
		});
                menu1.add(button3);

                //---- button2 ----
                button2.setText("\u67e5\u8be2");
                button2.addActionListener(e -> button2(e));
                menu1.add(button2);

                //---- button4 ----
                button4.setText("\u7edf\u8ba1");
                button4.addActionListener(e -> button4(e));
                menu1.add(button4);
            }
            menuBar1.add(menu1);
        }
        setJMenuBar(menuBar1);

        //---- label1 ----
        label1.setText("\u6b22\u8fce\u4f7f\u7528\u5b66\u751f\u8003\u52e4\u7cfb\u7edf\u2014\u2014\u6559\u5e08\u7aef");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 5f));
        contentPane.add(label1, "cell 5 1,aligny top,grow 100 0");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JButton button1;
    private JButton button3;
    private JButton button2;
    private JButton button4;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    private void RaddButton(ActionEvent event){Radd2 r = new Radd2();r.setVisible(true);}

    private void RalterButton(ActionEvent event){Ralter r = new Ralter();r.setVisible(true);}

    private void button2(ActionEvent event){Rfind r = new Rfind();r.setVisible(true);}

    private void button4(ActionEvent event){Rcount r = new Rcount();r.setVisible(true);}

    private void RfindButton(ActionEvent event){}

//    public static void main(String[] args) {Tmain t = new Tmain();t.setVisible(true);}
}
