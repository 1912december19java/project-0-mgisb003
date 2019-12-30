package com.revature.service;

import java.util.Scanner;
import com.revature.controller.UserLoginInformation;
import com.revature.controller.UserMainSelection;
import com.revature.model.Account;
import com.revature.repository.AccountDao;
import com.revature.repository.AccountDaoPostgress;

public class UserRegistration extends UserLoginInformation {


  public static void userRegistration() {
    
    AccountDao newAccount = new AccountDaoPostgress();
    Scanner in =new Scanner(System.in);
  //Lets user enter new username to be stored
    System.out.println("Enter your new username: ");
    String username = in.nextLine();
  //Lets user enter new password to be stored
    System.out.println("Enter your new password: ");
    String password = in.nextLine();
  //Stores user information in DB
    Account newUser = new Account(username, password, 0);
    newAccount.saveUserInfo(newUser);
  //Prints out user DB info
    System.out.println(newUser);
  //Allows user to make choice of logging in or exiting
    System.out.println("Log in?\n1)YES\n2)NO");
    int Log_in = in.nextInt();
  //Takes user to main selection screen
    if (Log_in == 1) {
    UserMainSelection.login();
    } 
  //Terminates program
    else {
      System.out.println("Have a nice day :)");
    }
    in.close();
  }
}
