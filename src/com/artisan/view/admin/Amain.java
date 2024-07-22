package com.artisan.view.admin;

import javax.swing.*;

import com.artisan.view.admin.course.Cadd;
import com.artisan.view.admin.course.Calter;
import com.artisan.view.admin.course.Cfind;
import com.artisan.view.admin.student.Sadd;
import com.artisan.view.admin.student.Salter;
import com.artisan.view.admin.student.Sfind;
import com.artisan.view.admin.teacher.Tadd;
import com.artisan.view.admin.teacher.Talter;
import com.artisan.view.admin.teacher.Tfind;
import net.miginfocom.swing.*;

import java.awt.event.ActionEvent;
/*
 * Created by JFormDesigner on Wed Oct 12 16:44:33 CST 2022
 */



/**
 * @author 1
 */
public class Amain extends JFrame {
    public Amain() {
        initComponents();
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        menuBar2 = new JMenuBar();
        menu6 = new JMenu();
        button8 = new JButton();
        button9 = new JButton();
        button10 = new JButton();
        menu2 = new JMenu();
        button4 = new JButton();
        button5 = new JButton();
        button6 = new JButton();
        label1 = new JLabel();

        //======== this ========
        setTitle("\u5b66\u751f\u8003\u52e4\u7cfb\u7edf-\u7ba1\u7406\u5458\u7aef");
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
                menu1.setText("\u6559\u5e08\u4fe1\u606f\u7ba1\u7406");

                //---- button1 ----
                button1.setText("      \u6dfb\u52a0      ");
                button1.addActionListener(e -> TaddButton(e));
                menu1.add(button1);

                //---- button2 ----
                button2.setText("      \u67e5\u8be2      ");
                button2.addActionListener(e -> TfindButton(e));
                menu1.add(button2);

                //---- button3 ----
                button3.setText("\u4fee\u6539  / \u5220\u9664");
                button3.addActionListener(e -> TalterButton(e));
                menu1.add(button3);
            }
            menuBar1.add(menu1);

            //======== menuBar2 ========
            {

                //======== menu6 ========
                {
                    menu6.setText("\u5b66\u751f\u4fe1\u606f\u7ba1\u7406");

                    //---- button8 ----
                    button8.setText("      \u6dfb\u52a0     ");
                    button8.addActionListener(e -> SaddButton(e));
                    menu6.add(button8);

                    //---- button9 ----
                    button9.setText("      \u67e5\u8be2     ");
                    button9.addActionListener(e -> SfindButton(e));
                    menu6.add(button9);

                    //---- button10 ----
                    button10.setText("\u4fee\u6539 / \u5220\u9664");
                    button10.addActionListener(e -> SalterButton(e));
                    menu6.add(button10);
                }
                menuBar2.add(menu6);
            }
            menuBar1.add(menuBar2);

            //======== menu2 ========
            {
                menu2.setText("\u8bfe\u7a0b\u4fe1\u606f\u7ba1\u7406");

                //---- button4 ----
                button4.setText("\u6dfb\u52a0");
                button4.addActionListener(e -> button4(e));
                menu2.add(button4);

                //---- button5 ----
                button5.setText("\u67e5\u8be2");
                button5.addActionListener(e -> button5(e));
                menu2.add(button5);

                //---- button6 ----
                button6.setText("\u5220\u9664");
                button6.addActionListener(e -> button6(e));
                menu2.add(button6);
            }
            menuBar1.add(menu2);
        }
        setJMenuBar(menuBar1);

        //---- label1 ----
        label1.setText("\u6b22\u8fce\u4f7f\u7528\u5b66\u751f\u8003\u52e4\u7cfb\u7edf\u2014\u2014\u7ba1\u7406\u5458\u7aef");
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
    private JButton button2;
    private JButton button3;
    private JMenuBar menuBar2;
    private JMenu menu6;
    private JButton button8;
    private JButton button9;
    private JButton button10;
    private JMenu menu2;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    private void TaddButton(ActionEvent event){
        new Tadd().setVisible(true);
    }

    private void TalterButton(ActionEvent event){
        new Talter().setVisible(true);
    }

    private void TfindButton(ActionEvent event){
        new Tfind().setVisible(true);
    }

    private void SaddButton(ActionEvent event){new Sadd().setVisible(true);}

    private void SalterButton(ActionEvent event){new Salter().setVisible(true);}

    private void SfindButton(ActionEvent event){new Sfind().setVisible(true);}

    private void button4(ActionEvent evt){new Cadd().setVisible(true);}

    private void button5(ActionEvent evt){new Cfind().setVisible(true);}

    private void button6(ActionEvent evt){new Calter().setVisible(true);}

//    public static void main(String[] args) {
//        Amain a = new Amain();
//        a.setVisible(true);
//    }

}
