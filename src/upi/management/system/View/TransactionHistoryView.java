package upi.management.system.View;


import upi.management.system.model.Transaction;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TransactionHistoryView {
    private JFrame frame;
    private JTextArea transactionListArea;
    private List<Transaction> transactions;

    public TransactionHistoryView() {
        frame = new JFrame("Transaction History");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JPanel panel = new JPanel(new GridLayout(1, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Add transaction list area
        transactionListArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(transactionListArea);
        panel.add(scrollPane);

        frame.add(panel);
        frame.setVisible(true);
    }

    public void displayTransactions(List<Transaction> transactions) {
        transactionListArea.setText("");
        for (Transaction transaction : transactions) {
            transactionListArea.append(transaction.toString() + "\n");
        }
    }

    public void updateTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
        displayTransactions(transactions);
        frame.repaint(); // Refresh the frame to display updated transactions
    }
}