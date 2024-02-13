package com.slovd.CarinaMyFakeAPI.web.components.checkoutPage;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

  public void typePhone(String value) {
    phoneInput.click();
    ((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1];",
        phoneInput.getElement(), value);
  }

  public void typeFirstName(String firstName) {
    firstNameInput.type(firstName);
  }

  public void typeLastName(String lastName) {
    lastNameInput.type(lastName);
  }

  public void clickSubmitButton() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.elementToBeClickable(submitButton.getElement()));
    submitButton.click();
  }
}
