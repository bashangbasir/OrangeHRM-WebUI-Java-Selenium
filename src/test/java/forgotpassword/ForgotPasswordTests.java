package forgotpassword;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgotPasswordTests extends BaseTest {

    @Test (priority = 0)
    public void testForgotPasswordWithCorrectUsername(){
        var forgotPasswordPage = homePage.clickForgotPasswordLink();
        forgotPasswordPage.setUsername("Admin");
        var successForgotPasswordPage = forgotPasswordPage.clickResetButton();
        Assert.assertEquals(successForgotPasswordPage.getSuccessHeader(),"Instruction Sent !","Incorrect Success Header's content");
        Assert.assertTrue(successForgotPasswordPage.getSuccessMessage().contains("Instructions for resetting your password have been sent to"),"Incorrect Success message's content ");
    }

    @Test
    public void testForgotPasswordWithCorrectUsernameMultipleTry(){
        var forgotPasswordPage = homePage.clickForgotPasswordLink();
        forgotPasswordPage.setUsername("Admin");
        forgotPasswordPage.clickResetButton();
        var isWarningMessageDisplayed = forgotPasswordPage.isMessageWarningDisplayed();
        Assert.assertTrue(isWarningMessageDisplayed,"Warning Message is not displayed");
        Assert.assertTrue(forgotPasswordPage.getWarningMessage().contains("There is a password reset request already in the system."),"Incorrect warning message's content");
    }

    @Test
    public void testForgotPasswordWithWrongUsername(){
        var forgotPasswordPage = homePage.clickForgotPasswordLink();
        forgotPasswordPage.setUsername("Aaaaaaaaaa");
        forgotPasswordPage.clickResetButton();
        var isWarningMessageDisplayed = forgotPasswordPage.isMessageWarningDisplayed();
        Assert.assertTrue(isWarningMessageDisplayed,"Warning Message is not displayed");
        Assert.assertTrue(forgotPasswordPage.getWarningMessage().contains("Please contact HR admin in order to reset the password"),"Incorrect warning message's content");

    }

    @Test
    public void testForgotPasswordWithEmptyUsername(){
        var forgotPasswordPage = homePage.clickForgotPasswordLink();
        forgotPasswordPage.setUsername("");
        forgotPasswordPage.clickResetButton();
        var isWarningMessageDisplayed = forgotPasswordPage.isMessageWarningDisplayed();
        Assert.assertTrue(isWarningMessageDisplayed,"Warning Message is not displayed");
        Assert.assertTrue(forgotPasswordPage.getWarningMessage().contains("Could not find a user with given details"),"Incorrect warning message's content");
    }

    @Test
    public void testCancelForgotPassword(){
        var forgotPasswordPage = homePage.clickForgotPasswordLink();
        forgotPasswordPage.clickCancelButton();
        Assert.assertEquals(homePage.getLoginPanelHeading(),"LOGIN Panel","Incorrect page");
    }
}
