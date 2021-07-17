package ui;

import util.CheckHandler;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class OrderShowDialog extends JDialog {
    public OrderShowDialog(String orderData){
        initUI(orderData);
    }

    private void initUI(String orderData) {
        setTitle("查看订单详情");
        setResizable(false);
        Container contentPane =getContentPane();

        setSize(400,400);
        JPanel dialogpane =new JPanel(new BorderLayout());
        dialogpane.setBorder(new EmptyBorder(20,20,20,20));
        JLabel jLabel =new JLabel();
        jLabel.setText(CheckHandler.showOrder(orderData));
        jLabel.setVerticalAlignment(SwingConstants.TOP);
        jLabel.setPreferredSize(new Dimension(350,350));
        dialogpane.add(jLabel);
        contentPane.add(dialogpane,BorderLayout.CENTER);
        setResizable(false);
        setLocationRelativeTo(getOwner());
        setVisible(true);


    }


}
