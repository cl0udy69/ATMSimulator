package src.functions;

import java.util.Scanner;
import java.util.Random;
import java.text.NumberFormat;

import src.functions.depositFunctions;
//import src.functions.withdrawFunctions;
//import src.functions.viewBalance;

public class depositFunctions {
    public void deposit() {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        NumberFormat formatter = NumberFormat.getInstance();
        viewBalance viewBal = new viewBalance();
        withdrawFunctions withdrawFunc = new withdrawFunctions();
        depositFunctions depositFunc = new depositFunctions();

        int randomBalance = rand.nextInt(1000000000) + 1;
        String formattedBalance = formatter.format(randomBalance);

        String selection = "";
        int debitPin;
        int sum;
        int depositAmount;

        System.out.println("Are you using a debit or credit card?: ");
        selection = scanner.nextLine();

        if (selection.equalsIgnoreCase("debit") || selection.equalsIgnoreCase("debit card")) {
            while (true) {
                System.out.println("Enter your debit card pin (4 characters): ");
                try {
                    debitPin = Integer.parseInt(scanner.nextLine());
                    if (String.valueOf(debitPin).length() != 4) {
                        throw new NumberFormatException();
                    }
                    break;
                } catch (NumberFormatException nfe) {
                    System.out.println("Invalid pin. Please enter a valid 4-digit pin.");
                }
            }
            System.out
                    .println("Your current balance is: $" + formattedBalance + ", how much would you like to deposit");
            depositAmount = scanner.nextInt();

            sum = depositAmount + randomBalance;
            String formattedSum = formatter.format(sum);
            System.out.println("Your current balance is " + formattedSum + ". Would you like to do something else?:");
            while (true) {
                selection = scanner.nextLine();
                if (selection.equalsIgnoreCase("yes") || selection.equalsIgnoreCase("y")) {
                    System.out.println("What would you like to do?: ");
                    selection = scanner.nextLine();
                    if (selection.equalsIgnoreCase("withdraw") || selection.equalsIgnoreCase("withdraw money")) {
                        withdrawFunc.withdraw();
                    } else if (selection.equalsIgnoreCase("deposit") || selection.equalsIgnoreCase("deposit money")) {
                        depositFunc.deposit();
                    } else if ((selection.equalsIgnoreCase("view balance")
                            || selection.equalsIgnoreCase("view current balance")
                            || selection.equalsIgnoreCase("balance")
                            || selection.equalsIgnoreCase("current balance"))) {
                        viewBal.balance();
                        break;
                    } else {
                        System.out.println(selection + " is not a valid input");
                    }
                } else if (selection.equalsIgnoreCase("no") || selection.equalsIgnoreCase("n")) {
                    break;
                } else {
                    System.out.println(selection + " is not a valid input");
                }
                scanner.close();
            }
        } else if (selection.equalsIgnoreCase("credit") || selection.equalsIgnoreCase("credit card")) {
            System.out
                    .println("Your current balance is: $" + formattedBalance + ", how much would you like to withdraw");
            depositAmount = scanner.nextInt();

            sum = depositAmount + randomBalance;
            String formattedSum = formatter.format(sum);
            System.out.println("Your current balance is: $" + formattedSum + ". Would you like to do something else?:");
            while (true) {
                selection = scanner.nextLine();
                if (selection.equalsIgnoreCase("yes") || selection.equalsIgnoreCase("y")) {
                    System.out.println("What would you like to do?: ");
                    selection = scanner.nextLine();
                    if (selection.equalsIgnoreCase("withdraw") || selection.equalsIgnoreCase("withdraw money")) {
                        withdrawFunc.withdraw();
                    } else if (selection.equalsIgnoreCase("deposit") || selection.equalsIgnoreCase("deposit money")) {
                        depositFunc.deposit();
                    } else if ((selection.equalsIgnoreCase("view balance")
                            || selection.equalsIgnoreCase("view current balance")
                            || selection.equalsIgnoreCase("balance")
                            || selection.equalsIgnoreCase("current balance"))) {
                        viewBal.balance();
                        break;
                    } else {
                        System.out.println(selection + " is not a valid input");
                    }
                } else if (selection.equalsIgnoreCase("no") || selection.equalsIgnoreCase("n")) {
                    break;
                } else {
                    System.out.println(selection + " is not a valid input");
                }
                scanner.close();
            }
        }
        scanner.close();
    }
}