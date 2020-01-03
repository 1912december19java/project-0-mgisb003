package jUnitTesting;

import static org.junit.Assert.*;
import org.junit.Test;
import com.revature.model.Account;
import com.revature.repository.AccountDaoPostgress;

public class Login extends AccountDaoPostgress {

  @Test
  public void test() {
    
    AccountDaoPostgress test = new AccountDaoPostgress();
    Account out = test.getUsername("mgisb1");
    assertEquals(out.getUsername(), out);
    
  }

}
