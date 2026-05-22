package com.qakit.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * LoginPage — Page Object for the login page.
 *
 * Demonstrates two locator approaches:
 *  1. @FindBy (PageFactory) — recommended for static locators
 *  2. By locators           — useful when the locator is dynamic or built at runtime
 *
 * NOTE: This is the demo version. The full kit also includes:
 *  - HomePage (second Page Object showing navigation between pages)
 *  - LoginTest with 6 complete scenarios (happy path + negative + security + data-driven)
 *
 * → Full kit: https://aionut.gumroad.com/l/qa_automation_starter_kit
 */
public class LoginPage extends BasePage {

    // -------------------------------------------------------------------------
    // Locators — @FindBy (PageFactory)
    // -------------------------------------------------------------------------
    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(css = "button[type='submit']")
    private WebElement loginButton;

    @FindBy(css = ".error-message")
    private WebElement errorMessage;

    // -------------------------------------------------------------------------
    // Locators — By (alternative for dynamic locators)
    // -------------------------------------------------------------------------
    private static final By FORGOT_PASSWORD_LINK = By.linkText("Forgot password?");
    private static final By SUCCESS_BANNER        = By.cssSelector(".alert-success");

    // -------------------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------------------
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // -------------------------------------------------------------------------
    // Actions
    // -------------------------------------------------------------------------

    public LoginPage enterUsername(String username) {
        type(usernameField, username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        type(passwordField, password);
        return this;
    }

    public void clickLogin() {
        click(loginButton);
    }

    /**
     * Composite method — full login in a single call.
     * Returns LoginPage so you can assert the error message if login fails.
     */
    public LoginPage login(String username, String password) {
        return enterUsername(username)
                .enterPassword(password)
                .submitAndReturn();
    }

    private LoginPage submitAndReturn() {
        click(loginButton);
        return this;
    }

    public void clickForgotPassword() {
        click(FORGOT_PASSWORD_LINK);
    }

    // -------------------------------------------------------------------------
    // Assertions
    // -------------------------------------------------------------------------

    public boolean isErrorMessageDisplayed() {
        return isDisplayed(errorMessage);
    }

    public String getErrorMessageText() {
        return getText(errorMessage);
    }

    public boolean isSuccessBannerDisplayed() {
        return isDisplayed(SUCCESS_BANNER);
    }

    public boolean isOnLoginPage() {
        return isDisplayed(usernameField);
    }
}
