package forgotpassword;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ForgotPasswordMessages;

public class ForgotPasswordTests extends BaseTest implements ForgotPasswordMessages {

    @Test (priority = 0)
    public void testForgotPasswordWithCorrectUsername(){
        var forgotPasswordPage = homePage.clickForgotPasswordLink();
        forgotPasswordPage.setUsername("Admin");
        var successForgotPasswordPage = forgotPasswordPage.clickResetButton();
        Assert.assertEquals(successForgotPasswordPage.getSuccessHeader(),ForgotPasswordMessages.INSTRUCTIONSENTSUCCESSMSG,"Incorrect Success Header's content");
        Assert.assertTrue(successForgotPasswordPage.getSuccessMessage().contains(ForgotPasswordMessages.INSTRUCTIONSENTDETAILMSG),"Incorrect Success message's content ");
    }

    @Test
    public void testForgotPasswordWithCorrectUsernameMultipleTry(){
        var forgotPasswordPage = homePage.clickForgotPasswordLink();
        forgotPasswordPage.setUsername("Admin");
        forgotPasswordPage.clickResetButton();
        var isWarningMessageDisplayed = forgotPasswordPage.isMessageWarningDisplayed();
        Assert.assertTrue(isWarningMessageDisplayed,"Warning Message is not displayed");
        Assert.assertTrue(forgotPasswordPage.getWarningMessage().contains(ForgotPasswordMessages.REQUESTINSYSTEMMSG),"Incorrect warning message's content");
    }

    @Test
    public void testForgotPasswordWithWrongUsername(){
        var forgotPasswordPage = homePage.clickForgotPasswordLink();
        forgotPasswordPage.setUsername("Aaaaaaaaaa");
        forgotPasswordPage.clickResetButton();
        var isWarningMessageDisplayed = forgotPasswordPage.isMessageWarningDisplayed();
        Assert.assertTrue(isWarningMessageDisplayed,"Warning Message is not displayed");
        Assert.assertTrue(forgotPasswordPage.getWarningMessage().contains(ForgotPasswordMessages.CONTACTHRMSG),
                "Incorrect warning message's content");

    }

    @Test
    public void testForgotPasswordWithEmptyUsername(){
        var forgotPasswordPage = homePage.clickForgotPasswordLink();
        forgotPasswordPage.setUsername("");
        forgotPasswordPage.clickResetButton();
        var isWarningMessageDisplayed = forgotPasswordPage.isMessageWarningDisplayed();
        Assert.assertTrue(isWarningMessageDisplayed,"Warning Message is not displayed");
        Assert.assertTrue(forgotPasswordPage.getWarningMessage().contains(ForgotPasswordMessages.MISSINGUSERNAMEMSG),"Incorrect warning message's content");
    }

    @Test
    public void testCancelForgotPassword(){
        var forgotPasswordPage = homePage.clickForgotPasswordLink();
        forgotPasswordPage.clickCancelButton();
        Assert.assertEquals(homePage.getLoginPanelHeading(),"LOGIN Panel","Incorrect page");
    }
}
