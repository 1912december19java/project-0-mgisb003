package com.revature.model;

public class Account {


  private int id;
  private String username;
  private int passcode;
  private double accountBalance;


  public Account(int id, String username, int passcode, double accountBalance) {
    super();
    this.id = id;
    this.username = username;
    this.passcode = passcode;
    this.accountBalance = accountBalance;
  }


  public int getId() {
    return id;
  }


  public void setId(int id) {
    this.id = id;
  }


  public String getUsername() {
    return username;
  }


  public void setUsername(String username) {
    this.username = username;
  }


  public int getPasscode() {
    return passcode;
  }


  public void setPasscode(int passcode) {
    this.passcode = passcode;
  }


  public double getAccountBalance() {
    return accountBalance;
  }


  public void setAccountBalance(double accountBalance) {
    this.accountBalance = accountBalance;
  }


  @Override
  public String toString() {
    return "UserAccount [id=" + id + ", username=" + username + ", accountBalance=" + accountBalance + "]";
  }



}
