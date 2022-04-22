package com.e2x.luma.pageObject;

import com.e2x.luma.cucumber.Hooks;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {
    public static long DEFAULT_ELEMENT_WAIT_TIMEOUT = 30;

    //Element Locator
    @FindBy(id = "quick-search-expand")
    private static WebElement searchBtn;

    @FindBy(id = "nav-quick-search")
    private static WebElement quickSearchBox;

    @FindBy(className = "navUser-item-cartLabel")
    private static WebElement cartMenu;

//    @FindBy(className = "previewCartAction-checkout")
    @FindBy(css = "a.button.button--primary")
    private static WebElement checkoutBtn;

    @FindBy(xpath = "//button[contains(text(), 'Accept All Cookies')]")
    private static WebElement acceptAllCookiesBtn;

    private WebDriverWait wait;

    //Initialize Elements using Selenium Webdriver
    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this); //initialise all element on page to use Webdriver
    }

    //Page Specific Method
    public void clickSearchBtn(){
        searchBtn.click();
    }

    public void searchProduct(String searchKeyword){
        quickSearchBox.sendKeys(searchKeyword);
        quickSearchBox.sendKeys(Keys.ENTER);
    }

    public void clickOnCartMenu() {
        scrollToTop();
        cartMenu.click();
    }

    public void clickOnCheckout() {
        new WebDriverWait(Hooks.driver, DEFAULT_ELEMENT_WAIT_TIMEOUT)
                .until(ExpectedConditions.visibilityOf(checkoutBtn));
        checkoutBtn.click();
    }

    public void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) Hooks.driver)
                .executeScript("arguments[0].scrollIntoView();", element);
    }

    public void scrollToTop() {
        ((JavascriptExecutor) Hooks.driver).executeScript("window.scrollTo(0, 0)");
    }

    public void scrollToBottom() {
        ((JavascriptExecutor) Hooks.driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void safeJavaScriptClick(WebElement element) {
        if (element.isEnabled() && element.isDisplayed()) {
            ((JavascriptExecutor) Hooks.driver).executeScript("arguments[0].click();", element);
        }
    }

    public void clickOnAcceptAllCookies() {
        if (acceptAllCookiesBtn.isDisplayed())
            acceptAllCookiesBtn.click();
    }
}
