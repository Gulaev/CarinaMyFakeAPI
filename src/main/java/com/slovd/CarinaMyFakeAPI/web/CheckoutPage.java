package com.slovd.CarinaMyFakeAPI.web;

import com.slovd.CarinaMyFakeAPI.web.components.checkoutPage.CheckoutContactBlockComponent;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends AbstractPage {

  @FindBy(xpath = "//div[@data-testid='edit_contacts_block']")
  private CheckoutContactBlockComponent checkoutContactBlockComponent;

  @FindBy(xpath = "//ul[@data-testid='suggest_list_block']//li[@data-testid='list_item']")
  private List<ExtendedWebElement> departmentsLocations;

  @FindBy(xpath = "//div[@data-testid='payment_dd']//li[@data-testid='list_item']")
  private List<ExtendedWebElement> paymentsMethods;

  @FindBy(xpath = "//button[@data-testid='create_order_btn']")
  private ExtendedWebElement createOrderButton;

  public CheckoutPage(WebDriver driver) {
    super(driver);
    setUiLoadedMarker(createOrderButton);
  }

  public CheckoutContactBlockComponent getCheckoutContactBlockComponent() {
    return checkoutContactBlockComponent;
  }

  public List<ExtendedWebElement> getDepartmentsLocations() {
    return departmentsLocations;
  }
}
