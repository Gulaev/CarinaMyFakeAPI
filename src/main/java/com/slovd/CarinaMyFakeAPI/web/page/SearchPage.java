package com.slovd.CarinaMyFakeAPI.web.page;

import com.slovd.CarinaMyFakeAPI.web.components.ProductCardComponent;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends AbstractPage {

  @FindBy(xpath = "//div[@data-qaid='product_block']")
  private List<ProductCardComponent> productItems;

  @FindBy(xpath = "//*[@data-qaid='breadcrumbs_seo_item']//span")
  private ExtendedWebElement searchElementTitle;

  @FindBy(xpath = "//div[@data-qaid='price_local__gte']//input")
  private ExtendedWebElement pricePerFilterField;

  @FindBy(xpath = "//div[@data-qaid='price_local__lte']//input")
  private ExtendedWebElement priceToUpFilterField;

  @FindBy(xpath = "//button[@data-qaid='accept_price']")
  private ExtendedWebElement submitPriceFilterButton;

  @FindBy(xpath = "//*[@data-qatype='checked_price_local']")
  private ExtendedWebElement priceRangeFilterButton;

  public SearchPage(WebDriver driver) {
    super(driver);
    setUiLoadedMarker(searchElementTitle);
  }

  private void typePricePerFilterField(String value) {
    pricePerFilterField.type(value);
  }

  private void typePriceToUpFilterField(String value) {
    priceToUpFilterField.type(value);
  }

  private void clickSubmitPriceFilterButton() {
    submitPriceFilterButton.click();
  }

  public String getSearchElementTitleText() {
    return searchElementTitle.getText();
  }

  public List<ProductCardComponent> getProductItems() {
    return productItems;
  }

  public SearchPage setFilterPrice(String pricePer, String priceToUp) {
    typePricePerFilterField(pricePer);
    typePriceToUpFilterField(priceToUp);
    clickSubmitPriceFilterButton();
    return new SearchPage(getDriver());
  }
}
