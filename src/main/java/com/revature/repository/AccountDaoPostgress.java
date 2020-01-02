package com.revature.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.revature.model.Account;
import com.revature.service.UserRegistration;

public class AccountDaoPostgress implements AccountDao {


  private static Connection conn;


  static {
    try {
      conn = DriverManager.getConnection(System.getenv("urlConn"), System.getenv("username"),
          System.getenv("password"));
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
 
  // Creates new account through user input and saves onto DB
  @Override
  public void saveUserInfo(Account account) {
    PreparedStatement stmt = null;
    while (true) {
      try {
        stmt = conn.prepareStatement(
            "INSERT INTO bankaccountinfo(username,passcode,balance) VALUES (?,?,?)");
        stmt.setString(1, account.getUsername());
        stmt.setString(2, account.getPasscode());
        stmt.setDouble(3, account.getAccountBalance());

        stmt.execute();
        break;
      } catch (SQLException e) {
        System.out.println("Username is already in use: ");
         UserRegistration.userRegistration();
        break;
      }
    }
  }

  // Method which pulls user account balance information
  @Override
  public Account getBalance(String username) {
    Account out = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
      stmt = conn.prepareStatement("SELECT * FROM bankaccountinfo WHERE username = ?");
      stmt.setString(1, username);
      if (stmt.execute()) {
        rs = stmt.getResultSet();
      }
      while (rs.next()) {
        out = new Account(rs.getString("username"), rs.getString("passcode"),
            rs.getDouble("balance"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return out;
  }

  // Method that adds user input to current account balance
  @Override
  public void updateDeposit(Account account) {
    PreparedStatement stmt = null;
    try {
      stmt = conn
          .prepareStatement("UPDATE bankaccountinfo SET balance = ? + balance WHERE username = ?");
      stmt.setDouble(1, account.getAccountBalance());
      stmt.setString(2, account.getUsername());
      stmt.execute();

    } catch (SQLException e) {
      
    }

  }

  // Method that subtracts user input from current account balance
  @Override
  public void updateWithdraw(Account account) {
    PreparedStatement stmt = null;
    try {
      stmt = conn
          .prepareStatement("UPDATE bankaccountinfo SET balance = balance - ? WHERE username = ?");
      stmt.setDouble(1, account.getAccountBalance());
      stmt.setString(2, account.getUsername());
      stmt.execute();

    } catch (SQLException e) {
      System.out.println("You do not have enough funds to withraw that amount.");
    }
  }
}


