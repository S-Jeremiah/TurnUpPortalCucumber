package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class LoginPage {

    public void LoginAction(WebDriver driver)
    {

        // launch the website
        driver.navigate().to("http://horse.industryconnect.io/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Identigy the username testbox and enter valid username
        WebElement usernameField = driver.findElement(By.id("UserName"));
        usernameField.sendKeys("hari");

        // Identify the password testbox and enter valid password
        WebElement passwordField = driver.findElement(By.id("Password"));
        passwordField.sendKeys("123123");

        //Identify the login button and click it
        WebElement loginButton = driver.findElement(By.xpath("//*[@id='loginForm']/form/div[3]/input[1]"));
        loginButton.click();


    }



}
