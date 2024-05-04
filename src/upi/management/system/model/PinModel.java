package upi.management.system.model;

import upi.management.system.Connn;

import java.sql.SQLException;

public class PinModel {
    public void changePin(String newPin, String oldPin) throws SQLException {
        Connn c = new Connn();
        String q1 = "update login set pin = '"+newPin+"' where pin = '"+oldPin+"'";
        String q2 = "update signupc set pin = '"+newPin+"' where pin = '"+oldPin+"'";
        c.statement.executeUpdate(q1);
        c.statement.executeUpdate(q2);
    }
}