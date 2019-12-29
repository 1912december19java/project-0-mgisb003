package com.revature.repository;


import com.revature.model.Account;

public interface AccountDao {

  void update(Account account);

  Account saveUserInfo(String username, int password, int accountBalance);

  Account get(String getAccountBalance);

  



  

}
