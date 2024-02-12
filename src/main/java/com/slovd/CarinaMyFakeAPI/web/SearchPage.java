package com.slovd.CarinaMyFakeAPI.web;

import com.slovd.CarinaMyFakeAPI.web.components.ProductCardComponent;
import com.slovd.CarinaMyFakeAPI.web.components.checkoutPage.CheckoutDeliveryBlockItemComponent;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends AbstractPage {

  @FindBy(xpath = "//div[@class='l-GwW js-productad']")
  private List<ProductCardComponent> productItems;

  @FindBy(xpath = "//*[@data-qaid='breadcrumbs_seo_item']//span")
  private ExtendedWebElement searchElementTitle;

  @FindBy(xpath = "//input[@id=':catalog-ui-r5q:']")
  private ExtendedWebElement pricePerFilterField;

  @FindBy(xpath = "//input[@id=':catalog-ui-r5r:']")
  private ExtendedWebElement priceToUpFilterField;

  @FindBy(xpath = "//button[@data-qaid='accept_price']")
  private ExtendedWebElement okayPriceFilterButton;

  @FindBy(xpath = ".//li[@data-testid='list_item']")
  private List<CheckoutDeliveryBlockItemComponent> deliveryChoiceItems;

  public SearchPage(WebDriver driver) {
    super(driver);
    setUiLoadedMarker(searchElementTitle);
  }

  public String getSearchElementTitleText() {
    return searchElementTitle.getText();
  }

  public List<ProductCardComponent> getProductItems() {
    return productItems;
  }
}
