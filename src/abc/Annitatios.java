package abc;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annitatios extends Generics{
	@BeforeMethod
	public void beforemethod() {
		
		System.out.println("before method");
	}
	@BeforeTest
	public void beforetest() {
		//System.out.println(System.getProperty("user.dir")+"/src/abc/Credentials.properties");
		System.out.println(pro.getProperty("searchBttn_xpath"));
		getelement("searchBttn_xpath");
	}
	
	@Test
	public void test() {
		
		System.out.println("testpass");
	}
	
	@Test
	public void test1() {
		
		System.out.println("test1 pass");
	}
	
	
	@AfterMethod
	public void aftermethod() {
		
		System.out.println("after method");
	}@AfterTest
	public void aftertest() {
		
		System.out.println("after test");
	}
	
	
	

}
