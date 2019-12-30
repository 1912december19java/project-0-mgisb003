package com.revature.controller;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.revature.service.DepositMoney;
import com.revature.service.ViewBalance;
import com.revature.service.WithdrawMoney;

public class UserMainSelection {

	

	public static void userMainSelection() {
		Scanner in = new Scanner(System.in);
		try {
			while (true) {

				System.out
						.println("What would you like to do?\n1)View balance\n2)Withdraw money\n3)Deposit money");
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

		} catch (InputMismatchException e) {
			userMainSelection();
		} finally {
			in.close();
		}

	}

	public static void doSomethingElse() {
		Scanner in = new Scanner(System.in);
		try {
			while (true) {
				System.out.println("Would you like to do anything else with your account?" + "\n1)Yes\n2)No");
				Integer userChoice = in.nextInt();

				if (userChoice == 1) {
					UserMainSelection.userMainSelection();
					break;
				} else if (userChoice == 2) {
					System.out.println("Have a nice day :)");
					break;
				} else {
					System.out.println("Please enter 1 or 2");
				}

			}
		} catch (InputMismatchException e) {
			UserMainSelection.doSomethingElse();
		} finally {
			in.close();
		}

	}

}
