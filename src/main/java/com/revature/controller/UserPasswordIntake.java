package com.revature.controller;

import java.util.Scanner;

public class UserPasswordIntake {
	
	static Scanner in = new Scanner(System.in);
	
	public static void userPasswordIntake() {
		System.out.print("Enter password here: ");
		Integer userPassword = in.nextInt();
	}

}
