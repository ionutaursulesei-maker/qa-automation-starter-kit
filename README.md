# QA Automation Starter Kit — Demo

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Selenium](https://img.shields.io/badge/Selenium-4.18-43B02A?logo=selenium&logoColor=white)](https://www.selenium.dev/)
[![RestAssured](https://img.shields.io/badge/RestAssured-5.4-00BFA6)](https://rest-assured.io/)
[![TestNG](https://img.shields.io/badge/TestNG-7.9-DC382D)](https://testng.org/)
[![Allure](https://img.shields.io/badge/Allure-2.27-FFCA28)](https://docs.qameta.io/allure/)
[![Azure Pipelines](https://img.shields.io/badge/Azure_Pipelines-CI%2FCD-0078D7?logo=azurepipelines&logoColor=white)](https://azure.microsoft.com/en-us/products/devops/pipelines)

> **This is the demo version.** It shows the structure, code style, and patterns of the full kit. To get the working framework with full test suites, complete CI/CD pipeline, and Allure reporting setup — [**get the full kit on Gumroad — €19**](https://aionut.gumroad.com/l/qa_automation_starter_kit) ↗

---

## What this kit is

A production-ready automation framework for **UI + API testing** in Java, with Allure reporting and Azure Pipelines CI/CD wired up out of the box. Built by a Senior QA Engineer with 12+ years of experience — not a YouTube tutorial.

If you've ever spent days configuring WebDriverManager, Allure, TestNG, Maven Surefire, and Azure Pipelines just to write your first test, this kit exists so you don't have to do it again.

---

## Demo vs Full version

| Feature | Demo (this repo) | Full kit (€19) |
|---------|:---:|:---:|
| Project structure & Maven setup | ✓ | ✓ |
| BasePage — Page Object Model base class | ✓ | ✓ |
| LoginPage — Page Object example | ✓ | ✓ |
| ApiModels — POJO patterns | ✓ | ✓ |
| Single example test (login happy path) | ✓ | ✓ |
| **BaseTest — WebDriver setup & teardown** | — | ✓ |
| **BaseApiTest — RestAssured config + auth** | — | ✓ |
| **ConfigReader — multi-source configuration** | — | ✓ |
| **Auto-screenshot on test failure** | — | ✓ |
| **6 login scenarios** (happy + negative + security + data-driven) | — | ✓ |
| **9 API CRUD tests** (GET/POST/PUT/PATCH/DELETE + performance) | — | ✓ |
| **HomePage Page Object** | — | ✓ |
| **WaitUtils + TestDataProvider** utilities | — | ✓ |
| **Allure** — full integration + categories.json | — | ✓ |
| **Azure Pipelines** — 3-stage CI/CD with Quality Gate | — | ✓ |
| **README** — 250-line setup + extension guide | — | ✓ |
| **Lifetime updates** | — | ✓ |

[**→ Get the full kit on Gumroad — €19**](https://aionut.gumroad.com/l/qa_automation_starter_kit)

---

## Project structure

```
qa-automation-starter-kit/
├── ui/                          # Selenium + TestNG + Allure
│   └── src/test/java/com/qakit/
│       ├── base/                # BaseTest, ConfigReader  ← FULL ONLY
│       ├── pages/               # BasePage, LoginPage, HomePage
│       ├── tests/               # LoginTest (6 scenarios) ← FULL ONLY
│       └── utils/               # WaitUtils, TestDataProvider ← FULL ONLY
│
├── api/                         # RestAssured + TestNG + Allure
│   └── src/test/java/com/qakit/
│       ├── base/                # BaseApiTest ← FULL ONLY
│       ├── models/              # POJOs: Post, User, ErrorResponse
│       └── tests/               # PostsApiTest (9 scenarios) ← FULL ONLY
│
├── allure-config/               # Allure setup ← FULL ONLY
│   ├── allure.properties
│   └── categories.json          # Custom error classification
│
└── ci/
    └── azure-pipelines.yml      # 3-stage pipeline ← FULL ONLY
```

---

## Why a demo?

Software you can't see is software you can't trust. This demo lets you:

- **Inspect the code quality** before paying — no marketing fluff
- **Confirm the patterns** match your team's standards (POM, AAA, Allure annotations)
- **Verify the project structure** is what you'd expect in a real repo
- **Read the Java style** and decide if it fits your codebase

If after browsing this you think *"yeah, I'd rather build this myself from scratch over a weekend"* — fair, don't buy it.
If you think *"this is exactly what I'd build, and I'd rather pay €19 than spend a weekend"* — that's who this is for.

---

## Quick look at the code

**BasePage — Page Object base (included in this demo):**

```java
public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    protected void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected void type(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }
    // ... more helpers
}
```

**LoginPage — fluent interface (included in this demo):**

```java
public LoginPage login(String username, String password) {
    return enterUsername(username)
            .enterPassword(password)
            .submitAndReturn();
}
```

**The rest — BaseTest, BaseApiTest, full test suites, CI/CD pipeline — is in the [full kit](https://aionut.gumroad.com/l/qa_automation_starter_kit).**

---

## Tech stack

- **Java 17+**
- **Maven 4.0+**
- **Selenium 4.18** + WebDriverManager 5.7
- **RestAssured 5.4** with JSON Schema validation
- **TestNG 7.9** (parallel test execution support)
- **Allure 2.27** (reporting + RestAssured integration)
- **Jackson 2.17** (POJO serialisation)
- **JavaFaker** (test data generation)
- **Azure Pipelines** (CI/CD)

---

## License

The code in **this demo repository** is licensed under the [MIT License](LICENSE). Use it however you want.

The **full kit** sold on Gumroad ships with a Personal Commercial License — single developer, unlimited personal/commercial projects. A Team License (up to 5 developers) is available on request.

---

## About the author

Built by a Senior QA Engineer with 12+ years of experience automating tests for web platforms. Currently working on a SaaS asset management platform.

Questions, ideas, or feedback? Open an issue or reach me at **ionut.aursulesei@gmail.com**.

---

## ⭐ If this helped you

- Star this repo — it helps others discover it
- Share with your QA / dev colleagues
- [**Get the full kit on Gumroad — €19**](https://aionut.gumroad.com/l/qa_automation_starter_kit) and skip the setup grind
