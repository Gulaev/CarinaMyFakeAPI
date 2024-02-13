package com.slovd.CarinaMyFakeAPI.web.components.homePage;

import com.slovd.CarinaMyFakeAPI.web.page.SearchPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CategoriesComponent extends AbstractUIObject {

  @FindBy(xpath = "//div[@data-qaid='menu_preview']")
  private ExtendedWebElement categoryUiElement;

  public CategoriesComponent(WebDriver driver, SearchContext searchContext) {
    super(driver, searchContext);
  }

  public SearchPage clickToRandomCategory() {
    categoryUiElement.doubleClick();
    return new SearchPage(getDriver());
  }
}
