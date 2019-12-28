package com.revature.repository;

import java.util.List;
import com.revature.model.Account;

public interface AccountDao {

  Account get(String username);
  
  Account saveUsername(String username);
  
  Account savePassword(int password);

  void update(Account account);

  

}
