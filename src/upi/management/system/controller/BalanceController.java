package upi.management.system.controller;

//package upi.management.system;

import upi.management.system.View.BalanceView;
import upi.management.system.View.MainView;
import upi.management.system.model.BalanceModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BalanceController {
    private BalanceView view;
    private BalanceModel model;
    private String pin;

    public BalanceController(String pin) {
        this.pin = pin;
        view = new BalanceView(0);
        model = new BalanceModel(pin);
        updateBalance();
        view.setBackListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setVisible(false);
                new MainView(pin);
            }
        });
    }

    private void updateBalance() {
        int balance = model.getBalance();
        view.label2.setText(String.valueOf(balance));
    }

    public static void main(String[] args) {
        new BalanceController("");
    }
}