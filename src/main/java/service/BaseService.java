package service;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseService {
    private WebDriver driver;

    @BeforeClass(description = "Opening Browser")
    public void startBrowser() {
        driver = DriverSingleton.getDriver();
    }

    @AfterClass(alwaysRun = true, description = "Closing Browser")
    public void closeBrowser() {
        DriverSingleton.closeDriver();
    }
}
