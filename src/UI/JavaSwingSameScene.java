import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import java.util.Random;

public class JavaSwingSameScene extends JFrame {
    private JTextArea outputArea;
    private JTextField amountField;
    private int balance;

    public JavaSwingSameScene() {
        setTitle("ATM Simulator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null); // Center the window

        // Create output area
        outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        outputArea.setBackground(new Color(48, 48, 48));
        outputArea.setForeground(Color.WHITE);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        // Create text field for entering withdrawal/deposit amount
        amountField = new JTextField(10);

        // Create button panel
        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        buttonPanel.setBackground(new Color(48, 48, 48));
        JButton withdrawButton = new JButton("Withdraw");
        JButton depositButton = new JButton("Deposit");
        JButton viewBalanceButton = new JButton("View Balance");
        buttonPanel.add(amountField);
        buttonPanel.add(withdrawButton);
        buttonPanel.add(depositButton);
        buttonPanel.add(viewBalanceButton);

        // Set actions for buttons
        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleWithdraw();
            }
        });

        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleDeposit();
            }
        });

        viewBalanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleViewBalance();
            }
        });

        // Create main panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(48, 48, 48));
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        add(mainPanel);

        setVisible(true);

        // Initialize balance
        Random rand = new Random();
        balance = rand.nextInt(1000000000) + 1;
    }

    private void handleWithdraw() {
        String amountText = amountField.getText();
        try {
            int withdrawAmount = Integer.parseInt(amountText);
            if (withdrawAmount <= 0) {
                outputArea.append("Invalid amount. Please enter a positive number.\n");
            } else if (withdrawAmount > balance) {
                outputArea.append("Insufficient funds. Please enter a smaller amount.\n");
            } else {
                balance -= withdrawAmount;
                outputArea.append("Withdrawn: $" + formatWithCommas(withdrawAmount) + "\n");
                outputArea.append("Remaining balance: $" + formatWithCommas(balance) + "\n");
            }
        } catch (NumberFormatException ex) {
            outputArea.append("Invalid amount. Please enter a valid number.\n");
        }
        amountField.setText("");
    }

    private void handleDeposit() {
        String amountText = amountField.getText();
        try {
            int depositAmount = Integer.parseInt(amountText);
            if (depositAmount <= 0) {
                outputArea.append("Invalid amount. Please enter a positive number.\n");
            } else {
                balance += depositAmount;
                outputArea.append("Deposited: $" + formatWithCommas(depositAmount) + "\n");
                outputArea.append("New balance: $" + formatWithCommas(balance) + "\n");
            }
        } catch (NumberFormatException ex) {
            outputArea.append("Invalid amount. Please enter a valid number.\n");
        }
        amountField.setText("");
    }

    private void handleViewBalance() {
        outputArea.append("Current balance: $" + formatWithCommas(balance) + "\n");
    }

    // Format balance with commas
    private String formatWithCommas(int amount) {
        return NumberFormat.getInstance().format(amount);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JavaSwingSameScene atm = new JavaSwingSameScene();
                atm.selectCardType();
            }
        });
    }

    // Prompt user to select card type
    private void selectCardType() {
        String[] options = { "Debit Card", "Credit Card" };
        int choice = JOptionPane.showOptionDialog(null, "Please select card type:", "Card Type",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (choice == 0) {
            // Debit card selected
            String pin = JOptionPane.showInputDialog("Please enter your 4-digit debit card PIN:");
            if (pin != null && pin.length() == 4) {
                // PIN entered correctly
                JOptionPane.showMessageDialog(null, "Debit card selected.\nPIN entered successfully.");
            } else {
                // Invalid PIN
                JOptionPane.showMessageDialog(null, "Invalid PIN. Please enter a 4-digit PIN.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                selectCardType(); // Retry card selection
            }
        } else if (choice == 1) {
            // Credit card selected
            JOptionPane.showMessageDialog(null, "Credit card selected.");
        } else {
            // Cancel or close button clicked
            JOptionPane.showMessageDialog(null, "Please select a card type.", "Error", JOptionPane.ERROR_MESSAGE);
            selectCardType(); // Retry card selection
        }
    }
}
