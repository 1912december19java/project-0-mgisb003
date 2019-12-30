package com.revature.controller;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.revature.service.DepositMoney;
import com.revature.service.ViewBalance;
import com.revature.service.WithdrawMoney;

public class UserMainSelection {



  public static void userMainSelection() {
    Scanner in = new Scanner(System.in);
    try {
      while (true) {
      //Allows user to make selection as to which function to do
        System.out.println(
            "What would you like to do?\n1)View balance\n2)Withdraw money\n3)Deposit money");
        Integer userChoice = in.nextInt();

        if (userChoice == 1) {
        //Takes user to method which allows him to view balance
          ViewBalance.viewBalance();
          break;
        } else if (userChoice == 2) {
        //Takes user to method which allows him to withdraw amount
          WithdrawMoney.withdrawAmount();
          break;
        } else if (userChoice == 3) {
        //Takes user to method which allows him to deposit amount
          DepositMoney.depositAmount();
          break;
        //Reruns method on case of invalid input
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
//Allows user to do another function or exit program
  public static void doSomethingElse() {
    Scanner in = new Scanner(System.in);
    try {
      while (true) {
        System.out
            .println("Would you like to do anything else with your account?" + "\n1)Yes\n2)No");
        Integer userChoice = in.nextInt();
      
        if (userChoice == 1) {
        //Takes user to choice option
          UserMainSelection.userMainSelection();
          break;
        } else if (userChoice == 2) {
        //Terminates program
          System.out.println("Have a nice day :)");
          break;
        } else {
        //Reruns method on case of invalid input
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
