package com.revature.service;

import java.util.Scanner;
import com.revature.controller.UserMainSelection;
import com.revature.model.Account;
import com.revature.repository.AccountDao;
import com.revature.repository.AccountDaoPostgress;

public class UserRegistration {


  public static void userRegistration() {
    
    AccountDao newAccount = new AccountDaoPostgress();
    Scanner in =new Scanner(System.in);
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
