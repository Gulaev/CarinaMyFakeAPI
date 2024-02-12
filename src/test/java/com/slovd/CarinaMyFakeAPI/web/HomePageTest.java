package com.slovd.CarinaMyFakeAPI.web;

import com.slovd.CarinaMyFakeAPI.web.components.HeaderComponent;
import com.slovd.CarinaMyFakeAPI.web.components.ProductCardComponent;
import com.slovd.CarinaMyFakeAPI.web.components.homePage.CategoriesComponent;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageTest extends AbstractTest {

  private final static String SEARCH_INPUT = R.TESTDATA.get("searchInput");

  @Test(testName = "")
  public void verifyHomepageLoad() {
    SoftAssert softAssert = new SoftAssert();
    HomePage homePage = new HomePage(getDriver());
    homePage.open();
    softAssert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
    CategoriesComponent categories = homePage.getCategories();
    categories.getCategoryUiElement().hover();
    categories.getCategories().get(0);
    homePage.clickPromUALogo();
    softAssert.assertTrue(getDriver().getCurrentUrl().equals(homePage.getCurrentUrl()));
    System.out.println();
  }


  @Test(testName = "")
  public void verifySearchFunctionality() {
    SoftAssert softAssert = new SoftAssert();
    HomePage homePage = new HomePage(getDriver());
    homePage.open();
    softAssert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
    HeaderComponent headerComponent = homePage.getHeader();
    softAssert.assertTrue(headerComponent.getSearchInput().isElementPresent(),
        "Input search name not found");
    softAssert.assertTrue(headerComponent.getSearchButton().isElementPresent(),
        "Button submit nut found");
    headerComponent.typeSearchInputValue(SEARCH_INPUT);
    SearchPage searchPage = headerComponent.clickSearchButton();
    softAssert.assertTrue(searchPage.isPageOpened(), "Search page is not open");
    List<ProductCardComponent> items = searchPage.getProductItems();
    softAssert.assertTrue(items.isEmpty(), "Items is not present by this request");
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
