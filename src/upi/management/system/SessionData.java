package upi.management.system;
public class SessionData {
    private static SessionData instance;
    private String phoneNumber;

    // Private constructor to prevent instantiation from outside
    private SessionData() {}

    // Method to get the instance of SessionData
    public static synchronized SessionData getInstance() {
        if (instance == null) {
            instance = new SessionData();
        }
        return instance;
    }

    // Getter and setter for the phone number
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

