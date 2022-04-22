package com.e2x.luma.pageObject;

import com.e2x.luma.cucumber.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProductListPage extends BasePage {

    //Element Locator
//    @FindBy(xpath = "//li[@class='product']//h3")
    @FindBy(css = "div.card-img-container")
    private static List<WebElement> productList;

    @FindBy(linkText = "Add to Cart")
    private static WebElement addToCartTxt;

    private WebDriverWait wait;

    //Initialize Elements using Selenium Webdriver
    public ProductListPage(WebDriver driver) {
        super(driver);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
    }


    //Page Specific Method
    public void clickOnFirstDisplayedProduct() {
        clickOnAcceptAllCookies();
        scrollToBottom();
        Actions actions = new Actions(Hooks.driver);
        if (productList.get(0).isDisplayed()) {
            actions.moveToElement(productList.get(0)).build().perform();
            clickOnAddToCart();
        }
        if (productList.get(0).isDisplayed()) {
            actions.moveToElement(productList.get(0)).build().perform();
            clickOnAddToCart();
        }

//        WebElement element = new WebDriverWait(Hooks.driver, DEFAULT_ELEMENT_WAIT_TIMEOUT)
//                .until(ExpectedConditions.visibilityOf(productList.get(0)));
//        if (element.isEnabled() && element.isDisplayed())
//            element.click();
    }

    private void clickOnAddToCart() {
        new WebDriverWait(Hooks.driver, DEFAULT_ELEMENT_WAIT_TIMEOUT)
                .until(ExpectedConditions.visibilityOf(addToCartTxt)).click();
    }

}


