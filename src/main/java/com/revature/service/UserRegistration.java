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
    System.out.println("Enter your new username: ");
    String username = in.nextLine();
    System.out.println("Enter your new password: ");
    String password = in.nextLine();
    Account newUser = new Account(username, password, 0);
    newAccount.saveUserInfo(newUser);
    System.out.println(newUser);
    
    UserMainSelection.userMainSelection();


  }
}
