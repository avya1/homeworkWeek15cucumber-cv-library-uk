package uk.co.library.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uk.co.library.utility.Utilities;


public class HomePage extends Utilities {
    private static final Logger log = LogManager.getLogger(HomePage.class.getName());
    public HomePage(){ PageFactory.initElements(driver, this);}
    @CacheLookup
    @FindBy(id = "keywords")
    WebElement jobTitleWE;
    @CacheLookup
    @FindBy(id = "location")
    WebElement locationWE;
    @CacheLookup
    @FindBy(id = "distance")
    WebElement distanceDropDown;
    @CacheLookup
    @FindBy(id = "toggle-hp-search")
    WebElement moreSearchOptionsLink;
    @CacheLookup
    @FindBy(id = "salarymin")
    WebElement salaryMin;
    @CacheLookup
    @FindBy(id = "salarymax")
    WebElement salaryMax;
    @CacheLookup
    @FindBy(id = "salarytype")
    WebElement salaryTypeDropDown;
    @CacheLookup
    @FindBy(id = "tempperm")
    WebElement jobTypeDropDown;
    @CacheLookup
    @FindBy(id = "hp-search-btn")
    WebElement findJobsBtn;
    @CacheLookup
    @FindBy(xpath = "//span//div//span[normalize-space()='Accept All']")
    WebElement acceptCookies;
    @CacheLookup
    @FindBy(id ="gdpr-consent-notice")
    WebElement iframe;

    public void setAcceptCookies(){
        switchToIframe(iframe);
        clickOnElement(acceptCookies);
        driver.switchTo().defaultContent();

    }
    public void enterJobTitle(String jobTitle){
        sendTextToElement(jobTitleWE,jobTitle);
        log.info("Clicking on job title   link : " + jobTitleWE.toString());
    }
    public void enterLocation(String location){
        sendTextToElement(locationWE,location);
        log.info("Clicking on location link : " + locationWE.toString());
    }
    public void selectDistance(String distance){

        sendTabAndEnterKey(distanceDropDown);
        selectByVisibleTextFromDropDown(distanceDropDown,distance);
        log.info("Clicking on distance drop down : " + distanceDropDown.toString());
    }
    public void clickOnMoreSearchOptionLink() throws InterruptedException {
        Thread.sleep(2000);
        clickOnElement(moreSearchOptionsLink);
        log.info("Clicking on more search option link : " + moreSearchOptionsLink.toString());

    }
    public void enterMinSalary(String minSalary){
        sendTextToElement(salaryMin,minSalary);
        log.info("Enter on minimum salary  : " + salaryMin.toString());
    }
    public void enterMaxSalary(String maxSalary){
        sendTextToElement(salaryMax,maxSalary);
        log.info("Enter maximum salary : " + salaryMax.toString());
    }
    public void selectSalaryType(String sType) {

        selectByVisibleTextFromDropDown(salaryTypeDropDown,sType);
        log.info("Select salary type: " + salaryTypeDropDown.toString());
    }
    public void selectJobType(String jobType) {

        selectByVisibleTextFromDropDown(jobTypeDropDown,jobType);
        log.info("Select job type: " + jobTypeDropDown.toString());
    }
    public void clickOnFindJobsButton(){

        clickOnElement(findJobsBtn);
        log.info("Clicking on find job btn link : " + findJobsBtn.toString());
    }

}
