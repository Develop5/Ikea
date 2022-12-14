package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static support.TestContest.*;

public class IkeaProductTablePage extends Page {

  @FindBy(xpath = "(//*[name()='svg'][@class='svg-icon button__add-to-cart-icon'])[3]")
  private WebElement thirdRowIcon;

  public void getThirdItemIcon() {
    getWait().until(ExpectedConditions.visibilityOf(thirdRowIcon));
    thirdRowIcon.isSelected();
  }

  @FindBy(xpath = "(//button[@type='button'])[12]")
  private WebElement addThirdItemToCart;

  public void addThirdItemToACart() {
    getExecutor().executeScript("arguments[0].scrollIntoView(true);", thirdRowIcon);
    getWait().until(ExpectedConditions.visibilityOf(thirdRowIcon));
    getExecutor().executeScript("arguments[0].click();", addThirdItemToCart);
    getWait().until(ExpectedConditions
        .visibilityOfElementLocated(By.xpath("(//div[@class='hnf-page-container'])[1]")));
  }

  @FindBy(xpath = "(//div[@class='hnf-page-container'])[1]")
  private WebElement pageHeader;

  @FindBy(xpath = "//*[@class='hnf-btn__inner js-shopping-cart-icon']")
  private WebElement cartButton;

  public void getCartButton() {
    getExecutor().executeScript("window.scrollBy(0,-250)");
    getWait().until(ExpectedConditions.visibilityOf(pageHeader));
    getWait().until(ExpectedConditions.visibilityOf(cartButton));
    getExecutor().executeScript("arguments[0].click();", cartButton);
  }
}
