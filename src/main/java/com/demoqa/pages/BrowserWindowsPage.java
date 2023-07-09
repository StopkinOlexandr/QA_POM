package com.demoqa.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BrowserWindowsPage extends BasePage {

  public BrowserWindowsPage(WebDriver wd) {
    super(wd);
  }

  @FindBy(id = "windowButton")
  WebElement windowButton;

  public BrowserWindowsPage switchToNewWindow(int index) {
    click(windowButton);
    List<String> windows = new ArrayList<>(wd.getWindowHandles());
    wd.switchTo().window(windows.get(index));
    return this;
  }

  @FindBy(id = "tabButton")
  WebElement tabButton;



  public BrowserWindowsPage switchToNewTab() {
    click(tabButton);
//    Actions action= new Actions(wd);
//    action.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).build().perform();
//    Assert.assertTrue(shouldHaveText(sampleTabHeading, "This is a sample page", 5));

//    String oldTab=wd.getWindowHandle();
//    ArrayList<String> newTab = new ArrayList<String>(wd.getWindowHandles());
//    newTab.remove(oldTab);
//    wd.switchTo().window(newTab.get(0));
//
//    wd.switchTo().window(oldTab);

    return this;
  }

  @FindBy(id = "sampleHeading")
  WebElement sampleHeading;

  public BrowserWindowsPage assertNewWindowMessage(String text) {
    Assert.assertTrue(shouldHaveText(sampleHeading, text, 5));
    return this;
  }

//  @FindBy(id = "sampleHeading")
//  WebElement sampleTabHeading;
//
//  public BrowserWindowsPage assertNewTabMessage(String text) {
//    Assert.assertTrue(shouldHaveText(sampleTabHeading, text, 5));
//    return this;
//  }


}
