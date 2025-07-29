package Pages;

import Utilities.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    public void NavigateToTMPage(WebDriver driver)
    {
        Wait.WaitToBeVisible(driver, "XPath", "/html/body/div[3]/div/div/ul/li[5]", 2);
        // Navigate to Time & Materials page
        WebElement adminMenu = driver.findElement(By.xpath("/html/body/div[3]/div/div/ul/li[5]"));
        adminMenu.click();
        // Wait for the menu to load
       Wait.waitToBeClicakable(driver, "XPath", "//a[contains(@href, 'TimeMaterial')]", 2);
        WebElement timeAndMaterialsMenu = driver.findElement(By.xpath("//a[contains(@href, 'TimeMaterial')]"));
        timeAndMaterialsMenu.click();
    }
    public void NavigateToEmployeePage(WebDriver driver)
    {
        Wait.WaitToBeVisible(driver, "XPath", "/html/body/div[3]/div/div/ul/li[5]", 2);
        // Navigate to Time & Materials page
        WebElement adminMenu = driver.findElement(By.xpath("/html/body/div[3]/div/div/ul/li[5]"));
        adminMenu.click();
        // Wait for the menu to load
        WebElement employeeMenu = driver.findElement(By.xpath("//a[contains(@href, 'User')]"));
        employeeMenu.click();

    }

}
