package com.revature.service;

import java.util.InputMismatchException;
import com.revature.controller.UserMainSelection;
import com.revature.model.Account;

public class DepositMoney extends UserMainSelection {


  public static void depositAmount() {

    while (true) {
      try {

        Account newBalance = user.getBalance(username);
        // Intakes deposit amount
        System.out.println("How much money would you like to deposit?");
        Double depositAmount = Double.parseDouble(in.nextLine());
        // Runs operations which adds input to user balance in SQL
        newBalance.setAccountBalance(depositAmount);
        user.updateDeposit(newBalance);
        // Prints out username and current balance
        System.out.println(user.getBalance(username));
      } catch (InputMismatchException e) {
      } catch (NumberFormatException e) {
        depositAmount();
        break;
      } // Prompts user for another option
        UserMainSelection.doSomethingElse();
        break;      
    }
  }

}
