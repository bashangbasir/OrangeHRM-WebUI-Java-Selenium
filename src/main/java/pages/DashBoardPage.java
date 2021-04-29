package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class DashBoardPage {
    private WebDriver driver;
    private By welcomeUser = By.id("welcome");
    private By leaveMenu = By.id("menu_leave_viewLeaveModule");
    private By applySubmenu = By.id("menu_leave_applyLeave");

    public DashBoardPage(WebDriver driver){
        this.driver = driver;
    }

    public String getWelcomeText(){
        return driver.findElement(welcomeUser).getText();
    }

    public ApplyLeavePage goToApplyLeaveViaLeaveMenu(){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(leaveMenu))
                .moveToElement(driver.findElement(applySubmenu))
                .click();

        actions.perform();
        return new ApplyLeavePage(driver);
    }
}