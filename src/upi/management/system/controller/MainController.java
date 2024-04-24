package upi.management.system.controller;
import upi.management.system.model.MainModel;
import  upi.management.system.View.MainView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainController /*implements ActionListener*/ {
    private MainModel model;
    private MainView view;

    public MainController(MainModel model, MainView view) {
        this.model = model;
        this.view = view;
/*
        // Attach event listeners to buttons in the view
        view.getB1().addActionListener(this);
        view.getB2().addActionListener(this);
        view.getB3().addActionListener(this);
        view.getB4().addActionListener(this);
        view.getB5().addActionListener(this);
        view.getB6().addActionListener(this);
        view.getB7().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getB1()) {
            new Deposit(model.getPin());
            view.setVisible(false);
        } else if (e.getSource() == view.getB2()) {
            new Withdrawal(model.getPin());
            view.setVisible(false);
        } else if (e.getSource() == view.getB3()) {
            new FastCash(model.getPin());
            view.setVisible(false);
        } else if (e.getSource() == view.getB4()) {
            new MiniStatement(model.getPin());
            view.setVisible(false);
        } else if (e.getSource() == view.getB5()) {
            new PinChange(model.getPin());
            view.setVisible(false);
        } else if (e.getSource() == view.getB6()) {
            new BalanceEnquiry(model.getPin());
            view.setVisible(false);
        } else if (e.getSource() == view.getB7()) {
            System.exit(0);
        }*/
    }
}
