package login;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testLoginInsertCorrectUsernameAndPassword(){
        homePage.setUsername("Admin");
        homePage.setPassword("admin123");
        var DashBoardPage = homePage.clickLoginButton();
        Assert.assertTrue(DashBoardPage.getWelcomeText().contains("Welcome"),"Sign in failed.");
    }

    @Test
    public void testLoginInsertCorrectUsernameAndWrongPassword(){
        homePage.setUsername("Admin");
        homePage.setPassword("admin456");
        homePage.clickLoginButton();
        Assert.assertEquals(homePage.getLoginErrorWarning(),"Invalid credentials", "Wrong login error warning.");
    }

    @Test
    public void testLoginInsertUsernameOnly(){
        homePage.setUsername("admin");
        homePage.setPassword("");
        homePage.clickLoginButton();
        Assert.assertEquals(homePage.getLoginErrorWarning(),"Password cannot be empty", "Wrong login error warning.");
    }

    @Test
    public void testLoginWithoutInsertUsernameAndPassword(){
        homePage.setUsername("");
        homePage.setPassword("");
        homePage.clickLoginButton();
        Assert.assertEquals(homePage.getLoginErrorWarning(),"Username cannot be empty", "Wrong login error warning.");
    }
}
