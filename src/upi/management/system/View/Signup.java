package upi.management.system.View;

import com.toedter.calendar.JDateChooser;
import upi.management.system.controller.SignupController;
import upi.management.system.model.SignupModel;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Signup extends JFrame {
    JRadioButton r1, r2, m1, m2, m3;
    JButton next;

    JTextField textuname, textpin, textphono, textfname, textaddr, textbank;
    JDateChooser dateChooser;
    Random ran = new Random();
    long first4 = (ran.nextLong() % 9000L) + 1000L;
    String first = " " + Math.abs(first4);

    public Signup() {
        super("APPLICATION FORM");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(25, 10, 100, 100);
        add(image);

        JLabel label1 = new JLabel("Sign up Details");
        label1.setBounds(160, 20, 600, 40);
        label1.setFont(new Font("Raleway", Font.BOLD, 38));
        add(label1);

        JLabel label2 = new JLabel("Page 1");
        label2.setFont(new Font("Ralway", Font.BOLD, 22));
        label2.setBounds(330, 70, 600, 30);
        add(label2);

        JLabel label3 = new JLabel("Personal Details");
        label3.setFont(new Font("Raleway", Font.BOLD, 22));
        label3.setBounds(290, 90, 600, 30);
        add(label3);

        JLabel labelName = new JLabel("User name");
        labelName.setFont(new Font("Raleway", Font.BOLD, 20));
        labelName.setBounds(100, 190, 200, 30);
        add(labelName);

        textuname = new JTextField();
        textuname.setFont(new Font("Raleway", Font.BOLD, 14));
        textuname.setBounds(300, 190, 400, 30);
        add(textuname);

        JLabel labelfName = new JLabel("Pin");
        labelfName.setFont(new Font("Raleway", Font.BOLD, 20));
        labelfName.setBounds(100, 240, 200, 30);
        add(labelfName);

        textpin = new JTextField();
        textpin.setFont(new Font("Raleway", Font.BOLD, 14));
        textpin.setBounds(300, 240, 400, 30);
        add(textpin);

        JLabel phone = new JLabel("Phone number");
        phone.setFont(new Font("Raleway", Font.BOLD, 20));
        phone.setBounds(100, 290, 200, 30);
        add(phone);

        textphono = new JTextField();
        textphono.setFont(new Font("Raleway", Font.BOLD, 14));
        textphono.setBounds(300, 290, 400, 30);
        add(textphono);

        JLabel lbank = new JLabel("Bank Name");
        lbank.setFont(new Font("Raleway", Font.BOLD, 20));
        lbank.setBounds(100, 340, 200, 30);
        add(lbank);

        textbank = new JTextField();
        textbank.setFont(new Font("Raleway", Font.BOLD, 14));
        textbank.setBounds(300, 340, 400, 30);
        add(textbank);

        JLabel lfname = new JLabel("full name");
        lfname.setFont(new Font("Raleway", Font.BOLD, 20));
        lfname.setBounds(100, 390, 200, 30);
        add(lfname);

        textfname = new JTextField();
        textfname.setFont(new Font("Raleway", Font.BOLD, 14));
        textfname.setBounds(300, 390, 400, 30);
        add(textfname);


        JLabel labelEmail = new JLabel("DOB");
        labelEmail.setFont(new Font("Raleway", Font.BOLD, 20));
        labelEmail.setBounds(100, 440, 200, 30);
        add(labelEmail);

        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105, 105, 105));
        dateChooser.setBounds(300, 440, 400, 30);
        add(dateChooser);


        JLabel labelMs = new JLabel("Address");
        labelMs.setFont(new Font("Raleway", Font.BOLD, 20));
        labelMs.setBounds(100, 490, 200, 30);
        add(labelMs);

        textaddr = new JTextField();
        textaddr.setFont(new Font("Raleway", Font.BOLD, 14));
        textaddr.setBounds(300, 490, 400, 30);
        add(textaddr);

        next = new JButton("Next"); // Instantiate next button
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(620, 710, 80, 30);
        add(next);

        getContentPane().setBackground(new Color(222, 255, 228));
        setLayout(null);
        setSize(850, 800);
        setLocation(360, 40);

        SignupModel model = new SignupModel();
        Signup view = this; // Pass the Signup instance to the controller
        MainView mainClass = new MainView("ok");
        SignupController controller = new SignupController(model, view);

    }
    public String getUsername() {
        return textuname.getText();
    }

    public String getPin() {
        return textpin.getText();
    }

    public String getPhono() {
        return textphono.getText();
    }

    public String getBankname() {
        return textbank.getText();
    }

    public String getFullname() {
        return textfname.getText();
    }

    public String getDob() {
        return ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
    }

    public String getAddress() {
        return textaddr.getText();
    }

    public JButton getNextButton() {
        return next;
    }

    public static void main(String[] args) {
            Signup view = new Signup();
            view.setVisible(true);
        }
}