package org.practice;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelSheet {
	
	public static void main(String[] args) throws Throwable {
		
		//Read file using File Input Stream
		InputStream fis = new FileInputStream("./data/TestData.xlsx");
		
		//Create Workbook
		 Workbook workbook = WorkbookFactory.create(fis);
		 
	    //Load the sheet
		 Sheet sheet = workbook.getSheet("demo");
		 
		//Navigate to row
		 Row row = sheet.getRow(1);
		 
	    //Navigate to cell
		 Cell cell = row.getCell(2);
		 
		//read the value inside the cell
		 System.out.println(cell.getStringCellValue());
		
	}

}
