package com.qakit.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * BasePage — parent class for all Page Objects.
 *
 * Contains Selenium wrapper methods that:
 *  - include explicit waits (do not rely on implicit wait for actions)
 *  - provide clear error messages on timeout
 *  - are reusable across all Page Objects in the project
 *
 * NOTE: This is the demo version of the kit. The full version includes:
 *  - BaseTest with WebDriver lifecycle management
 *  - ConfigReader for multi-source configuration
 *  - Auto-screenshot on test failure (attached to Allure reports)
 *  - Complete test suites (UI + API CRUD)
 *  - Allure integration + categories.json
 *  - Azure Pipelines CI/CD with Quality Gate
 *
 * → Full kit: https://aionut.gumroad.com/l/qa_automation_starter_kit
 */
public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    private static final int DEFAULT_TIMEOUT_SECONDS = 15;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT_SECONDS));
        PageFactory.initElements(driver, this);
    }

    // -------------------------------------------------------------------------
    // Basic actions
    // -------------------------------------------------------------------------

    protected void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected void type(By locator, String text) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        el.clear();
        el.sendKeys(text);
    }

    protected void type(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }

    protected String getText(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    protected String getText(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    protected void selectByVisibleText(By locator, String text) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        new Select(el).selectByVisibleText(text);
    }

    protected void selectByValue(By locator, String value) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        new Select(el).selectByValue(value);
    }

    // -------------------------------------------------------------------------
    // Checks / waits
    // -------------------------------------------------------------------------

    protected boolean isDisplayed(By locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    protected boolean isDisplayed(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    protected void waitForUrlContains(String urlFragment) {
        wait.until(ExpectedConditions.urlContains(urlFragment));
    }

    protected void waitForTextPresent(By locator, String text) {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    // -------------------------------------------------------------------------
    // Utilities
    // -------------------------------------------------------------------------

    protected void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected void clickWithJS(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
