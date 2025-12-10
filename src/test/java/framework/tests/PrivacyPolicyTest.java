package framework.tests;

import framework.pages.PrivacyPolicyPage;
import framework.pages.HomePage;
import framework.pages.MainPageNavigation;
import org.testng.annotations.Test;

public class PrivacyPolicyTest extends BaseTest{
    protected HomePage homePage = new HomePage();
    protected PrivacyPolicyPage privacyPolicyPage =  new PrivacyPolicyPage();

    @Test
    public void privacyPolicytest() {
        homePage.clickNavigationLink(MainPageNavigation.Privacy_Policy);
        privacyPolicyPage.verifyPrivacyPolicyPage();
    }

    @Test
    public void privacyFooterTest() {
        homePage.clickNavigationLink(MainPageNavigation.Privacy_Policy);
        privacyPolicyPage.verifyPrivacyPolicyPage();
        String privacyText = privacyPolicyPage.getFooterPrivacyPolicyText();
        assert privacyText.equals("Privacy") : "Expected 'Privacy' but got '" + privacyText + "'";
        String copyrightText = privacyPolicyPage.getFooterCopyrightText();
        assert copyrightText.contains("© 2025 - BPCalculator -") : "Expected copyright symbol but got '" + copyrightText + "'";
    }
}
