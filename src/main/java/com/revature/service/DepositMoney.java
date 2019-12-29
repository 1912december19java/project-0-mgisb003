package com.revature.service;

import java.util.Scanner;
import com.revature.model.Account;
import com.revature.repository.AccountDao;
import com.revature.repository.AccountDaoPostgress;

public class DepositMoney {

  static Scanner in = new Scanner(System.in);


  public static  void depositAmount() {
	  
	  AccountDao depositMoney = new AccountDaoPostgress();
	  
	  System.out.println("Enter your username to deposit money: ");
	  String username = in.nextLine();
		System.out.println("How much money would you like to deposit?");		
		Integer depositAmount = in.nextInt();
		
		Account balanceToChange = new Account(username, 0,0 );
		double currentBalance = balanceToChange.getAccountBalance();
	    balanceToChange.setAccountBalance(currentBalance + depositAmount);
		depositMoney.update(balanceToChange);
				
		System.out.println("Your new balance is: " + balanceToChange);

	}

}
