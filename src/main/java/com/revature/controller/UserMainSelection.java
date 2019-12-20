package com.revature.controller;

import java.util.Scanner;
import com.revature.service.DepositMoney;
import com.revature.service.ViewBalance;
import com.revature.service.WithdrawMoney;

public class UserMainSelection {

	String checkBalance;
	String depositMoney;
	String withdrawMoney;

	static Scanner in = new Scanner(System.in);

	public static void userMainSelection() {
		while (true) {

			System.out.println("Would would you like to do?\n1)View balance\n2)Withdraw money"
								+ "\n3)Deposit money");
			Integer userChoice = in.nextInt();
			
			if (userChoice == 1) {
				ViewBalance.viewBalance();
				break;
			} else if (userChoice == 2) {
				WithdrawMoney.withdrawAmount();
				break;
			} else if (userChoice == 3) {
				DepositMoney.depositAmount();
				break;
			} else {
				System.out.println("Please enter 1, 2, or 3");
			}

		}

	}

	public static void doSomethingElse() {
		while (true) {
			System.out.println("Would you like to do anything else with your account?"
								+ "\n1)Yes\n2)No");
			Integer userChoice = in.nextInt();
			
			if (userChoice == 1) {
				System.out.println("this is where userMainSelection will be repeated");
				break;
			} else if (userChoice == 2) {
				System.out.println("Have a nice day :)");
				break;
			} else {
				System.out.println("Please enter 1 or 2");
			}

		}

	}

}
