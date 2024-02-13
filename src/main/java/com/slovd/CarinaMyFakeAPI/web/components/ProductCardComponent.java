package com.slovd.CarinaMyFakeAPI.web.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductCardComponent extends AbstractUIObject {

  @FindBy(xpath = ".//span[@data-qaid='product_name']")
  private ExtendedWebElement titleElement;

  @FindBy(xpath = ".//div[@data-qaid='product_price']")
  private ExtendedWebElement price;

  @FindBy(xpath = ".//a[@type='button']")
  private ExtendedWebElement addToCardButton;

  public ProductCardComponent(WebDriver driver, SearchContext searchContext) {
    super(driver, searchContext);
    setUiLoadedMarker(titleElement);
  }

  public String getTitleText() {
    return titleElement.getText();
  }

  public void clickToAddToCardButton() {
    addToCardButton.click();
  }

  public int getPrice() {
    String attribute = price.getAttribute("data-qaprice");
    try {
      double priceValue = Double.parseDouble(attribute);
      return (int) Math.round(priceValue);
    } catch (NumberFormatException e) {
      throw new RuntimeException("Failed to parse the price value: " + attribute, e);
    }
  }
}
