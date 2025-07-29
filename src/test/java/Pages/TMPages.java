package Pages;

import Utilities.Wait;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class TMPages {

    public void CreateTimeRecord(WebDriver driver) throws InterruptedException {
        //Click on Create New button
        Wait.WaitToBeVisible(driver, "xpath", "//*[@id='container']/p/a", 5);
        WebElement createNewButton = driver.findElement(By.xpath("//*[@id='container']/p/a"));
        createNewButton.click();
        //Select Time from TypeCode dropdown
        WebElement typeCodeDropdown = driver.findElement(By.xpath("//*[@id=\"TimeMaterialEditForm\"]/div/div[1]/div/span[1]/span/span[2]/span"));
        typeCodeDropdown.click();
        Wait.waitToBeClicakable(driver, "xpath", "//*[@id=\"TypeCode_listbox\"]/li[2]", 2);
        WebElement timeOption = driver.findElement(By.xpath("//*[@id=\"TypeCode_listbox\"]/li[2]"));
        timeOption.click();
        //Type code in the Code textbox
        WebElement codeTextbox = driver.findElement(By.id("Code"));
        codeTextbox.sendKeys("Creating Time Record");
        //Type description in the Description textbox
        WebElement descriptionTextbox = driver.findElement(By.id("Description"));
        descriptionTextbox.sendKeys("This is the description for Time");


        //Type price in the Price textbox
        WebElement priceTabOverlap = driver.findElement(By.xpath("//*[@id=\"TimeMaterialEditForm\"]/div/div[4]/div/span[1]/span/input[1]"));
        priceTabOverlap.click();
        WebElement priceTextbox = driver.findElement(By.id("Price"));
        priceTextbox.sendKeys("10");
        //Click on Save button
        WebElement saveButton = driver.findElement(By.id("SaveButton"));
        saveButton.click();
        Thread.sleep(2000); // Wait for the save operation to complete



        Wait.WaitToBeVisible(driver,"xpath","//a[@title=\"Go to the last page\"]",20);
       // Wait.waitToBeClicakable(driver, "xpath", "//a[@title=\"Go to the last page\"]", 20);
        WebElement goTOlastPageRecord = driver.findElement(By.xpath("//a[@title=\"Go to the last page\"]"));

        goTOlastPageRecord.click();


        Wait.WaitToBeVisible(driver, "xpath", "//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[1]", 4);
        WebElement lastElement = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[1]"));
        //Assert.That(lastElement.Text, Is.EqualTo("Creating Time Record"), "Last record is not displayed in the form.");
        Assert.assertEquals(lastElement.getText(), "Creating Time Record", "Last record is not displayed in the form.");


    }

    public String GetNewCode(WebDriver driver)
    {
        WebElement lastElement = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[1]"));
        return lastElement.getText();
    }

    public String GetNewDescription(WebDriver driver)
    {
        WebElement lastDescription = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[3]"));
        return lastDescription.getText();
    }

    public String GetNewPrice(WebDriver driver)
    {
        WebElement lastPrice = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[4]"));
        return lastPrice.getText();
    }
    public void EditTimeRecord(WebDriver driver) throws InterruptedException {
        //Editing the last record
        WebElement editButton = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[5]/a[1]"));
        editButton.click();


        WebElement changeCodeBox = driver.findElement(By.xpath("//*[@id=\"Code\"]"));
        changeCodeBox.clear();
        changeCodeBox.sendKeys("Editing Time Record");

        WebElement changeDescriptionBox = driver.findElement(By.xpath("//*[@id=\"Description\"]"));
        changeDescriptionBox.clear();
        changeDescriptionBox.sendKeys("This is the Edited description for Time");
        WebElement saveBtn = driver.findElement(By.xpath("//*[@id=\"SaveButton\"]"));
        saveBtn.click();
        Thread.sleep(4000); // Wait for the save operation to complete
        //verify the last record is displayed is edited in the form

        Wait.waitToBeClicakable(driver, "xpath", "//*[@id=\"tmsGrid\"]/div[4]/a[4]/span", 10);
        WebElement goToLastRecordEdited = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[4]/a[4]/span"));
        goToLastRecordEdited.click();
        Wait.WaitToBeVisible(driver, "xpath", "//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[1]", 2);
        //Click on the last record in the table
        WebElement lastRecordEdited = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[1]"));
        //Assert.That(lastRecordEdited.Text, Is.EqualTo("12TimeCode"), "Last record is not edited in the form.");
        Assert.assertEquals(lastRecordEdited.getText(), "Editing Time Record", "Last record is not edited in the form.");
    }
    public String GetEditedCode(WebDriver driver)
    {
        WebElement lastRecordEdited = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[1]"));
        return lastRecordEdited.getText();
    }
    public void DeleteTimeRecord(WebDriver driver)
    {
        //Delete the last record
        WebElement deleteButton = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[5]/a[2]"));
        deleteButton.click();
        Alert alert = driver.switchTo().alert();

        // Option 1: Accept the alert (click OK)
        alert.accept();

        //verify the last record is deleted

        Wait.waitToBeClicakable(driver, "xpath", "//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[1]", 2);
        WebElement lastRecordDeleted = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[1]"));
        //Assert.That(lastRecordDeleted.Text, Is.Not.EqualTo("12TimeCode"), "Last record is not deleted in the form.");
        Assert.assertNotEquals(lastRecordDeleted.getText(), "Editing Time Record", "Last record is not deleted in the form.");
    }

    public String GetDeletedCode(WebDriver driver)
    {
        WebElement lastRecordDeleted = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[1]"));
        return lastRecordDeleted.getText();
    }
}
