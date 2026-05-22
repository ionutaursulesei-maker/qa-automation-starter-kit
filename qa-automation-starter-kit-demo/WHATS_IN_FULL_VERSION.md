# What's in the full kit (€19)

This document describes exactly what you get when you purchase the [full QA Automation Starter Kit on Gumroad](https://aionut.gumroad.com/l/qa_automation_starter_kit).

---

## Files in the full kit (not in this demo)

### UI Module — Selenium

- **`BaseTest.java`** — WebDriver setup/teardown, automatic screenshot capture on failure, Chrome + Firefox support, headless mode for CI, configurable timeouts
- **`ConfigReader.java`** — Multi-source config loader (system properties → properties file → defaults). Lets you override any value from the CI command line without editing files
- **`HomePage.java`** — Second Page Object example, demonstrating post-login state verification and navigation between pages
- **`LoginTest.java`** — Full test suite (6 scenarios):
  - `testSuccessfulLogin` — happy path with HomePage verification
  - `testLoginWithWrongPassword` — error message validation
  - `testLoginWithEmptyFields` — form-level validation
  - `testLoginWithInvalidEmailFormat` — HTML5 validation check
  - `testLoginSQLInjectionPrevention` — security test
  - `testForgotPasswordNavigation` — flow verification
  - `testLoginWithMultipleInvalidCredentials` — data-driven test (7 datasets)
- **`WaitUtils.java`** — Custom waits: element count, attribute value, page load completion, hard wait wrapper, element existence check
- **`TestDataProvider.java`** — Centralised data providers for data-driven tests, ready to extend with CSV/JSON sources

### API Module — RestAssured

- **`BaseApiTest.java`** — Centralised RestAssured config with reusable RequestSpecification, automatic Allure logging for every request and response, Bearer token authentication helpers
- **`PostsApiTest.java`** — Full CRUD test suite (9 scenarios):
  - 4 × GET tests (all, by ID, by query param, 404 handling)
  - 2 × POST tests (create + empty payload)
  - PUT (full update)
  - PATCH (partial update)
  - DELETE
  - Response time validation (<2s)

### Allure Configuration

- **`allure.properties`** — Issue tracker integration (VSTS / Jira link patterns)
- **`categories.json`** — 5 custom error categories with regex matching:
  - Infrastructure failures (WebDriver / connection errors)
  - Flaky tests (timeouts, stale elements)
  - API errors (unexpected status codes)
  - Assertion errors
  - Skipped tests

### CI/CD — Azure Pipelines

- **`azure-pipelines.yml`** — Complete 3-stage pipeline:
  - **Stage 1 — API Tests:** Java setup, Maven dependency cache, RestAssured tests, Allure CLI install, report generation, artifact publishing
  - **Stage 2 — UI Tests:** Chrome install, headless Selenium tests, Allure report generation
  - **Stage 3 — Quality Gate:** Evaluates results, blocks merge on API failure, surfaces UI failures as warnings
- **Scheduled nightly regression** (Mon–Fri at 06:00 UTC)
- **PR triggers** on main + develop branches
- **Secret variables** properly handled (TEST_PASSWORD, API_TOKEN)

### Documentation

- **`README.md`** — 250-line setup guide with:
  - 5-minute quickstart
  - Configuration via command line and properties file
  - Allure CLI install instructions (macOS, Linux)
  - How to add a new Page Object
  - How to add a new test
  - How to register tests in testng.xml
  - Azure DevOps pipeline setup
  - Variable groups configuration
  - Common troubleshooting (Chrome version mismatch, headless issues, Allure CLI not found)

### Support files

- **`.gitignore`** — Java/Maven/IDE/Allure with safe template patterns
- **Template config files** — Safe to commit, no real credentials
- **`CHANGELOG.md`** — Version history

---

## What you save by buying the kit

A realistic estimate from someone who's done this multiple times:

| Task | Hours from scratch | Hours with kit |
|------|:---:|:---:|
| Project setup, Maven config, dependencies | 2–4h | 5 min |
| BaseTest with WebDriver lifecycle + screenshot | 2–3h | 0 |
| Page Object Model base class | 2h | 0 |
| RestAssured + Allure integration | 2–3h | 0 |
| Allure config + categories.json | 1–2h | 0 |
| Azure Pipelines YAML (debugging the YAML alone) | 4–8h | 5 min |
| Documentation (writing it down properly) | 2–4h | 0 |
| **Total** | **15–26 hours** | **~10 minutes** |

At €19 with 15+ hours saved, that's under €1.50/hour for senior-quality scaffolding.

---

## License (full kit)

The full kit ships under a **Personal Commercial License**:

- ✓ Use on unlimited personal projects
- ✓ Use on unlimited commercial / client projects
- ✓ Modify the code as needed
- ✓ Single-developer usage
- ✗ No redistribution, no resale of the kit itself
- ✗ No sharing of the kit files with non-licensed developers

A **Team License** (up to 5 developers) is available at €49 — contact me directly.

---

## Refund policy

30-day money-back guarantee: if the kit doesn't run on your setup and I can't help you fix it, you get a full refund — no questions asked.

The guarantee covers **technical issues**, not buyer's remorse. Because this is a digital download with no scarcity for me, but real value transferred to you on download, I review refund requests case-by-case.

---

## Get it now

[**→ Download the full kit on Gumroad — €19**](https://aionut.gumroad.com/l/qa_automation_starter_kit)
