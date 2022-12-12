package runner;

import driver.DriverSingleton;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@CucumberOptions(
        features = "src/test/resources",
        glue = "service",
        tags = "@Smoke",
        plugin = {"pretty", "html:target/cucumber.html",
                "json:target/cucumber.json"}
)
public class BookingRunner extends AbstractTestNGCucumberTests {
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
