package com.revature.model;

public class Account {



  private String username;
  private String passcode;
  private String firstName;
  private String lastName;
  private double checkingBalance;
  private double savingBalance;


  public Account(String username, String passcode, String firstName, String lastName,
      double checkingBalance, double savingBalance) {
    super();

    this.username = username;
    this.passcode = passcode;
    this.firstName = firstName;
    this.lastName = lastName;
    this.checkingBalance = checkingBalance;
    this.savingBalance = savingBalance;
  }



  public String getUsername() {
    return username;
  }


  public void setUsername(String username) {
    this.username = username;
  }


  public String getPasscode() {
    return passcode;
  }


  public void setPasscode(String passcode) {
    this.passcode = passcode;
  }
  

  public String getFirstName() {
    return firstName;
  }


  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }


  public String getLastName() {
    return lastName;
  }


  public void setLastName(String lastName) {
    this.lastName = lastName;
  }


  public double getCheckingBalance() {
    return checkingBalance;
  }


  public void setCheckingBalance(double checkingBalance) {
    this.checkingBalance = checkingBalance;
  }


  public double getSavingBalance() {
    return savingBalance;
  }


  public void setSavingBalance(double savingBalance) {
    this.savingBalance = savingBalance;
  }


  @Override
  public String toString() {
    return "UserAccount:\n[ Username= " + username + "\nChecking balance= " + checkingBalance + "\nSavings balance= " + savingBalance + " ]\n";
  }



}
