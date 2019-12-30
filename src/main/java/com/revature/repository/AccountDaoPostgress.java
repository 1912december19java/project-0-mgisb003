package com.revature.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.revature.model.Account;

public class AccountDaoPostgress implements AccountDao {


  private static Connection conn;


  static {
    try {
      conn = DriverManager.getConnection(
          "jdbc:postgresql://database-1.cbu886n5wmpw.us-east-1.rds.amazonaws.com:5432/postgres",
          "postgres", "Krelthor1!");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void updateDeposit(Account account) {
    PreparedStatement stmt = null;
    try {
      stmt = conn.prepareStatement("UPDATE bankaccountinfo SET balance = ? + balance WHERE username = ?");
      stmt.setDouble(1, account.getAccountBalance());
      stmt.setString(2, account.getUsername());
      stmt.execute();

    } catch (SQLException e) {
      e.printStackTrace();
    }


  }


  @Override
  public void saveUserInfo(Account account) {
    PreparedStatement stmt = null;
    try {
      stmt = conn.prepareStatement("INSERT INTO bankaccountinfo(username,passcode,balance) VALUES (?,?,?)");
      stmt.setString(1, account.getUsername());
      stmt.setString(2, account.getPasscode());
      stmt.setDouble(3, account.getAccountBalance());

      stmt.execute();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    
  }



  @Override
  public Account login(String username, int password) {
    Account out = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
      stmt = conn
          .prepareStatement("SELECT * FROM bankaccountinfo WHERE username = ? and passcode = ?");
      stmt.setString(1, username);
      stmt.setInt(2, password);
      if (stmt.execute()) {
        rs = stmt.getResultSet();
      }
      while (rs.next()) {
        out = new Account(rs.getString("username"), rs.getString("passcode"), rs.getDouble("balance"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return out;
  }



  @Override
  public Account getUsername(String username) {
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
        out = new Account(rs.getString("username"), rs.getString("passcode"), rs.getDouble("balance"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return out;
  }
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
        out = new Account(rs.getString("username"), rs.getString("passcode"), rs.getDouble("balance"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return out;
  }


  @Override
  public void updateWithdraw(Account account) {
    PreparedStatement stmt = null;
    try {
      stmt = conn.prepareStatement("UPDATE bankaccountinfo SET balance = balance - ? WHERE username = ?");
      stmt.setDouble(1, account.getAccountBalance());
      stmt.setString(2, account.getUsername());
      stmt.execute();

    } catch (SQLException e) {
      e.printStackTrace();
    }
    
  }


}


