package com.revature.controller;

import java.util.Scanner;
import com.revature.service.UserRegistration;

public class UserLoginInformation  {

    

  public static void userRegisterIntake() {
    
    Scanner in =new Scanner(System.in);
    
    System.out.println("Do you have an account?:\n1)YES\n2)NO");
    int userRegister = in.nextInt();
  
    if (userRegister == 1) {
    //Takes user to login console method
      UserMainSelection.login();
    } else if (userRegister == 2) {
    //Takes user to create new account method
      UserRegistration.userRegistration();
    }in.close();
  }
}
