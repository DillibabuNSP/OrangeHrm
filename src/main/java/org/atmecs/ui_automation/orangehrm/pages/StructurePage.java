package org.atmecs.ui_automation.orangehrm.pages;

import org.atmecs.ui_automation_orangehrm.constants.Constants;
import org.atmecs.ui_automation_orangehrm.constants.FilePathConstants;
import org.atmecs.ui_automation_orangehrm.pagekeys.StructurePageKeys;
import org.atmecs.ui_automation_orangrhrm.utils.PropertyParser;
import org.openqa.selenium.WebElement;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.ui.selenium.Verify;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;

public class StructurePage {
	private ReportLogService report = new ReportLogServiceImpl(StructurePage.class);
	private PropertyParser structurePageProperty;
	public StructurePage() {
		structurePageProperty = new PropertyParser(FilePathConstants.STRUCTURE_PAGE_PATH);
	}
	
	public void clickOrganizationTab(Browser browser) {
		report.info("Clicking on Organization");
		String organisationButtonXpath = structurePageProperty.getPropertyValue(StructurePageKeys.ORGANIZATION_TAB);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, organisationButtonXpath, Constants.TIME_OUTS);
		browser.getClick().performClick(LocatorType.XPATH, organisationButtonXpath);
	}
	
	public void clickStructureTab(Browser browser) throws InterruptedException {
		report.info("Clicking on Structure");
		String structureButtonXpath = structurePageProperty.getPropertyValue(StructurePageKeys.STRUCTURE_TAB);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, structureButtonXpath, Constants.TIME_OUTS);
		browser.getClick().performClick(LocatorType.XPATH, structureButtonXpath);
		Thread.sleep(2000);
	}
	
	public void clickEngineeringDropDown(Browser browser) throws InterruptedException {
		report.info("Clicking on Engineering DropDown");
		String engineeringDropDownXpath = structurePageProperty.getPropertyValue(StructurePageKeys.ENGINEERING_DROPDOWN);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, engineeringDropDownXpath, Constants.TIME_OUTS);
		browser.getClick().performClick(LocatorType.XPATH, engineeringDropDownXpath);
		Thread.sleep(2000);
	}
	
	public void clickAgainEngineeringDropDown(Browser browser) throws InterruptedException {
		report.info("Clicking again on Engineering DropDown");
		Thread.sleep(3000);
		String engineeringDropDownXpath = structurePageProperty.getPropertyValue(StructurePageKeys.ADDED_STRUCTURE);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, engineeringDropDownXpath, Constants.TIME_OUTS);
		browser.getClick().performClick(LocatorType.XPATH, engineeringDropDownXpath);
		Thread.sleep(5000);
	}
	
	public void clickEditButton(Browser browser) {
		report.info("Clicking on Edit Button");
		String editButtonXpath = structurePageProperty.getPropertyValue(StructurePageKeys.EDIT_BUTTON);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, editButtonXpath, Constants.TIME_OUTS);
		browser.getClick().performClick(LocatorType.XPATH, editButtonXpath);
	}
	
	public void clickQaEditButton(Browser browser) {
		report.info("Clicking on QA Edit Button");
		String qaEditButtonXpath = structurePageProperty.getPropertyValue(StructurePageKeys.QA_EDIT_BUTTON);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, qaEditButtonXpath, Constants.TIME_OUTS);
		browser.getClick().performClick(LocatorType.XPATH, qaEditButtonXpath);
	}
	
	public void clickQaTextFiled(Browser browser,String text) {
		report.info("Enter Text on the QA");
		String qaTextFieldXpath = structurePageProperty.getPropertyValue(StructurePageKeys.QA_TEXT_FIELD);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, qaTextFieldXpath, Constants.TIME_OUTS);
		WebElement qaTextFieldElement = browser.getFindFromBrowser().findElementByXpath(qaTextFieldXpath);
		qaTextFieldElement.clear();
		qaTextFieldElement.sendKeys(text);
	}
	
	public void clickQADropDown(Browser browser) {
		report.info("Clicking on DropDown under QA");
		String qaDropDownXpath = structurePageProperty.getPropertyValue(StructurePageKeys.QA_DROP_DOWN);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, qaDropDownXpath, Constants.TIME_OUTS);
		browser.getClick().performClick(LocatorType.XPATH, qaDropDownXpath);
	}
	
	public void verifyAddedRecordDisplayed(Browser browser) {
		WebElement textElement = browser.getFindFromBrowser()
				.findElementByXpath(structurePageProperty.getPropertyValue(StructurePageKeys.QA_ADDED_RECORD));
		String verificationText = textElement.getText();
		Verify.verifyString(verificationText, "Testing", "Added Record: ");
		System.out.println("Added Record: " + verificationText);
	}
}
