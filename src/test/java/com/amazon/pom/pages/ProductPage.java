package com.amazon.pom.pages;

import com.amazon.pom.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    private final By addToCartButton = By.cssSelector("[id=add-to-cart-button][type=submit]");

    private final By productTitle = By.xpath("//h3[text()=' Ürün Bilgileri ']");

    private final By productAddedToCartText = By.cssSelector("h1.a-size-medium-plus.a-color-base.sw-atc-text.a-text-bold");

    public ProductPage selectSize () {
        Select select = new Select(driver.findElement(By.cssSelector("[name=dropdown_selected_size_name]")));
        select.selectByIndex(3);
        return this ;
    }

    public ProductPage clickAddToCart () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButton)).click();
        return this;
    }

    public String getText () {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productTitle)).getText();
    }

    public String getCartText () {
         return wait.until(ExpectedConditions.visibilityOfElementLocated(productAddedToCartText)).getText();

    }
}
