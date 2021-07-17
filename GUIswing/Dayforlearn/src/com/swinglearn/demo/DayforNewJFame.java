package com.swinglearn.demo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DayforNewJFame {
    public static void main(String[] args) {
        new DayforNewJFame();
    }

    public static void show(JFrame jf){
        jf.setVisible(false);
        JFrame jf2= new JFrame("新窗口");
        JPanel jp=new JPanel();
        JLabel jl = new JLabel("新创了");
        JButton jb = new JButton("返回");
        jb.setBounds(10,10,50,50);
        jb.setAlignmentX(10);




        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jf.setVisible(true);
                jf2.setVisible(false);
            }
        });
        jp.add(jb);
        jp.add(jl);
        jf2.add(jp);
        jf2.setVisible(true);
        jf2.setBounds(40,40,200,300);
        jf2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public DayforNewJFame(){
        JFrame jf = new JFrame("创建窗口");
        JPanel jp = new JPanel();
        JButton jButton = new JButton("new JFAME");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                show(jf);
            }
        });

        jButton.setBounds(100,100,50,100);
        jp.add(jButton);
        jf.add(jp);
        jf.setBounds(20,20,500,600);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
