package StepDefinition;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.TMPages;
import Utilities.BaseClass;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class TMStepdefs extends BaseClass
{
    @Given("I logged into Turnup portal successfully")
    public void i_logged_into_turnup_portal_successfully() {
        LoginPage loginPageObj = new LoginPage();
        loginPageObj.LoginAction(driver);

    }
    @When("I navigate to Time and Material page")
    public void i_navigate_to_time_and_material_page() {
        HomePage homePageObj = new HomePage();
        homePageObj.NavigateToTMPage(driver);
    }
    @When("I create a Time Record")
    public void i_create_a_time_record() throws InterruptedException {
        TMPages tmPageObj = new TMPages();
        tmPageObj.CreateTimeRecord(driver);
    }
    @Then("the Time Record should be created successfully")
    public void the_time_record_should_be_created_successfully() {
        TMPages tmPageObj = new TMPages();
        String newcode = tmPageObj.GetNewCode(driver);
        String newDescription = tmPageObj.GetNewDescription(driver);
        String newPrice = tmPageObj.GetNewPrice(driver);

        Assert.assertEquals(newcode, "Creating Time Record", "Code is not matching");
        Assert.assertEquals(newDescription, "This is the description for Time", "Description is not matching");
        Assert.assertEquals(newPrice, "10", "Price is not matching");
    }
    @When("I Edit a Time Record")
    public void i_edit_a_time_record() throws InterruptedException {
        TMPages tmPageObj = new TMPages();
        tmPageObj.EditTimeRecord(driver);
    }
    @Then("the Time Record should be edited successfully")
    public void the_time_record_should_be_edited_successfully() {
        TMPages tmPageObj = new TMPages();
        String neweditedcode = tmPageObj.GetEditedCode(driver);
        Assert.assertEquals(neweditedcode,"Editing Time Record","Code is not matching");
    }
    @When("I delete a Time Record")
    public void i_delete_a_time_record() {
        TMPages tmPageObj = new TMPages();
        tmPageObj.DeleteTimeRecord(driver);
    }
    @Then("the Time Record should be deleted successfully")
    public void the_time_record_should_be_deleted_successfully() {
        TMPages tmPageObj = new TMPages();
        String deleteRecord = tmPageObj.GetDeletedCode(driver);
        Assert.assertNotEquals(deleteRecord,"Editing Time Record","delete is not successfull");

    }
}