package com.revature.controller;

import java.util.InputMismatchException;
import java.util.Scanner;
import org.apache.log4j.Logger;
import com.revature.model.Account;
import com.revature.repository.AccountDao;
import com.revature.repository.AccountDaoPostgress;
import com.revature.service.CheckingDepositMoney;
import com.revature.service.CheckingWithdrawMoney;
import com.revature.service.SavingsDepositMoney;
import com.revature.service.SavingsWithdrawMoney;
import com.revature.service.TransferCheckingToSaving;
import com.revature.service.TransferSavingToChecking;
import com.revature.service.UserRegistration;
import com.revature.service.ViewBalance;

public class UserMainSelection {

  protected static String username;
  protected static String password;
  protected static Scanner in = new Scanner(System.in);
  protected static AccountDao user = new AccountDaoPostgress();
  static Account accountU;
  static Account accountP;
  private static Logger log = Logger.getLogger(AccountDaoPostgress.class);


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
        log.trace("User login incorrect");
        // Used once user runs out of login attempts, will prompt if they want to make a new account
        if (i == 0) {
          while (true) {
            try {
              System.out.println(
                  "Maximum number of attempts reached. Would you like to make a new account?\n1)YES\n2)NO");
              log.trace("user no account");
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

  // user decides if they want to access checking or savings
  public static void userMainSelection() {

    System.out.println(
        "Would you like to access your checking or your savings account?\n1)Checking\n2)Savings");
    Integer userChoice = Integer.parseInt(in.nextLine());

    while (true) {
      try {
        if (userChoice == 1) {
          checkingAccount();
          break;
        } else if (userChoice == 2) {
          savingsAccount();
          break;
        }
      } catch (InputMismatchException e) {

      } catch (NumberFormatException e) {
        System.out.println("Please enter 1 or 2");
      }
    }

  }

  public static void savingsAccount() {

    while (true) {
      try {
        // Allows user to make selection as to which function to use
        System.out.println(
            "What would you like to do?\n1)View balance\n2)Withdraw money\n3)Deposit money\n4)Transfer to checking account");
        Integer userChoice = Integer.parseInt(in.nextLine());

        if (userChoice == 1) {
          // Method for viewing current balance
          ViewBalance.viewBalance();
          break;

        } else if (userChoice == 2) {
          // Method for implementing withdraw
          SavingsWithdrawMoney.savingsWithdrawAmount();
          break;

        } else if (userChoice == 3) {
          // Method for implementing withdraw
          SavingsDepositMoney.savingsDepositAmount();
          break;
        } else if (userChoice == 4) {
          // Method for implementing transfer
          TransferSavingToChecking.transferSavingToChecking();
          break;
        }

      } catch (InputMismatchException e) {

      } catch (NumberFormatException e) {
        System.out.println("Please enter 1, 2, or 3");
      }
    }
  }

  public static void checkingAccount() {

    while (true) {
      try {
        // Allows user to make selection as to which function to use
        System.out.println(
            "What would you like to do?\n1)View balance\n2)Withdraw money\n3)Deposit money\n4)Transfer to savings account");
        Integer userChoice = Integer.parseInt(in.nextLine());

        if (userChoice == 1) {
          // Method for viewing current balance
          ViewBalance.viewBalance();
          break;

        } else if (userChoice == 2) {
          // Method for implementing withdraw
          CheckingWithdrawMoney.checkingWithdrawAmount();
          break;

        } else if (userChoice == 3) {
          // Method for implementing withdraw
          CheckingDepositMoney.checkingDepositAmount();
          break;
        } else if (userChoice == 4) {
          // Method for implementing withdraw
          TransferCheckingToSaving.transferCheckingToSaving();
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
