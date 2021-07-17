package com.swinglearn.demo;

import javax.swing.*;
import java.awt.*;

public class Text {
    public static void main(String[] args) {
        JFrame jf = new JFrame("Mouse");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container container = jf.getContentPane();
        jf.setSize(300,300);
        // 第 1 个 JPanel, 使用默认的浮动布局
        JPanel panel01 = new JPanel();
        panel01.setBackground(new Color(220,025,255));
        JButton jButton =new JButton("MOUSE");

        new DayforMouse(jf,jButton);
        panel01.add(jButton);
//        jf.add(jButton);
        jf.add(panel01);
        jf.setContentPane(panel01);
//        jf.pack();

        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }
}
