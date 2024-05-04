package upi.management.system.controller;
import upi.management.system.View.MainView;
import  upi.management.system.View.SelfTransferView;
import upi.management.system.model.MainModel;
import upi.management.system.model.SelfTransferModel;
import  upi.management.system.SessionData;

import java.awt.event.ActionListener;


import upi.management.system.View.MainView;
import upi.management.system.View.SelfTransferView;
import upi.management.system.model.SelfTransferModel;
import upi.management.system.SessionData;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelfTransferController implements ActionListener {
    private SelfTransferView view;
    private SelfTransferModel model;
    private MainController mainController;

    public SelfTransferController(SelfTransferView view, SelfTransferModel model) {
        this.model = model;
        this.view = view;

        // Attach event listeners to buttons in the view
        view.getSubmitButton().addActionListener(this);
        view.getBackButton().addActionListener(this);

        // Set the phone number in the session data
        SessionData.getInstance().setPhoneNumber(model.getPhoneNumber());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getSubmitButton()) {
            // Handle submit button action
            // Retrieve form data from the view
            String phoneNumber = view.getPhoneNumber();

            // Update the model with form data
            model.setPhoneNumber(phoneNumber);

            // Perform any additional processing for submit button action
            // For example, validation or database operations
        } else if (e.getSource() == view.getBackButton()) {
            // Handle back button action
            // Close the current view and go back to the main view
            view.dispose();
            view.setVisible(false);
            mainController.showMainView();
        }
    }

    public void showSelfTransferView() {
        view.setVisible(true);
    }

    // Method to fetch UPI IDs and update the view
    public void fetchUPIIDs(String phoneNumber) {
        model.getUPIIDs(phoneNumber, upiids -> {
            // Update the view with the fetched UPI IDs
            view.setUPIIDs(upiids);
        });
    }

    public static void main(String[] args) {
        // Create instances of views, models, and controllers
        SelfTransferView selfTransferView = new SelfTransferView();
        SelfTransferModel selfTransferModel = new SelfTransferModel(SessionData.getInstance().getPhoneNumber());
        // Create an instance of SelfTransferController
        SelfTransferController selfTransferController = new SelfTransferController(selfTransferView, selfTransferModel);

        // Show the self transfer view
        selfTransferController.showSelfTransferView();
    }
}
