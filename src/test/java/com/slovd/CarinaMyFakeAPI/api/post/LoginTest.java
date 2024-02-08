package com.slovd.CarinaMyFakeAPI.api.post;

import com.slovd.CarinaMyFakeAPI.api.model.User;
import org.testng.annotations.Test;

public class LoginTest {

  @Test
  public void isLogin() {
    User user = new User();
    user.setUserName("John");
    user.setPassword("Jardani");
    user.setVerified(true);
    Login login = new Login(user);
    login.callAPIExpectSuccess();
    login.validateResponse();
  }

}
