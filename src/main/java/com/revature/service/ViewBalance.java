package com.revature.service;

import com.revature.controller.UserMainSelection;
import com.revature.model.Account;

public class ViewBalance extends UserMainSelection{

  public static void viewBalance() {  
   
  //Pulls up account balance from DB
    Account currentBalance = user.getBalance(username);
  //Prints out username and current balance
    System.out.println(currentBalance);
  //Prompts user to do something else
    UserMainSelection.doSomethingElse();

  }

}
