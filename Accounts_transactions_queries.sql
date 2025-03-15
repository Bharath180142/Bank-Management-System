-- Database: bank_management
CREATE DATABASE IF NOT EXISTS bank_management;
USE bank_management;

-- Table: accounts
CREATE TABLE IF NOT EXISTS accounts (
    account_id INT PRIMARY KEY AUTO_INCREMENT,
    account_holder_name VARCHAR(100) NOT NULL,
    balance DECIMAL(10, 2) NOT NULL
);

-- Table: transactions
CREATE TABLE IF NOT EXISTS transactions (
    transaction_id INT PRIMARY KEY AUTO_INCREMENT,
    account_id INT,
    transaction_type ENUM('DEPOSIT', 'WITHDRAW') NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (account_id) REFERENCES accounts(account_id)
);

-- Sample Data for accounts
INSERT INTO accounts (account_holder_name, balance) VALUES ('John Doe', 1000.00);
INSERT INTO accounts (account_holder_name, balance) VALUES ('Jane Smith', 500.00);

-- Sample Data for transactions
INSERT INTO transactions (account_id, transaction_type, amount) VALUES (1, 'DEPOSIT', 200.00);
INSERT INTO transactions (account_id, transaction_type, amount) VALUES (2, 'WITHDRAW', 100.00);