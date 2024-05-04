package upi.management.system.model;

//package upi.management.system;

import upi.management.system.Connn;

import java.sql.ResultSet;

public class BalanceModel {
    private String pin;

    public BalanceModel(String pin) {
        this.pin = pin;
    }

    public int getBalance() {
        int balance = 0;
        try {
            Connn c = new Connn();
            ResultSet resultSet = c.statement.executeQuery("Select * from bank where pin = '" + pin + "'");
            while (resultSet.next()) {
                if (resultSet.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(resultSet.getString("amount"));
                } else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return balance;
    }
}