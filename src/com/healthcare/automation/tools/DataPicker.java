package com.healthcare.automation.tools;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataPicker {
	public static List<String> getTestClasses(String filePath, String sheetName) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet(sheetName);
        List<String> testClasses = new ArrayList<>();
        
        for (Row row : sheet) {
            String testClass = row.getCell(0).getStringCellValue();
            testClasses.add(testClass);
        }
        
        workbook.close();
        fis.close();
        
        return testClasses;
    }
}
