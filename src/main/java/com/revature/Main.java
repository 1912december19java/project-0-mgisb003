package com.revature;

import com.revature.controller.UserLoginInformation;
import com.revature.controller.UserLoginIntake;
import com.revature.controller.UserMainSelection;
import com.revature.controller.UserPasswordIntake;
import com.revature.model.Account;
import com.revature.repository.AccountDao;
import com.revature.repository.AccountDaoPostgress;

/**
 * Create an instance of your controller and launch your application.
 * 
 * Try not to have any logic at all on this class.
 */
public class Main {

	public static void main(String[] args) {
		
	    UserLoginInformation.userRegisterIntake();
		UserMainSelection.userMainSelection();
		UserMainSelection.doSomethingElse();

	}
}
