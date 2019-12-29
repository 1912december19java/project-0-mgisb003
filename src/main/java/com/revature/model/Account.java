package com.revature.model;

public class Account {



  private String username;
  private int passcode;
  private double accountBalance;


  public Account(String username, int passcode, double accountBalance) {
    super();

    this.username = username;
    this.passcode = passcode;
    this.accountBalance = accountBalance;
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
    System.out.println("Password: ");
  }


  public double getAccountBalance() {
    return accountBalance;
  }


  public void setAccountBalance(double accountBalance) {
    this.accountBalance = accountBalance;
  }


  @Override
  public String toString() {
    return "UserAccount [ username=" + username + ", accountBalance=" + accountBalance
        + "]";
  }



}
