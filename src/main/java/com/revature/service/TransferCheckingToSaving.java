package com.revature.service;

import java.util.InputMismatchException;
import com.revature.controller.UserMainSelection;
import com.revature.model.Account;

public class TransferCheckingToSaving extends UserMainSelection {

  public static void transferCheckingToSaving() {
    while (true) {
      try {
        Account transferBalance = user.getBalance(username);
        // Intakes transfer amount
        System.out.println("How much money would you like to transfer?");
        double transferAmount = Double.parseDouble(in.nextLine());
        if (transferAmount <= 0) {
          System.out.println("Your transfer amount is invalid.");
          transferCheckingToSaving();
          break;
        }
        // Runs operations which subtracts input from user balance in SQL and adds to other account
        transferBalance.setCheckingBalance(transferAmount);
        transferBalance.setSavingBalance(transferAmount);
        user.checkingToSaving(transferBalance);
        // Prints out username and current balance
        System.out.println(user.getBalance(username));

      } catch (InputMismatchException e) {
      } catch (NumberFormatException e) {
        transferCheckingToSaving();
        break;
      }
      // Prompts user for another option
      UserMainSelection.doSomethingElse();
      break;

    }

  }

}


