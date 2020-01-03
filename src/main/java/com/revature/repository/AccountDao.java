package com.revature.repository;


import com.revature.model.Account;

public interface AccountDao {
  
  void updateDepositChecking(Account account);
  
  void updateWithdrawChecking(Account account);
  
  void updateDepositSaving(Account account);
  
  void updateWithdrawSaving(Account account);

  void saveUserInfo(Account account);
 
  Account getBalance(String username);
  
  Account getUsername(String username);
  
  Account getPassword(String password);
  
  void savingToChecking (Account account);
  
  void checkingToSaving (Account account);

}
