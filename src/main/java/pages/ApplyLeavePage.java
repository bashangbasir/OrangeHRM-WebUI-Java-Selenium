package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApplyLeavePage {

    private WebDriver driver;
    private By applyLeaveHeader = By.xpath("//div[@class='head']/h1");
    private By leaveTypeDropdown = By.id("applyleave_txtLeaveType");
    private By applyButton = By.id("applyBtn");
    private By inputStartDate = By.id("applyleave_txtFromDate");
    private By inputEndDate = By.id("applyleave_txtToDate");
    private By leaveApplyStatusMessage = By.cssSelector("div.fadable");
    private By leaveTypeMessageValidation = By.xpath("//li/span[@for ='applyleave_txtLeaveType' and @class='validation-error']");

    public ApplyLeavePage(WebDriver driver){
        this.driver = driver;
    }

    public String getApplyLeaveHeader(){
        return driver.findElement(applyLeaveHeader).getText();
    }

    public void setLeaveCompulsoryDetail(String leaveType,String startDate,String endDate){
        setLeaveType(leaveType);
        setStartDate(startDate);
        setEndDate(endDate);
    }

    public void applyLeave(){
        //driver.findElement(applyButton).click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", driver.findElement(applyButton));
    }

    public String getLeaveApplyStatusMessage(){
        return driver.findElement(leaveApplyStatusMessage).getText();
    }

    public Boolean isLeaveApplyStatusMessageDisplayed(){
        return driver.findElement(leaveApplyStatusMessage).isDisplayed();
    }

    public String getLeaveTypeValidationMessage(){
        return driver.findElement(leaveTypeMessageValidation).getText();
    }

    private void setLeaveType(String leaveType){
        Select leaveTypeDropdownElement = new Select(driver.findElement(leaveTypeDropdown));
        leaveTypeDropdownElement.selectByVisibleText(leaveType);
    }

    private void setStartDate(String startDate){
        driver.findElement(inputStartDate).clear();
        driver.findElement(inputStartDate).sendKeys(startDate);
    }

    private void setEndDate(String endDate){
        driver.findElement(inputEndDate).clear();
        driver.findElement(inputEndDate).sendKeys(endDate);
    }

}
