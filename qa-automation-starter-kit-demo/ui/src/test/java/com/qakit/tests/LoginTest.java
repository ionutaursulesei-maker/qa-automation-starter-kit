package com.qakit.tests;

import com.qakit.pages.LoginPage;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * LoginTest — DEMO version with a single example test.
 *
 * The full kit includes 6 complete scenarios:
 *   ✓ testSuccessfulLogin                       (this demo)
 *   ✗ testLoginWithWrongPassword                — full kit only
 *   ✗ testLoginWithEmptyFields                  — full kit only
 *   ✗ testLoginWithInvalidEmailFormat           — full kit only
 *   ✗ testLoginSQLInjectionPrevention           — full kit only
 *   ✗ testForgotPasswordNavigation              — full kit only
 *   ✗ testLoginWithMultipleInvalidCredentials   — full kit only (data-driven, 7 datasets)
 *
 * IMPORTANT: This demo class does NOT compile or run as-is because it depends on
 * BaseTest (WebDriver setup, screenshot on failure, config loading) which is part
 * of the full kit only. The class is provided as a code-style reference.
 *
 * → Get the full, runnable kit: https://aionut.gumroad.com/l/qa_automation_starter_kit
 */
@Epic("Authentication")
@Feature("Login")
public class LoginTest /* extends BaseTest — included in full kit */ {

    // In the full kit, this WebDriver and the helpers below come from BaseTest
    protected WebDriver driver;

    /**
     * Example happy-path test showing the framework's style.
     *
     * In the full kit, this test runs out of the box because:
     *   - BaseTest spins up a WebDriver (Chrome / Firefox, headless or not)
     *   - ConfigReader injects base.url, credentials, timeouts
     *   - On failure, a screenshot is automatically attached to Allure
     *   - The Allure annotations populate the report with Epic / Feature / Story
     */
    @Test(description = "Login with valid credentials")
    @Story("Valid Login")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verifies that a user with correct credentials is authenticated and redirected to the dashboard.")
    public void testSuccessfulLogin() {
        // navigateTo() and config.get() come from BaseTest + ConfigReader in the full kit
        // navigateTo("/login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("testuser@example.com", "TestPass123!");

        // HomePage and assertions on successful navigation are in the full kit
        Assert.assertTrue(true, "Demo placeholder — see the full kit for the complete assertion chain.");
    }

    // ─────────────────────────────────────────────────────────────────────────
    // The remaining 5 tests + data-driven scenario are part of the full kit.
    //
    // What you'd see in the full kit:
    //
    //   @Test
    //   public void testLoginWithWrongPassword() { ... }
    //
    //   @Test
    //   public void testLoginSQLInjectionPrevention() { ... }
    //
    //   @Test(dataProvider = "invalidCredentials",
    //         dataProviderClass = TestDataProvider.class)
    //   public void testLoginWithMultipleInvalidCredentials(
    //       String username, String password, String scenario) { ... }
    //
    // → https://aionut.gumroad.com/l/qa_automation_starter_kit
    // ─────────────────────────────────────────────────────────────────────────
}
