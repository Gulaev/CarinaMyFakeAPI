package com.slovd.CarinaMyFakeAPI.api.post;

import com.slovd.CarinaMyFakeAPI.api.model.User;
import org.testng.annotations.Test;

public class ContactusTest {

  @Test
  public void isCanContactus() {
    User user = new User();
    user.setFirstName("Jardani");
    user.setLastName("Jovonovich");
    user.setMessage("Need help");
    user.setContact(1234567890);
    Contactus contactus = new Contactus(user);
    contactus.callAPIExpectSuccess();
  }
}


