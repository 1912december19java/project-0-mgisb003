package com.revature.controller;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.revature.service.UserRegistration;

public class UserLoginInformation {

  public static void userRegisterIntake() {
    Scanner in = new Scanner(System.in);

    try {
      while (true) {
        System.out.print("Do you have an account?:\n1)YES\n2)NO");

        int userRegister = in.nextInt();

        if (userRegister == 1) {

          UserLoginIntake.userLoginIntake();
          UserPasswordIntake.userPasswordIntake();
          break;

        } else if (userRegister == 2) {

          UserRegistration.usernameRegistration();
          UserRegistration.passwordRegistration();
          break;

        }
      }
    } catch (InputMismatchException e) {
      userRegisterIntake();
    }finally {
      in.close();
    }


  }

}
