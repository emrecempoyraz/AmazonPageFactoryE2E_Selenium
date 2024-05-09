package com.amazon.pom.base;

import com.amazon.pom.utils.ConfigLoader;
import com.amazon.pom.driver.DriverManagerFactory;
import com.amazon.pom.utils.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.time.Duration;


public class BaseTest {

    private final ThreadLocal <WebDriver> driver = new ThreadLocal<>();


    private void setDriver(WebDriver driver){
        this.driver.set(driver);
    }

    protected WebDriver getDriver(){
        return this.driver.get();
    }

    @Parameters({"browser"})
    @BeforeTest
    public synchronized void startDriver (@Optional String browser) {
       browser = System.getProperty("browser",browser);
       if (browser == null){
           browser = "CHROME";
       }
       setDriver(DriverManagerFactory.getManager(DriverType.valueOf(browser)).createDriver());
       getDriver().get(ConfigLoader.getInstance().getBaseUrl());
       getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
       getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
    }

    /*@AfterTest
    public void quitDriver(){
       if (getDriver() != null){
           getDriver().quit();
       }
    }*/

}
