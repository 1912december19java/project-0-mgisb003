package com.revature.service;

import com.revature.controller.UserLoginInformation;
import com.revature.controller.UserMainSelection;
import com.revature.model.Account;
import com.revature.repository.AccountDao;
import com.revature.repository.AccountDaoPostgress;

public class UserRegistration extends UserLoginInformation {


  public static void userRegistration() {
    
    AccountDao newAccount = new AccountDaoPostgress();
    
  //Lets user enter new username
    System.out.println("Enter your new username: ");
    String username = in.nextLine();
  //Lets user enter new password
    System.out.println("Enter your new password: ");
    String password = in.nextLine();
  //Stores user information in DB
    Account newUser = new Account(username, password, 0);
    newAccount.saveUserInfo(newUser);
  //Prints out user DB info
    System.out.println(newUser);
  //Takes user to main selection screen
    UserMainSelection.userMainSelection();


  }
}
