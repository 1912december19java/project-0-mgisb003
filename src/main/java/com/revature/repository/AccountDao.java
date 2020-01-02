package com.revature.repository;


import com.revature.model.Account;

public interface AccountDao {
  
  void updateDeposit(Account account);
  
  void updateWithdraw(Account account);

  void saveUserInfo(Account account);
 
  Account getBalance(String username);
  
  Account getUsername(String username);
  
  Account getPassword(String password);
  

}
