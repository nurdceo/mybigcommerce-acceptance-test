package com.e2x.luma.stepDefinition;

import com.e2x.luma.cucumber.Hooks;
import com.e2x.luma.pageObject.*;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Instant;
import java.util.Date;
import java.util.List;

public class OrderManagementSteps {
    WebDriver driver = Hooks.driver;

    BasePage basePage = new BasePage(driver);
    ProductListPage productListPage = new ProductListPage(driver);
    ProductDetailPage productDetailPage = new ProductDetailPage(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);
    OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);

    @Given("^I have a \"([^\"]*)\" in my cart$")
    public void addProductToCart(String product) throws Throwable {
        basePage.clickSearchBtn();
        basePage.searchProduct(product);
        productListPage.clickOnFirstDisplayedProduct();
        basePage.clickOnCheckout();

    }

    @When("^I complete the checkout process with default details$")
    public void completeCheckoutProcess(DataTable customerData) {
        List<List<String>> data = customerData.raw();

        // email reformatting to ensure unique is used each time test run
        long millis = Instant.now().toEpochMilli();
        String email = data.get(0).get(0);
        String[] emailArr = email.split("@");
        email = emailArr[0] +"_"+ millis +"@"+ emailArr[1];

        checkoutPage.inputEmail(email);
        checkoutPage.acceptPrivacyPolicy();
        checkoutPage.clickOnContinueAsGuest();
        checkoutPage.inputFirstname(data.get(0).get(1));
        checkoutPage.inputLastname(data.get(0).get(2));
        checkoutPage.inputAddressLine1(data.get(0).get(3));
        checkoutPage.inputAddressCity(data.get(0).get(4));
        checkoutPage.inputPostcode(data.get(0).get(5));
        checkoutPage.inputPhoneNumber(data.get(0).get(6));
        checkoutPage.inputOrderComment(data.get(0).get(7));
        checkoutPage.clickOnContinueBtn();
    }

    @And("^I enter my payment detail \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void enterPaymentDetails(String cardNum, String nameOnCard, String ccExpiry, String cvv) {
        checkoutPage.inputPaymentCardNumber(cardNum);
        checkoutPage.inputNameOnCard(nameOnCard);
        checkoutPage.inputExpirationDate(ccExpiry);
        checkoutPage.inputCvv(cvv);
        checkoutPage.clickOnPlaceOrder();
    }

    @Then("^I am presented with a purchase confirmation page for my order$")
    public void confirmMyOrder() {
        orderConfirmationPage.confirmOrderNumberIsPresent();
    }
}
