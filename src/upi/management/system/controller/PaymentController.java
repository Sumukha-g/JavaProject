package upi.management.system.controller;
import upi.management.system.model.PaymentModel;
import upi.management.system.View.PaymentView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class PaymentController {
    private PaymentModel model;
    private PaymentView view;

    public PaymentController(PaymentModel model, PaymentView view) {
        this.model = model;
        this.view = view;

        // Register action listener for the Pay button
        view.addPayButtonListener(new PayButtonListener());
    }
    class PayButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String billType = view.getSelectedBillType();
            double amount = view.getAmount();

            if (billType.isEmpty()) {
                // Display an error message if no bill type is selected
                JOptionPane.showMessageDialog(view, "Please select a bill type.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Create a map to hold payment details
            Map<String, Object> paymentDetails = new HashMap<>();
            paymentDetails.put("billType", billType);
            paymentDetails.put("amount", amount);

            // Call the makePayment method of the model
            boolean paymentSuccessful = model.makePayment(paymentDetails);

            // Display a success or failure message based on the payment result
            if (paymentSuccessful) {
                JOptionPane.showMessageDialog(view, "Payment successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(view, "Payment failed. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        PaymentModel model = new PaymentModel();
        PaymentView view = new PaymentView();
        PaymentController controller = new PaymentController(model, view);

        // Set up JFrame properties
        view.setSize(400, 550);
        view.setLocationRelativeTo(null); // Center the window
        view.setVisible(true);
    }
}
