package com.slovd.CarinaMyFakeAPI.web.components;

import com.slovd.CarinaMyFakeAPI.web.HomePage;
import com.slovd.CarinaMyFakeAPI.web.SearchPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HeaderComponent extends AbstractUIObject {

  @FindBy(xpath = ".//button[@data-qaid='shopping_cart']")
  private ExtendedWebElement shoppingCartIcon;

  @FindBy(xpath = ".//*[@data-qaid='search_form'].//input[@type='search']")
  private ExtendedWebElement searchInput;

  @FindBy(xpath = ".//*[@data-qaid='search_form'].//*[@type='submit']")
  private ExtendedWebElement searchButton;

  public SideBlockComponent clickToShoppingCart() {
    shoppingCartIcon.click();
    return new HomePage(getDriver()).getSideBlock();
  }

  public HeaderComponent(WebDriver driver, SearchContext searchContext) {
    super(driver, searchContext);
    setUiLoadedMarker(shoppingCartIcon);
  }

  public SearchPage clickSearchButton() {
    searchButton.click();
    return new SearchPage(getDriver());
  }

  public void typeSearchInputValue(String value) {
    searchInput.clickIfPresent();
    searchInput.type(value);
  }

  public ExtendedWebElement getSearchInput() {
    return searchInput;
  }

  public ExtendedWebElement getSearchButton() {
    return searchButton;
  }

  public ExtendedWebElement getShoppingCartIcon() {
    return shoppingCartIcon;
  }
}
