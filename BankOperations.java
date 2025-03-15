package com.tap.package1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankOperations {

    public void deposit(int accountId, double amount) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            // Update account balance
            String sql = "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1, amount);
            pstmt.setInt(2, accountId);
            pstmt.executeUpdate();

            // Record transaction
            sql = "INSERT INTO transactions (account_id, transaction_type, amount) VALUES (?, 'DEPOSIT', ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, accountId);
            pstmt.setDouble(2, amount);
            pstmt.executeUpdate();
        }
    }

    public void withdraw(int accountId, double amount) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            // Update account balance
            String sql = "UPDATE accounts SET balance = balance - ? WHERE account_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1, amount);
            pstmt.setInt(2, accountId);
            pstmt.executeUpdate();

            // Record transaction
            sql = "INSERT INTO transactions (account_id, transaction_type, amount) VALUES (?, 'WITHDRAW', ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, accountId);
            pstmt.setDouble(2, amount);
            pstmt.executeUpdate();
        }
    }

    public double checkBalance(int accountId) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT balance FROM accounts WHERE account_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, accountId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble("balance");
            }
        }
        return 0;
    }
}