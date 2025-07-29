package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.Map;

public class BaseClass {

    public WebDriver driver = null;

    @BeforeTest
    public void SatrtBrowser()
    {

        driver=InitBrowser("Chrome");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }
    public WebDriver InitBrowser(String browserName) {
        switch (browserName) {
            case "Chrome":
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("prefs", Map.of(
                        "profile.password_manager_leak_detection", false));
                WebDriverManager.chromedriver().setup();
                 driver = new ChromeDriver(options);
                driver.manage().window().maximize();
                break;

            case "Edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                break;
            default:
                System.out.println("Browser not supported: " + browserName);
                break;

        }
        return driver;

    }
    @AfterTest
    public void AfterTest()
    {
    driver.quit();
    }

}
