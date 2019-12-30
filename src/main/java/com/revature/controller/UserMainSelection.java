package com.revature.controller;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.revature.model.Account;
import com.revature.repository.AccountDao;
import com.revature.repository.AccountDaoPostgress;
import com.revature.service.DepositMoney;
import com.revature.service.ViewBalance;
import com.revature.service.WithdrawMoney;

public class UserMainSelection {

  protected static String username;
  protected static String password;
  
  protected static Scanner in = new Scanner(System.in);
  protected static AccountDao user = new AccountDaoPostgress();
  
  
  public static void login() {    
    //Allows user to enter username and password
    System.out.print("Enter username here: ");
    username = in.nextLine();
    System.out.println("Enter password here: ");
    password = in.nextLine(); 
    Account account = user.getBalance(username);
    if ( account == null) {
      System.out.println("Incorrect username or password please try again. ");
      login();      
    }else {
    userMainSelection();
    }
  }

  public static void userMainSelection() {
    

   try {
      while (true) {
        // Allows user to make selection as to which function to do
        System.out.println(
            "What would you like to do?\n1)View balance\n2)Withdraw money\n3)Deposit money");
        Integer userChoice = in.nextInt();

        if (userChoice == 1) {
        //Method for viewing current balance
          ViewBalance.viewBalance();
          break;

        } else if (userChoice == 2) {
          //Method for implementing withdraw
          WithdrawMoney.withdrawAmount();
          break;

        } else if (userChoice == 3) {
          
          //Method for implementing withdraw
          DepositMoney.depositAmount();
          break;
          
          // Reruns method on case of invalid input
        } else {
          System.out.println("Please enter 1, 2, or 3");
        }
      }

    } catch (InputMismatchException e) {
      userMainSelection();
    } finally {
      in.close();
    }

  }

  // Allows user to do another function or exit program
  public static void doSomethingElse() {
    
    try {
      while (true) {
        System.out
            .println("Would you like to do anything else with your account?" + "\n1)Yes\n2)No");
        Integer userChoice = in.nextInt();

        if (userChoice == 1) {
          // Takes user to choice option
          UserMainSelection.userMainSelection();
          break;
        } else if (userChoice == 2) {
          // Terminates program
          System.out.println("Have a nice day :)");
          break;
        } else {
          // Reruns method on case of invalid input
          System.out.println("Please enter 1 or 2");
        }

      }
    } catch (InputMismatchException e) {
      UserMainSelection.doSomethingElse();
    } finally {
      in.close();
    }

  }

}
