package framework.tests;

import framework.pages.HomePage;
import framework.utils.SettingsTestData;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    public static WebDriver driver;
    protected HomePage homePage = new HomePage();

    @BeforeMethod
    public void setup() {
        // Ensure chromedriver binary is available and matches installed Chrome
        WebDriverManager.chromedriver().setup();
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

}
