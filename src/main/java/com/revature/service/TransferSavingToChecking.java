package com.revature.service;

import java.util.InputMismatchException;
import com.revature.controller.UserMainSelection;
import com.revature.model.Account;

public class TransferSavingToChecking extends UserMainSelection {
  
  public static void transferSavingToChecking() {
    
    while (true) {
      try {
        Account transferBalance = user.getBalance(username);
        // Intakes transfer amount
        System.out.println("How much money would you like to transfer?");
        double transferAmount = Double.parseDouble(in.nextLine());
        if (transferAmount <= 0) {
          System.out.println("Your transfer amount is invalid.");
          transferSavingToChecking();
          break;
        }
        // Runs operations which subtracts input from user balance in SQL and adds to other account
        transferBalance.setSavingBalance(transferAmount);
        transferBalance.setCheckingBalance(transferAmount);
        user.savingToChecking(transferBalance);
        // Prints out username and current balance
        System.out.println(user.getBalance(username));

      } catch (InputMismatchException e) {
      } catch (NumberFormatException e) {
        transferSavingToChecking();
        break;
      }
      // Prompts user for another option
      UserMainSelection.doSomethingElse();
      break;

    }

  }


}
