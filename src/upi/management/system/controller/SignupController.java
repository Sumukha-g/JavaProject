package upi.management.system.controller;
import  upi.management.system.View.MainView;
import upi.management.system.model.SignupModel;
import upi.management.system.View.Signup;
import  upi.management.system.SessionData;
import upi.management.system.Connn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class SignupController implements ActionListener {
    private SignupModel model;
    private Signup view;

    public SignupController(SignupModel model, Signup view) {
        this.model = model;
        this.view = view;

        // Attach event listener to the next button in the view
        view.getNextButton().addActionListener(this);
        SessionData.getInstance().setPhoneNumber(model.getPhono());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Get form data from the view
        String username = view.getUsername();
        String pin = view.getPin();
        String phono = view.getPhono();
        String bankname = view.getBankname();
        String fname = view.getFullname();
        String dob = view.getDob();
        String address = view.getAddress();

        // Update the model with form data
        model.setUsername(username);
        model.setPin(pin);
        model.setPhono(phono);
        model.setBankname(bankname);
        model.setFullName(fname);
        model.setDob(dob);
        model.setAddress(address);

        if (username.isEmpty() || pin.isEmpty() || phono.isEmpty() || bankname.isEmpty() || fname.isEmpty() || dob.isEmpty() || address.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Fill all the fields");
        } else {
            try {
                Connn c = new Connn();
                String upiid = username + "@ok_" + bankname;
                String insertQuery = "INSERT INTO signupc VALUES ('" + username + "', '" + pin + "', '" + phono + "', '" + bankname + "', '" + fname + "', '" + dob + "', '" + address + "', '" + upiid + "')";
                c.statement.executeUpdate(insertQuery);
                new MainView(model.getPhono());
                view.setVisible(false);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        // Create model
        SignupModel signupModel = new SignupModel();

        // Create view
        Signup signupView = new Signup();

        // Create controller
        SignupController signupController = new SignupController(signupModel, signupView);

        // Make signup view visible
        signupView.setVisible(true);
    }
}

