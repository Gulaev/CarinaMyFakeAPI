package com.slovd.CarinaMyFakeAPI.web;

import com.slovd.CarinaMyFakeAPI.web.components.SearchFormComponent;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import java.net.MalformedURLException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageTest extends AbstractTest {

  @Test
  public void verifySearchTest() throws MalformedURLException {
    HomePage homePage = new HomePage(getDriver());
    SoftAssert sa = new SoftAssert();
    homePage.open();
    SearchFormComponent searchFormComponent  = homePage.getHeader().getSearchFormComponent();
//    searchFormComponent.typeSearchInputValue("Ручка");
//    searchFormComponent.clickSearchButton();
    sa.assertTrue(searchFormComponent.getSearchInput().isElementPresent(),
        "Input search name not found");
    sa.assertTrue(searchFormComponent.getSearchButton().isElementPresent(),
        "Button submit nut found");
    ExtendedWebElement searchInput = searchFormComponent.getSearchInput();

    searchInput.doubleClick();
    searchInput.sendKeys("value=Hiiii");
//    searchFormComponent.clickSearchButton();
    System.out.println();
  }

}
