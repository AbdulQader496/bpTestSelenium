package framework.tests;

import framework.pages.HomePage;
import framework.utils.SettingsTestData;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    public static WebDriver driver;
    protected HomePage homePage = new HomePage();

    @BeforeMethod
    public void setup() {

        WebDriverManager.chromedriver()
                .avoidBrowserDetection()
                .setup();
        

        ChromeOptions options = new ChromeOptions();

        // Detect if running inside GitHub Actions (Linux CI)
        boolean isCI = System.getenv("GITHUB_ACTIONS") != null;

        if (isCI) {
            System.out.println("Running in GitHub Actions - enabling headless mode");

            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");
            options.addArguments("--disable-extensions");
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--window-size=1920,1080");
        }

        driver = new ChromeDriver(options);

        driver.get(SettingsTestData.getEnvData().getHost());
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}



// package framework.tests;

// import framework.pages.HomePage;
// import framework.utils.SettingsTestData;
// import io.github.bonigarcia.wdm.WebDriverManager;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.chrome.ChromeDriver;
// import org.testng.annotations.AfterMethod;
// import org.testng.annotations.BeforeMethod;

// public class BaseTest {

//     public static WebDriver driver;
//     protected HomePage homePage = new HomePage();

//     @BeforeMethod
//     public void setup() {
//         // Ensure chromedriver binary is available and matches installed Chrome
//         WebDriverManager.chromedriver().setup();
//         driver = new ChromeDriver();
//         driver.get(SettingsTestData.getEnvData().getHost());
//         driver.manage().window().maximize();
//     }

//     @AfterMethod
//     public void teardown() {
//         if (driver != null) {
//             driver.quit();
//         }
//     }

// }
