package com.revature.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.revature.model.Account;

public class AccountDaoPostgress implements AccountDao {


  private static Connection conn;


  static {
    try {
      conn = DriverManager.getConnection("jdbc:postgresql://database-1.cbu886n5wmpw.us-east-1.rds.amazonaws.com:5432/postgres",
          "postgres","Krelthor1!");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public Account get(String username) {
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
        out = new Account(rs.getInt("id"), rs.getString("username"), rs.getInt("passcode"),
            rs.getDouble("balance"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return out;
  }


  
  

  @Override
  public void update(Account account) {
    PreparedStatement stmt = null;
    try {
      stmt = conn.prepareStatement("UPDATE bankaccountinfo SET balance = ? WHERE id = ?");
      stmt.setDouble(1, account.getAccountBalance());
      stmt.setInt(2, account.getId());
      stmt.execute();

    } catch (SQLException e) {
      e.printStackTrace();
    }


  }


  @Override
  public Account saveUsername(String username) {
    Account out = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
      stmt = conn.prepareStatement("INSERT INTO bankaccountinfo(id,username) VALUES (DEFAULT,?)");
      stmt.setString(1, username);
      if (stmt.execute()) {
        rs = stmt.getResultSet();
      }

      while (rs.next()) {
        out = new Account(rs.getInt("id"), rs.getString("username"), rs.getInt("passcode"),
            rs.getDouble("balance"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return out;
  }


  @Override
  public Account savePassword(int password) {
    Account out = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
      stmt = conn.prepareStatement("INSERT INTO bankaccountinfo(id,passcode) VALUES (DEFAULT,?)");
      stmt.setInt(1, password);
      if (stmt.execute()) {
        rs = stmt.getResultSet();
      }

      while (rs.next()) {
        out = new Account(rs.getInt("id"), rs.getString("username"), rs.getInt("passcode"),
            rs.getDouble("balance"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return out;
  }
}