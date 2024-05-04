package upi.management.system.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PinView extends JFrame {
    public JButton b1, b2;
    private JPasswordField p1, p2;

    public PinView() {
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);

        JLabel label1 = new JLabel("CHANGE YOUR PIN");
        label1.setForeground(Color.BLACK);
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(430,180,400,35);
        l3.add(label1);


        JLabel label2 = new JLabel("New PIN: ");
        label2.setForeground(Color.BLACK);
        label2.setFont(new Font("System", Font.BOLD, 16));
        label2.setBounds(430,220,150,35);
        l3.add(label2);

        p1 = new JPasswordField();
        p1.setBackground(new Color(65,125,128));
        p1.setForeground(Color.BLACK);
        p1.setBounds(600,220,180,25);
        p1.setFont(new Font("Raleway", Font.BOLD,22));
        l3.add(p1);

        JLabel label3 = new JLabel("Re-Enter New PIN: ");
        label3.setForeground(Color.BLACK);
        label3.setFont(new Font("System", Font.BOLD, 16));
        label3.setBounds(430,250,400,35);
        l3.add(label3);

        p2 = new JPasswordField();
        p2.setBackground(new Color(65,125,128));
        p2.setForeground(Color.BLACK);
        p2.setBounds(600,255,180,25);
        p2.setFont(new Font("Raleway", Font.BOLD,22));
        l3.add(p2);



        b1 = new JButton("CHANGE");
        b1.setBounds(700,362,150,35);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.BLACK);

        l3.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(700,406,150,35);
        b2.setBackground(new Color(65,125,128));
        b2.setForeground(Color.BLACK);

        l3.add(b2);



        setSize(1550, 1080);
        setLayout(null);
        setLocation(0, 0);
        setVisible(true);
    }

    public String getNewPin() {
        return new String(p1.getPassword());
    }

    public String getConfirmPin() {
        return new String(p2.getPassword());
    }

    public void addButton1Listener(ActionListener listener) {
        b1.addActionListener(listener);
    }

    public void addButton2Listener(ActionListener listener) {
        b2.addActionListener(listener);
    }


}