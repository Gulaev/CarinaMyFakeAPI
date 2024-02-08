package com.slovd.CarinaMyFakeAPI.web.components;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Header extends AbstractUIObject {

  @FindBy(xpath = ".//*[@data-qaid='search_form']")
  private SearchFormComponent searchFormComponent;

  public Header(WebDriver driver, SearchContext searchContext) {
    super(driver, searchContext);
  }

  public SearchFormComponent getSearchFormComponent() {
    return searchFormComponent;
  }
}
