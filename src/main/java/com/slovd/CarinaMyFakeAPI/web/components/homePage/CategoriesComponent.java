package com.slovd.CarinaMyFakeAPI.web.components.homePage;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoriesComponent extends AbstractUIObject {

  public CategoriesComponent(WebDriver driver, SearchContext searchContext) {
    super(driver, searchContext);
  }

  @FindBy(xpath = ".//span[@style='vertical-align: middle;']")
  private List<ExtendedWebElement> categories;

  @FindBy(xpath = "//div[@data-qaid='menu_preview']")
  private ExtendedWebElement categoryUiElement;

  public List<ExtendedWebElement> getCategories() {
    categoryUiElement.hover();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    By locator = By.xpath(".//span[@style='vertical-align: middle;']");
    wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    return categories;
  }

  public ExtendedWebElement getCategoryUiElement() {
    return categoryUiElement;
  }
}
