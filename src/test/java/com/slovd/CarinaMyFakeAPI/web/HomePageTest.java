package com.slovd.CarinaMyFakeAPI.web;

import com.slovd.CarinaMyFakeAPI.web.components.HeaderComponent;
import com.slovd.CarinaMyFakeAPI.web.components.ProductCardComponent;
import com.slovd.CarinaMyFakeAPI.web.components.homePage.CategoriesComponent;
import com.slovd.CarinaMyFakeAPI.web.page.HomePage;
import com.slovd.CarinaMyFakeAPI.web.page.SearchPage;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.R;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageTest extends AbstractTest {

  private final static String SEARCH_INPUT = R.TESTDATA.get("searchInput");
  private final static String HOME_URL = R.TESTDATA.get("homeUrl");

  @Test(testName = "Test Case 1: Homepage Load Verification")
  public void verifyHomepageLoadTest() {
    HomePage homePage = new HomePage(getDriver());
    homePage.open();
    Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

    SoftAssert softAssert = new SoftAssert();
    CategoriesComponent categories = homePage.getCategories();
    categories.getCategoryUiElement().doubleClick();
    softAssert.assertFalse(getDriver().getCurrentUrl().equals(HOME_URL),
        "Invalid url, must by not home url");
    homePage.clickPromUALogo();
    softAssert.assertTrue(getDriver().getCurrentUrl().equals(HOME_URL),
        "Invalid url, must by home url");
    softAssert.assertAll();
  }


  @Test(testName = "Test Case 2: Search Functionality")
  public void verifySearchFunctionalityTest() {
    SoftAssert softAssert = new SoftAssert();
    HomePage homePage = new HomePage(getDriver());
    homePage.open();
    Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
    HeaderComponent headerComponent = homePage.getHeader();
    softAssert.assertTrue(headerComponent.getSearchInput().isElementPresent(),
        "Input search name not found");
    softAssert.assertTrue(headerComponent.getSearchButton().isElementPresent(),
        "Button submit nut found");
    headerComponent.typeSearchInputValue(SEARCH_INPUT);
    SearchPage searchPage = headerComponent.clickSearchButton();
    Assert.assertTrue(searchPage.isPageOpened(), "Search page is not open");
    List<ProductCardComponent> items = searchPage.getProductItems();
    softAssert.assertFalse(items.isEmpty(), "Items is not present by this request");
    String titleText;
    String itemText;

    for (ProductCardComponent productCardComponent : items) {
      titleText = productCardComponent.getTitleText();
      itemText = searchPage.getSearchElementTitleText();
      boolean containsSearchTerm = titleText.toLowerCase().contains(itemText.toLowerCase());
      softAssert.assertTrue(containsSearchTerm,
          "The title text does not contain the expected item text.");
    }
    softAssert.assertAll();
  }
}
