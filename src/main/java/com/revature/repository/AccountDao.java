package com.revature.repository;


import com.revature.model.Account;

public interface AccountDao {

  void update(Account account);

  public void saveUserInfo(Account account);

  Account login(String username, int password);
  
  Account getUsername(String username);

  Account getBalance(String username);
  

}
