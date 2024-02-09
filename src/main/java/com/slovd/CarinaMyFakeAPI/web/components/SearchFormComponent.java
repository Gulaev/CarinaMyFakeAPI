package com.slovd.CarinaMyFakeAPI.web.components;

import com.slovd.CarinaMyFakeAPI.web.SearchPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchFormComponent extends AbstractUIObject {

  public SearchFormComponent(WebDriver driver, SearchContext searchContext) {
    super(driver, searchContext);
  }
  @FindBy(xpath = ".//input[@type='search']")
  private ExtendedWebElement searchInput;

  @FindBy(xpath = ".//*[@type='submit']")
  private ExtendedWebElement searchButton;

  public SearchPage clickSearchButton(){
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
}
