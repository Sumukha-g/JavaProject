package upi.management.system.controller;
import com.sun.tools.javac.Main;
import upi.management.system.View.PinView;
import upi.management.system.model.PinModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinController implements ActionListener {
    private PinView view;
    private PinModel model;
    private String pin;

    public PinController(PinView view, PinModel model, String pin) {
        this.view = view;
        this.model = model;
        this.pin = pin;

        this.view.addButton1Listener(this);
        this.view.addButton2Listener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String pin1 = view.getNewPin();
            String pin2 = view.getConfirmPin();

            if (!pin1.equals(pin2)) {
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }

            if (e.getSource() == view.b1) {
                if (pin1.equals("") || pin2.equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter both New PIN and Re-Enter New PIN");
                    return;
                }

                model.changePin(pin1, pin);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                view.setVisible(false);
                // new Main(pin);

            } else if (e.getSource() == view.b2) {
                // new Main(pin);
                view.setVisible(false);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        PinModel model = new PinModel();
        PinView view = new PinView();
        new PinController(view, model, "");
    }
}