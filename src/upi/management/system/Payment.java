package upi.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Payment extends JFrame {
    JRadioButton waterBill, electricityBill, gasBill;
    JTextField textAccountNumber, textAmount;
    JButton payButton;

    public Payment() {
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

        JLabel label2 = new JLabel("Enter Account Number");
        label2.setFont(new Font("Raleway", Font.BOLD, 20));
        label2.setBounds(50, 220, 250, 30);
        add(label2);

        textAccountNumber = new JTextField();
        textAccountNumber.setFont(new Font("Raleway", Font.PLAIN, 16));
        textAccountNumber.setBounds(50, 270, 300, 30);
        add(textAccountNumber);

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

        // Action listener for the Pay button
        payButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String billType = "";
                if (waterBill.isSelected()) {
                    billType = "Water";
                } else if (electricityBill.isSelected()) {
                    billType = "Electricity";
                } else if (gasBill.isSelected()) {
                    billType = "Gas";
                }

                String accountNumber = textAccountNumber.getText();
                double amount = Double.parseDouble(textAmount.getText());

                // Implement payment logic here, e.g., connecting to a database and making the transaction
                // For simplicity, we'll just print the details for now
                System.out.println("Bill Type: " + billType);
                System.out.println("Account Number: " + accountNumber);
                System.out.println("Amount: " + amount);
            }
        });
    }

    public static void main(String[] args) {
        new Payment();
    }
}
