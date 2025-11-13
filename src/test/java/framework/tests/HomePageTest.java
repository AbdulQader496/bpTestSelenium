package framework.tests;

import org.testng.annotations.Test;

import framework.pages.HomePage;

public class HomePageTest extends BaseTest {
    protected HomePage homePage = new HomePage();

    @Test
    public void homePagetest() {
        homePage.homePageHeader();
    }

    @Test
    public void IdealBpCatagoryTest() {
        homePage.enterSystolicValue("115");
        homePage.enterDiastolicValue("75"); 
        homePage.clickSubmitButton();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        String result = homePage.getBPCategoryResult();
        assert result.contains("Ideal Blood Pressure") : "Expected 'Ideal blood pressure' but got '" + result + "'";
        String idealText = homePage.getIdealBPCategoryText();
        assert idealText.equals("Blood Pressure Category: Ideal") : "Expected 'Ideal' but got '" + idealText + "'";        
    }

    @Test
    public void PreHighBpCatagoryTest() {
        homePage.enterSystolicValue("130");
        homePage.enterDiastolicValue("60"); 
        homePage.clickSubmitButton();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        String result = homePage.getBPCategoryResult();
        assert result.contains("Pre-High Blood Pressure") : "Expected 'Ideal blood pressure' but got '" + result + "'";
        String preHighText = homePage.getPreHighBPCategoryText();
        assert preHighText.equals("Blood Pressure Category: PreHigh") : "Expected 'PreHigh' but got '" + preHighText + "'";
    }

    @Test
    public void HighBpCatagoryTest() {
        homePage.enterSystolicValue("140");
        homePage.enterDiastolicValue("75"); 
        homePage.clickSubmitButton();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        String result = homePage.getBPCategoryResult();
        assert result.contains("High Blood Pressure") : "Expected 'Ideal blood pressure' but got '" + result + "'";
        String highBpText = homePage.getHighBPCategoryText();
        assert highBpText.equals("Blood Pressure Category: High") : "Expected 'High' but got '" + highBpText + "'";
        
    }

    @Test
    public void LowBpCatagoryTest() {
        homePage.enterSystolicValue("70");
        homePage.enterDiastolicValue("60"); 
        homePage.clickSubmitButton();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        String result = homePage.getBPCategoryResult();
        assert result.contains("Low Blood Pressure") : "Expected 'Ideal blood pressure' but got '" + result + "'";
        String lowBpText = homePage.getLowBPCategoryText();
        assert lowBpText.equals("Blood Pressure Category: Low") : "Expected 'Low' but got '" + lowBpText + "'";        
    }

    @Test
    public void FooterTest() {
        String privacyText = homePage.getFooterPrivacyPolicyText();
        assert privacyText.equals("Privacy") : "Expected 'Privacy' but got '" + privacyText + "'";
        String copyrightText = homePage.getFooterCopyrightText();
        assert copyrightText.contains("© 2025 - BPCalculator -") : "Expected copyright symbol but got '" + copyrightText + "'";
    }

    @Test
    public void SystolicAndDiastolicValueOutOfLowerRange() {
        homePage.enterSystolicValue("69");
        homePage.enterDiastolicValue("39"); 
        homePage.clickSubmitButton();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        String systolicValueValidationText = homePage.getSystolicValueValidationText();
        assert systolicValueValidationText.equals("Invalid Systolic Value") : "Expected 'Invalid Systolic Value'" + systolicValueValidationText + "'";
        String diastolicValueValidationText = homePage.getDiastolicValueValidationText();
        assert diastolicValueValidationText.equals("Invalid Diastolic Value") : "Expected 'Invalid Diastolic Value'" + diastolicValueValidationText + "'";
    }

    @Test
    public void SystolicAndDiastolicValueOutOfUpperRange() {
        homePage.enterSystolicValue("191");
        homePage.enterDiastolicValue("101"); 
        homePage.clickSubmitButton();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        String systolicValueValidationText = homePage.getSystolicValueValidationText();
        assert systolicValueValidationText.equals("Invalid Systolic Value") : "Expected 'Invalid Systolic Value'" + systolicValueValidationText + "'";
        String diastolicValueValidationText = homePage.getDiastolicValueValidationText();
        assert diastolicValueValidationText.equals("Invalid Diastolic Value") : "Expected 'Invalid Diastolic Value'" + diastolicValueValidationText + "'";
    
    }   

    @Test
    public void getValueGreaterValidationText() {
        homePage.enterSystolicValue("80");
        homePage.enterDiastolicValue("100"); 
        homePage.clickSubmitButton();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        String valueGreaterValidationText = homePage.getValueGreaterValidationText();
        assert valueGreaterValidationText.equals("Systolic must be greater than Diastolic") : "Expected 'Systolic value must be greater than Diastolic value.'" + valueGreaterValidationText + "'";
    }


    
}
