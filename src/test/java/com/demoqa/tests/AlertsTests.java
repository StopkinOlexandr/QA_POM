package com.demoqa.tests;

import com.demoqa.pages.AlertsPage;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsTests extends TestBase{

  @BeforeMethod
  public void openHomePage() {
    new HomePage(wd).getAlertsFrameWindows();
    new SidePanel(wd).selectAlerts();
  }

  @Test
  public void sendMessageToAlertTest() {
    new AlertsPage(wd).sendMessageToAlert("Hello World!")
        .assertMessage("Hello World!");
  }

  @Test
  public void clickToSeeAlertTest() {
    new AlertsPage(wd).alertWindow();
  }

  @Test
  public void clickToSeeAlertAfter5SecondsTest() {
    new AlertsPage(wd).alertWindowAfter5Sec();
  }

  @Test
  public void clickToSeeAlertWithConfirmTest() {
    new AlertsPage(wd).sendMessageToAlert("Cancel")
        .assertMessage("Cancel");
  }


}
