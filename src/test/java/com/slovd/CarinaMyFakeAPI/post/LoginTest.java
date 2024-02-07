package com.slovd.CarinaMyFakeAPI.post;

import com.slovd.CarinaMyFakeAPI.api.post.Login;
import com.slovd.CarinaMyFakeAPI.model.User;
import org.testng.annotations.Test;

public class LoginTest {

  @Test
  public void isLogin() {
  User user = new User();
  user.setUserName("John");
  user.setPassword("Jardani");
  user.setVerified(true);
  Login login = new Login(user);
  login.callAPI();
  login.callAPIExpectSuccess();
  login.validateResponse();
  }

}
