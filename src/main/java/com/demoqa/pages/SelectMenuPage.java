package com.demoqa.pages;

import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SelectMenuPage extends BasePage {

  public SelectMenuPage(WebDriver wd) {
    super(wd);
  }

  @FindBy(id = "oldSelectMenu")
  WebElement oldSelectMenu;

  public SelectMenuPage selectOldStyle(String color) {
    Select select = new Select(oldSelectMenu);
    select.selectByVisibleText(color);

    List<WebElement> options = select.getOptions(); // доставать опции из списка
    System.out.println(select.getFirstSelectedOption().getText() + "is first");
    for (int i = 0; i < options.size(); i++) {
      System.out.println(options.get(i).getText());
    }

    return this;
  }

  @FindBy(id = "react-select-4-input")
  WebElement inputSelect;

  @FindBy(css = "html")
  WebElement space;

  public SelectMenuPage multiSelect(String[] colors) {
    for (int i = 0; i < colors.length; i++) {
      if (colors[i] != null) {
        inputSelect.sendKeys(colors[i]);
        inputSelect.sendKeys(Keys.ENTER);
      }
      click(space);
    }
    return this;
  }

  @FindBy(id = "cars")
  WebElement cars;

  public SelectMenuPage standardMultiSelect(int index) {
    Select select = new Select(cars);
    if (select.isMultiple()) {
      select.selectByIndex(index);
    }
    return this;
  }
}
