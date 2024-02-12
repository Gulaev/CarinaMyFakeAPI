package com.slovd.CarinaMyFakeAPI.web.components.checkoutPage;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckoutContactBlockComponent extends AbstractUIObject {

  @FindBy(xpath = ".//input[@id='phoneInputLabel']")
  private ExtendedWebElement phoneInput;

  @FindBy(xpath = ".//input[@id='last_name_block']")
  private ExtendedWebElement lastNameInput;

  @FindBy(xpath = ".//input[@id='first_name_block']")
  private ExtendedWebElement firstNameInput;

  @FindBy(xpath = ".//button[@data-testid='save_btn']")
  private ExtendedWebElement submitButton;

  public CheckoutContactBlockComponent(WebDriver driver, SearchContext searchContext) {
    super(driver, searchContext);
    setUiLoadedMarker(submitButton);
  }
}
