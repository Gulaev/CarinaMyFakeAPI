package com.slovd.CarinaMyFakeAPI.web;

import com.slovd.CarinaMyFakeAPI.web.components.HeaderComponent;
import com.slovd.CarinaMyFakeAPI.web.components.ProductCardComponent;
import com.slovd.CarinaMyFakeAPI.web.components.SideBlockComponent;
import com.slovd.CarinaMyFakeAPI.web.components.homePage.SideBlockCardItemComponent;
import com.slovd.CarinaMyFakeAPI.web.page.CheckoutPage;
import com.slovd.CarinaMyFakeAPI.web.page.HomePage;
import com.slovd.CarinaMyFakeAPI.web.page.SearchPage;
import com.zebrunner.carina.core.AbstractTest;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SearchPageTest extends AbstractTest {

  private final static String SEARCH_INPUT = "IPhone";
  private final static String PRICE_PER = "100";
  private final static String PRICE_TO_UP = "1000";

  @Test(testName = "Checkout Process")
  public void verifyProductSelectionAndDetailViewingTest() {
    SoftAssert softAssert = new SoftAssert();
    HomePage homePage = new HomePage(getDriver());
    homePage.open();
    Assert.assertTrue(homePage.isPageOpened(), "Home page is not open");
    HeaderComponent headerComponent = homePage.getHeader();

    softAssert.assertTrue(headerComponent.isSearchInputPresent(),
        "Input search name not found");
    softAssert.assertTrue(headerComponent.isSearchButtonPresent(),
        "Button submit nut found");

    headerComponent.typeSearchInputValue(SEARCH_INPUT);
    SearchPage searchPage = headerComponent.clickSearchButton();
    String searchTitle = searchPage.getSearchElementTitleText().toLowerCase();

    Assert.assertTrue(searchPage.isPageOpened(), "Search page is not open");
    softAssert.assertEquals(searchTitle, SEARCH_INPUT.toLowerCase(),
        String.format("Incorrect search title name %s", searchTitle));
    softAssert.assertTrue(getDriver().getCurrentUrl().toLowerCase().contains(searchTitle));

    List<ProductCardComponent> items = searchPage.getProductItems();
    softAssert.assertFalse(items.isEmpty(),
        String.format("Items in search page not present by this request %s", searchTitle));

    for (ProductCardComponent productCardComponent : items) {
      String titleText = productCardComponent.getTitleText();
      String itemText = searchPage.getSearchElementTitleText();
      boolean containsSearchTerm = titleText.toLowerCase().contains(itemText.toLowerCase());
      softAssert.assertTrue(containsSearchTerm,
          "The title text does not contain the expected item text.");
    }

    ProductCardComponent firstItem = items.get(0);
    softAssert.assertTrue(firstItem.isUIObjectPresent(), "First item is not present");

    String textItem = firstItem.getTitleText().toLowerCase();
    softAssert.assertTrue(textItem.contains(searchTitle),
        "Title name on first item is not contains request product name");
    firstItem.clickToAddToCardButton();

    SideBlockComponent sideBlockComponent = homePage.getHeader().clickToShoppingCart();
    softAssert.assertTrue(sideBlockComponent.isShoppingCardEmpty(), "Shopping card is empty");
    List<SideBlockCardItemComponent> sideBlockCardItemComponents = sideBlockComponent
        .getSideBlockCardItemComponents();

    int size = sideBlockCardItemComponents.size();
    softAssert.assertEquals(size, 1, "Shopping cart dont have elements");

    SideBlockCardItemComponent sideBlockCardItemComponent = sideBlockCardItemComponents.get(0);
    softAssert.assertTrue(sideBlockCardItemComponent.getItemTitleText()
        .toLowerCase().contains(SEARCH_INPUT.toLowerCase()));
    CheckoutPage checkoutPage = sideBlockCardItemComponent.clickCreateOrderButton();

    Assert.assertTrue(checkoutPage.isPageOpened(), "Checkout page is not open");
    softAssert.assertTrue(checkoutPage.getCurrentUrl().toLowerCase().contains("shopping_cart"));
    softAssert.assertAll();
  }


  @Test(testName = "Filter Functionality")
  public void verifyFilterFunctionalityTest() {
    SoftAssert softAssert = new SoftAssert();
    HomePage homePage = new HomePage(getDriver());
    homePage.open();
    Assert.assertTrue(homePage.isPageOpened(), "Home page is not open");
    SearchPage searchPage = homePage.getCategories().clickToRandomCategory();
    Assert.assertTrue(searchPage.isPageOpened(), "Search page is not open");
    searchPage = searchPage.setFilterPrice(PRICE_PER, PRICE_TO_UP);
    Assert.assertTrue(searchPage.isPageOpened(), "Search page is not open");

    List<ProductCardComponent> items = searchPage.getProductItems();
    for (ProductCardComponent card : items) {
      int currentPrice = card.getPrice();
      softAssert.assertTrue((currentPrice >= Integer.parseInt(PRICE_PER))
              && (currentPrice <= Integer.parseInt(PRICE_TO_UP)),
          String.format("The price of the item: %s is not within the range of %s to %s",
              currentPrice, PRICE_PER, PRICE_TO_UP));
    }
    softAssert.assertAll();
  }
}
