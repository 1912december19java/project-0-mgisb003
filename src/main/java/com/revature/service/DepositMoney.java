package com.revature.service;
import java.util.Scanner;
import com.revature.model.UserBalanceObject;

public class DepositMoney {
	
	Scanner in = new Scanner(System.in);	
	UserBalanceObject userBalance = new UserBalanceObject();
	
	public void depositAmount() {
		
		System.out.println("How much money would you like to deposit?");
		Integer depositAmount = in.nextInt();		
		Integer newBalance = depositAmount+userBalance;
		System.out.println("Your new balance is: " + newBalance);
		
		
	}

}
