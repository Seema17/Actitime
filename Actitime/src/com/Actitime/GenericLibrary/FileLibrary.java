package com.Actitime.GenericLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * this class is a generic class which contain non static to read data from property and excel file
 * @author DELL
 */

public class FileLibrary {
	/**
	 * this method id is a non static method used to read data from property file.
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromProperty(String key) throws IOException {
		FileInputStream fis=new FileInputStream("./Testdata/commondata.property");
		Properties p=new Properties();
		p.load(fis);
		 String value = p.getProperty(key);
		 return value;
	}
	public String readDataFromExcel(String sheet, int row, int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./Testdata/commondata.property");
		Workbook wb = WorkbookFactory.create(fis);
		 String value = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		 return value;
	}
	public String readDataFromExcelSheet(String sheet, int row, int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("./TestData/bankinginfo.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		return value;

}
}
