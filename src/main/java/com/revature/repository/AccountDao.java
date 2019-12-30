package com.revature.repository;


import com.revature.model.Account;

public interface AccountDao {

  void updateDeposit(Account account);
  
  void updateWithdraw(Account account);

  void saveUserInfo(Account account);

  Account login(String username, int password);

  Account getBalance(String username);
  

}
