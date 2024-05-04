package upi.management.system.controller;

import upi.management.system.View.TransactionHistoryView;
import upi.management.system.model.Transaction;
import upi.management.system.model.TransactionHistoryModel;

import java.util.List;

public class TransactionHistoryController {
    private TransactionHistoryModel transactionHistoryModel;
    private TransactionHistoryView transactionHistoryView;

    public TransactionHistoryController(TransactionHistoryModel transactionHistoryModel, TransactionHistoryView transactionHistoryView) {
        this.transactionHistoryModel = transactionHistoryModel;
        this.transactionHistoryView = transactionHistoryView;

        // Display initial transactions
        List<Transaction> transactions = transactionHistoryModel.getAllTransactions("account_number");
        transactionHistoryView.displayTransactions(transactions);
    }

    public static void main(String[] args) {
        TransactionHistoryModel transactionHistoryModel = new TransactionHistoryModel();
        TransactionHistoryView transactionHistoryView = new TransactionHistoryView();
        TransactionHistoryController transactionHistoryController = new TransactionHistoryController(transactionHistoryModel, transactionHistoryView);
    }
}