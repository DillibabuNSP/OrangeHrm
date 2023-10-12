package org.atmecs.ui_automation.orangehrm.pages;

import org.atmecs.ui_automation_orangehrm.constants.Constants;
import org.atmecs.ui_automation_orangehrm.constants.FilePathConstants;
import org.atmecs.ui_automation_orangehrm.helper.MethodHelper;
import org.atmecs.ui_automation_orangehrm.pagekeys.AdminPageKeys;

import org.atmecs.ui_automation_orangrhrm.utils.PropertyParser;

import org.openqa.selenium.WebElement;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;

public class AdminPage {
	private ReportLogService report = new ReportLogServiceImpl(AdminPage.class);
	private PropertyParser adminPageProperty;
	MethodHelper methodHelper = new MethodHelper();
	

	public AdminPage() {
		adminPageProperty = new PropertyParser(FilePathConstants.ADMIN_PAGE_PATH);
	
	}
	
	public void clickAdminTab(Browser browser) {
		report.info("Clicking on Admin Tab");
		String adminButtonXpath = adminPageProperty.getPropertyValue(AdminPageKeys.ADMIN_TAB);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, adminButtonXpath, Constants.TIME_OUTS);
		browser.getClick().performClick(LocatorType.XPATH, adminButtonXpath);
	}
	
	public void clickJobTab(Browser browser) {
		report.info("Clicking on Job");
		String jobButtonXpath = adminPageProperty.getPropertyValue(AdminPageKeys.JOB_TAB);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, jobButtonXpath, Constants.TIME_OUTS);
		browser.getClick().performClick(LocatorType.XPATH, jobButtonXpath);
	}
	
	public void clickJobTitle(Browser browser) {
		report.info("Clicking on Job Title");
		String jobTitleXpath = adminPageProperty.getPropertyValue(AdminPageKeys.JOB_TITLE);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, jobTitleXpath, Constants.TIME_OUTS);
		browser.getClick().performClick(LocatorType.XPATH, jobTitleXpath);
	}
	
	public void enterJobTitle(Browser browser,String jobTitle) throws InterruptedException {
		report.info("Entering Job Title");
		String reportNameXpath = adminPageProperty.getPropertyValue(AdminPageKeys.JOB_TITLE_TEXT_FIELD);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, reportNameXpath, Constants.TIME_OUTS);
		WebElement jobTitleElement = browser.getFindFromBrowser().findElementByXpath(reportNameXpath);
		jobTitleElement.sendKeys(jobTitle);
		Thread.sleep(5000);
	}
	
	public void clickPayGrade(Browser browser) throws InterruptedException{
		report.info("Clicking on Pay Grade");
		String payGradeXpath = adminPageProperty.getPropertyValue(AdminPageKeys.PAY_GRADES);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, payGradeXpath, Constants.TIME_OUTS);
		browser.getClick().performClick(LocatorType.XPATH, payGradeXpath);
		Thread.sleep(2000);
	}
	
	public void clickJobCategories(Browser browser){
		report.info("Clicking on Job Categories");
		String payGradeXpath = adminPageProperty.getPropertyValue(AdminPageKeys.JOB_CATEGORIES);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, payGradeXpath, Constants.TIME_OUTS);
		browser.getClick().performClick(LocatorType.XPATH, payGradeXpath);
	}
	
}
