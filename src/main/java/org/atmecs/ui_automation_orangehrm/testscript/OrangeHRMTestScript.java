/**
 * This is the main test script for automating actions in the OrangeHRM application.
 * It includes test methods to perform various actions such as launching the application,
 * logging in, and interacting with different pages in the application.
 *
 * The test data required for these actions is provided through data providers.
 */
package org.atmecs.ui_automation_orangehrm.testscript;

import java.util.ArrayList;
import java.util.Iterator;

import org.atmecs.ui_automation.orangehrm.pages.AdminPage;
import org.atmecs.ui_automation.orangehrm.pages.DashboardPage;
import org.atmecs.ui_automation.orangehrm.pages.LoginPage;
import org.atmecs.ui_automation.orangehrm.pages.PIMPage;
import org.atmecs.ui_automation.orangehrm.pages.StructurePage;
import org.atmecs.ui_automation_orangehrm.base.BasePage;
import org.atmecs.ui_automation_orangehrm.testsuite.SampleTestSuiteBase;
import org.atmecs.ui_automation_orangrhrm.utils.TestUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OrangeHRMTestScript extends SampleTestSuiteBase {

	LoginPage loginPage;
	BasePage basePage;
	PIMPage pimPage;
	DashboardPage dashboardPage;
	AdminPage adminPage = new AdminPage();
	private StructurePage structurePage;

	/**
	 * Data provider for test data.
	 *
	 * @return An iterator of test data.
	 */
	@DataProvider(name = "getData")
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> testData = TestUtils.getDataProvider();
		return testData.iterator();
	}

	/**
	 * Test method to launch the application.
	 *
	 * @param os             The operating system.
	 * @param osVersion      The operating system version.
	 * @param br             The browser.
	 * @param browserVersion The browser version.
	 */
	@Test
	@Parameters({ "os", "osVersion", "browser", "browserVersion" })
	public void launchApp(String os, String osVersion, String br, String browserVersion) {
		// Launch the application
		basePage = new BasePage();
		basePage.launchApp(browser, os, osVersion, br, browserVersion);
	}

	@Test(priority = 1, dataProvider = "getData", dependsOnMethods = "launchApp")
	@Parameters({ "userName", "passWord" })
	public void loginPageActions(String userName, String passWord) throws InterruptedException {
		loginPage = new LoginPage();
		loginPage.enterInvalidLoginCredentials(browser, userName, passWord);

	}

	@DataProvider(name = "getDataSheet2")
	public Iterator<Object[]> getTestDataFromSheet2() {
		ArrayList<Object[]> testData = TestUtils.getDataProviderSheet2();
		return testData.iterator();
	}

	@Test(priority = 2, dataProvider = "getDataSheet2")
	@Parameters({ "validUserName", "validPassWord", "reportName", "selectionCriteria", "selectInclude",
			"displayFieldGroup", "displayField", "selectionCriteriaCategory" })
	public void pimTabActions(String validUserName, String validPassWord, String reportName, String selectionCriteria,
			String selectInclude, String displayFieldGroup, String displayField, String selectionCriteriaCategory)
			throws InterruptedException {
		dashboardPage = new DashboardPage();
		pimPage = new PIMPage();

		dashboardPage.entervalidLoginCredentials(browser, validUserName, validPassWord);
		dashboardPage.clickPIMTab(browser);

		pimPage.clickReports(browser);
		pimPage.clickAdd(browser);
		pimPage.enterReportName(browser, reportName);
		pimPage.selectionCriteria(browser, selectionCriteria);
		pimPage.selectInclude(browser, selectInclude);
		pimPage.selectDisplayFieldGroup(browser, displayFieldGroup);
		pimPage.selectDisplayField(browser, displayField);
		pimPage.selectionCriteriaCategroy(browser, selectionCriteriaCategory);
		pimPage.clickSave(browser);

		pimPage.clickReports(browser);
		pimPage.clickReportNameTextField(browser, reportName);
		pimPage.clickSearch(browser);
		pimPage.getTextOfRecords(browser, reportName);
		pimPage.clickEdit(browser);
		pimPage.selectDisplayFieldGroupInEdit(browser, displayFieldGroup);
		pimPage.selectionCriteriaCategroyInEdit(browser, selectionCriteriaCategory);
		pimPage.clickSave(browser);

		pimPage.clickReports(browser);
		pimPage.clickReportNameTextField(browser, reportName);
		pimPage.clickSearch(browser);
		pimPage.getTextOfRecords(browser, reportName);
		pimPage.clickDelete(browser);
		pimPage.getTextOfDeleteRecords(browser, reportName);

	}

	@Test(priority = 3)
	public void adminPageActions() throws InterruptedException {

		adminPage.clickAdminTab(browser);
		adminPage.clickJobTab(browser);
		adminPage.clickJobTitle(browser);
		pimPage.clickAdd(browser);
		adminPage.enterJobTitle(browser, "Software");
		pimPage.clickSave(browser);
		pimPage.clickEdit(browser);
		adminPage.enterJobTitle(browser, "Software Engineering");
		pimPage.clickSave(browser);
		pimPage.clickDelete(browser);

		adminPage.clickJobTab(browser);
		adminPage.clickJobCategories(browser);
		pimPage.clickAdd(browser);
		adminPage.enterJobTitle(browser, "Software");
		pimPage.clickSave(browser);
		pimPage.clickEdit(browser);
		adminPage.enterJobTitle(browser, "Software Engineering");
		pimPage.clickSave(browser);
		pimPage.clickDelete(browser);

	}

	@Test(priority = 4)
	public void structurePageActions() throws InterruptedException {
		structurePage = new StructurePage();

		adminPage.clickAdminTab(browser);
		structurePage.clickOrganizationTab(browser);
		structurePage.clickStructureTab(browser);
		structurePage.clickEngineeringDropDown(browser);
		structurePage.clickEditButton(browser);
		structurePage.clickQaEditButton(browser);
		structurePage.clickQaTextFiled(browser, "Testing");
		pimPage.clickSave(browser);
		structurePage.clickAgainEngineeringDropDown(browser);
		structurePage.clickQADropDown(browser);
		structurePage.verifyAddedRecordDisplayed(browser);
	}
}
