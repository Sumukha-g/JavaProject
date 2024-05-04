package upi.management.system.model;
import upi.management.system.Connn;
import java.sql.ResultSet;

public class LoginModel {
    public boolean authenticateUser(String cardNumber, String pin) {
        try {
            Connn c = new Connn();
            String query = "select * from login where user_name = '" + cardNumber + "' and pin = '" + pin + "'";
            ResultSet resultSet = c.statement.executeQuery(query);
            return resultSet.next();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public String getPhoneNumber(String cardNumber) {
        String phoneNumber = null;
        try {
            Connn c = new Connn();
            String query = "SELECT phono FROM signupc WHERE cardNumber = '" + cardNumber + "'";
            ResultSet resultSet = c.statement.executeQuery(query);
            if (resultSet.next()) {
                phoneNumber = resultSet.getString("phono");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return phoneNumber;
    }
}
