package com.slovd.CarinaMyFakeAPI.api.post;

import com.slovd.CarinaMyFakeAPI.api.model.User;
import org.testng.annotations.Test;

public class SignUpTest {

  @Test
  public void verifyIfUserCanSignupTest() {
    User user = new User();
    user.setFirstName("luffy");
    user.setLastName("Monkey");
    user.setMessage("One Piece");
    user.setCountry("Japan");
    user.setEdm(false);
    user.setMobile(9124124);
    SignUp signup = new SignUp(user);
    signup.callAPIExpectSuccess();
    signup.validateResponse();
  }
}
