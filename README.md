# Bank-Management-System
●     Developed a Bank Management System using Java and SQL to handle account management, deposits,        withdrawals, and balance inquiries. Established JDBC connectivity for secure data interaction between the Java application and SQL database. Applied object-oriented principles and optimized SQL queries for efficient transactions.
# Bank Management System

A simple **Bank Management System** built using **Java**, **MySQL**, and **JDBC API**. This project allows users to perform basic banking operations such as depositing money, withdrawing money, and checking account balances.

---

## Features
- **Deposit Money**: Add funds to a bank account.
- **Withdraw Money**: Deduct funds from a bank account.
- **Check Balance**: View the current balance of a bank account.
- **Transaction History**: All transactions are recorded in the database.

---

## Technologies Used
- **Java**: Core programming language for the application logic.
- **MySQL**: Database management system for storing account and transaction data.
- **JDBC API**: Java Database Connectivity API for connecting Java applications to the MySQL database.

---

## Prerequisites
Before running the project, ensure you have the following installed:
1. **Java Development Kit (JDK)**: Version 8 or higher.
2. **MySQL**: Installed and running on your machine.
3. **MySQL Connector/J**: JDBC driver for MySQL.
4. **IDE**: IntelliJ IDEA, Eclipse, or any Java-supported IDE.

---

## Setup Instructions

### 1. Set Up MySQL Database
1. Open MySQL Command Line Client or MySQL Workbench.
2. Run the following SQL script to create the database and tables:

```sql
CREATE DATABASE bank_management;

USE bank_management;

CREATE TABLE accounts (
    account_id INT PRIMARY KEY AUTO_INCREMENT,
    account_holder_name VARCHAR(100) NOT NULL,
    balance DECIMAL(10, 2) NOT NULL
);

CREATE TABLE transactions (
    transaction_id INT PRIMARY KEY AUTO_INCREMENT,
    account_id INT,
    transaction_type ENUM('DEPOSIT', 'WITHDRAW') NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (account_id) REFERENCES accounts(account_id)
);


Insert sample data (optional):

INSERT INTO accounts (account_holder_name, balance) VALUES ('John Doe', 1000.00);
INSERT INTO accounts (account_holder_name, balance) VALUES ('Jane Smith', 500.00);


Update the database credentials in DatabaseConnection.java:

private static final String URL = "jdbc:mysql://localhost:3306/bank_management";
private static final String USER = "root";
private static final String PASSWORD = "root"; 


Project Structure:
bank-management-system/
│
├── src/
│   ├── DatabaseConnection.java       // Handles database connectivity
│   ├── BankOperations.java           // Contains banking operations logic
│   └── UserInterface.java           // Provides a console-based menu
│
├── README.md                        // Project documentation
└── bank_management.sql              // SQL script for database setup



How to Use
1.Deposit Money:

Choose option 1 from the menu.

Enter the account ID and the amount to deposit.

2.Withdraw Money:

Choose option 2 from the menu.

Enter the account ID and the amount to withdraw.

3.Check Balance:

Choose option 3 from the menu.

Enter the account ID to view the current balance.

4.Exit:

Choose option 4 to exit the application.

Screenshots
Main Menu

Bank Management System
1. Deposit
2. Withdraw
3. Check Balance
4. Exit
Choose an option:

Deposit

Enter account ID: 1
Enter amount to deposit: 500
Deposit successful!

Check Balance

Enter account ID: 1
Current balance: 1500.0
