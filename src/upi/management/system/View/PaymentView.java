package upi.management.system.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentView extends JFrame {
    private JRadioButton waterBill, electricityBill, gasBill;
    private JTextField  textAmount;
    private JButton payButton;
    public PaymentView(){
        super("Payment System");

        JLabel label1 = new JLabel("Select Bill Type");
        label1.setFont(new Font("Raleway", Font.BOLD, 20));
        label1.setBounds(50, 30, 200, 30);
        add(label1);

        waterBill = new JRadioButton("Water Bill");
        waterBill.setFont(new Font("Raleway", Font.PLAIN, 16));
        waterBill.setBounds(50, 80, 150, 30);
        add(waterBill);

        electricityBill = new JRadioButton("Electricity Bill");
        electricityBill.setFont(new Font("Raleway", Font.PLAIN, 16));
        electricityBill.setBounds(50, 120, 150, 30);
        add(electricityBill);

        gasBill = new JRadioButton("Gas Bill");
        gasBill.setFont(new Font("Raleway", Font.PLAIN, 16));
        gasBill.setBounds(50, 160, 150, 30);
        add(gasBill);

        ButtonGroup billGroup = new ButtonGroup();
        billGroup.add(waterBill);
        billGroup.add(electricityBill);
        billGroup.add(gasBill);

        JLabel label3 = new JLabel("Enter Amount");
        label3.setFont(new Font("Raleway", Font.BOLD, 20));
        label3.setBounds(50, 320, 200, 30);
        add(label3);

        textAmount = new JTextField();
        textAmount.setFont(new Font("Raleway", Font.PLAIN, 16));
        textAmount.setBounds(50, 370, 300, 30);
        add(textAmount);

        payButton = new JButton("Pay");
        payButton.setFont(new Font("Raleway", Font.BOLD, 16));
        payButton.setBounds(150, 430, 100, 30);
        add(payButton);

        getContentPane().setBackground(new Color(222, 255, 228));
        setLayout(null);
        setSize(400, 550);
        setLocation(360, 40);

        setVisible(true);
    }

    public String getSelectedBillType() {
        if (waterBill.isSelected()) {
            return "Water";
        } else if (electricityBill.isSelected()) {
            return "Electricity";
        } else if (gasBill.isSelected()) {
            return "Gas";
        } else {
            return "";
        }
    }

    public double getAmount() {
        return Double.parseDouble(textAmount.getText());
    }

    public void addPayButtonListener(ActionListener listener) {
        payButton.addActionListener(listener);
    }
}