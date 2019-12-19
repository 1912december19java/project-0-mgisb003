package com.revature.service;

import java.util.Scanner;

public class UserPasswordIntake {
	
	Scanner in = new Scanner(System.in);
	
	public void userPasswordIntake() {
		System.out.print("Enter password here: ");
		Boolean userPassword = in.hasNext();
	}

}
