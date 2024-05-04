package  upi.management.system.View;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;

public class SelfTransferView extends JFrame {  private JLabel label;
    public JTextField textField;
    public JButton submitButton;
    public JButton backButton;
    public SelfTransferView() {
        // Set the background color
        setBackground(new Color(222, 255, 228));

        // Create and configure the label
        label = new JLabel("Phone Number:");
        label.setFont(new Font("Raleway", Font.BOLD, 20));
        label.setBounds(100, 100, 200, 30);

        // Create and configure the text field
        textField = new JTextField();
        textField.setFont(new Font("Raleway", Font.BOLD, 14));
        textField.setBounds(300, 100, 400, 30);

        // Create and configure the submit button
        submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Raleway", Font.BOLD, 14));
        submitButton.setBounds(300, 150, 100, 30);

        // Create and configure the back button
        backButton = new JButton("Back");
        backButton.setFont(new Font("Raleway", Font.BOLD, 14));
        backButton.setBounds(420, 150, 100, 30);

        // Add components to the panel
        add(label);
        add(textField);
        add(submitButton);
        add(backButton);

        // Set layout and size of the panel
        setLayout(null);
        setPreferredSize(new Dimension(850, 200));
    }

    // Method to get the phone number entered in the text field
    public String getPhoneNumber() {
        return textField.getText();
    }

    public JButton getSubmitButton() {
        return submitButton;
    }

    public JButton getBackButton() {
        return backButton;
    }
    public void setUPIIDs(String[] upiids) {
        // Clear existing components
        getContentPane().removeAll();

        // Create and configure a new label to display UPI IDs
        JLabel upiLabel = new JLabel("UPI IDs:");
        upiLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        upiLabel.setBounds(100, 200, 200, 30);
        add(upiLabel);

        // Create and configure a new panel to display UPI IDs
        JPanel upiPanel = new JPanel();
        upiPanel.setLayout(new GridLayout(upiids.length, 1));
        upiPanel.setBounds(300, 200, 400, 200);

        // Add UPI IDs to the panel
        for (String upiid : upiids) {
            JLabel upiIDLabel = new JLabel(upiid);
            upiPanel.add(upiIDLabel);
        }

        // Add the panel to the frame
        add(upiPanel);

        // Update the frame
        revalidate();
        repaint();
    }
}
