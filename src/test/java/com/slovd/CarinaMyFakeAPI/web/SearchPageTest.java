package com.slovd.CarinaMyFakeAPI.web;

import com.slovd.CarinaMyFakeAPI.web.components.HeaderComponent;
import com.slovd.CarinaMyFakeAPI.web.components.ProductCardComponent;
import com.slovd.CarinaMyFakeAPI.web.components.SideBlockCardItemComponent;
import com.slovd.CarinaMyFakeAPI.web.components.SideBlockComponent;
import com.zebrunner.carina.core.AbstractTest;
import java.util.List;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SearchPageTest extends AbstractTest {

  @Test(testName = "")
  public void verifyProductSelectionAndDetailViewingTest() {
    SoftAssert sa = new SoftAssert();
    HomePage homePage = new HomePage(getDriver());
    homePage.open();
    sa.assertTrue(homePage.isPageOpened(), "Home page is not open");
    HeaderComponent headerComponent = homePage.getHeader();
    sa.assertTrue(headerComponent.getSearchInput().isElementPresent(),
        "Input search name not found");
    sa.assertTrue(headerComponent.getSearchButton().isElementPresent(), "Button submit nut found");
    headerComponent.typeSearchInputValue("IPhone");
    SearchPage searchPage = headerComponent.clickSearchButton();
    sa.assertTrue(searchPage.isPageOpened(), "Search page is not open");
    String searchTitle = searchPage.getSearchElementTitleText().toLowerCase();
    sa.assertEquals(searchTitle, "iphone",
        String.format("Incorrect search title name %s", searchTitle));
    sa.assertTrue(getDriver().getCurrentUrl().contains(searchTitle));
    List<ProductCardComponent> items = searchPage.getItems();
    sa.assertTrue(items.isEmpty(),
        String.format("Items in search page not present by this request %s", searchTitle));
    ProductCardComponent firstItem = items.get(0);
    sa.assertTrue(firstItem.isUIObjectPresent(), "First item is not present");
    String textItem = firstItem.getTitleText().toLowerCase();
    sa.assertTrue(textItem.contains(searchTitle),
        "Title name on first item is not contains request product name");
//    String colorBeforeClick = firstItem.getCssValueOfAddToCardButton("color");
    firstItem.clickToAddToCardButton();
//    String colorAfterClick = firstItem.getCssValueOfAddToCardButton("color");
//    sa.assertNotEquals(colorBeforeClick, colorAfterClick, "Button color is not change");
    SideBlockComponent sideBlockComponent = homePage.getHeader().clickToShoppingCart();
    sa.assertFalse(sideBlockComponent.isShoppingCardEmpty(), "Shopping card is empty");
    List<SideBlockCardItemComponent> sideBlockCardItemComponents =
        sideBlockComponent.getSideBlockCardItemComponents();
    int size = sideBlockCardItemComponents.size();
    sa.assertEquals(size, 1, "Shopping cart dont have elements");
    sa.assertAll();
  }
}
