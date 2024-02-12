package com.slovd.CarinaMyFakeAPI.web.components;

import com.slovd.CarinaMyFakeAPI.web.CheckoutPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SideBlockCardItemComponent extends AbstractUIObject {

  @FindBy(xpath = "//button[@data-testid='create_order_btn']")
  private ExtendedWebElement createOrderButton;

  @FindBy(xpath = "//div[@data-testid='product_link']//span")
  private ExtendedWebElement itemTitle;

  public SideBlockCardItemComponent(WebDriver driver, SearchContext searchContext) {
    super(driver, searchContext);
    setUiLoadedMarker(createOrderButton);
  }

  public CheckoutPage clickCreateOrderButton() {
    createOrderButton.click();
    return new CheckoutPage(getDriver());
  }

  public String getItemTitleText() {
    return itemTitle.getText();
  }
}
