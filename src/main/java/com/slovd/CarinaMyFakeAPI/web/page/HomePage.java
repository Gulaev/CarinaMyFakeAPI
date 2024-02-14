package com.slovd.CarinaMyFakeAPI.web.page;

import com.slovd.CarinaMyFakeAPI.web.components.HeaderComponent;
import com.slovd.CarinaMyFakeAPI.web.components.SideBlockComponent;
import com.slovd.CarinaMyFakeAPI.web.components.homePage.CategoriesComponent;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

  @FindBy(xpath = "//header")
  private HeaderComponent headerComponent;

  @FindBy(xpath = "//div[@data-qaid='sc_side_block']")
  private SideBlockComponent sideBlockComponent;

  @FindBy(xpath = "//div[@data-qaid='menu_preview']")
  private CategoriesComponent categories;

  @FindBy(xpath = "//div[@data-qaid='menu_preview']")
  private CategoriesComponent performCategoriesComponent;

  public HomePage(WebDriver driver) {
    super(driver);
    setUiLoadedMarker(headerComponent.getSearchInput());
  }

  public HeaderComponent getHeader() {
    return headerComponent;
  }

  public SideBlockComponent getSideBlock() {
    return sideBlockComponent;
  }

  public CategoriesComponent getCategories() {
    return categories;
  }
}
