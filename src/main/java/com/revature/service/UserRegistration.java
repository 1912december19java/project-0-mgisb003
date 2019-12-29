package com.revature.service;

import java.util.Scanner;
import com.revature.repository.AccountDao;
import com.revature.repository.AccountDaoPostgress;

public class UserRegistration {
  
  
  public static void userRegistration() {
  Scanner in = new Scanner(System.in);
  
  System.out.println("Enter new username here: ");
  String username = in.nextLine();
  System.out.println("Enter new password here: ");
  int password = in.nextInt();
  
  AccountDao test1 = new AccountDaoPostgress();
  test1.saveUserInfo(username, password, 0);
  

  
  }
}
