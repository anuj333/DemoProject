package abc;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Takescreenshot {

	
	@Test
	public void screenshot() throws IOException {
		
		System.out.println(System.getProperty("user.dir"));
		 
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromedriver");
		 
				WebDriver driver=new ChromeDriver();
		 
				driver.get("http://www.facebook.com");
				
				TakesScreenshot	 ts=(TakesScreenshot)driver;
			    File source=ts.getScreenshotAs(OutputType.FILE);
			    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			    
			   //HH:mm:ss
			    Date date = new Date();
			   
			    String date1= dateFormat.format(date);
			
				String path = System.getProperty("user.dir")+"/Screenshot/"+"TC_01"+"_"+date1.replace(":", "_").replace(",", "_").replace("/","_")+".png";
		    	System.out.println(path);
				File destination=new File(path);
				
				FileUtils.copyFile(source, destination);
				driver.close();
	}
	
	
}
