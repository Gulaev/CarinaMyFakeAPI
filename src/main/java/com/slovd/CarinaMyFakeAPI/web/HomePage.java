package com.slovd.CarinaMyFakeAPI.web;

import com.slovd.CarinaMyFakeAPI.web.components.HeaderComponent;
import com.slovd.CarinaMyFakeAPI.web.components.SideBlockComponent;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

  @FindBy(xpath = "//header")
  private HeaderComponent headerComponent;

  @FindBy(xpath = "//header//img[@alt='prom']")
  private ExtendedWebElement promUALogo;

  @FindBy(xpath = "//div[@data-qaid='sc_side_block']")
  private SideBlockComponent sideBlockComponent;

  public HomePage(WebDriver driver) {
    super(driver);
    setUiLoadedMarker(promUALogo);
  }

  public HeaderComponent getHeader() {
    return headerComponent;
  }

  public ExtendedWebElement getPromUALogo() {
    return promUALogo;
  }

  public SideBlockComponent getSideBlock() {
    return sideBlockComponent;
  }
}
