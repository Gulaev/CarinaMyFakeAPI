package com.slovd.CarinaMyFakeAPI.web;

import com.slovd.CarinaMyFakeAPI.web.components.ProductCardComponent;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends AbstractPage {

  @FindBy(xpath = "//div[@class='l-GwW js-productad']")
  private List<ProductCardComponent> items;

  @FindBy(xpath = "//*[@data-qaid='breadcrumbs_seo_item']//span")
  private ExtendedWebElement searchElementTitle;

  public SearchPage(WebDriver driver) {
    super(driver);
    setUiLoadedMarker(searchElementTitle);
  }

  public String getSearchElementTitleText() {
    return searchElementTitle.getText();
  }

  public List<ProductCardComponent> getItems() {
    return items;
  }
}
