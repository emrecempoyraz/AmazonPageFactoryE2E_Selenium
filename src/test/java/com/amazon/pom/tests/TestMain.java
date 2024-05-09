package com.amazon.pom.tests;

import com.amazon.pom.base.BaseTest;
import com.amazon.pom.pages.FashionPage;
import com.amazon.pom.pages.HomePage;
import com.amazon.pom.pages.ProductPage;
import com.amazon.pom.pages.ResultsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestMain extends BaseTest {


    @Test (priority = 1)
    public void NavigateFromHomeToFashionUsingMainMenu () {
        HomePage homePage = new HomePage(getDriver());
                 homePage
                         .acceptCookies()
                         .selectFashionSection();
        FashionPage fashionPage = new FashionPage(getDriver());
        Assert.assertEquals(fashionPage.getTitle(),"Moda");
    }

    @Test (priority = 2,dependsOnMethods = "NavigateFromHomeToFashionUsingMainMenu")
    public void searchProductOnFashionPage () {
        String searchFor = "adidas ayakkabı";
        FashionPage fashionPage = new FashionPage(getDriver());
           fashionPage
                   .searchProduct(searchFor);
        ResultsPage resultsPage = new ResultsPage(getDriver());
        Assert.assertTrue(resultsPage.getTitle().contains(searchFor));
    }

    @Test(priority = 3,dependsOnMethods = "searchProductOnFashionPage")
    public void selectProductOnResultsPage () {
        ResultsPage resultsPage = new ResultsPage(getDriver());
        resultsPage
                .selectProduct();
        ProductPage productPage = new ProductPage(getDriver());
          productPage
                  .selectSize();
        Assert.assertTrue(productPage.getText().contains("Ürün Bilgileri"));
    }

    @Test(priority = 4,dependsOnMethods = "selectProductOnResultsPage")
    public void addProductToCart () throws InterruptedException {
        Thread.sleep(3000);
        ProductPage productPage = new ProductPage(getDriver());
          productPage
                .clickAddToCart();
        Assert.assertTrue(productPage.getCartText().contains("Eklendi"));
    }






}
