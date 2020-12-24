package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;
    private By usernameInput = By.id("txtUsername");
    private By passwordInput = By.id("txtPassword");
    private By loginButton = By.id("btnLogin");
    private By loginErrorMessage = By.id("spanMessage");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void setUsername(String userName){
        driver.findElement(usernameInput).sendKeys(userName);
    }

    public void setPassword(String password){
        driver.findElement(passwordInput).sendKeys(password);
    }

    public DashBoardPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new DashBoardPage(driver);
    }

    public String getLoginErrorWarning(){
        return driver.findElement(loginErrorMessage).getText();
    }

    public String getPageTitle(){
        return driver.getTitle();
    }


}
