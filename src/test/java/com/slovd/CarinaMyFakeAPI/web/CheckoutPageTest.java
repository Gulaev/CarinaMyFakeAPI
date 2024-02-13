package com.slovd.CarinaMyFakeAPI.web;

import com.slovd.CarinaMyFakeAPI.web.components.HeaderComponent;
import com.slovd.CarinaMyFakeAPI.web.components.ProductCardComponent;
import com.slovd.CarinaMyFakeAPI.web.components.SideBlockComponent;
import com.slovd.CarinaMyFakeAPI.web.components.checkoutPage.CheckoutContactBlockComponent;
import com.slovd.CarinaMyFakeAPI.web.components.checkoutPage.CheckoutDeliveryBlockItemComponent;
import com.slovd.CarinaMyFakeAPI.web.components.homePage.SideBlockCardItemComponent;
import com.slovd.CarinaMyFakeAPI.web.page.CheckoutPage;
import com.slovd.CarinaMyFakeAPI.web.page.HomePage;
import com.slovd.CarinaMyFakeAPI.web.page.SearchPage;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.R;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CheckoutPageTest extends AbstractTest {

  private final static String SEARCH_INPUT = R.TESTDATA.get("searchInput");
  private final static String PHONE_NUMBER = R.TESTDATA.get("phoneNumber");

  @Test(testName = "Test Case 5: Placing an Order")
  private void verifyPlacingAnOrderTest() {
    SoftAssert softAssert = new SoftAssert();
    HomePage homePage = new HomePage(getDriver());
    homePage.open();

    Assert.assertTrue(homePage.isPageOpened(), "Home page is not open");
    HeaderComponent headerComponent = homePage.getHeader();

    softAssert.assertTrue(headerComponent.getSearchInput().isElementPresent(),
        "Input search name not found");
    softAssert.assertTrue(headerComponent.getSearchButton().isElementPresent(),
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
    ProductCardComponent firstItem = items.get(0);
    softAssert.assertTrue(firstItem.isUIObjectPresent(), "First item is not present");

    String textItem = firstItem.getTitleText().toLowerCase();
    softAssert.assertTrue(textItem.contains(searchTitle),
        "Title name on first item is not contains request product name");

    firstItem.clickToAddToCardButton();
    SideBlockComponent sideBlockComponent = homePage.getHeader().clickToShoppingCart();

    softAssert.assertTrue(sideBlockComponent.isShoppingCardEmpty(), "Shopping card is empty");
    List<SideBlockCardItemComponent> sideBlockCardItemComponents =
        sideBlockComponent.getSideBlockCardItemComponents();

    int size = sideBlockCardItemComponents.size();
    Assert.assertEquals(size, 1, "Shopping cart dont have elements");
    SideBlockCardItemComponent sideBlockCardItemComponent = sideBlockCardItemComponents.get(0);
    CheckoutPage checkoutPage = sideBlockCardItemComponent.clickCreateOrderButton();
    Assert.assertTrue(checkoutPage.isPageOpened(), "Checkout page is not open");
    softAssert.assertTrue(checkoutPage.getCurrentUrl().toLowerCase().contains("shopping_cart"));
    softAssert.assertTrue(
        checkoutPage.getCurrentUrl().toLowerCase().contains(SEARCH_INPUT.toLowerCase()));

    CheckoutContactBlockComponent checkoutContactBlock =
        checkoutPage.getCheckoutContactBlockComponent();
    checkoutContactBlock.typePhone(PHONE_NUMBER);
    checkoutContactBlock.typeFirstName("Денис");
    checkoutContactBlock.typeLastName("Сосін");
    checkoutContactBlock.clickSubmitButton();
    softAssert.assertFalse(checkoutPage.isContactFormHidden(),
        "Contact block is not hidden after click to submit button");

    CheckoutDeliveryBlockItemComponent checkoutDeliveryBlockItem
        = checkoutPage.getDeliveryChoiceItems().get(0);
    checkoutDeliveryBlockItem.clickToChoseDeliveryMethod();
    checkoutDeliveryBlockItem.getDeliveryCityButtons().get(0).click();
    checkoutDeliveryBlockItem.clickToGetLocationDepartmentsButtons().get(0).click();
    softAssert.assertTrue(checkoutPage.isCreateOrderButtonClickable());
    checkoutPage.clickCreateOrderButton();
    softAssert.assertTrue(checkoutPage.isSMSSideMenuPresent());

    softAssert.assertAll();
  }

}
