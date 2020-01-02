package com.revature.controller;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.revature.model.Account;
import com.revature.repository.AccountDao;
import com.revature.repository.AccountDaoPostgress;
import com.revature.service.DepositMoney;
import com.revature.service.UserRegistration;
import com.revature.service.ViewBalance;
import com.revature.service.WithdrawMoney;

public class UserMainSelection {

  protected static String username;
  protected static String password;
  protected static Scanner in = new Scanner(System.in);
  protected static AccountDao user = new AccountDaoPostgress();
  static Account accountU;
  static Account accountP;


  public static void login() {

    for (int i = 3; i >= 0; i--) {
      // Allows user to enter username and password
      System.out.println("Enter username here: ");
      username = in.nextLine();
      System.out.println("Enter password here: ");
      password = in.nextLine();
      // Used to verify if account exists in DB
      accountU = user.getUsername(username);
      accountP = user.getPassword(password);
      if (accountU != null & accountP != null) {
        userMainSelection();
        break;
      } else if (accountU == null || accountP == null) {
        System.out.println("Incorrect username or password please try again. You have " + i
            + " attempts remaining.");
        if (i == 0) {
          while (true) {
            try {
              System.out.println(
                  "Maximum number of attempts reached. Would you like to make a new account?\n1)YES\n2)NO");
              Integer newAccount = Integer.parseInt(in.nextLine());
              if (newAccount == 1) {
                UserRegistration.userRegistration();
                break;

              } else if (newAccount == 2) {
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
    }
  }



  public static void userMainSelection() {


    while (true) {
      try {
        // Allows user to make selection as to which function to use
        System.out.println(
            "What would you like to do?\n1)View balance\n2)Withdraw money\n3)Deposit money");
        Integer userChoice = Integer.parseInt(in.nextLine());

        if (userChoice == 1) {
          // Method for viewing current balance
          ViewBalance.viewBalance();
          break;

        } else if (userChoice == 2) {
          // Method for implementing withdraw
          WithdrawMoney.withdrawAmount();
          break;

        } else if (userChoice == 3) {
          // Method for implementing withdraw
          DepositMoney.depositAmount();
          break;
        }

      } catch (InputMismatchException e) {

      } catch (NumberFormatException e) {
        System.out.println("Please enter 1, 2, or 3");
      }
    }
  }

  // Allows user to do another function or exit program
  public static void doSomethingElse() {

    while (true) {
      try {
        System.out
            .println("Would you like to do anything else with your account?" + "\n1)Yes\n2)No");
        Integer userChoice = Integer.parseInt(in.nextLine());

        if (userChoice == 1) {
          // Takes user to choice option
          userMainSelection();
          break;
        } else if (userChoice == 2) {
          // Terminates program
          System.out.println("Have a nice day :)");
          break;
        }
      } catch (InputMismatchException e) {

      } catch (NumberFormatException e) {
        System.out.println("Please enter 1 or 2");
        doSomethingElse();
      }
      break;
    }

  }
}
