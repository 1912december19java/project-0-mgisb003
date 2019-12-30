package com.revature.service;

import java.util.Scanner;
import com.revature.controller.UserMainSelection;
import com.revature.model.Account;
import com.revature.repository.AccountDao;
import com.revature.repository.AccountDaoPostgress;

public class ViewBalance {

  public static void viewBalance() {
    AccountDao getAccBal = new AccountDaoPostgress();

    Scanner in = new Scanner(System.in);
    AccountDao viewBalance = new AccountDaoPostgress();
    System.out.println("Enter your username to view your balance: ");
    String username = in.nextLine();
    Account currentBalance = viewBalance.getBalance(username);
    System.out.println(currentBalance);
    
    UserMainSelection.doSomethingElse();

  }

}
