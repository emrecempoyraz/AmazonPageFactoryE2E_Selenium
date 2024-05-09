package com.amazon.pom.pages;

import com.amazon.pom.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class ResultsPage extends BasePage {

    public ResultsPage(WebDriver driver) {
        super(driver);
    }

    private final By resultsTitle = By.xpath("//span[@class='a-color-state a-text-bold']");
    private final By productLink = By.xpath("//div[@data-index='4']");

    public String getTitle () {
      return wait.until(ExpectedConditions.visibilityOfElementLocated(resultsTitle)).getText();
    }

    public ResultsPage selectProduct () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productLink)).click();
        return this;
    }
}
