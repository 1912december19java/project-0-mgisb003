package com.revature.controller;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.revature.repository.AccountDao;
import com.revature.repository.AccountDaoPostgress;
import com.revature.service.UserRegistration;

public class UserLoginInformation {

  int password;
  static AccountDao accountDao = new AccountDaoPostgress();



  public static void userRegisterIntake() {
    Scanner in = new Scanner(System.in);


    System.out.print("Do you have an account?:\n1)YES\n2)NO");

    try {
      while (true) {
        int userRegister = in.nextInt();

        if (userRegister == 1) {

          UserLoginIntake.userLoginIntake();
          UserPasswordIntake.userPasswordIntake();

        } else if (userRegister == 2) {

          UserRegistration.userRegistration();

        }

      }
    } catch (InputMismatchException e) {
     
    }catch (NullPointerException e) {
      UserMainSelection.userMainSelection();
    }finally {
      in.close();
    }

  }
}
