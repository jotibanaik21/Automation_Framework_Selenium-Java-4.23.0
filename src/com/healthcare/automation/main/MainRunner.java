package com.healthcare.automation.main;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.slf4j.*;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.LoggerFactory;
import org.testng.TestNG;
import com.healthcare.automation.utils.PropertiesHelper;

public class MainRunner {
	private static PropertiesHelper propertiesHelper;
	private static Properties defaultCredProp;
	private static Properties defaultAutomationProp;
	private static String configPath;
	private static String testClassPath;
	private static List<String> methodsToExecute;
	private static final Logger LOGGER=LoggerFactory.getLogger(MainRunner.class);

	public static void main(String[] args) throws Exception {
		Configurator.initialize(null,"config/log4j2.xml");
		try {
			
			LOGGER.info("Configuring default properties");
			configPath=System.getProperty("user.dir")+File.separator+"config"+File.separator;
			testClassPath="com.healthcare.automation.tests.";
			propertiesHelper=new PropertiesHelper();
			defaultCredProp=propertiesHelper.loadProperties(configPath+"DefaultCred.properties");
			defaultAutomationProp=propertiesHelper.loadProperties(configPath+"DefaultAutomation.properties");

			// Load the Excel file
			FileInputStream file = new FileInputStream(new File(configPath+"AutomationSuit.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Read the regression sheet
			XSSFSheet regressionSheet = workbook.getSheet("Regression");
			int rowCountRegression = regressionSheet.getPhysicalNumberOfRows();

			List<String> classesToExecute = new ArrayList<>();


			for (int i = 1; i < rowCountRegression; i++) { // Start from 1 to skip header row
				Row row = regressionSheet.getRow(i);
				String execute = row.getCell(0).getStringCellValue();
				String className = row.getCell(1).getStringCellValue();

				if ("Y".equalsIgnoreCase(execute)) {
					classesToExecute.add(className);
					XSSFSheet testClassSheet = workbook.getSheet(className);
					int rowCountTestClass = testClassSheet.getPhysicalNumberOfRows();
					methodsToExecute= new ArrayList<>();

					for (int j = 1; j < rowCountTestClass; j++) { // Start from 1 to skip header row
						Row row_ = testClassSheet.getRow(j);
						String execute_ = row_.getCell(0).getStringCellValue();
						String methodName_ = row_.getCell(1).getStringCellValue();
						if ("Y".equalsIgnoreCase(execute_)) {

							methodsToExecute.add(methodName_);

						}
					}
				}
			}

			workbook.close();
			file.close();

			// Create TestNG instance
			TestNG testNG = new TestNG();

			// Dynamically add test classes and methods
			List<Class<?>> testClasses = new ArrayList<>();
			for (String className : classesToExecute) {
				Class<?> loadedClass = Class.forName(testClassPath+className);

				testClasses.add(loadedClass);
			}

			testNG.setTestClasses(testClasses.toArray(new Class<?>[0]));
			testNG.setDefaultSuiteName("Automation Suite");
			testNG.setDefaultTestName("Regression Tests");
			testNG.setUseDefaultListeners(false);
			testNG.run();



		} catch (Exception e) {
			e.printStackTrace();
		}


	}

	public static Properties getDefaultCredProp() {
		return defaultCredProp;
	}

	public static Properties getDefaultAutomationProp() {
		return defaultAutomationProp;
	}

	public static List<String> getMethodsToExecute() {
		return methodsToExecute;
	}




}


