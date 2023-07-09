package com.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{


  public HomePage(WebDriver wd) {
    super(wd);
  }

  @FindBy(xpath = "//h5[.='Alerts, Frame & Windows']")
  WebElement alertsFrameWindow;
  public SidePanel getAlertsFrameWindows() {
    clickWithJSExecutor(alertsFrameWindow, 0, 300);
    return new SidePanel(wd);
  }

  @FindBy(xpath = "//h5[.='Widgets']")
  WebElement widgets;

  public SidePanel getWidgets() {
    clickWithJSExecutor(widgets, 0, 300);
    return new SidePanel(wd);
  }

  @FindBy(xpath = "//h5[.='Interactions']")
  WebElement interactions;

  public void getInteractions() {
    clickWithJSExecutor(interactions,0,300);
  }

  @FindBy(xpath = "//h5[.='Forms']")
  WebElement forms;

  public SidePanel getForms() {
    clickWithJSExecutor(forms,0,300);
    return new SidePanel(wd);
  }
}
