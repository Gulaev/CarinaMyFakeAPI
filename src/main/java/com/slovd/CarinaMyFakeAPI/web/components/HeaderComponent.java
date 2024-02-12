package com.slovd.CarinaMyFakeAPI.web.components;

import com.slovd.CarinaMyFakeAPI.web.HomePage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HeaderComponent extends AbstractUIObject {

  @FindBy(xpath = ".//*[@data-qaid='search_form']")
  private SearchFormComponent searchFormComponent;

  @FindBy(xpath = ".//button[@data-qaid='shopping_cart']")
  private ExtendedWebElement shoppingCartIcon;

  public HeaderComponent(WebDriver driver, SearchContext searchContext) {
    super(driver, searchContext);
    setUiLoadedMarker(shoppingCartIcon);
  }

  public SearchFormComponent getSearchFormComponent() {
    return searchFormComponent;
  }

  public ExtendedWebElement getShoppingCartIcon() {
    return shoppingCartIcon;
  }
  
  public SideBlockComponent clickToShoppingCart() {
    shoppingCartIcon.click();
    return new HomePage(getDriver()).getSideBlock();
  }
}
