package uk.co.library.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uk.co.library.utility.Utilities;


public class ResultPage extends Utilities {
    private static final Logger log = LogManager.getLogger(ResultPage.class.getName());

public ResultPage(){
    { PageFactory.initElements(driver, this);}
}

   /* @CacheLookup
    @FindBy(xpath = "//header[@class='search-header search-card']")
    WebElement resultText;

    */
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Permanent')]")
    WebElement resultText;

public String getRestulText(){
    log.info("result is : " + resultText.toString());
    return getTextFromElement(resultText);
}

}
