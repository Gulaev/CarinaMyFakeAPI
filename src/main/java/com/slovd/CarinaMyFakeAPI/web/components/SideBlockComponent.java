package com.slovd.CarinaMyFakeAPI.web.components;

import com.slovd.CarinaMyFakeAPI.web.components.homePage.SideBlockCardItemComponent;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import java.util.List;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SideBlockComponent extends AbstractUIObject {

  @FindBy(xpath = ".//div[@data-qaid='sc_side_block']")
  public ExtendedWebElement returnToShoppingButton;

  @FindBy(xpath = ".//li[@data-testid='cart_block']")
  private List<SideBlockCardItemComponent> sideBlockCardItemComponents;

  public SideBlockComponent(WebDriver driver, SearchContext searchContext) {
    super(driver, searchContext);
  }

  public boolean isShoppingCardEmpty() {
    return !returnToShoppingButton.isElementPresent();
  }

  public List<SideBlockCardItemComponent> getSideBlockCardItemComponents() {
    return sideBlockCardItemComponents;
  }
}
