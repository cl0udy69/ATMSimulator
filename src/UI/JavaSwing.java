import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JavaSwing extends JFrame {
    private JTextArea outputArea;

    public JavaSwing() {
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

        // Create button panel
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        buttonPanel.setBackground(new Color(48, 48, 48));
        JButton withdrawButton = new JButton("Withdraw");
        JButton depositButton = new JButton("Deposit");
        JButton viewBalanceButton = new JButton("View Balance");
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
        // Add logic for withdraw functionality
        outputArea.append("Withdraw selected\n");
    }

    private void handleDeposit() {
        // Add logic for deposit functionality
        outputArea.append("Deposit selected\n");
    }

    private void handleViewBalance() {
        // Add logic for view balance functionality
        outputArea.append("View balance selected\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JavaSwing();
            }
        });
    }
}
