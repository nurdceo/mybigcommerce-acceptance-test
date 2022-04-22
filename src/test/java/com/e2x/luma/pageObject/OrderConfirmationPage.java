package com.e2x.luma.pageObject;

import com.e2x.luma.cucumber.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.e2x.luma.pageObject.BasePage.DEFAULT_ELEMENT_WAIT_TIMEOUT;

public class OrderConfirmationPage {

    //Element Locator
    @FindBy(xpath = "//*[@data-test='order-confirmation-order-number-text']")
    private static WebElement confirmationOrderNumber;


    private WebDriverWait wait;

    //Initialize Elements using Selenium Webdriver
    public OrderConfirmationPage(WebDriver driver){
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    //Page Specific Method
    public void confirmOrderNumberIsPresent() {
        new WebDriverWait(Hooks.driver, DEFAULT_ELEMENT_WAIT_TIMEOUT)
                .until(ExpectedConditions.visibilityOf(confirmationOrderNumber))
                .isDisplayed();
    }



}
