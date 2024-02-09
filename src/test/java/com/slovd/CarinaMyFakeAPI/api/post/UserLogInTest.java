package com.slovd.CarinaMyFakeAPI.api.post;

import com.slovd.CarinaMyFakeAPI.api.model.User;
import org.testng.annotations.Test;

public class UserLogInTest {

  @Test
  public void verifyCanUserLoginTest() {
    User user = new User();
    user.setUsername("mor_2314");
    user.setPassword("83r5^_");
    UserLogIn userLogIn = new UserLogIn(user);
    userLogIn.callAPIExpectSuccess();
    userLogIn.validateResponse();
  }

}
