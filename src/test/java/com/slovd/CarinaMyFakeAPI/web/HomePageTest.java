package com.slovd.CarinaMyFakeAPI.web;

import com.zebrunner.carina.core.AbstractTest;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class HomePageTest extends AbstractTest {

  @Test
  public void verifySearchTest() throws MalformedURLException {
    HomePage homePage = new HomePage(getDriver());
    homePage.open();

    System.out.println();
  }

}
