package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

    private WebDriver driver;
    private By usernameTextBox = By.id("securityAuthentication_userName");
    private By resetButton = By.id("btnSearchValues");
    private By cancelButton = By.id("btnCancel");

    public ForgotPasswordPage(WebDriver driver){
        this.driver = driver;
    }

    public void setUsername(String username){
        driver.findElement(usernameTextBox).sendKeys(username);
    }

    public void clickResetButton(){
        driver.findElement(resetButton).click();
    }

    public HomePage clickCancelButton(){
        driver.findElement(cancelButton).click();
        return new HomePage(driver);
    }
}
