package com.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataReader {

	XSSFWorkbook wb;

	public ExcelDataReader() throws FileNotFoundException {

		File src = new File("C:\\Users\\UD20461958\\OneDrive - Wipro\\TestData.xlsx");

		try {
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);

		} catch (Exception e){
			System.out.println("Unable to read the Xlx File" + e.getMessage());

		}

	}

	public String getStringData(int sheeIndex, int row, int coloumn) {
		return wb.getSheetAt(sheeIndex).getRow(row).getCell(coloumn).getStringCellValue();

	}

	public String getstringData(String sheetName, int row, int coloumn) {
		XSSFCell cell = wb.getSheet(sheetName).getRow(row).getCell(coloumn);
		String stringCellValue = cell.getStringCellValue();
		return stringCellValue;

	}
	

	public double getNumericData(String sheetName, int row, int coloumn) {
		return wb.getSheet(sheetName).getRow(row).getCell(coloumn).getNumericCellValue();

	}

}
