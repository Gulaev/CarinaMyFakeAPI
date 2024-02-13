package com.slovd.CarinaMyFakeAPI.web.components;

import com.slovd.CarinaMyFakeAPI.web.page.HomePage;
import com.slovd.CarinaMyFakeAPI.web.page.SearchPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HeaderComponent extends AbstractUIObject {

  @FindBy(xpath = ".//button[@data-qaid='shopping_cart']")
  private ExtendedWebElement shoppingCartIcon;

  @FindBy(xpath = ".//*[@data-qaid='search_form']//input[@type='search']")
  private ExtendedWebElement searchInput;

  @FindBy(xpath = ".//*[@data-qaid='search_form']//*[@type='submit']")
  private ExtendedWebElement searchButton;

  @FindBy(xpath = ".//img[@alt='prom']")
  private ExtendedWebElement promUALogo;

  public HeaderComponent(WebDriver driver, SearchContext searchContext) {
    super(driver, searchContext);
    setUiLoadedMarker(shoppingCartIcon);
  }

  public SideBlockComponent clickToShoppingCart() {
    shoppingCartIcon.click();
    return new HomePage(getDriver()).getSideBlock();
  }

  public SearchPage clickSearchButton() {
    searchButton.click();
    return new SearchPage(getDriver());
  }

  public void typeSearchInputValue(String value) {
    searchInput.type(value);
  }

  public boolean isSearchInputPresent() {
    return searchInput.isElementPresent();
  }

  public boolean isSearchButtonPresent() {
    return searchButton.isElementPresent();
  }

  public HomePage clickPromUALogo() {
    promUALogo.click();
    return new HomePage(getDriver());
  }

  public ExtendedWebElement getSearchInput() {
    return searchInput;
  }

  public SearchPage searchingByQuery(String query) {
    searchInput.type(query);
    searchButton.click();
    return new SearchPage(getDriver());
  }
}
