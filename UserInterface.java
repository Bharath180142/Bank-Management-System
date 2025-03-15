package com.tap.package1;

import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankOperations bankOps = new BankOperations();

        while (true) {
            System.out.println("\nBank Management System");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter account ID: ");
                    int depositAccountId = scanner.nextInt();
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    try {
                        bankOps.deposit(depositAccountId, depositAmount);
                        System.out.println("Deposit successful!");
                    } catch (SQLException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Enter account ID: ");
                    int withdrawAccountId = scanner.nextInt();
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    try {
                        bankOps.withdraw(withdrawAccountId, withdrawAmount);
                        System.out.println("Withdrawal successful!");
                    } catch (SQLException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Enter account ID: ");
                    int balanceAccountId = scanner.nextInt();
                    try {
                        double balance = bankOps.checkBalance(balanceAccountId);
                        System.out.println("Current balance: " + balance);
                    } catch (SQLException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}