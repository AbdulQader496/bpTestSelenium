package framework.pages;

import framework.LocatorConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static framework.tests.BaseTest.driver;

public class HomePage {
    private static final By SYSTOLIC_INPUT = By.id("BP_Systolic");
    private static final By DIASTOLIC_INPUT = By.id("BP_Diastolic");
    private static final By SUBMIT_BUTTON = By.xpath("//input[@type='submit'][@value='Submit']");
    private static final By BP_CATEGORY_RESULT = By.xpath("//*[@id=\"form1\"]/div[4]");
    private static final By IDEAL_BP_CATEGORY = By.xpath("//div[contains(@class,'bp-category') and contains(@class,'ideal')]");
    private static final By PREHIGH_BP_CATEGORY = By.xpath("//div[contains(@class,'bp-category') and contains(@class,'prehigh')]");
    private static final By HIGH_BP_CATEGORY = By.xpath("//div[contains(@class,'bp-category') and contains(@class,'high')]");
    private static final By LOW_BP_CATEGORY = By.xpath("//div[contains(@class,'bp-category') and contains(@class,'low')]");
    private static final By FOOTER_PRIVACY_POLICY_LINK = By.xpath("//footer//a[contains(text(),'Privacy')]");
    private static final By FOOTER_COPYRIGHT = By.xpath("//footer//div[contains(@class,'container')]");
    private static final By SYSTOLIC_VALUE_VALIDATION = By.xpath("//span[@data-valmsg-for='BP.Systolic']");
    private static final By DIASTOLIC_VALUE_VALIDATION = By.xpath("//span[@data-valmsg-for='BP.Diastolic']");
    private static final By VALUE_GRETTER_VALIDATION = By.xpath("//div[contains(@class,'validation-summary-errors')]//li");

    public void homePageHeader() {
        driver.findElement(By.xpath(String.format(LocatorConstants.PRECISE_TEXT_XPATH, "BP Category Calculator"))).isDisplayed();
    }

    private WebElement getNavigationLink(MainPageNavigation navigation) {
        return driver.findElement(By.xpath(String.format(LocatorConstants.PRECISE_TEXT_XPATH, navigation.label)));
    }

    public void clickNavigationLink(MainPageNavigation navigation) {
        getNavigationLink(navigation).click();
    }

    public void enterSystolicValue(String systolic) {
        driver.findElement(SYSTOLIC_INPUT).clear();
        driver.findElement(SYSTOLIC_INPUT).sendKeys(systolic);
    }
    public void enterDiastolicValue(String diastolic) {
        driver.findElement(DIASTOLIC_INPUT).clear();
        driver.findElement(DIASTOLIC_INPUT).sendKeys(diastolic);
    }
    public void clickSubmitButton() {
        driver.findElement(SUBMIT_BUTTON).click();
    }
    public String getBPCategoryResult() {
        return driver.findElement(BP_CATEGORY_RESULT).getText();
    }
    public String getIdealBPCategoryText() {
        return driver.findElement(IDEAL_BP_CATEGORY).getText();
    }
    public String getPreHighBPCategoryText() {
        return driver.findElement(PREHIGH_BP_CATEGORY).getText();
    }
    public String getHighBPCategoryText() {
        return driver.findElement(HIGH_BP_CATEGORY).getText();
    }
    public String getLowBPCategoryText() {
        return driver.findElement(LOW_BP_CATEGORY).getText();
    }
    public String getFooterPrivacyPolicyText() {
        return driver.findElement(FOOTER_PRIVACY_POLICY_LINK).getText();
    }
    public String getFooterCopyrightText() {
        return driver.findElement(FOOTER_COPYRIGHT).getText();
    }
    public String getSystolicValueValidationText() {
        return driver.findElement(SYSTOLIC_VALUE_VALIDATION).getText();
    }  
    public String getDiastolicValueValidationText() {
        return driver.findElement(DIASTOLIC_VALUE_VALIDATION).getText();
    }
    public String getValueGreaterValidationText() {
        return driver.findElement(VALUE_GRETTER_VALIDATION).getText();
    }

}
