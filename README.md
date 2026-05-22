# QA Automation Starter Kit — Demo

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Java](https://img.shields.io/badge/Java-17-007396?logo=openjdk&logoColor=white)](https://openjdk.org/)
[![Selenium](https://img.shields.io/badge/Selenium-4.15-43B02A?logo=selenium&logoColor=white)](https://www.selenium.dev/)
[![RestAssured](https://img.shields.io/badge/RestAssured-5.3-00BFA6)](https://rest-assured.io/)
[![TestNG](https://img.shields.io/badge/TestNG-7.8-DC382D)](https://testng.org/)
[![Allure](https://img.shields.io/badge/Allure-2.24-FFCA28)](https://docs.qameta.io/allure/)
[![Azure Pipelines](https://img.shields.io/badge/Azure_Pipelines-CI%2FCD-0078D7?logo=azurepipelines&logoColor=white)](https://azure.microsoft.com/en-us/products/devops/pipelines)

> **This is the demo version.** It shows the structure, code style, and patterns of the full kit. To get the working framework with parallel-safe execution, retry logic, multi-environment config, and full CI/CD — [**get the full kit on Gumroad — €19**](https://aionut.gumroad.com/l/qa_automation_starter_kit) ↗

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
| **Parent POM — multi-module Maven build** | — | ✓ |
| **BaseTest — ThreadLocal WebDriver (parallel-safe)** | — | ✓ |
| **BaseApiTest — RestAssured config + auth** | — | ✓ |
| **ConfigReader — singleton (system prop → env → file)** | — | ✓ |
| **Multi-environment configs** (dev / staging / prod) | — | ✓ |
| **Auto-screenshot on test failure** | — | ✓ |
| **RetryAnalyzer — automatic flaky-test retry** | — | ✓ |
| **TestListener — logging, Allure, auto-retry injection** | — | ✓ |
| **6 login scenarios** (happy + negative + security + data-driven) | — | ✓ |
| **9 API CRUD tests** (GET/POST/PUT/PATCH/DELETE + performance) | — | ✓ |
| **HomePage Page Object** | — | ✓ |
| **WaitUtils + TestDataProvider** utilities | — | ✓ |
| **JSON schemas** for API contract testing | — | ✓ |
| **Logback** logging configuration | — | ✓ |
| **Smoke + Regression suites** (separate TestNG XML) | — | ✓ |
| **Allure** — full integration + categories.json | — | ✓ |
| **Azure Pipelines** — 3-stage CI/CD with Quality Gate | — | ✓ |
| **README** — setup + extension guide | — | ✓ |
| **Lifetime updates** | — | ✓ |

[**→ Get the full kit on Gumroad — €19**](https://aionut.gumroad.com/l/qa_automation_starter_kit)

---

## Project structure (full kit)

```
qa-automation-starter-kit/
├── pom.xml                         # Parent POM — multi-module build
├── azure-pipelines.yml             # CI/CD pipeline
├── README.md
├── CHANGELOG.md
│
├── api/                            # API Test Module — RestAssured
│   ├── pom.xml
│   └── src/test/
│       ├── java/com/qakit/
│       │   ├── base/
│       │   │   ├── BaseApiTest.java     # ThreadLocal cleanup, RestAssured specs
│       │   │   └── ConfigReader.java    # Singleton config
│       │   ├── listeners/
│       │   │   ├── RetryAnalyzer.java   # Flaky-test retry
│       │   │   └── TestListener.java    # Logging, Allure, auto-retry injection
│       │   ├── models/
│       │   │   └── ApiModels.java       # Request/response POJOs
│       │   └── tests/
│       │       └── PostsApiTest.java
│       └── resources/
│           ├── config.properties         # Default API config
│           ├── config-dev.properties     # Per-env overrides
│           ├── testng-api.xml            # Regression suite
│           ├── smoke-api.xml             # Smoke suite
│           ├── allure.properties
│           ├── categories.json
│           ├── logback.xml
│           └── schemas/                  # JSON schemas for contract tests
│
└── ui/                             # UI Test Module — Selenium 4
    ├── pom.xml
    └── src/test/
        ├── java/com/qakit/
        │   ├── base/
        │   │   ├── BaseTest.java        # ThreadLocal WebDriver, multi-browser
        │   │   └── ConfigReader.java
        │   ├── listeners/
        │   │   ├── RetryAnalyzer.java
        │   │   └── TestListener.java
        │   ├── pages/
        │   │   ├── BasePage.java        # Waits, clicks, typeSecret helpers
        │   │   ├── LoginPage.java
        │   │   └── HomePage.java
        │   ├── tests/
        │   │   └── LoginTest.java
        │   └── utils/
        │       ├── WaitUtils.java
        │       └── TestDataProvider.java
        └── resources/
            ├── config.properties
            ├── config-dev.properties
            ├── config-staging.properties
            ├── config-prod.properties
            ├── testng.xml
            ├── smoke.xml
            ├── allure.properties
            ├── categories.json
            └── logback.xml
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

**The rest — BaseTest, BaseApiTest, RetryAnalyzer, TestListener, full test suites, CI/CD pipeline — is in the [full kit](https://aionut.gumroad.com/l/qa_automation_starter_kit).**

---

## Tech stack

- **Java 17** (LTS)
- **Maven 4.0+**
- **Selenium 4.15** + WebDriverManager 5.7
- **RestAssured 5.3.2** with JSON Schema validation
- **TestNG 7.8** (parallel test execution support)
- **Allure 2.24** (reporting + RestAssured integration)
- **Jackson 2.15.3** (POJO serialisation)
- **Logback** (logging)
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
