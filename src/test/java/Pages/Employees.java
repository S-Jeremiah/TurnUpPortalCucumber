package Pages;

import Utilities.Wait;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Employees
{

    public void CreateEmployee(WebDriver driver)
    {
        // Click on Create New button
        Wait.WaitToBeVisible(driver, "xpath", "//*[@id=\"container\"]/p/a", 2);
        WebElement createNewButton = driver.findElement(By.xpath("//*[@id=\"container\"]/p/a"));
        createNewButton.click();
        // Fill in employee details
        Wait.waitToBeClicakable(driver, "Id", "Name", 2);
        WebElement nameTextbox = driver.findElement(By.id("Name"));
        nameTextbox.sendKeys("Mindy");
        WebElement userNameTextbox = driver.findElement(By.id("Username"));
        userNameTextbox.sendKeys("Chen");
        WebElement contactTextbox = driver.findElement(By.id("ContactDisplay"));
        contactTextbox.sendKeys("Auckland");
        WebElement passwordTextbox = driver.findElement(By.id("Password"));
        passwordTextbox.sendKeys("123456");
        WebElement confirmPasswordTextbox = driver.findElement(By.id("RetypePassword"));
        confirmPasswordTextbox.sendKeys("123456");
        WebElement vehicleTextboxClick = driver.findElement(By.xpath("//*[@id=\"UserEditForm\"]/div/div[7]/div/span[1]/span"));
        vehicleTextboxClick.click();
        WebElement vehicleTextbox = driver.findElement(By.xpath("//*[@id=\"UserEditForm\"]/div/div[7]/div/span[1]/span/input"));
        vehicleTextbox.sendKeys("Car");

        /*WebElement groupname = driver.findElement(By.xpath("//*[@id=\"UserEditForm\"]/div/div[8]/div/div/div[1]/input"));
        groupname.sendKeys("asb");


        Wait.WaitToBeVisible(driver,"XPath"," //ul[@id='groupList_listbox']", 2);

        List<WebElement> options = driver.findElements(By.cssSelector(".k-item"));

        for(WebElement option : options)
        {
            if(option.getText().equals("asb"))
            {
                option.click();
                break;
            }

        }*/



        WebElement saveButton = driver.findElement(By.id("SaveButton"));
        saveButton.click();
        //Thread.Sleep(2000); // Wait for the save operation to complete


        Wait.WaitToBeVisible(driver, "xpath", "//*[@id='container']/div/a", 2);
        WebElement backToListButton = driver.findElement(By.xpath("//*[@id='container']/div/a"));
        backToListButton.click();

        // Verify the employee is created
        Wait.WaitToBeVisible(driver, "xpath", "//*[@id=\"usersGrid\"]/div[4]/a[4]/span", 2);
        WebElement lastPageEmployee = driver.findElement(By.xpath("//*[@id=\"usersGrid\"]/div[4]/a[4]/span"));
        lastPageEmployee.click();
        Wait.waitToBeClicakable(driver, "xpath", "//*[@id=\"usersGrid\"]/div[3]/table/tbody/tr[last()]/td[1]", 3);

        WebElement lastEmployeeRecord = driver.findElement(By.xpath("//*[@id=\"usersGrid\"]/div[3]/table/tbody/tr[last()]/td[1]"));
        Assert.assertEquals(lastEmployeeRecord.getText(), "Mindy", "Last employee record is not created successfully.");

    }
    public void EditEmployee(WebDriver driver) throws InterruptedException {
        WebElement editEmployeebutton= driver.findElement(By.xpath("//*[@id=\"usersGrid\"]/div[3]/table/tbody/tr[last()]/td[3]/a[1]"));
        editEmployeebutton.click();
        WebElement editNamebox = driver.findElement(By.id("Name"));
        editNamebox.clear();
        editNamebox.sendKeys("Min");
        WebElement editContactbox= driver.findElement(By.xpath("//*[@id=\"ContactDisplay\"]"));
        editContactbox.clear();
        editContactbox.sendKeys("Philippines");
        WebElement editSaveButton = driver.findElement(By.xpath("//*[@id=\"SaveButton\"]"));
        editSaveButton.click();
        Thread.sleep(2000); // Wait for the save operation to complete


        // Verify the employee is edited
         Wait.waitToBeClicakable(driver, "xpath", "//*[@id=\"container\"]/div/a", 10);

        WebElement backToEditList= driver.findElement(By.xpath("//*[@id=\"container\"]/div/a"));
        backToEditList.click();

        WebElement lastPageEditedEmployee = driver.findElement(By.xpath("//*[@id=\"usersGrid\"]/div[4]/a[4]/span"));
        lastPageEditedEmployee.click();

        Wait.WaitToBeVisible(driver, "xpath", "//*[@id=\"usersGrid\"]/div[3]/table/tbody/tr[last()]/td[1]", 3);
        WebElement lastEditedEmployeeRecord = driver.findElement(By.xpath("//*[@id=\"usersGrid\"]/div[3]/table/tbody/tr[last()]/td[1]"));
        Assert.assertEquals(lastEditedEmployeeRecord.getText(), "Min", "Last employee record is not edited successfully.");




    }

    public void DeleteEmployee(WebDriver driver) throws InterruptedException {
        Wait.WaitToBeVisible(driver, "xpath", "//*[@id=\"usersGrid\"]/div[3]/table/tbody/tr[last()]/td[3]/a[2]", 3);
        WebElement deleteEmployeeButton = driver.findElement(By.xpath("//*[@id=\"usersGrid\"]/div[3]/table/tbody/tr[last()]/td[3]/a[2]"));
        deleteEmployeeButton.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();
        Thread.sleep(2);
        // Verify the employee is deleted
        Wait.waitToBeClicakable(driver, "xpath", "//*[@id=\"usersGrid\"]/div[3]/table/tbody/tr[last()]/td[1]", 3);
        WebElement lastEmployeeName= driver.findElement(By.xpath("//*[@id=\"usersGrid\"]/div[3]/table/tbody/tr[last()]/td[1]"));
        Assert.assertNotEquals(lastEmployeeName.getText(), "Min", "Last employee record is not deleted successfully.");

    }


}



