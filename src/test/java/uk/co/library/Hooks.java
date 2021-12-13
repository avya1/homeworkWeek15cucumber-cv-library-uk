package uk.co.library;

import com.cucumber.listener.Reporter;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import uk.co.library.propertyreader.PropertyReader;
import uk.co.library.utility.Utilities;

import java.io.IOException;

public class Hooks extends Utilities {
    @Before
    public void setUp(){
        selectBrowser(PropertyReader.getInstance().getProperty("browser"));
        Reporter.assignAuthor("Anchal");
    }
    @After
    public void tearDown(Scenario scenario){

        if(scenario.isFailed()){
            String screenShortPath=Utilities.getScreenshot(driver,scenario.getName().replace(" ","_"));
            try {
                Reporter.addScreenCaptureFromPath(screenShortPath);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        closeBrowser();
    }

}
