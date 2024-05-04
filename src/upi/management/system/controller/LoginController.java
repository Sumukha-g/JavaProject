package upi.management.system.controller;
import upi.management.system.View.*;
import upi.management.system.model.*;
import  upi.management.system.View.Signup;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




public class LoginController implements ActionListener {
    private LoginModel loginModel;
    private LoginView loginView;
    private SignupModel signupModel;
    private Signup signupView;

    public LoginController(LoginModel loginModel, LoginView loginView, SignupModel signupModel, Signup signupView) {
        this.loginModel = loginModel;
        this.loginView = loginView;
        this.signupModel = signupModel;
        this.signupView = signupView;

        // Attach action listeners to login view buttons
        loginView.getButton1().addActionListener(this);
        loginView.getButton2().addActionListener(this);
        loginView.getButton3().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginView.getButton1()) {
            // Authenticate user using loginModel
            String cardNumber = loginView.getTextField2().getText();
            String pin = new String(loginView.getPasswordField3().getPassword());

            if (loginModel.authenticateUser(cardNumber, pin)) {
                // If authentication successful, hide login view and show main view
                loginView.setVisible(false);
                String phono=loginModel.getPhoneNumber(cardNumber);
                MainView mainView = new MainView(phono);
                MainModel mainModel=new MainModel(phono);
                MainController mainController=new MainController(mainView,mainModel,phono);
                loginView.setVisible(false);
                mainView.setVisible(true);// Assuming main view requires PIN
                // Create MainController if necessary
            } else {
                // Show error message for incorrect credentials
                JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
            }
        } else if (e.getSource() == loginView.getButton2()) {
            // Clear login form
            loginView.getTextField2().setText("");
            loginView.getPasswordField3().setText("");
        } else if (e.getSource() == loginView.getButton3()) {
            // Redirect to signup view using SignupController
            SignupController signupController = new SignupController(signupModel, signupView);
            loginView.setVisible(false);
            signupView.setVisible(true);
        }
    }
    public static void main(String[] args) {
        // Create models
        LoginModel loginModel = new LoginModel();
        SignupModel signupModel = new SignupModel();

        // Create views
        LoginView loginView = new LoginView();
        Signup signupView = new Signup();

        // Create controllers
        LoginController loginController = new LoginController(loginModel, loginView, signupModel, signupView);

        // Make login view visible
        loginView.setVisible(true);
    }

}
