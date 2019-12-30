package com.revature.service;

import java.util.Scanner;
import com.revature.controller.UserMainSelection;
import com.revature.model.Account;
import com.revature.repository.AccountDao;
import com.revature.repository.AccountDaoPostgress;

public class DepositMoney {

  static Scanner in = new Scanner(System.in);


  public static void depositAmount() {

    AccountDao depositMoney = new AccountDaoPostgress();

    System.out.println("Enter the your username to deposit: ");
    String username = in.nextLine();
    
    Account newBalance = depositMoney.getBalance(username);
    
    System.out.println("How much money would you like to deposit?");
    double depositAmount = in.nextDouble();
  //Runs operations which add money from user balance in SQL
    newBalance.setAccountBalance(depositAmount);
    depositMoney.updateDeposit(newBalance);
  //Prints out username and current balance
    System.out.println(depositMoney.getBalance(username));
  //Prompts user for another option
    UserMainSelection.doSomethingElse();

  }

}
