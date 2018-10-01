package abc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Generics {
	static WebDriver driver=null;
	static  ExtentReports reports =null;
	static ExtentTest test = null;
	static Properties pro =null;
	
	public Generics() {
		pro=new Properties();
		try {
			FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"/src/abc/Credentials.properties");
			pro.load(objfile);
			
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/abc/HomePage.properties");
			pro.load(fis);
			
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
  public static WebElement getelement(String locatorkey) {
		WebElement ele = null;
		if (locatorkey.endsWith("_ID")) {
			 ele= driver.findElement(By.id(pro.getProperty(locatorkey)));
		}
		else if(locatorkey.endsWith("_xpath")){
			ele=driver.findElement(By.xpath(pro.getProperty(locatorkey)));
		}
		return ele;
		 
	}
	
  public static void input(String locatorkey,String value) {
		getelement(locatorkey).sendKeys(value);
	}
	
  public static HashMap<String,String> getdata(String filepath,String sheetname,String testcase) throws IOException{
	test.log(LogStatus.INFO, "Excel sheet read");
	XLReader obj = new XLReader(filepath);
	int rownum =obj.getrownumber(sheetname,testcase);
	HashMap<String,String>testdata = obj.getcelldata(sheetname, rownum);
	
	return testdata;
	}
    
    
  public static void clicktoelement(String locatorkey) {
	getelement(locatorkey).click();
	
}
  
  
  public static void input(WebElement locatorkey,String value) {
	locatorkey.sendKeys(value);
	
}
  
  public static void switchtoframe(String locatorkey) {
	  driver.switchTo().frame(pro.getProperty(locatorkey));
	  //driver.switchTo().frame(getelement(locatorkey));
  }
  

  public static void open_browser(String url,String driverName) {
	
	//System.out.println(System.getProperty("user.dir"));
	if(driverName.equalsIgnoreCase("chromedriver")) {
	 
	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromedriver");
	 
			 driver=new ChromeDriver();
			 driver.manage().deleteAllCookies();
			driver.get(url);
	}
	else {
		
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromedriver");
		 
		 driver=new ChromeDriver();
		 driver.manage().deleteAllCookies();
         driver.get(url);
	}
}
	
	
	
	
}
