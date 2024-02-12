package com.slovd.CarinaMyFakeAPI.web;

import com.slovd.CarinaMyFakeAPI.web.components.ProductCardComponent;
import com.slovd.CarinaMyFakeAPI.web.components.SearchFormComponent;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageTest extends AbstractTest {

  @Test
  public void verifyHomepageLoad() {
    HomePage homePage = new HomePage(getDriver());
    homePage.open();
    Assert.assertTrue(homePage.isPageOpened());
    ExtendedWebElement promUALogo = homePage.getPromUALogo();
    promUALogo.click();
    System.out.println();
  }


  @Test
  public void verifySearchFunctionality() {
    SoftAssert sa = new SoftAssert();
    HomePage homePage = new HomePage(getDriver());
    homePage.open();
    sa.assertTrue(homePage.isPageOpened(), "Home page is not opened");
    SearchFormComponent searchForm = homePage.getHeader().getSearchFormComponent();
    sa.assertTrue(searchForm.getSearchInput().isElementPresent(),
        "Input search name not found");
    sa.assertTrue(searchForm.getSearchButton().isElementPresent(),
        "Button submit nut found");
    searchForm.typeSearchInputValue("IPhone");
    SearchPage searchPage = searchForm.clickSearchButton();
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
