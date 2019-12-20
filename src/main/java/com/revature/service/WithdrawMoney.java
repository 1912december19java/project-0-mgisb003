package com.revature.service;

import java.util.Scanner;
import com.revature.model.UserBalanceObject;

public class WithdrawMoney {

	static Scanner in = new Scanner(System.in);

	UserBalanceObject userBalance = new UserBalanceObject();

	public static void withdrawAmount() {

		System.out.println("How much money would you like to deposit?");
		Integer withdrawAmount = in.nextInt();
		Integer newBalance = userBalance - withdrawAmount;
		System.out.println("Your new balance is: " + newBalance);

	}

}
