package upi.management.system.model;

import upi.management.system.Connn;

import java.sql.SQLException;
import java.util.Map;

public class PaymentModel {
    // Method to perform the payment transaction
    public boolean makePayment(Map<String, Object> paymentDetails) {
        String billType = (String) paymentDetails.get("billType");
        double amount = (double) paymentDetails.get("amount");
        String accountNumber;
        String upiids = "oknana@";
        String rNumber = getRNumber(billType); // Retrieve the receiver identifier

        if (billType.equals("Water")) {
            accountNumber = "1920192019";
            upiids = "Waterbill@okvhi";
        } else if (billType.equals("Gas")) {
            accountNumber = "9210921092";
            upiids = "Gasbill@okvhi";
        } else if (billType.equals("Electricity")) {
            accountNumber = "2190219021";
            upiids = "Ebill@okkar";
        } else {
            accountNumber = null; // Handle the case where bill type is invalid
        }

        // Insert transaction into the database
        try {
                Connn conn = new Connn();
                int rowsInserted = conn.statement.executeUpdate("INSERT INTO Transaction (upiid, account_number, transaction_type, receiver_identifier, amount) VALUES ('" + upiids + "', '" + accountNumber + "', 'UPI', '" + rNumber + "', " + amount + ")");
                return rowsInserted > 0;
            } catch (Exception e) {
        e.printStackTrace();
        return false;
    }

}

    private String getRNumber(String billType) {
        // Simulated account numbers for each bill type
        if (billType.equals("Water")) {
            return "water_account_number";
        } else if (billType.equals("Electricity")) {
            return "electricity_account_number";
        } else if (billType.equals("Gas")) {
            return "gas_account_number";
        } else {
            return null;
        }
    }

    // Method to retrieve the receiver identifier based on bill type
    private String getReceiverIdentifier(String billType) {
        // Simulated receiver identifiers for each bill type
        if (billType.equals("Water")) {
            return "water_receiver_identifier";
        } else if (billType.equals("Electricity")) {
            return "electricity_receiver_identifier";
        } else if (billType.equals("Gas")) {
            return "gas_receiver_identifier";
        } else {
            return null;
        }
    }
}
