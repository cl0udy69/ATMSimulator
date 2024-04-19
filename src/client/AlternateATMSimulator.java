package src.client;

import java.util.Scanner;

import src.functions.depositFunctions;
import src.functions.withdrawFunctions;
import src.functions.viewBalance;

public class AlternateATMSimulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        withdrawFunctions withdrawFunc = new withdrawFunctions();
        depositFunctions depositFunc = new depositFunctions();
        viewBalance viewBal = new viewBalance();

        String selection = "";

        while (true) {
            System.out.println("Would you like to withdraw, deposit, or view your current balance?: ");
            selection = scanner.nextLine();
            if (selection.equalsIgnoreCase("withdraw") || selection.equalsIgnoreCase("withdraw money")
                    || selection.equalsIgnoreCase("deposit") || selection.equalsIgnoreCase("deposit money")
                    || selection.equalsIgnoreCase("view balance") || selection.equalsIgnoreCase("view current balance")
                    || selection.equalsIgnoreCase("balance") || selection.equalsIgnoreCase("current balance")) {
                break;
            } else {
                System.out.println(selection + " is not a valid input");
            }
        }

        if (selection.equalsIgnoreCase("withdraw") || selection.equalsIgnoreCase("withdraw money")) {
            withdrawFunc.withdraw();
        } else if (selection.equalsIgnoreCase("deposit") || selection.equalsIgnoreCase("deposit money")) {
            depositFunc.deposit();
        } else if (selection.equalsIgnoreCase("view balance") || selection.equalsIgnoreCase("view current balance")
                || selection.equalsIgnoreCase("balance") || selection.equalsIgnoreCase("current balance")) {
            viewBal.balance();
        }
        scanner.close();
    }
}
