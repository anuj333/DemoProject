package abc;

import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class Testing extends Generics{
	
	@Test
	public void method1() throws IOException {
		
		 reports=new ExtentReports(System.getProperty("user.dir")+"/Report/TC_01.html");
		//reports = new ExtentReports(System.getProperty("user.dir")+"/Report/TC_01.html");
		test=reports.startTest("TC_01","excel test start");
		test.log(LogStatus.INFO, "Excel sheet read");
		System.out.println(System.getProperty("user.dir")+"/Data/ExcelData.xlsx");
		HashMap<String,String>data =getdata(System.getProperty("user.dir")+"/Data/ExcelData.xls","testdata","TC_01");
		System.out.println(data);
		
	}
	@AfterMethod
	public void endtest() {
		test.log(LogStatus.PASS, "Test Case TC_01 is passed");
		reports.endTest(test);
		reports.flush();
		driver.close();
	}
	

}
