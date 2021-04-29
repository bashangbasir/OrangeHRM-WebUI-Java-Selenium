package login;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.LoginMessages;

public class LoginTests extends BaseTest implements LoginMessages {

    @Test
    public void testLoginInsertCorrectUsernameAndPassword(){
        homePage.setUsername("Admin");
        homePage.setPassword("admin123");
        var DashBoardPage = homePage.clickLoginButton();
        Assert.assertTrue(DashBoardPage.getWelcomeText().contains(LoginMessages.WELCOMEMSG),"Sign in failed.");
    }


    @Test
    public void testLoginInsertCorrectUsernameAndWrongPassword(){
        homePage.setUsername("Admin");
        homePage.setPassword("admin456");
        homePage.clickLoginButton();
        Assert.assertEquals(homePage.getLoginErrorWarning(), LoginMessages.INVALIDCREDMSG, "Wrong login error warning.");
    }

    @Test
    public void testLoginInsertWrongUsernameAndWrongPassword(){
        homePage.setUsername("xxxxx");
        homePage.setPassword("admin456");
        homePage.clickLoginButton();
        Assert.assertEquals(homePage.getLoginErrorWarning(), LoginMessages.INVALIDCREDMSG, "Wrong login error warning.");
    }

    @Test
    public void testLoginInsertUsernameOnly(){
        homePage.setUsername("admin");
        homePage.setPassword("");
        homePage.clickLoginButton();
        Assert.assertEquals(homePage.getLoginErrorWarning(), LoginMessages.EMPTYPASSWORDMSG, "Wrong login error warning.");
    }

    @Test
    public void testLoginInsertPasswordOnly(){
        homePage.setUsername("");
        homePage.setPassword("aaaa");
        homePage.clickLoginButton();
        Assert.assertEquals(homePage.getLoginErrorWarning(), LoginMessages.EMPTYUSERNAMEMSG, "Wrong login error warning.");
    }

    @Test
    public void testLoginWithoutInsertUsernameAndPassword(){
        homePage.setUsername("");
        homePage.setPassword("");
        homePage.clickLoginButton();
        Assert.assertEquals(homePage.getLoginErrorWarning(), LoginMessages.EMPTYUSERNAMEMSG, "Wrong login error warning.");
    }


}
