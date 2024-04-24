package upi.management.system.model;
import upi.management.system.Connn;
import java.sql.ResultSet;

public class LoginModel {
    public boolean authenticateUser(String cardNumber, String pin) {
        try {
            Connn c = new Connn();
            String query = "select * from login where card_number = '" + cardNumber + "' and pin = '" + pin + "'";
            ResultSet resultSet = c.statement.executeQuery(query);
            return resultSet.next();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
