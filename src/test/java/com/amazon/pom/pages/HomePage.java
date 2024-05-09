package com.amazon.pom.pages;

import com.amazon.pom.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {


    public HomePage(WebDriver driver) {
        super(driver);
    }

    /*@FindBy(xpath = "(//li[@class='sf-MenuItems-WulWXvlfIAwNiOUGY7FP'])[2]")
    WebElement fashionButtonNavigationBar;*/
    By fashionButtonNavigationBar = By.xpath("//a[@data-csa-c-slot-id='nav_cs_7']");

    By acceptCookiesButton = By.cssSelector("#sp-cc-accept");


    public HomePage acceptCookies () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(acceptCookiesButton)).click();
        return this ;
    }


    public HomePage selectFashionSection () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(fashionButtonNavigationBar)).click();
        return this;
    }




}
