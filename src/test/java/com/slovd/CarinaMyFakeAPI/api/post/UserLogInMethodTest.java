package com.slovd.CarinaMyFakeAPI.api.post;

import com.slovd.CarinaMyFakeAPI.api.model.User;
import org.testng.annotations.Test;

public class UserLogInMethodTest {

  @Test
  public void verifyCanUserLoginTest() {
    User user = new User();
    user.setUsername("mor_2314");
    user.setPassword("83r5^_");
    UserLogInMethod userLogInMethod = new UserLogInMethod(user);
    userLogInMethod.callAPIExpectSuccess();
    userLogInMethod.validateResponse();
  }

}
