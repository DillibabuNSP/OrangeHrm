package org.atmecs.ui_automation.orangehrm.pages;

//Import statements for necessary classes and constants
import org.atmecs.ui_automation_orangehrm.constants.Constants;
import org.atmecs.ui_automation_orangehrm.constants.FilePathConstants;
import org.atmecs.ui_automation_orangehrm.helper.MethodHelper;
import org.atmecs.ui_automation_orangehrm.pagekeys.PIMPageKeys;
import org.atmecs.ui_automation_orangrhrm.utils.PropertyParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.ui.selenium.Verify;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;

public class PIMPage {
	private ReportLogService report = new ReportLogServiceImpl(PIMPage.class);
	private PropertyParser pimPageProperty;
	MethodHelper methodHelper  = new MethodHelper();

	public PIMPage() {
		pimPageProperty = new PropertyParser(FilePathConstants.PIM_PAGE_PATH);
	}

	 // Method to click on the "Reports" section
	public void clickReports(Browser browser) {
		report.info("Clicking on Reports");
		String reportButtonXpath = pimPageProperty.getPropertyValue(PIMPageKeys.REPORTS);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, reportButtonXpath, Constants.TIME_OUTS);
		browser.getClick().performClick(LocatorType.XPATH, reportButtonXpath);
	}
	
	 // Method to click on the "Add" button
	public void clickAdd(Browser browser) {
		report.info("Clicking on Add");
		String addButtonXpath = pimPageProperty.getPropertyValue(PIMPageKeys.ADD_BUTTON);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, addButtonXpath, Constants.TIME_OUTS);
		browser.getClick().performClick(LocatorType.XPATH, addButtonXpath);
	}
	
	// Method to enter a report name in a text field
	public void enterReportName(Browser browser,String reportName) {
		report.info("Entering Report Name");
		String reportNameXpath = pimPageProperty.getPropertyValue(PIMPageKeys.REPORT_NAME);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, reportNameXpath, Constants.TIME_OUTS);
		browser.getTextField().enterTextField(LocatorType.XPATH, reportNameXpath, reportName);
	}
	
	// Method to select a criteria for a report
	public void selectionCriteria(Browser browser,String selectCriteria) {
		report.info("Selecting Selection Criteria");
		String selectionCriteriaXpath = pimPageProperty.getPropertyValue(PIMPageKeys.SELECTION_CRITERIA);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, selectionCriteriaXpath, Constants.TIME_OUTS);
		browser.getClick().performClick(LocatorType.XPATH, selectionCriteriaXpath);
		
		String selectCriteriaXpath = pimPageProperty.getPropertyValue(PIMPageKeys.SELECT_CRITERIA);
		methodHelper.selectHiddenDropdownByVisibleText(browser, selectCriteriaXpath, selectCriteria);
	}
	
	
	// Method to select an inclusion criteria for a report
	public void selectInclude(Browser browser,String selectInclude) {
		report.info("Selecting Include");
		String includeXpath = pimPageProperty.getPropertyValue(PIMPageKeys.INCLUDE);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, includeXpath, Constants.TIME_OUTS);
		browser.getClick().performClick(LocatorType.XPATH, includeXpath);
		
		String selectCriteriaXpath = pimPageProperty.getPropertyValue(PIMPageKeys.SELECT_CRITERIA);
		methodHelper.selectHiddenDropdownByVisibleText(browser, selectCriteriaXpath, selectInclude);
	}
	
	// Method to select a display field group for a report
	public void selectDisplayFieldGroup(Browser browser,String displayFieldGroup){
		report.info("Selecting select display field group");
		String displayFieldGroupXpath = pimPageProperty.getPropertyValue(PIMPageKeys.SELECT_DISPLAY_FIELD_GROUP);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, displayFieldGroupXpath, Constants.TIME_OUTS);
		browser.getClick().performClick(LocatorType.XPATH, displayFieldGroupXpath);
		
		String selectCriteriaXpath = pimPageProperty.getPropertyValue(PIMPageKeys.SELECT_CRITERIA);
		methodHelper.selectHiddenDropdownByVisibleText(browser, selectCriteriaXpath, displayFieldGroup);
	}
	
	// Method to select a display field for a report
	public void selectDisplayField(Browser browser,String displayField) {
		report.info("Selecting display field");
		String displayFieldXpath = pimPageProperty.getPropertyValue(PIMPageKeys.SELECT_DISPLAY_FIELD);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, displayFieldXpath, Constants.TIME_OUTS);
		browser.getClick().performClick(LocatorType.XPATH, displayFieldXpath);
		
		String selectCriteriaXpath = pimPageProperty.getPropertyValue(PIMPageKeys.SELECT_CRITERIA);
		methodHelper.selectHiddenDropdownByVisibleText(browser, selectCriteriaXpath, displayField);
	}
	
	
	public void selectionCriteriaCategroy(Browser browser,String selectCriteriaCategory) throws InterruptedException {
		report.info("Selecting the category under Selection Criteria ");
		String selectionCriteriaPlusIconXpath = pimPageProperty.getPropertyValue(PIMPageKeys.SELECTION_CRITERIA_PLUS_ICON);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, selectionCriteriaPlusIconXpath, Constants.TIME_OUTS);
		browser.getClick().performClick(LocatorType.XPATH, selectionCriteriaPlusIconXpath);
		
		String selectionCriteriaCategoryXpath = pimPageProperty.getPropertyValue(PIMPageKeys.SELECTION_CRITERIA_CATEGORY);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, selectionCriteriaCategoryXpath, Constants.TIME_OUTS);
		browser.getClick().performClick(LocatorType.XPATH, selectionCriteriaCategoryXpath);
		Thread.sleep(3000);
		
		String selectCriteriaXpath = pimPageProperty.getPropertyValue(PIMPageKeys.SELECT_CRITERIA);
		methodHelper.selectHiddenDropdownByVisibleText(browser, selectCriteriaXpath, selectCriteriaCategory);
		
	}
	
	public void clickSave(Browser browser) {
		report.info("Clicking on Save");
		String saveButtonXpath = pimPageProperty.getPropertyValue(PIMPageKeys.SAVE_BUTTON);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, saveButtonXpath, Constants.TIME_OUTS);
		browser.getClick().performClick(LocatorType.XPATH, saveButtonXpath);
		
	}
	
	public void clickReportNameTextField(Browser browser, String reportName) throws InterruptedException {
		report.info("Clicking on Report Name Text Field");
		String reportNameTextFieldPath = pimPageProperty.getPropertyValue(PIMPageKeys.REPORT_NAME_TEXT_FIELD);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, reportNameTextFieldPath, Constants.TIME_OUTS);
		browser.getTextField().enterTextField(LocatorType.XPATH, reportNameTextFieldPath,reportName);
		Thread.sleep(2000);
		
		String selectCriteriaXpath = pimPageProperty.getPropertyValue(PIMPageKeys.SELECT_CRITERIA);
		methodHelper.selectHiddenDropdownByVisibleText(browser, selectCriteriaXpath, reportName);
		
	}
	
	public void clickSearch(Browser browser) {
		report.info("Clicking on Search");
		String saveButtonXpath = pimPageProperty.getPropertyValue(PIMPageKeys.SEARCH_BUTTON);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, saveButtonXpath, Constants.TIME_OUTS);
		browser.getClick().performClick(LocatorType.XPATH, saveButtonXpath);
		
	}
	
	// Method to verify the text of records
	public void getTextOfRecords(Browser browser, String reportName) {
		report.info("Verify the Text Records");
		String foundNameXPath = pimPageProperty.getPropertyValue(PIMPageKeys.RECORD_FOUND);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, foundNameXPath, Constants.TIME_OUTS);
		WebElement  foundName = browser.getDriver().findElement(By.xpath(foundNameXPath));
		Verify.verifyString(foundName.getText(), "(1) Record Found","Found Message: ");
	}
	
	public void clickEdit(Browser browser) {
		report.info("Clicking on Edit");
		String editButtonXpath = pimPageProperty.getPropertyValue(PIMPageKeys.EDIT_BUTTON);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, editButtonXpath, Constants.TIME_OUTS);
		browser.getClick().performClick(LocatorType.XPATH, editButtonXpath);
		
	}
	
	public void selectDisplayFieldGroupInEdit(Browser browser,String displayFieldGroup) throws InterruptedException{
		report.info("Selecting display field group in Edit Page");
		String displayFieldGroupXpath = pimPageProperty.getPropertyValue(PIMPageKeys.SELECT_DISPLAY_FIELD_GROUP_IN_EDIT);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, displayFieldGroupXpath, Constants.TIME_OUTS);
		browser.getClick().performClick(LocatorType.XPATH, displayFieldGroupXpath);
		
		
		System.out.println(displayFieldGroup);
		String selectCriteriaXpath = pimPageProperty.getPropertyValue(PIMPageKeys.SELECT_CRITERIA);
		methodHelper.selectHiddenDropdownByVisibleText(browser, selectCriteriaXpath, displayFieldGroup);
		Thread.sleep(4000);
	}
	
	public void selectionCriteriaCategroyInEdit(Browser browser,String selectCriteriaCategory) throws InterruptedException {
		report.info("Selecting the category under display field in Edit Page");
		String selectionCriteriaPlusIconXpath = pimPageProperty.getPropertyValue(PIMPageKeys.SELECTION_CRITERIA_PLUS_ICON);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, selectionCriteriaPlusIconXpath, Constants.TIME_OUTS);
		browser.getClick().performClick(LocatorType.XPATH, selectionCriteriaPlusIconXpath);
		
		String selectionCriteriaCategoryXpath = pimPageProperty.getPropertyValue(PIMPageKeys.SELECTION_CRITERIA_CATEGORY_IN_EDIT);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, selectionCriteriaCategoryXpath, Constants.TIME_OUTS);
		browser.getClick().performClick(LocatorType.XPATH, selectionCriteriaCategoryXpath);
		
		String selectCriteriaXpath = pimPageProperty.getPropertyValue(PIMPageKeys.SELECT_CRITERIA);
		methodHelper.selectHiddenDropdownByVisibleText(browser, selectCriteriaXpath, selectCriteriaCategory);
		
	}
	
	public void clickDelete(Browser browser) {
		report.info("Clicking on Delete");
		String deleteButtonXpath = pimPageProperty.getPropertyValue(PIMPageKeys.DELETE_RECORD);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, deleteButtonXpath, Constants.TIME_OUTS);
		browser.getClick().performClick(LocatorType.XPATH, deleteButtonXpath);
		
		report.info("Clicking on Delete Alert");
		String deletAlertButtonXpath = pimPageProperty.getPropertyValue(PIMPageKeys.DELETE_RECORD_ALERT);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, deletAlertButtonXpath, Constants.TIME_OUTS);
		browser.getClick().performClick(LocatorType.XPATH, deletAlertButtonXpath);
		
	}
	
	public void getTextOfDeleteRecords(Browser browser, String reportName) {
		report.info("Verify the Text Delete Records");
		String foundNameXPath = pimPageProperty.getPropertyValue(PIMPageKeys.DELETE_RECORD_FOUND);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, foundNameXPath, Constants.TIME_OUTS);
		WebElement  foundName = browser.getDriver().findElement(By.xpath(foundNameXPath));
		Verify.verifyString(foundName.getText(), "No Records Found","Found Message: ");
	}
}
