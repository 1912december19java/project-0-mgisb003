package com.revature.controller;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.revature.service.UserRegistration;

public class UserLoginInformation {


  static Scanner in = new Scanner(System.in);

  public static void userRegisterIntake() {
    while (true) {
      try {

        System.out.println("Do you have an account?:\n1)YES\n2)NO");
        Integer userRegister = Integer.parseInt(in.nextLine());

        if (userRegister == 1) {
          // Takes user to console login method
          UserMainSelection.login();
          break;
        } else if (userRegister == 2) {
          // Takes user to create new account method
          UserRegistration.userRegistration();
          break;
        }
      }catch (InputMismatchException e) {

      } catch (NumberFormatException e) {
        System.out.println("Please enter 1 or 2");
      }
    }
  }
}
