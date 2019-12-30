package com.revature.service;

import java.util.Scanner;
import com.revature.controller.UserMainSelection;
import com.revature.model.Account;
import com.revature.repository.AccountDao;
import com.revature.repository.AccountDaoPostgress;

public class WithdrawMoney {

  static Scanner in = new Scanner(System.in);

  public static void withdrawAmount() {

    AccountDao withdrawMoney = new AccountDaoPostgress();
    
    System.out.println("Enter the your username to withdraw: ");
    String username = in.nextLine();
    
    Account newBalance = withdrawMoney.getBalance(username);
    
    System.out.println("How much money would you like to withdraw?");
    double withdrawAmount = in.nextDouble();
  //Runs operations which add money from user balance in SQL
    newBalance.setAccountBalance(withdrawAmount);
    withdrawMoney.updateWithdraw(newBalance);
  //Prints out username and current balance
    System.out.println(withdrawMoney.getBalance(username));
  //Prompts user for another option
    UserMainSelection.doSomethingElse();
  

  }

}
