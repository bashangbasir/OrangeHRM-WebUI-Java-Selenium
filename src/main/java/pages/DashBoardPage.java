package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoardPage {
    private WebDriver driver;
    private By welcomeUser = By.id("welcome");

    public DashBoardPage(WebDriver driver){
        this.driver = driver;
    }

    public String getWelcomeText(){
        return driver.findElement(welcomeUser).getText();
    }
}