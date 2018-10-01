package abc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLReader extends Generics{
	
	
	public String filepath;
	String FileExtension = null;
	FileInputStream fis =null;
	Workbook workbook = null;
	Sheet sheet= null;
	Row row=null;
	Cell cell=null;
	
	public XLReader(String filepath) throws IOException {
		
		this.filepath = filepath;
		
		FileExtension = filepath.substring(filepath.indexOf(".x"));
		System.out.println(FileExtension);
		File file =    new File(filepath);
		fis = new FileInputStream(file);
		
		try {
			
			if(FileExtension.equals(".xlsx")) {
				
				workbook = new XSSFWorkbook(fis);
				System.out.println("xssf");
			}
        else if(FileExtension.equals(".xls")){
				
				workbook = new HSSFWorkbook(fis);
				System.out.println("hssf");
        }
			
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		finally {
			fis.close();			
		}
		
		
	}
	
	public int getrownumber(String sheetname,String testcase) {
		int rownumber =0;
		int sheetindex= workbook.getSheetIndex(sheetname);
		if (sheetindex==-1) {
			System.out.println(sheetindex);
			return 0;
		}
		sheet = workbook.getSheetAt(sheetindex);
		int rowcount = sheet.getLastRowNum();
		System.out.println(rowcount);
		
		for (int i =0;i<=rowcount; i++) {
			String requiredrow =sheet.getRow(i).getCell(0).getStringCellValue();
			if(requiredrow.equals(testcase)) {
				 rownumber= i;
				break;
				
			}
			System.out.println(rownumber);
		}
		
		return rownumber;
		
	}
	
	public HashMap<String, String> getcelldata(String sheetname,int rownumber) {
		HashMap<String,String>data=new HashMap<>();
		int sheetindex =workbook.getSheetIndex(sheetname);
		System.out.println("new");
		//sheet = workbook.getSheetAt(sheetindex);
		sheet = workbook.getSheetAt(sheetindex);
		System.out.println("latest");
		row = sheet.getRow(0);
		for (int i=0;i<row.getLastCellNum(); i++) {
			String header = sheet.getRow(0).getCell(i).getStringCellValue();
			String values = sheet.getRow(rownumber).getCell(i).getStringCellValue();
			data.put(header, values);
			
		}
		return data;
		
		
	}
	
	
	
	

}
