package com.slovd.CarinaMyFakeAPI.api.post;

import com.slovd.CarinaMyFakeAPI.api.model.User;
import org.testng.annotations.Test;

public class LogInTest {

  @Test
  public void verifyIsUserCanLoginTest() {
    User user = new User();
    user.setUserName("John");
    user.setPassword("Jardani");
    user.setVerified(true);
    LogIn login = new LogIn(user);
    login.callAPIExpectSuccess();
    login.validateResponse();
  }

}
