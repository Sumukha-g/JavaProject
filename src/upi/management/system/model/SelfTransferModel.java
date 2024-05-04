package upi.management.system.model;

import  upi.management.system.Connn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelfTransferModel {
    public interface UPIIDCallback {
        void onUPIIDsReceived(String[] upiids);
    }

    public void getUPIIDs(String phoneNumber, UPIIDCallback callback) {
        String[] upiids = null;
        try {
            Connn conn = new Connn();
            String query = "SELECT upiid FROM signupc WHERE phono = '" + phoneNumber + "'";
            ResultSet resultSet = conn.statement.executeQuery(query);
            int rowCount = 0;
            if (resultSet.last()) {
                rowCount = resultSet.getRow();
                resultSet.beforeFirst();
            }
            upiids = new String[rowCount];
            int index = 0;
            while (resultSet.next()) {
                upiids[index++] = resultSet.getString("upiid");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        callback.onUPIIDsReceived(upiids);
    }
    private String phono;

    public SelfTransferModel(String phono) {
        this.phono = phono;
    }

    public String getPhoneNumber() {
        return phono;
    }
    public void setPhoneNumber(String phono) {
        this.phono=phono;
    }
}
