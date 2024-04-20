package src.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ATMSimulatorGUI extends JFrame {
    private JTextArea outputArea;

    public ATMSimulatorGUI() {
        // Set up the JFrame
        setTitle("ATM Simulator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null); // Center the window
        setLayout(new BorderLayout());
        setResizable(false);
        getContentPane().setBackground(Color.DARK_GRAY); // Set background color

        // Create the output area (where the text will be displayed)
        outputArea = new JTextArea(10, 30); // 10 rows, 30 columns
        outputArea.setEditable(false); // Make the text area read-only
        outputArea.setLineWrap(true); // Enable text wrapping
        outputArea.setWrapStyleWord(true); // Wrap at word boundaries
        outputArea.setForeground(Color.WHITE); // Set text color to white
        outputArea.setBackground(Color.DARK_GRAY); // Set background color to dark gray
        outputArea.setFont(new Font("Arial", Font.PLAIN, 14)); // Set font
        JScrollPane scrollPane = new JScrollPane(outputArea); // Add scrollbars

        // Add the output area to the center of the BorderLayout
        add(scrollPane, BorderLayout.CENTER);

        // Create a panel for buttons
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 10, 10)); // 3 rows, 1 column, with 10 pixels of horizontal
                                                                       // and vertical spacing
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add padding to the panel
        buttonPanel.setBackground(Color.DARK_GRAY); // Set background color to dark gray

        // Create buttons for actions
        JButton withdrawButton = new JButton("Withdraw");
        JButton depositButton = new JButton("Deposit");
        JButton viewBalanceButton = new JButton("View Balance");

        // Set button colors and font
        Color buttonColor = new Color(59, 89, 182); // Blue color
        Color textColor = Color.WHITE; // White color
        Font buttonFont = new Font("Arial", Font.BOLD, 16); // Bold font
        withdrawButton.setBackground(buttonColor);
        withdrawButton.setForeground(textColor);
        withdrawButton.setFont(buttonFont);
        depositButton.setBackground(buttonColor);
        depositButton.setForeground(textColor);
        depositButton.setFont(buttonFont);
        viewBalanceButton.setBackground(buttonColor);
        viewBalanceButton.setForeground(textColor);
        viewBalanceButton.setFont(buttonFont);

        // Add action listeners to the buttons
        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                outputArea.append("Withdraw selected\n");
                // Call your withdraw function here
            }
        });

        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                outputArea.append("Deposit selected\n");
                // Call your deposit function here
            }
        });

        viewBalanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                outputArea.append("View balance selected\n");
                // Call your view balance function here
            }
        });

        // Add buttons to the button panel
        buttonPanel.add(withdrawButton);
        buttonPanel.add(depositButton);
        buttonPanel.add(viewBalanceButton);

        // Add the button panel to the bottom of the BorderLayout
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        // Create and display the GUI on the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ATMSimulatorGUI().setVisible(true);
            }
        });
    }
}
