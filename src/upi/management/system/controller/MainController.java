package upi.management.system.controller;
import upi.management.system.View.*;
import upi.management.system.model.*;
import upi.management.system.model.SelfTransferModel;
import  upi.management.system.SessionData;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainController {
    private MainView mainView;
    private MainModel mainModel;

    public MainController(MainView mainView, MainModel mainModel,String phono) {
        this.mainView = mainView;
        this.mainModel = mainModel;
        // Set this controller as the listener for mainView
        mainView.addActionListenerToButtons((ActionListener) this);
    }
    public void showMainView() {
        mainView.setVisible(true);
    }

    // Method to handle actions for each button in the main view
    public void actionPerformed(String actionCommand) {

        switch (actionCommand) {
            case "Self transfer":
                SelfTransferView sview=new SelfTransferView();
                SelfTransferModel smodel=new SelfTransferModel(SessionData.getInstance().getPhoneNumber());
                new SelfTransferController(sview,smodel);
                mainView.setVisible(false);
                sview.setVisible(true);// Hide main view
                break;
            case "Bills":
                //new BillController(mainModel.getPhoneNumber());
                mainView.setVisible(false);
                break;
            case "Payments":
                PaymentView payview=new PaymentView();
                PaymentModel paymodel=new PaymentModel();
                new PaymentController(paymodel,payview);
                mainView.setVisible(false);
                break;
            case "PIN CHANGE":
                PinView pview=new PinView();
                PinModel pmodel=new PinModel();
                new PinController(pview,pmodel,mainModel.getPhoneNumber());
                mainView.setVisible(false);
                pview.setVisible(true);
                break;
            case "BALANCE ENQUIRY":
               new BalanceController(mainModel.getPhoneNumber());
                mainView.setVisible(false);
                break;
            case "Transaction history":
                 TransactionHistoryModel tmodel=new TransactionHistoryModel();
                 TransactionHistoryView tview=new TransactionHistoryView();
                new TransactionHistoryController(tmodel,tview);
                mainView.setVisible(false);
                break;
            case "EXIT":
                System.exit(0);
                break;
            default:
                break;
        }
    }
    public static void main(String[] args) {
        // Create an instance of MainView
        MainView mainView = new MainView(SessionData.getInstance().getPhoneNumber());

        // Create an instance of MainModel
        MainModel mainModel = new MainModel(SessionData.getInstance().getPhoneNumber());
        String phono=mainModel.getPhoneNumber();

        // Create an instance of MainController
        MainController mainController = new MainController(mainView, mainModel,phono);

        // Show the main view
        mainController.showMainView();

        // Now, when the "Self transfer" button is clicked in the main view,
        // it will create an instance of SelfTransferController and handle the self transfer logic.
    }
}

