package com.amazon.pom.pages;

import com.amazon.pom.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FashionPage extends BasePage {

    public FashionPage(WebDriver driver) {
        super(driver);
    }

    private final By title = By.xpath("//h1[text()='Moda']");
    private final By searchField = By.cssSelector("#twotabsearchtextbox");
    private final By searchButton = By.cssSelector("#nav-search-submit-button");

    public String getTitle () {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(title)).getText();
    }

    private FashionPage enterTextInSearchField (String text) {
      wait.until(ExpectedConditions.visibilityOfElementLocated(searchField)).sendKeys(text);
      return this ;
    }

    private FashionPage clickSearchButton () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchButton)).click();
        return this ;
    }

    public FashionPage searchProduct (String text) {
        enterTextInSearchField(text).clickSearchButton();
        return this ;
    }


}
