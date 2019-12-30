package com.revature.controller;

import com.revature.repository.AccountDao;
import com.revature.repository.AccountDaoPostgress;
import com.revature.service.UserRegistration;

public class UserLoginInformation extends ScannerClass {

  static AccountDao accountDao = new AccountDaoPostgress();

  public static void userRegisterIntake() {
    
    System.out.println("Do you have an account?:\n1)YES\n2)NO");
    int userRegister = in.nextInt();
  
    if (userRegister == 1) {
    //Takes user to login console method
      UserMainSelection.login();
    } else if (userRegister == 2) {
    //Takes user to create new account method
      UserRegistration.userRegistration();
    }in.close();
  }
}
