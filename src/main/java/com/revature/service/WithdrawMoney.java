package com.revature.service;

import com.revature.controller.UserMainSelection;
import com.revature.model.Account;

public class WithdrawMoney extends UserMainSelection {  

  public static void withdrawAmount() {
    
    Account newBalance = user.getBalance(username);
  //Intakes withdraw amount
    System.out.println("How much money would you like to withdraw?");
    double withdrawAmount = in.nextDouble();
  //Runs operations which subtracts input from user balance in SQL
    newBalance.setAccountBalance(withdrawAmount);
    user.updateWithdraw(newBalance);
  //Prints out username and current balance
    System.out.println(user.getBalance(username));
  //Prompts user for another option
    UserMainSelection.doSomethingElse();
  

  }

}
