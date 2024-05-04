package upi.management.system.model;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionHistoryModel {
    private Connection connection;

    public TransactionHistoryModel() {
        // Initialize database connection
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/upisystem", "root", "Sumukha123");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Transaction> getAllTransactions(String accountNumber) {
        List<Transaction> transactions = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Transaction WHERE account_number = ?");
            statement.setString(1, accountNumber);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                transactions.add(new Transaction(
                        resultSet.getString("upiid"),
                        resultSet.getString("account_number"),
                        resultSet.getString("transaction_type"),
                        resultSet.getString("receiver_identifier"),
                        resultSet.getBigDecimal("amount"),
                        resultSet.getTimestamp("transaction_date").toLocalDateTime()
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }

    // Other CRUD operations as needed
}