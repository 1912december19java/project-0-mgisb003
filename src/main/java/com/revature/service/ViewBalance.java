package com.revature.service;

import java.util.Scanner;
import com.revature.model.Account;

public class ViewBalance {

  public static void viewBalance() {
    Scanner in = new Scanner(System.in);
    System.out.println("Enter your username to view your current balance: ");
    String getAccountBalance = in.nextLine();
    Account viewUserBalance = new Account(getAccountBalance, 0, 0);
    System.out.println(viewUserBalance);
    in.close();
  }

}
