package  upi.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {
    JLabel label1;
    JTextField textField2;
    JPasswordField passwordField2;
    JButton button1,button2,button3;
    Login(){


        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2=i1.getImage().getScaledInstance(180,100, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(350,10,100,100);
        add(image);

        ImageIcon ii1=new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));
        Image ii2=ii1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon ii3=new ImageIcon(ii2);
        JLabel image1=new JLabel(ii3);
        image1.setBounds(630,350,100,100);
        add(image1);

        label1=new JLabel("Welcome to UPI");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("AvantGarde",Font.BOLD,38));
        label1.setBounds(230,125,450,40);
        add(label1);

        textField2=new JTextField(15);
        textField2.setBounds(325,190,230,30);
        textField2.setFont(new Font("Arial",Font.BOLD,20));
        add(textField2);
        passwordField2=new JPasswordField(15);
        passwordField2.setBounds(325,250,230,30);
        passwordField2.setFont(new Font("Arial",Font.BOLD,20));
        add(passwordField2);

        button1=new JButton("Sign in");
        button1.setFont(new Font ("Arial",Font.BOLD,14));
        button1.setForeground(Color.BLUE);
        button1.setBounds(300,300,100,30);
        button1.addActionListener(this);
        add(button1);

        button2=new JButton("Clear");
        button2.setFont(new Font ("Arial",Font.BOLD,14));
        button2.setForeground(Color.BLUE);
        button2.setBounds(430,300,100,30);
        button2.addActionListener(this);
        add(button2);

        button3=new JButton("Sign up");
        button3.setFont(new Font ("Arial",Font.BOLD,14));
        button3.setForeground(Color.BLUE);
        button3.setBounds(300,350,230,30);
        button3.addActionListener(this);
        add(button3);
        // for back ground
        ImageIcon iii1=new ImageIcon(ClassLoader.getSystemResource("icon/backbg.png"));
        Image iii2=iii1.getImage().getScaledInstance(850,480, Image.SCALE_DEFAULT);
        ImageIcon iii3=new ImageIcon(iii2);
        JLabel image2=new JLabel(iii3);
        image2.setBounds(630,350,850,480);
        add(image2);


        setSize(850,480);

        setLocation(450,200);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource()==button1){

            }
            else if(e.getSource()==button2){
                textField2.setText("");
                passwordField2.setText("");
            }
            else if(e.getSource()==button3){

            }
        }catch (Exception E){
            E.printStackTrace();
        }


    }

    public static void main(String[] args) {
        new Login();

    }
}
