package com.revature.service;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.revature.controller.UserLoginInformation;
import com.revature.controller.UserMainSelection;
import com.revature.model.Account;
import com.revature.repository.AccountDao;
import com.revature.repository.AccountDaoPostgress;

public class UserRegistration extends UserLoginInformation {

  static Scanner in = new Scanner(System.in);

  public static void userRegistration() {

    AccountDao newAccount = new AccountDaoPostgress();
    // Lets user enter new username to be stored
    System.out.println("Enter your new username: ");
    String username = in.nextLine();
    // Lets user enter new password to be stored
    System.out.println("Enter your new password: ");
    String password = in.nextLine();
    // Stores user information in DB
    Account account = newAccount.getBalance(username);
    // Checks if username already exists
    if (account != null) {
      System.out.println("Username already exists");
      userRegistration();
    } else {
      Account newUser = new Account(username, password, 0);
      newAccount.saveUserInfo(newUser);
      // Prints out user DB info
      System.out.println(newUser);
      log_in();
    }
  }


  public static void log_in() {
    while (true) {
      try {
        // Allows user to make choice of logging in or exiting
        System.out.println("Log in?\n1)YES\n2)NO");
        Integer Log_in = Integer.parseInt(in.nextLine());
        // Takes user to main selection screen
        if (Log_in == 1) {
          UserMainSelection.login();
          break;
        }
        // Terminates program
        else if (Log_in == 2) {
          System.out.println("Have a nice day :)");
          break;
        }
      } catch (InputMismatchException e) {

      } catch (NumberFormatException e) {
        System.out.println("Please enter 1 or 2");
      }
    }

  }
}

