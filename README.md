# BpTestSelenium

A Selenium-based automated testing framework for web applications. This project is structured as a Maven project with TestNG and includes robust WebDriver management for local and CI environments.

## Table of Contents

- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Setup](#setup)
- [Running Tests](#running-tests)
- [Configuration](#configuration)
- [Architecture](#architecture)

---

## Project Structure

```
BpTestSelenium/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── framework/
│   │   │       ├── LocatorConstants.java      # XPath and locator templates
│   │   │       ├── models/                    # Data models (Env, EnvData, UserData, etc.)
│   │   │       ├── pages/                     # Page Object Model classes
│   │   │       └── utils/                     # Utility classes (FileUtil, StringUtils, etc.)
│   │   └── resources/
│   │       ├── env.json                       # Environment selection (prod/dev)
│   │       └── prodenv.json                   # Production environment config
│   └── test/
│       └── java/
│           └── framework/
│               └── tests/                     # Test classes (BaseTest, CheckBoxesTest, etc.)
├── target/                                    # Build output (auto-generated)
├── pom.xml                                    # Maven configuration
├── .gitignore                                 # Git ignore rules
└── README.md                                  # This file
```

---

## Prerequisites

### Required
- **Java JDK 21** or higher
- **Maven 3.6.0** or higher
- **Chrome browser** (latest version recommended)

### Optional (for WebDriver management)
- WebDriverManager is included in the POM; it automatically downloads matching ChromeDriver

### Verify Installation

```powershell
java -version
mvn -version
```

---

## Setup

### 1. Clone the Repository

```powershell
git clone https://github.com/AbdulQader496/bpTestSelenium.git
cd bpTestSelenium
```

### 2. Install Dependencies

Maven will automatically download all required dependencies on the first build:

```powershell
mvn clean install
```

### 3. Environment Configuration

Edit `src/main/resources/prodenv.json` to point to your target website:

```json
{
  "protocol": "https",
  "domain": "the-internet.herokuapp.com",
  "wait": 10
}
```

- `protocol`: HTTP or HTTPS
- `domain`: Target website domain (do not include protocol)
- `wait`: Implicit wait timeout (seconds)

Select the environment in `src/main/resources/env.json`:

```json
{
  "env": "prod"
}
```

---

## Running Tests

### Run All Tests

```powershell
mvn test
```

### Run a Specific Test Class

```powershell
mvn -Dtest=CheckBoxesTest test
```

### Run a Specific Test Method

```powershell
mvn -Dtest=CheckBoxesTest#checkBox1test test
```

### Run Tests with Verbose Output

```powershell
mvn -Dtest=CheckBoxesTest test -X
```

### Run Tests in Headless Mode (CI/Local)

To run tests in headless Chrome (useful for CI pipelines):

```powershell
mvn test -Dchrome.headless=true
```

> **Note**: Headless mode support requires updating `BaseTest` to accept the property (see Configuration section).

---

## Configuration

### BaseTest Class

The `BaseTest` class handles WebDriver initialization and teardown:

```java
@BeforeMethod
public void setup() {
    WebDriverManager.chromedriver().setup();  // Auto-manages ChromeDriver
    driver = new ChromeDriver();
    driver.get(SettingsTestData.getEnvData().getHost());
    driver.manage().window().maximize();
}

@AfterMethod
public void teardown() {
    if (driver != null) {
        driver.quit();
    }
}
```

### WebDriverManager

WebDriverManager automatically:
- Downloads the correct ChromeDriver version for your installed Chrome browser
- Manages driver caching to avoid re-downloads
- Works seamlessly in local and CI environments

### Dependencies (pom.xml)

Key dependencies:
- **Selenium**: `org.seleniumhq.selenium:selenium-java:4.27.0`
- **WebDriverManager**: `io.github.bonigarcia:webdrivermanager:5.4.1`
- **TestNG**: `org.testng:testng:7.1.0` (test framework)
- **Lombok**: `org.projectlombok:lombok:1.18.36` (code generation)
- **GSON**: `com.google.code.gson:gson:2.11.0` (JSON parsing)

---

## Architecture

### Page Object Model (POM)

Tests follow the Page Object Model pattern for maintainability:

- **HomePage** — Base page with common navigation methods
- **CheckBoxesPage** — Test-specific page with element locators
- **MainPageNavigation** — Enum for navigation link labels

### Locator Strategy

Locators are centralized in `LocatorConstants.java`:

```java
public static final String PRECISE_TEXT_XPATH = "//*[text()='%s']";
public static final String PARTICULAR_TEXT_XPATH = "//*[contains(text(),'%s')]";
```

### Test Structure

```java
public class CheckBoxesTest extends BaseTest {
    protected CheckBoxesPage checkBoxesPage = new CheckBoxesPage();
    
    @Test
    public void checkBox1test() {
        homePage.clickNavigationLink(MainPageNavigation.CHECKBOXES);
        checkBoxesPage.verifyCheckBoxPage();
        checkBoxesPage.clickCheckbox1();
    }
}
```

---

## Troubleshooting

### Chrome WebDriver Version Mismatch

If you see warnings about Chrome DevTools Protocol (CDP) mismatch:

```
WARNING: Unable to find CDP implementation matching 142
```

This is non-fatal. To suppress it, add the matching selenium-devtools dependency to `pom.xml`:

```xml
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-devtools-v142</artifactId>
    <version>4.27.0</version>
</dependency>
```

Replace `v142` with your Chrome major version.

### Tests Not Discovered

Ensure test classes:
- Are in `src/test/java/framework/tests/` directory
- Extend `BaseTest` (or have TestNG annotations)
- Have method names starting with test-related keywords or `@Test` annotation

### Environment File Not Found

Verify `env.json` and `prodenv.json` exist in `src/main/resources/`:

```powershell
ls src/main/resources/
```

---

## CI/CD Integration

For GitHub Actions or other CI systems, use:

```bash
mvn clean test
```

To run headless in CI (add to your CI config):

```bash
mvn clean test -Dchrome.headless=true
```

For Maven properties override in CI, update `BaseTest` to read environment variables or system properties.

---

## Contributing

1. Create a feature branch: `git checkout -b feature/my-test`
2. Commit changes: `git commit -m "Add new test"`
3. Push to GitHub: `git push origin feature/my-test`
4. Open a Pull Request

---

## License

This project is private. Contact the repository owner for access details.

---

## Support

For issues, questions, or feature requests, please open an issue on GitHub or contact the development team.

---

**Last Updated**: November 13, 2025
