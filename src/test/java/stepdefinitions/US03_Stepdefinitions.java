package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pages.GMICreatePassword;
import utilities.ConfigurationReader;
import utilities.Driver;

public class US03_Stepdefinitions {
  GMICreatePassword gmiCreatePassword = new GMICreatePassword();


    @Given("User is on GMIBank Login pageGiven")
    public void user_is_on_GMIBank_Login_pageGiven() {
        Driver.getDriver().get(ConfigurationReader.getProperty("gmi_account"));

    }

    @Given("user fills in the New Password textbox with valid {string}")
    public void user_fills_in_the_New_Password_textbox_with_valid(String string) {
        gmiCreatePassword.firstPassword.sendKeys("visible_value",string);
    }
    @Given("verify red messages under the box")
    public void verify_red_messages_under_the_box() {
        Assert.assertFalse(gmiCreatePassword.requiredAlert.isDisplayed());
    }

    @Then("verify Password strength")
    public void verify_Password_strength() {
        Select color=new Select(gmiCreatePassword.color);
        color.selectByIndex(5) ;
    }

}
