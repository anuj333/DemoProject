package abc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelReader{
	
	
	@Test
	public void getdata() throws IOException {
	
	File fs = new File("/Users/anujkumarsingh/Desktop/ExcelData.xlsx");
	
	FileInputStream fis = new FileInputStream(fs);
	
	XSSFWorkbook w = new XSSFWorkbook(fis);
	
	XSSFSheet sh = w.getSheet("testdata");
	
	String s = sh.getRow(0).getCell(0).getStringCellValue();
	
	System.out.println(s);
	w.close();
}

}