package com.amazon.pom.driver;

import com.amazon.pom.utils.DriverType;

public class DriverManagerFactory {

    public static DriverManager getManager (DriverType driverType) {
        switch (driverType){
            case CHROME -> {
                return new ChromeDriverManager();
            }
            case FIREFOX -> {
                return new FirefoxDriverManager();
            }
            default -> throw new IllegalStateException("Unexpected value: " + driverType);
        }
    }
}
