package com.slovd.CarinaMyFakeAPI.web;

import com.slovd.CarinaMyFakeAPI.web.components.ProductCard;
import com.slovd.CarinaMyFakeAPI.web.components.SearchFormComponent;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import java.net.MalformedURLException;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageTest extends AbstractTest {

  @Test
  public void verifySearchTest() {
    HomePage homePage = new HomePage(getDriver());
    SoftAssert sa = new SoftAssert();
    homePage.open();
    Assert.assertTrue(homePage.isPageOpened());
    SearchFormComponent searchFormComponent = homePage.getHeader().getSearchFormComponent();
    sa.assertTrue(searchFormComponent.getSearchInput().isElementPresent(),
        "Input search name not found");
    sa.assertTrue(searchFormComponent.getSearchButton().isElementPresent(),
        "Button submit nut found");
    searchFormComponent.typeSearchInputValue("IPhone");
    SearchPage searchPage = searchFormComponent.clickSearchButton();
    List<ProductCard> productCards = searchPage.getProductCards();
    productCards.forEach(p -> System.out.println(p.getTitleText()));
//    searchFormComponent.clickSearchButton();
    System.out.println();
  }

}
