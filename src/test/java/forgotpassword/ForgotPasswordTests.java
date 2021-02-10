package forgotpassword;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgotPasswordTests extends BaseTest {

    @Test
    public void testForgotPasswordWithCorrectUsername(){
        var forgotPasswordPage = homePage.clickForgotPasswordLink();
        forgotPasswordPage.setUsername("Admin");
        var successForgotPasswordPage = forgotPasswordPage.clickResetButton();
        Assert.assertEquals(successForgotPasswordPage.getSuccessHeader(),"Instruction Sent !","Incorrect Success Header's content");
        Assert.assertTrue(successForgotPasswordPage.getSuccessMessage().contains("Instructions for resetting your password have been sent to"),"Incorrect Success message's content ");
    }

    @Test
    public void testCancelForgotPassword(){
        var forgotPasswordPage = homePage.clickForgotPasswordLink();
        forgotPasswordPage.clickCancelButton();
        Assert.assertEquals(homePage.getLoginPanelHeading(),"LOGIN Panel","Incorrect page");
    }
}
