package com.slovd.CarinaMyFakeAPI.web;

import com.slovd.CarinaMyFakeAPI.web.components.ProductCard;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends AbstractPage {

  @FindBy(xpath = "//*[contains(@class,'l-GwW js-productad')]")
  private List<ProductCard> productCards;

  public SearchPage(WebDriver driver) {
    super(driver);

  }

  public List<ProductCard> getProductCards() {
    return productCards;
  }
}
