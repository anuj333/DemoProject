package abc;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CalendarConcept {
	
	
	@Test
	public void calendar() {
	System.out.println(System.getProperty("user.dir"));
	 
	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromedriver");
	
			WebDriver driver=new ChromeDriver();
	 
			driver.get("https://www.jetairways.com/EN/IN/Home.aspx");
			
			WebElement w=driver.findElement(By.id("txtStartDate"));
			String s = "Wednesday 5, September 2018";
			
	JavascriptExecutor js = ((JavascriptExecutor)driver);
	js.executeScript("arguments[0],setAttribute('aria-label','"+s+"');", w);
	
	
	
	
	}
	
	
	
}
