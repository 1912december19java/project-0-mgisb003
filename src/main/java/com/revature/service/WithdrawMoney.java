package com.revature.service;

import java.util.Scanner;
import com.revature.model.Account;
import com.revature.repository.AccountDao;
import com.revature.repository.AccountDaoPostgress;

public class WithdrawMoney {

  static Scanner in = new Scanner(System.in);

  public static void withdrawAmount() {

    AccountDao withdrawMoney = new AccountDaoPostgress();

    System.out.println("How much money would you like to withdraw?");
    double withdrawAmount = in.nextDouble();
    Account newBalance = withdrawMoney.getBalance(UserLoginIntake.login.getUsername()) - withdrawAmount;
    
    withdrawMoney.update();
   

    System.out.println("Your new balance is: " + newBalance);
  

  }

}
