package com.e2x.luma.stepDefinition;

import com.e2x.luma.cucumber.Hooks;
import com.e2x.luma.pageObject.BasePage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

// this should contain common scenario steps - WIP
public class CommonSteps {
    WebDriver driver  = Hooks.driver;

    @Given("^My Web app is displayed successfully with title equals \"([^\"]*)\"$")
    public void launchWebApp(String homePageTitle) {
        Assert.assertEquals(homePageTitle,driver.getTitle());
    }

    @When("^user is on the sign in page$")
    public void userIsOnTheSignInPage() {

    }

}
