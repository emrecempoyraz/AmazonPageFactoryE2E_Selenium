package com.amazon.pom.base;

import com.amazon.pom.utils.ConfigLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

  protected WebDriver driver ;
  protected WebDriverWait wait ;


  public BasePage(WebDriver driver) {
      this.driver = driver;
      wait = new WebDriverWait(driver, Duration.ofSeconds(30));
  }

  public void loadBaseUrl () {
      driver.get(ConfigLoader.getInstance().getBaseUrl());
  }




}
