package com.revature.service;

import java.util.Scanner;
import com.revature.controller.UserMainSelection;
import com.revature.model.Account;
import com.revature.repository.AccountDao;
import com.revature.repository.AccountDaoPostgress;

public class ViewBalance {

  public static void viewBalance() {
   
    AccountDao viewBalance = new AccountDaoPostgress();
    Scanner in = new Scanner(System.in);
    
    System.out.println("Enter your username to view your balance: ");
    String username = in.nextLine();
  //Pulls up account balance from DB
    Account currentBalance = viewBalance.getBalance(username);
  //Prints out username and current balance
    System.out.println(currentBalance);
  //Prompts user to do something else
    UserMainSelection.doSomethingElse();

  }

}
