package com.revature.service;

import java.util.Scanner;
import com.revature.controller.UserMainSelection;
import com.revature.model.Account;
import com.revature.repository.AccountDao;
import com.revature.repository.AccountDaoPostgress;

public class UserLoginIntake {

	public static void userLoginIntake() {
	  
	  AccountDao loginInfo = new AccountDaoPostgress();
	  
	    double accountBalance = 0;
		System.out.print("Enter username here: ");
		String userName = in.next();
		System.out.println("Enter password here: ");
		int password = in.nextInt();		
		login.setUsername(userName);
		login.setPasscode(password);
		loginInfo.login(userName, password);
		
		UserMainSelection.userMainSelection();
		

	}
}
