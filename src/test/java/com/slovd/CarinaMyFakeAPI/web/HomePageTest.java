package com.slovd.CarinaMyFakeAPI.web;

import com.slovd.CarinaMyFakeAPI.web.components.HeaderComponent;
import com.slovd.CarinaMyFakeAPI.web.components.ProductCardComponent;
import com.slovd.CarinaMyFakeAPI.web.components.homePage.CategoriesComponent;
import com.slovd.CarinaMyFakeAPI.web.page.HomePage;
import com.slovd.CarinaMyFakeAPI.web.page.SearchPage;
import com.zebrunner.carina.core.AbstractTest;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageTest extends AbstractTest {

  private final static String SEARCH_INPUT = "IPhone";
  private final static String HOME_URL = "https://prom.ua/ua/";

  @Test(testName = "Test Case 1: Homepage Load Verification")
  public void verifyHomepageLoadTest() {
    HomePage homePage = new HomePage(getDriver());
    homePage.open();
    Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

    SoftAssert softAssert = new SoftAssert();
    CategoriesComponent categories = homePage.getCategories();
    SearchPage searchPage = categories.clickToRandomCategory();
    softAssert.assertFalse(searchPage.getCurrentUrl().equals(HOME_URL),
        String.format("Invalid URL, it must not be equal to %s", HOME_URL));
    homePage = homePage.getHeader().clickPromUALogo();
    softAssert.assertTrue(homePage.getCurrentUrl().equals(HOME_URL),
        String.format("Invalid URL, must by %s", HOME_URL));
    softAssert.assertAll();
  }


  @Test(testName = "Test Case 2: Search Functionality")
  public void verifySearchFunctionalityTest() {
    SoftAssert softAssert = new SoftAssert();
    HomePage homePage = new HomePage(getDriver());
    homePage.open();
    Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
    HeaderComponent headerComponent = homePage.getHeader();
    softAssert.assertTrue(headerComponent.isSearchInputPresent(),
        "Input search name not found");
    softAssert.assertTrue(headerComponent.isSearchButtonPresent(),
        "Button submit not found");
    SearchPage searchPage = headerComponent.searchingByQuery(SEARCH_INPUT);
    Assert.assertTrue(searchPage.isPageOpened(), "Search page is not open");
    List<ProductCardComponent> items = searchPage.getProductItems();
    softAssert.assertFalse(items.isEmpty(), "Items is not present by this request");

    for (ProductCardComponent productCardComponent : items) {
      String titleText = productCardComponent.getTitleText();
      String itemText = searchPage.getSearchElementTitleText();
      boolean containsSearchTerm = titleText.toLowerCase().contains(itemText.toLowerCase());
      softAssert.assertTrue(containsSearchTerm,
          "The title text does not contain the expected item text.");
    }
    softAssert.assertAll();
  }
}
