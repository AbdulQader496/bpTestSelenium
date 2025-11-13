package framework.pages;

import framework.LocatorConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static framework.tests.BaseTest.driver;

public class PrivacyPolicyPage extends HomePage{
    private static final String NAME = "Privacy Policy";
     private static final By FOOTER_PRIVACY_POLICY_LINK = By.xpath("//footer//a[contains(text(),'Privacy')]");
    private static final By FOOTER_COPYRIGHT = By.xpath("//footer//div[contains(@class,'container')]");


    public void verifyPrivacyPolicyPage() {
        driver.findElement(By.xpath(String.format(LocatorConstants.PRECISE_TEXT_XPATH, NAME))).isDisplayed();
    }

    public String getFooterPrivacyPolicyText() {
        return driver.findElement(FOOTER_PRIVACY_POLICY_LINK).getText();
    }
    public String getFooterCopyrightText() {
        return driver.findElement(FOOTER_COPYRIGHT).getText();
    }

    // public void clickCheckbox1() {
    //     WebElement CheckBox1 = driver.findElement(CHECKBOX1_LOCATOR);
    //     CheckBox1.click();
    // }

    // public void clickCheckbox2() {
    //     WebElement CheckBox2 = driver.findElement(CHECKBOX2_LOCATOR);
    //     CheckBox2.click();
    // }

}
