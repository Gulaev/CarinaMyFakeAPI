package com.slovd.CarinaMyFakeAPI.web;

import com.slovd.CarinaMyFakeAPI.web.components.HeaderComponent;
import com.slovd.CarinaMyFakeAPI.web.components.SideBlockComponent;
import com.slovd.CarinaMyFakeAPI.web.components.homePage.CategoriesComponent;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

  @FindBy(xpath = "//header")
  private HeaderComponent headerComponent;

  @FindBy(xpath = "//header//img[@alt='prom']")
  private ExtendedWebElement promUALogo;

  @FindBy(xpath = "//div[@data-qaid='sc_side_block']")
  private SideBlockComponent sideBlockComponent;

  @FindBy(xpath = "//div[@data-qaid='menu_preview']")
  private CategoriesComponent categories;

  @FindBy(xpath = "//div[@class='l-GwW _2CmaJ']")
  private CategoriesComponent performCategoriesComponent;

  public HomePage(WebDriver driver) {
    super(driver);
    setUiLoadedMarker(promUALogo);
  }

  public HeaderComponent getHeader() {
    return headerComponent;
  }

  public HomePage clickPromUALogo() {
    promUALogo.click();
    return new HomePage(getDriver());
  }

  public SideBlockComponent getSideBlock() {
    return sideBlockComponent;
  }

  public CategoriesComponent getCategories() {
    return categories;
  }
}
