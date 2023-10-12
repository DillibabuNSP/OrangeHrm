package org.atmecs.ui_automation_orangrhrm.utils;

import java.io.IOException;
import java.util.ArrayList;

import org.atmecs.ui_automation.orangehrm.pages.LoginPage;
import org.atmecs.ui_automation_orangehrm.constants.Constants;
import org.atmecs.ui_automation_orangehrm.constants.FilePathConstants;

import com.atmecs.falcon.automation.util.parser.XlsReader;

/**
 * This class provides utility methods for fetching test data from an Excel
 * file.
 */
public class TestUtils {
	static LoginPage loginPage = new LoginPage();

	/**
	 * This method retrieves test data from an Excel file and returns it as an
	 * ArrayList of Object arrays.
	 *
	 * @return An ArrayList of Object arrays containing test data.
	 */
	public static ArrayList<Object[]> getDataProvider() {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		XlsReader xlsReader = new XlsReader();

		try {
			xlsReader.setPath(FilePathConstants.EXCEL_INPUT_PATH);
		} catch (IOException e) {
			e.printStackTrace();
		}

		int rowCount = xlsReader.getRowCount(Constants.SHEET_1);
		System.out.println(rowCount);

		for (int rowNum = 1; rowNum <= rowCount; rowNum++) {
			String userName = xlsReader.getCellDataByColumnName(Constants.SHEET_1, Constants.COLUMN_USERNAME, rowNum);
			String passWord = xlsReader.getCellDataByColumnName(Constants.SHEET_1, Constants.COLUMN_PASSWORD, rowNum);

			Object ob[] = { userName, passWord };
			myData.add(ob);
		}

		return myData;
	}

	public static ArrayList<Object[]> getDataProviderSheet2() {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		XlsReader xlsReader = new XlsReader();

		try {
			xlsReader.setPath(FilePathConstants.EXCEL_INPUT_PATH);
		} catch (IOException e) {
			e.printStackTrace();
		}

		int rowCount = xlsReader.getRowCount(Constants.SHEET_2);
		System.out.println(rowCount);

		for (int rowNum = 1; rowNum <= rowCount; rowNum++) {
			String validUserName = xlsReader.getCellDataByColumnName(Constants.SHEET_2, Constants.COLUMN_VALID_USERNAME,
					rowNum);
			String validPassWord = xlsReader.getCellDataByColumnName(Constants.SHEET_2, Constants.COLUMN_VALID_PASSWORD,
					rowNum);

			String reportName = xlsReader.getCellDataByColumnName(Constants.SHEET_2, Constants.COLUMN_REPORT_NAME,
					rowNum);
			String selectionCriteria = xlsReader.getCellDataByColumnName(Constants.SHEET_2,
					Constants.COLUMN_SELECION_CRITERIA, rowNum);
			String selectInclude = xlsReader.getCellDataByColumnName(Constants.SHEET_2,
					Constants.COLUMN_SELECION_INCLUDE, rowNum);
			String displayFieldGroup = xlsReader.getCellDataByColumnName(Constants.SHEET_2,
					Constants.COLUMN_DISPLAY_FIELD_GROUP, rowNum);
			String displayField = xlsReader.getCellDataByColumnName(Constants.SHEET_2, Constants.COLUMN_DISPLAY_FIELD,
					rowNum);
			String selectionCriteriaCategory = xlsReader.getCellDataByColumnName(Constants.SHEET_2,
					Constants.COLUMN_DISPLAY_FIELD_2, rowNum);
//			String jobTitle = xlsReader.getCellDataByColumnName(Constants.SHEET_2, Constants.COLUMN_JOB_TITLE, rowNum);

			Object ob[] = { validUserName, validPassWord, reportName, selectionCriteria, selectInclude,
					displayFieldGroup, displayField, selectionCriteriaCategory};
			myData.add(ob);
		}

		return myData;
	}
}
