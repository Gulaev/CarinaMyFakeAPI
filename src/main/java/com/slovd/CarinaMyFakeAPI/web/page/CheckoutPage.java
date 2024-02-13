package com.slovd.CarinaMyFakeAPI.web.page;

import com.slovd.CarinaMyFakeAPI.web.components.checkoutPage.CheckoutContactBlockComponent;
import com.slovd.CarinaMyFakeAPI.web.components.checkoutPage.CheckoutDeliveryBlockItemComponent;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage extends AbstractPage {

  @FindBy(xpath = ".//div[@data-testid='edit_contacts_block']")
  private CheckoutContactBlockComponent checkoutContactBlockComponent;

  @FindBy(xpath = ".//ul[@data-testid='suggest_list_block']//li[@data-testid='list_item']")
  private List<ExtendedWebElement> departmentsLocations;

  @FindBy(xpath = ".//div[@data-testid='payment_dd']//li[@data-testid='list_item']")
  private List<ExtendedWebElement> paymentsMethods;

  @FindBy(xpath = ".//button[@data-testid='create_order_btn']")
  private ExtendedWebElement createOrderButton;

  @FindBy(xpath = ".//li[@data-testid='list_item']")
  private List<CheckoutDeliveryBlockItemComponent> deliveryChoiceItems;

  @FindBy(xpath = ".//button[@data-testid='edit_option_btn']")
  private ExtendedWebElement editContactInformationButton;

  @FindBy(xpath = ".//div[@data-qaid='banochka_popup']")
  private ExtendedWebElement smsSideMenu;


  public CheckoutPage(WebDriver driver) {
    super(driver);
    setUiLoadedMarker(createOrderButton);
  }

  public List<CheckoutDeliveryBlockItemComponent> getDeliveryChoiceItems() {
    return deliveryChoiceItems;
  }

  public CheckoutContactBlockComponent getCheckoutContactBlockComponent() {
    return checkoutContactBlockComponent;
  }

  public List<ExtendedWebElement> getPaymentsMethods() {
    return paymentsMethods;
  }

  public ExtendedWebElement clickCreateOrderButton() {
    createOrderButton.hover();
    createOrderButton.doubleClick();
    return smsSideMenu;
  }

  public boolean isCreateOrderButtonClickable() {
    return createOrderButton.isClickable();
  }

  public boolean isContactFormHidden() {
    return editContactInformationButton.isElementPresent();
  }

  public List<ExtendedWebElement> getDepartmentsLocations() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    By locator = By.xpath("//ul[@data-testid='suggest_list_block']//li[@data-testid='list_item']");
    wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    return departmentsLocations;
  }

  public boolean isSMSSideMenuPresent() {
    return smsSideMenu.isElementPresent();
  }
}
