package org.atmecs.ui_automation_orangehrm.helper;



import java.util.List;

import org.atmecs.ui_automation_orangrhrm.utils.PropertyParser;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;

/**
 * The <code>ReusableFiles</code> class contains reusable methods for various
 * actions such as selecting dropdown values, entering dates, clicking radio
 * buttons, generating credit card numbers, and getting text from web elements.
 */
public class MethodHelper {
	private ReportLogService report = new ReportLogServiceImpl(MethodHelper.class);
	PropertyParser propertyParser;
	

	public String Alert(Browser browser) {
        boolean presentFlag = false;
        Alert alert = null;
        String alertText = null;
        try {
            // Check the presence of alert
            alert = browser.getDriver().switchTo().alert();
            alertText = alert.getText();
            // if present consume the alert
            alert.accept();
            presentFlag = true;
        } catch (NoAlertPresentException ex) {
            // Alert present; set the flag

            // Alert not present
            //ex.printStackTrace();
        } finally {
            if (!presentFlag) {
                report.info("The Alert is handled successfully");
            } else{
                report.info("There was no alert to handle");
            }
        }

        return alertText;
    }

	public void selectHiddenDropdownByVisibleText(Browser browser,String locator,String text) {
		List<WebElement>suggList = browser.getFindFromBrowser().findElementsBy(By.xpath(locator));
		
		 for (WebElement element : suggList) {
			    String elementText = element.getText();
			    if (elementText.contains(text)) {
			    	
			    	element.click();
			        
			        break; // Exit the loop since we found and clicked the desired element
			    }
			}
	}
}
