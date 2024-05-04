package upi.management.system.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class MainView extends JFrame {
    private JButton b1, b2, b3, b4, b5, b6, b7;

    public MainView(String phono) {
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1550, 830);
        add(l3);

        JLabel label = new JLabel("Please Select Your Transaction");
        label.setBounds(430, 180, 700, 35);
        label.setForeground(Color.BLACK);
        label.setFont(new Font("System", Font.BOLD, 28));
        l3.add(label);

        b1 = new JButton("Self transfer");
        b1.setForeground(Color.BLACK);
        b1.setBackground(new Color(65, 125, 128));
        b1.setBounds(410, 274, 150, 35);
        l3.add(b1);

        b2 = new JButton("Bills");
        b2.setForeground(Color.BLACK);
        b2.setBackground(new Color(65, 125, 128));
        b2.setBounds(700, 274, 150, 35);
        l3.add(b2);

        b3 = new JButton("Payments");
        b3.setForeground(Color.BLACK);
        b3.setBackground(new Color(65, 125, 128));
        b3.setBounds(410, 318, 150, 35);
        l3.add(b3);

        b4 = new JButton("Transaction history");
        b4.setForeground(Color.BLACK);
        b4.setBackground(new Color(65, 125, 128));
        b4.setBounds(700, 318, 150, 35);
        l3.add(b4);

        b5 = new JButton("PIN CHANGE");
        b5.setForeground(Color.BLACK);
        b5.setBackground(new Color(65, 125, 128));
        b5.setBounds(410, 362, 150, 35);
        l3.add(b5);

        b6 = new JButton("BALANCE ENQUIRY");
        b6.setForeground(Color.BLACK);
        b6.setBackground(new Color(65, 125, 128));
        b6.setBounds(700, 362, 150, 35);
        l3.add(b6);

        b7 = new JButton("EXIT");
        b7.setForeground(Color.BLACK);
        b7.setBackground(new Color(65, 125, 128));
        b7.setBounds(700, 406, 150, 35);
        l3.add(b7);

        setLayout(null);
        setSize(1550, 1080);
        setLocation(0, 0);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JButton getB1() {
        return b1;
    }

    public String getB2() {
        return b2.getText();
    }

    public String getB3() {
        return b3.getText();
    }

    public String getB4() {
        return b4.getText();
    }

    public String getB5() {
        return b5.getText();
    }

    public String getB6() {
        return b6.getText();
    }

    public String getB7() {
        return b7.getText();
    }

    public void addActionListenerToButtons(ActionListener listener) {
        b1.addActionListener(listener);
        b2.addActionListener(listener);
        b3.addActionListener(listener);
        b4.addActionListener(listener);
        b5.addActionListener(listener);
        b6.addActionListener(listener);
        b7.addActionListener(listener);
    }
}
