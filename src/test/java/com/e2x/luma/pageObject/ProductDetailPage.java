package com.e2x.luma.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailPage extends BasePage {

    //Element Locator
    @FindBy(id = "icon-keyboard-arrow-down")
    private static WebElement iconArrowDownBtn;

    @FindBy(id = "icon-keyboard-arrow-up")
    private static WebElement iconArrowUpBtn;

    @FindBy(id = "form-action-addToCart")
    private static WebElement addToCartBtn;

    @FindBy(linkText = "Add to Wish List")
    private static WebElement addToWishListBtn;

    @FindBy(xpath = "//*[@class='modal-header-title' and contains(text(),'added to your cart')]")
    private static WebElement addedItemNotificationHeader;

    @FindBy(xpath = "//*[@class='previewCartCheckout-price']")
    private static WebElement cartCheckoutPriceLabel;

    @FindBy(linkText = "Continue Shopping")
    private static WebElement continueShoppingLabel;

    @FindBy(xpath = "//div[@id='previewModal']//button[@class='modal-close']")
    private static WebElement closeModalBtn;

    private WebDriverWait wait;

    //Initialize Elements using Selenium Webdriver
    public ProductDetailPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this); //initialise all element on page to use Webdriver
    }

    //Page Specific Method

    public void reduceQuantity() {
        iconArrowDownBtn.click();
    }

    public void  increaseQuantity() {
        iconArrowUpBtn.click();
    }

    public void addProductToCart() {
        scrollIntoView(addToCartBtn);
        addToCartBtn.click();
    }

    public boolean addToCartMessagePresent() {
        wait.until(ExpectedConditions.visibilityOf(addedItemNotificationHeader));
        return addedItemNotificationHeader.isDisplayed();
    }

    public boolean verifyCheckoutPriceIsPresent() {
        return cartCheckoutPriceLabel.isDisplayed();
    }

    public void clickOnContinueShopping() {
        continueShoppingLabel.click();
    }

    public void clickOnCloseModal() {
        closeModalBtn.click();
    }

}
