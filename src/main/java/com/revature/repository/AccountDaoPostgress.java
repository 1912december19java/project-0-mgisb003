package com.revature.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import com.revature.exception.UsernameAlreadyExistsException;
import com.revature.exception.UsernameDoesNotExistException;
import com.revature.model.Account;
import com.revature.service.UserRegistration;

public class AccountDaoPostgress implements AccountDao {

  private static Logger log = Logger.getLogger(AccountDaoPostgress.class);

  private static Connection conn;


  static {
    try {
      conn = DriverManager.getConnection(System.getenv("urlConn"), System.getenv("username"),
          System.getenv("password"));
    } catch (SQLException e) {
      e.printStackTrace();
    }
    log.trace("connection successful");
  }

  // Checks username input from user input to DB
  @Override
  public Account getUsername(String username) {
    Account out = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
      stmt = conn.prepareStatement("SELECT * FROM bankaccountinfo WHERE username = ? ");
      stmt.setString(1, username);
      stmt.execute();
      if (stmt.execute()) {
        rs = stmt.getResultSet();
      }
      while (rs.next()) {
        out = new Account(rs.getString("username"), rs.getString("passcode"),
            rs.getString("firstname"), rs.getString("lastname"), rs.getDouble("checkingaccount"),
            rs.getDouble("savingsaccount"));
      }
    }catch (UsernameDoesNotExistException e) {
    } catch (UsernameAlreadyExistsException e) {
    } catch (SQLException e) {

    }
    log.trace("User usernamed returned");
    return out;
  }

  // Checks password input from user input to DB
  @Override
  public Account getPassword(String password) {
    Account out = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
      stmt = conn.prepareStatement("SELECT * FROM bankaccountinfo WHERE passcode = ?");
      stmt.setString(1, password);
      stmt.execute();
      if (stmt.execute()) {
        rs = stmt.getResultSet();
      }
      while (rs.next()) {
        out = new Account(rs.getString("username"), rs.getString("passcode"),
            rs.getString("firstname"), rs.getString("lastname"), rs.getDouble("checkingaccount"),
            rs.getDouble("savingsaccount"));
      }

    } catch (SQLException e) {

    }
    log.trace("User password returned");
    return out;
  }

  // Creates new account through user input and saves onto DB
  @Override
  public void saveUserInfo(Account account) {
    PreparedStatement stmt = null;
    while (true) {
      try {
        stmt = conn.prepareStatement(
            "INSERT INTO bankaccountinfo(username,passcode,firstname,lastname,checkingaccount,savingsaccount) VALUES (?,?,?,?,?,?)");
        stmt.setString(1, account.getUsername());
        stmt.setString(2, account.getPasscode());
        stmt.setString(3, account.getFirstName());
        stmt.setString(4, account.getLastName());
        stmt.setDouble(5, account.getCheckingBalance());
        stmt.setDouble(6, account.getSavingBalance());

        stmt.execute();
        break;
        
      } catch (UsernameAlreadyExistsException e) {

      } catch (SQLException e) {
        System.out.println("Username is already in use: ");
        UserRegistration.userRegistration();
        break;
      }
    }
    log.trace("user info saved");
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
            rs.getString("firstname"), rs.getString("lastname"), rs.getDouble("checkingaccount"),
            rs.getDouble("savingsaccount"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    log.trace("savings and checking account balance returned");
    return out;
  }

  // Method that adds user input to current account balance
  @Override
  public void updateDepositChecking(Account account) {
    PreparedStatement stmt = null;
    try {
      stmt = conn.prepareStatement(
          "UPDATE bankaccountinfo SET checkingaccount = ? + checkingaccount WHERE username = ?");
      stmt.setDouble(1, account.getCheckingBalance());
      stmt.setString(2, account.getUsername());
      stmt.execute();
    } catch (SQLException e) {
    }
    log.trace("checking account balance updated");

  }

  // Method that subtracts user input from current account balance
  @Override
  public void updateWithdrawChecking(Account account) {
    PreparedStatement stmt = null;
    try {
      stmt = conn.prepareStatement(
          "UPDATE bankaccountinfo SET checkingaccount = checkingaccount - ? WHERE username = ?");
      stmt.setDouble(1, account.getCheckingBalance());
      stmt.setString(2, account.getUsername());
      stmt.execute();

    } catch (SQLException e) {
      System.out.println("You do not have enough funds to withdraw that amount.");
    }
    log.trace("checking account balance updated");
  }

  // Method that adds user input to current account balance
  @Override
  public void updateDepositSaving(Account account) {
    PreparedStatement stmt = null;
    try {
      stmt = conn.prepareStatement(
          "UPDATE bankaccountinfo SET savingsaccount = ? + savingsaccount WHERE username = ?");
      stmt.setDouble(1, account.getSavingBalance());
      stmt.setString(2, account.getUsername());
      stmt.execute();
    } catch (SQLException e) {
    }
    log.trace("savings account balance updated");

  }

  // Method that subtracts user input from current account balance
  @Override
  public void updateWithdrawSaving(Account account) {
    PreparedStatement stmt = null;
    try {
      stmt = conn.prepareStatement(
          "UPDATE bankaccountinfo SET savingsaccount = savingsaccount - ? WHERE username = ?");
      stmt.setDouble(1, account.getSavingBalance());
      stmt.setString(2, account.getUsername());
      stmt.execute();

    } catch (SQLException e) {
      System.out.println("You do not have enough funds to withdraw that amount.");
    }
    log.trace("savings account balance updated");
  }

  // Method that transfers from savings account to checking Account
  @Override
  public void savingToChecking(Account account) {
    PreparedStatement stmt = null;
    try {
      stmt = conn.prepareStatement("UPDATE bankaccountinfo SET savingsaccount = savingsaccount - ?"
          + ",checkingaccount = ? + checkingaccount WHERE username = ?");
      stmt.setDouble(1, account.getSavingBalance());
      stmt.setDouble(2, account.getCheckingBalance());
      stmt.setString(3, account.getUsername());
      stmt.execute();

    } catch (SQLException e) {
      System.out.println("You do not have enough funds to withdraw that amount.");
    }
    log.trace("savings and checking account balance updated");
  }

  // Method that transfers from checking account to savings Account
  @Override
  public void checkingToSaving(Account account) {
    PreparedStatement stmt = null;
    try {
      stmt =
          conn.prepareStatement("UPDATE bankaccountinfo SET checkingaccount = checkingaccount - ?"
              + ",savingsaccount = ? + savingsaccount WHERE username = ?");
      stmt.setDouble(2, account.getSavingBalance());
      stmt.setDouble(1, account.getCheckingBalance());
      stmt.setString(3, account.getUsername());
      stmt.execute();

    } catch (SQLException e) {
      System.out.println("You do not have enough funds to withdraw that amount.");
    }
    log.trace("savings and checking account balance updated");
  }

}


