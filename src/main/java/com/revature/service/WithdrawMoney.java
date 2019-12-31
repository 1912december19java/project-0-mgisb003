package com.revature.service;

import java.util.InputMismatchException;
import com.revature.controller.UserMainSelection;
import com.revature.model.Account;

public class WithdrawMoney extends UserMainSelection {

  public static void withdrawAmount() {

    while (true) {
      try {
        Account newBalance = user.getBalance(username);
        // Intakes withdraw amount
        System.out.println("How much money would you like to withdraw?");
        double withdrawAmount = Double.parseDouble(in.nextLine());
        // Runs operations which subtracts input from user balance in SQL
        newBalance.setAccountBalance(withdrawAmount);
        user.updateWithdraw(newBalance);
        // Prints out username and current balance
        System.out.println(user.getBalance(username));
      } catch (InputMismatchException e) {
      } catch (NumberFormatException e) {
        withdrawAmount();
        break;
      }
      // Prompts user for another option
      UserMainSelection.doSomethingElse();
      break;

    }

  }
}


