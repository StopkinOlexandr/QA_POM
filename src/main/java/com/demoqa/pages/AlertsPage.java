package com.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AlertsPage extends BasePage {

  public AlertsPage(WebDriver wd) {
    super(wd);
  }

  @FindBy(id = "promtButton")
  WebElement promtButton;

  public AlertsPage sendMessageToAlert(String message) {
//    click(promtButton);
    clickWithJSExecutor(promtButton, 0, 300); //если прямой клик не срабатывает то через js

    if (message != null) {
      wd.switchTo().alert().sendKeys(message);
      wd.switchTo().alert().accept();
    }
    return this;
  }

  @FindBy(id = "promptResult")
  WebElement promptResult;

  public AlertsPage assertMessage(String message) {
    Assert.assertTrue(promptResult.getText().contains(message));
    return this;
  }

  @FindBy(id = "alertButton")
  WebElement alertButton;

  public AlertsPage alertWindow() {
    click(alertButton);
    wd.switchTo().alert().accept();
    return this;
  }

  @FindBy(id = "timerAlertButton")
  WebElement timerAlertButton;

  public AlertsPage alertWindowAfter5Sec() {
    click(timerAlertButton);
    if (isAlertPresent()) {
//      wd.switchTo().alert();
      wd.switchTo().alert().accept();
      return this;
    }
    return this;
  }

  @FindBy(id = "confirmButton")
  WebElement confirmButton;
  public AlertsPage confirmButton(String text) {
    clickWithJSExecutor(confirmButton,0,100);
//    click(confirmButton);
//    wd.switchTo().alert().accept();

    if (text != null && text.equalsIgnoreCase("OK")) {
      wd.switchTo().alert().accept();
    } else if (text != null && text.equalsIgnoreCase("Cancel")) {
      wd.switchTo().alert().dismiss();
    }

    return this;
  }
  @FindBy(id = "confirmResult")
  WebElement confirmResult;

  public AlertsPage confirmResult(String message) {
    Assert.assertTrue(confirmResult.getText().contains(message));
    return this;
  }

}
