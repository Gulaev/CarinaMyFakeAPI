package com.slovd.CarinaMyFakeAPI.web;

import com.slovd.CarinaMyFakeAPI.web.components.Header;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

  @FindBy(xpath = "//header")
  private Header header;

  public HomePage(WebDriver driver) {
    super(driver);
    setUiLoadedMarker(header.getSearchFormComponent().getSearchInput());
  }

  public Header getHeader() {
    return header;
  }
}
