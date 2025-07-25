# WebTestFramework

## 📌 Purpose

This repository provides an automated testing framework for web applications using Java, Selenium WebDriver, and TestNG. It is built with a scalable and maintainable architecture, following the Page Object Model (POM) design pattern. The goal is to streamline UI testing, enhance reusability, and support CI/CD integration.

---

## ⚙️ Setup & Execution

### Requirements:
- Java JDK 8+
- Maven 3.6+
- ChromeDriver (or other browser drivers)
- IntelliJ IDEA or Eclipse

### Installation:
```bash
git clone https://github.com/your-account/WebTestFramework.git
cd WebTestFramework
mvn clean install
```

### Running tests:
```bash
mvn test
```

Or using TestNG suite:
```bash
mvn test -DsuiteXmlFile=TestRunner.xml
```

---

## 📁 Project Structure

```
src/
├── main/
│   └── java/
│       ├── core/
│       │   ├── base/          # Test base, actions, retry analyzer
│       │   ├── driver/        # WebDriver management
│       │   ├── enums/         # Browser targets
│       │   ├── data/          # Shared constants
│       │   ├── exceptions/    # Custom exceptions
│       │   └── utils/         # Logging, name generation
│       └── helpers/           # Config property helpers
│
├── test/
│   ├── java/
│   │   └── webapp/
│   │       ├── pages/         # Page Object classes
│   │       ├── testcases/     # Main test scripts
│   │       └── testdata/      # Test data constants
│   └── resources/
│       └── config.properties  # Config for environment, browser, etc.
```

---

## 🔍 Key Components

| Component | Description |
|-----------|-------------|
| `TestBase.java` | Initializes and tears down WebDriver sessions. |
| `RetryAnalyzer.java` | Automatically retries failed tests. |
| `ElementActions.java` | Common UI actions: click, input, wait, etc. |
| `DriverManager.java` & `BrowserFactory.java` | Handles WebDriver setup and configuration. |
| `TargetFactory.java` | Supports local or remote execution. |
| `LoginPage.java`, `DashboardPage.java` | Page Object Models for UI interaction. |
| `VerifyProjectTicket.java` | Sample test case to verify ticket creation. |
| `PropertiesHelpers.java` | Utility to read `config.properties` file. |

---

## 🚀 Quick Usage

1. Update `config.properties` with desired values:
    ```
    url=https://your-web-url.com
    browser=chrome
    timeout=30
    retry=1
    ```
2. Add new Page Object classes under `pages/`
3. Create test cases under `testcases/`
4. Run via TestNG or Maven as shown above

---

## 📦 Key Dependencies

- Selenium WebDriver
- TestNG
- WebDriverManager
- (Optional) ExtentReports or Allure for reporting
- Maven Surefire Plugin

---

## ✅ CI/CD (Optional)

You can integrate this framework into CI/CD pipelines:
- GitHub Actions or Jenkins
- Auto-run tests on push/pull requests
- Store results in `reports/` and screenshots in `screenshots/`

---

## 📝 Notes

- Easily extendable for API or mobile testing.
- Can integrate Docker/Grid for distributed execution.
- Add visual reports or parallel execution as needed.
