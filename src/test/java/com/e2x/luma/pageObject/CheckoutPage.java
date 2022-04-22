package com.e2x.luma.pageObject;

import com.e2x.luma.cucumber.Hooks;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;

import static com.e2x.luma.pageObject.BasePage.DEFAULT_ELEMENT_WAIT_TIMEOUT;

public class CheckoutPage extends BasePage {

    //Element Locator
    @FindBy(id = "email")
    private static WebElement emailInput;

    @FindBy(id = "checkout-customer-continue")
    private static WebElement checkoutCustomerContinue;

    @FindBy(id = "privacyPolicy")
    private static WebElement privacyPolicyCheckbox;

    @FindBy(id = "countryCodeInput")
    private static WebElement countryInput;

    @FindBy(id = "firstNameInput")
    private static WebElement firstnameInput;

    @FindBy(id = "lastNameInput")
    private static WebElement lastnameInput;

    @FindBy(id = "addressLine1Input")
    private static WebElement addressLine1Input;

    @FindBy(id = "cityInput")
    private static WebElement cityInput;

    @FindBy(id = "postCodeInput")
    private static WebElement postcodeInput;

    @FindBy(id = "phoneInput")
    private static WebElement phoneInput;

    @FindBy(name = "orderComment")
    private static WebElement orderCommentInput;

    @FindBy(id = "checkout-shipping-continue")
    private static WebElement continueBtn;

    @FindBy(id = "ccNumber")
    private static WebElement ccNumberInput;

    @FindBy(id = "ccName")
    private static WebElement nameOnCardInput;

    @FindBy(id = "ccExpiry")
    private static WebElement ccExpirationInput;

    @FindBy(id = "ccCvv")
    private static WebElement ccCvvInput;

    @FindBy(id = "checkout-payment-continue")
    private static WebElement placeOrderBtn;


    private WebDriverWait wait;

    //Initialize Elements using Selenium Webdriver
    public CheckoutPage(WebDriver driver){
        super(driver);
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    //Page Specific Method
    public void inputEmail(String email) {
        WebElement contactEmail = new WebDriverWait(Hooks.driver, DEFAULT_ELEMENT_WAIT_TIMEOUT)
                .until(ExpectedConditions.visibilityOf(emailInput));
        contactEmail.sendKeys(email);
    }

    public void clickOnContinueAsGuest() {
        checkoutCustomerContinue.click();
    }

    public void acceptPrivacyPolicy() {
        safeJavaScriptClick(privacyPolicyCheckbox);
    }

    public void inputFirstname(String firstNameInput) {
        new WebDriverWait(Hooks.driver, DEFAULT_ELEMENT_WAIT_TIMEOUT)
                .until(ExpectedConditions.visibilityOf(firstnameInput))
                .sendKeys(firstNameInput);
    }

    public void inputLastname(String lastname) {
        new WebDriverWait(Hooks.driver, DEFAULT_ELEMENT_WAIT_TIMEOUT)
                .until(ExpectedConditions.visibilityOf(lastnameInput))
                .sendKeys(lastname);
    }

    public void inputAddressLine1(String addressLin1) {
        addressLine1Input.sendKeys(addressLin1);
    }

    public void inputAddressCity(String city) {
        cityInput.sendKeys(city);
    }

    public void inputPostcode(String postcode) {
        postcodeInput.sendKeys(postcode);
    }

    public void inputPhoneNumber(String phoneNumber) {
        phoneInput.sendKeys(phoneNumber);
    }

    public void inputOrderComment(String orderComment) {
        orderCommentInput.sendKeys(orderComment);
        orderCommentInput.sendKeys(Keys.ENTER);
    }

    public void clickOnContinueBtn() {
        scrollToBottom();
        try {
            Thread.sleep(DEFAULT_ELEMENT_WAIT_TIMEOUT);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new WebDriverWait(Hooks.driver, DEFAULT_ELEMENT_WAIT_TIMEOUT)
                .until(ExpectedConditions.visibilityOf(continueBtn));
        if (continueBtn.isDisplayed()) {
            continueBtn.click();
        }
        if (continueBtn.isDisplayed()) {
            continueBtn.click();
        }
    }

    public void inputPaymentCardNumber(String cardNumber) {
        new WebDriverWait(Hooks.driver, DEFAULT_ELEMENT_WAIT_TIMEOUT)
                .until(ExpectedConditions.visibilityOf(ccNumberInput))
                .sendKeys(cardNumber);
    }

    public void inputNameOnCard(String name) {
        nameOnCardInput.sendKeys(name);
    }

    public void inputExpirationDate(String expiry) {
        ccExpirationInput.sendKeys(expiry);
    }

    public void inputCvv(String cvv) {
        ccCvvInput.sendKeys(cvv);
    }

    public void clickOnPlaceOrder() {
        scrollToBottom();
        placeOrderBtn.click();
    }
}
