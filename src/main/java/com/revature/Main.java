package com.revature;

import com.revature.controller.UserLoginIntake;
import com.revature.controller.UserMainSelection;
import com.revature.controller.UserPasswordIntake;

/**
 * Create an instance of your controller and launch your application.
 * 
 * Try not to have any logic at all on this class.
 */
public class Main {

	public static void main(String[] args) {
		
//		UserLoginIntake.userLoginIntake();
//		UserPasswordIntake.userPasswordIntake();
		UserMainSelection.userMainSelection();
		UserMainSelection.doSomethingElse();

	}
}
