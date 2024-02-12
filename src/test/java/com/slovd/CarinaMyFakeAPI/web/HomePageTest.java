package com.slovd.CarinaMyFakeAPI.web;

import com.slovd.CarinaMyFakeAPI.web.components.HeaderComponent;
import com.slovd.CarinaMyFakeAPI.web.components.ProductCardComponent;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageTest extends AbstractTest {

  @Test(testName = "")
  public void verifyHomepageLoad() {
    HomePage homePage = new HomePage(getDriver());
    homePage.open();
    Assert.assertTrue(homePage.isPageOpened());
    ExtendedWebElement promUALogo = homePage.getPromUALogo();
    promUALogo.click();
    System.out.println();
  }


  @Test(testName = "")
  public void verifySearchFunctionality() {
    SoftAssert sa = new SoftAssert();
    HomePage homePage = new HomePage(getDriver());
    homePage.open();
    sa.assertTrue(homePage.isPageOpened(), "Home page is not opened");
    HeaderComponent headerComponent = homePage.getHeader();
    sa.assertTrue(headerComponent.getSearchInput().isElementPresent(),
        "Input search name not found");
    sa.assertTrue(headerComponent.getSearchButton().isElementPresent(),
        "Button submit nut found");
    headerComponent.typeSearchInputValue("IPhone");
    SearchPage searchPage = headerComponent.clickSearchButton();
    sa.assertTrue(searchPage.isPageOpened(), "Search page is not open");
    List<ProductCardComponent> items = searchPage.getItems();
    sa.assertTrue(items.isEmpty(), "Items is not present by this request");
    String titleText;
    String itemText;

    for (ProductCardComponent productCardComponent : items) {
      titleText = productCardComponent.getTitleText();
      itemText = searchPage.getSearchElementTitleText();
      boolean containsSearchTerm = titleText.toLowerCase().contains(itemText.toLowerCase());
      sa.assertTrue(containsSearchTerm,
          "The title text does not contain the expected item text.");
    }
    sa.assertAll();
  }
}
