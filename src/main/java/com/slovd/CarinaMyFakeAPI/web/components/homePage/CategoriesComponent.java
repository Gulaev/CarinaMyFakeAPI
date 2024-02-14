package com.slovd.CarinaMyFakeAPI.web.components.homePage;

import com.slovd.CarinaMyFakeAPI.web.page.SearchPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CategoriesComponent extends AbstractUIObject {

  @FindBy(xpath = "//div[@data-qaid='menu_preview']//ul/li")
  private List<ExtendedWebElement> categoryUiElement;

  public CategoriesComponent(WebDriver driver, SearchContext searchContext) {
    super(driver, searchContext);

  }

  public SearchPage clickToRandomCategory() {
    int random = new Random().nextInt(categoryUiElement.size());
    categoryUiElement.get(random).click();
    return new SearchPage(getDriver());
  }
}
