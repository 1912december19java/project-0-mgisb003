package com.revature.service;

import java.util.InputMismatchException;
import com.revature.controller.UserMainSelection;
import com.revature.model.Account;

public class SavingsWithdrawMoney extends UserMainSelection {

  public static void savingsWithdrawAmount() {

    while (true) {
      try {
        Account newBalance = user.getBalance(username);
        // Intakes withdraw amount
        System.out.println("How much money would you like to withdraw?");
        double withdrawAmount = Double.parseDouble(in.nextLine());
        if (withdrawAmount <= 0) {
          System.out.println("Your withdrawal amount is invalid.");
          savingsWithdrawAmount();
          break;
        }
        // Runs operations which subtracts input from user balance in SQL
        newBalance.setSavingBalance(withdrawAmount);
        user.updateWithdrawSaving(newBalance);
        // Prints out username and current balance
        System.out.println(user.getBalance(username));

      } catch (InputMismatchException e) {
      } catch (NumberFormatException e) {
        savingsWithdrawAmount();
        break;
      }
      // Prompts user for another option
      UserMainSelection.doSomethingElse();
      break;

    }

  }
}


