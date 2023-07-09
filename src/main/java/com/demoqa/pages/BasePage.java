package com.demoqa.pages;

import com.beust.ah.A;
import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

  WebDriver wd;

  public BasePage(WebDriver wd) {
    this.wd = wd;
    PageFactory.initElements(wd, this); //инициализация странички и элементов
  }

  public void click(WebElement element) {
    element.click();
  }

  public void type(WebElement element, String text) {
    if (text != null) {
      click(element);
      element.clear();
      element.sendKeys(text);
    }
  }
  public void typeWithJSExecutor(WebElement element, String text, int x, int y) {
    if (text != null) {
      clickWithJSExecutor(element, x, y);
      element.clear();
      element.sendKeys(text);
    }
  }

  public void clickWithJSExecutor(WebElement element, int x, int y) {
    JavascriptExecutor js = (JavascriptExecutor) wd;
    js.executeScript("window.scrollBy(" + x + "," + y + ")");
    click(element);
  }

  public boolean shouldHaveText(WebElement element, String text, int time) {
    return new WebDriverWait(wd, Duration.ofSeconds(time))
        .until(ExpectedConditions.textToBePresentInElement(element, text));
  }

  public void hideAdd() {
    JavascriptExecutor js = (JavascriptExecutor) wd;
    js.executeScript("document.getElementById('adplus-anchor').style.display='none';");
  }

  public void hideFooter() {
    JavascriptExecutor js = (JavascriptExecutor) wd;
    js.executeScript("document.querySelector('footer').style.display='none';");
  }

  public void hideIframes() {
    hideAdd();
    hideFooter();
  }

  public boolean isAlertPresent() {

    Alert alert = new WebDriverWait(wd, Duration.ofSeconds(20))
        .until(ExpectedConditions.alertIsPresent());
    if (alert == null) {
      return false;
    } else {
      return true;
    }
  }

  public void selectOS(WebElement element) {
    String os = System.getProperty("os.name");
    System.out.println("OS: " + os);
    if(os.startsWith("Mac")) {
      element.sendKeys(Keys.chord(Keys.COMMAND, "a"));
    } else {
      element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
    }
  }

  public void clickWithRectangle(WebElement element, int i, int j) {
    Rectangle rectangle = element.getRect();
    int offSetX = rectangle.getWidth() / i;
    int offSetY = rectangle.getHeight() / j;

    Actions actions = new Actions(wd);
    actions.moveToElement(element).perform();
    actions.moveByOffset(-offSetX, -offSetY).click().perform();
  }

}
