package org.atmecs.ui_automation.orangehrm.pages;

import org.atmecs.ui_automation_orangehrm.constants.Constants;
import org.atmecs.ui_automation_orangehrm.constants.FilePathConstants;
import org.atmecs.ui_automation_orangehrm.helper.MethodHelper;
import org.atmecs.ui_automation_orangehrm.pagekeys.LoginPageKeys;
import org.atmecs.ui_automation_orangrhrm.utils.PropertyParser;
import org.openqa.selenium.WebElement;
import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.ui.selenium.Verify;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;

public class LoginPage {
	private ReportLogService report = new ReportLogServiceImpl(LoginPage.class);
	PropertyParser loginPageProperty;
	MethodHelper methodHelper = new MethodHelper();

	public LoginPage() {
		loginPageProperty = new PropertyParser(FilePathConstants.LOGIN_PAGE_PATH);
	}

	public void enterInvalidLoginCredentials(Browser browser, String userName, String passWord)
			throws InterruptedException {
		report.info("Entering the Invalid Credentials");
		String userNameXpath = loginPageProperty.getPropertyValue(LoginPageKeys.USER_NAME);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, userNameXpath, Constants.TIME_OUTS);
		browser.getTextField().enterTextField(LocatorType.XPATH, userNameXpath, userName);
		

		String passWordXpath = loginPageProperty.getPropertyValue(LoginPageKeys.PASS_WORD);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, passWordXpath, Constants.TIME_OUTS);
		browser.getTextField().enterTextField(LocatorType.XPATH, passWordXpath, passWord);
		
		String loginButtonXpath = loginPageProperty.getPropertyValue(LoginPageKeys.LOGIN_BUTTON);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, loginButtonXpath, Constants.TIME_OUTS);
		browser.getClick().performClick(LocatorType.XPATH, loginButtonXpath);
		Thread.sleep(3000);

		WebElement errorMessageElement = browser.getFindFromBrowser()
				.findElementByXpath(loginPageProperty.getPropertyValue(LoginPageKeys.ERROR_MESSAGE));
		String errorMessage = errorMessageElement.getText();
		Verify.verifyString(errorMessage, "Invalid credentials", "Error Message: ");
		System.out.println("Error Message: " + errorMessage);
	}

}
