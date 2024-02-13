package com.slovd.CarinaMyFakeAPI.web.components.checkoutPage;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutContactBlockComponent extends AbstractUIObject {

  @FindBy(xpath = ".//input[@id='phoneInputLabel']")
  private ExtendedWebElement phoneInput;

  @FindBy(xpath = ".//input[@id='last_name_block']")
  private ExtendedWebElement lastNameInput;

  @FindBy(xpath = ".//input[@id='first_name_block']")
  private ExtendedWebElement firstNameInput;

  @FindBy(xpath = ".//button[@data-testid='save_btn']")
  private ExtendedWebElement submitButton;

  @FindBy(xpath = ".//*[@data-testid='input_field_correct_value']")
  private List<ExtendedWebElement> acceptedDataInInputs;

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
    waitUntil(ExpectedConditions.elementToBeClickable(submitButton.getElement()), 10);
    submitButton.click();
  }

  public boolean validateAllDataInInputAccepted() {
    return acceptedDataInInputs.size() == 3;
  }
}
