import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class JavaSwing extends JFrame {
    private JTextArea outputArea;
    private JTextField amountField;
    private JButton withdrawButton;
    private JButton depositButton;
    private JButton viewBalanceButton;
    private int balance;

    public JavaSwing() {
        setTitle("ATM Simulator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null); // Center the window

        //Random rand = new Random(); // Initial balance
        //int randomBalance = rand.nextInt(1000000000) + 1;


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
        withdrawButton = new JButton("Withdraw");
        depositButton = new JButton("Deposit");
        viewBalanceButton = new JButton("View Balance");
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
    }

    private void handleWithdraw() {
        String amountText = amountField.getText();
        try {
            int withdrawAmount = Integer.parseInt(amountText);
            if (withdrawAmount <= 0) {
                outputArea.append("Invalid amount. Please enter a positive number.\n");
            } else if (withdrawAmount > Balance) {
                outputArea.append("Insufficient funds. Please enter a smaller amount.\n");
            } else {
                balance -= withdrawAmount;
                outputArea.append("Withdrawn: $" + withdrawAmount + "\n");
                outputArea.append("Remaining balance: $" + balance + "\n");
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
                outputArea.append("Deposited: $" + depositAmount + "\n");
                outputArea.append("New balance: $" + balance + "\n");
            }
        } catch (NumberFormatException ex) {
            outputArea.append("Invalid amount. Please enter a valid number.\n");
        }
        amountField.setText("");
    }

    private void handleViewBalance() {
        outputArea.append("Current balance: $" + balance + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JavaSwing();
            }
        });
    }
}
