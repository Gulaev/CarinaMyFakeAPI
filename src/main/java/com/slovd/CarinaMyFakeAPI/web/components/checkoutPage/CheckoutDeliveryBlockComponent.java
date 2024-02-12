package com.slovd.CarinaMyFakeAPI.web.components.checkoutPage;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import java.util.List;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckoutDeliveryBlockComponent extends AbstractUIObject {

  @FindBy(xpath = ".//li[@data-testid='list_item']")
  private List<CheckoutDeliveryBlockItemComponent> items;


  public CheckoutDeliveryBlockComponent(WebDriver driver, SearchContext searchContext) {
    super(driver, searchContext);
  }
}
