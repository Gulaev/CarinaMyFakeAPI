package com.slovd.CarinaMyFakeAPI.web.components.checkoutPage;

import com.slovd.CarinaMyFakeAPI.web.page.CheckoutPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import java.util.List;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckoutDeliveryBlockItemComponent extends AbstractUIObject {

  @FindBy(xpath = ".//span[@data-testid='option_name']")
  private ExtendedWebElement deliveryCompanyButton;

  @FindBy(xpath = ".//div[@data-testid='item_name']")
  private List<ExtendedWebElement> deliveryMethods;

  @FindBy(xpath = ".//span[@data-testid='city_suggestions']")
  private List<ExtendedWebElement> deliveryCityButtons;

  @FindBy(xpath = ".//button[@data-testid='save_delivery_btn']")
  private ExtendedWebElement submitButton;

  @FindBy(xpath = ".//div[@data-testid='warehouse_dd']")
  private ExtendedWebElement choseLocationDepartmentButton;

  public CheckoutDeliveryBlockItemComponent(WebDriver driver, SearchContext searchContext) {
    super(driver, searchContext);
    setUiLoadedMarker(submitButton);
  }

  public List<ExtendedWebElement> clickToGetLocationDepartmentsButtons() {
    choseLocationDepartmentButton.click();
    return new CheckoutPage(getDriver()).getDepartmentsLocations();
  }

  public List<ExtendedWebElement> getDeliveryCityButtons() {
    return deliveryCityButtons;
  }

  public void clickToChoseDeliveryMethod() {
    deliveryCompanyButton.click();
  }



}
