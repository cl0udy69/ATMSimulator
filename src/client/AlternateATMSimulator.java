package src.client;

//import java.text.NumberFormat;
import java.util.Scanner;
//import java.util.Random;

import src.functions.withdrawFunctions;

public class AlternateATMSimulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String options = "";
        String selection = "";

        while (true) {
            System.out.println("Would you like to withdraw, deposit, or view your current balance?: ");
            options = scanner.nextLine();
            if (options.equalsIgnoreCase("withdraw") || options.equalsIgnoreCase("withdraw money")
                    || options.equalsIgnoreCase("deposit") || options.equalsIgnoreCase("deposit money")
                    || options.equalsIgnoreCase("view balance") || options.equalsIgnoreCase("view current balance")
                    || options.equalsIgnoreCase("balance") || options.equalsIgnoreCase("current balance")) {
                selection = scanner.nextLine();
                break;
            } else {
                System.out.println(options + " is not a valid input");
            }
        }

        if (options.equalsIgnoreCase("withdraw") || options.equalsIgnoreCase("withdraw money")) {
            withdrawFunctions withdrawFunctions = new withdrawFunctions();
            withdrawFunctions.withdraw();
        } else if (options.equalsIgnoreCase("deposit") || options.equalsIgnoreCase("deposit money")) {
            // Code for deposit function
        } else if (options.equalsIgnoreCase("view balance") || options.equalsIgnoreCase("view current balance")
                || options.equalsIgnoreCase("balance") || options.equalsIgnoreCase("current balance")) {
            // Code for view balance function
        }
        scanner.close();
    }
}
