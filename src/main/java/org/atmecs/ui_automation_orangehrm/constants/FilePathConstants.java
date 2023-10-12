package org.atmecs.ui_automation_orangehrm.constants;

import java.io.File;

/**
 * This class centralizes file paths used in the automation project.
 * It provides a convenient way to manage and update file paths in one place.
 */
public class FilePathConstants {

    /** The user's home directory where the project is located. */
    public final static String USER_HOME = System.getProperty("user.dir") + File.separator;

    /** The directory where project resources are stored, such as properties files or configuration files. */
    public final static String RESOURCES_HOME = USER_HOME + "src" + File.separator + "main" + File.separator
            + "resources" + File.separator;

    /** The directory where locator-related files are stored (element locators used in automation tests). */
    public final static String LOCATOR_HOME = RESOURCES_HOME + "locators" + File.separator;

    /** The directory where output files are stored, such as log files or generated reports. */
    public final static String OUTPUT_HOME = RESOURCES_HOME + "output" + File.separator;

    /** The directory where testdata files are stored, such as log files or generated reports. */
    public final static String TESTDATA_HOME = RESOURCES_HOME + "testdata" + File.separator;
    
    public static final String EXCEL_INPUT_PATH = TESTDATA_HOME + "OrangeHRM.xlsx";
    
    public final static String LOGIN_PAGE_PATH= LOCATOR_HOME + "loginpage.properties";
    public final static String DASHBOARD_PAGE_PATH= LOCATOR_HOME + "dashboardpage.properties";
    public final static String PIM_PAGE_PATH= LOCATOR_HOME + "pimpage.properties";
    public final static String ADMIN_PAGE_PATH= LOCATOR_HOME + "adminpage.properties";
    public final static String STRUCTURE_PAGE_PATH= LOCATOR_HOME + "structure.properties";
}
