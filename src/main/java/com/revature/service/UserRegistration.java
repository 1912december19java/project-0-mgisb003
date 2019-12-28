package com.revature.service;

import java.util.Scanner;
import com.revature.model.Account;
import com.revature.repository.AccountDao;
import com.revature.repository.AccountDaoPostgress;

public class UserRegistration {

  static Scanner in = new Scanner(System.in);

  static AccountDao accountDao = new AccountDaoPostgress();

  public static void main(String[] args) {



  }

  public static String usernameRegistration() {

    System.out.println("Enter new Username here: ");
    String username = in.nextLine();
    Account saveUsername = accountDao.saveUsername(username);
    saveUsername.setUsername(username);

    return username;

  }

  public static int passwordRegistration() {

    System.out.println("Enter new password here");
    int password = in.nextInt();
    Account savePassword = accountDao.savePassword(password);
    savePassword.setPasscode(password);
    return password;
  }


}


