package com.revature;

import com.revature.controller.UserMainSelection;

/** 
 * Create an instance of your controller and launch your application.
 * 
 * Try not to have any logic at all on this class.
 */
public class Main {

	public static void main(String[] args) {
		
		UserMainSelection userChoice= new UserMainSelection();
		userChoice.userMainSelection();
		userChoice.doSomethingElse();

	}
}
