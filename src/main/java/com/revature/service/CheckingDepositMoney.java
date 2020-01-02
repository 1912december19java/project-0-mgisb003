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
        Double depositMoney = Double.parseDouble(in.nextLine());
        if (depositMoney <= 0) {
          System.out.println("Your withdrawal amount is invalid.");
          depositAmount();
          break;
          }
        else if (depositMoney >= 10000001) {
          System.out.println("You can only deposit up to 10,000,000 at a time");
          depositAmount();
          break;
        }
        // Runs operations which adds input to user balance in SQL
        newBalance.setAccountBalance(depositMoney);
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
