package TestNG;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNG_Intro {
	WebDriver driver;
	
	@BeforeClass
	public void beforeclass() {
		System.out.println("Before Class");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("BeforeMethod");
	}
	
	@Test
	public void scDemo () throws IOException, InterruptedException {
		System.out.println("test");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver.exe3");
		 
		 driver =new ChromeDriver();
		
		driver.get("https:www.youtube.com");
		Thread.sleep(2000);
		
	String url=	driver.getCurrentUrl();
	String title=	driver.getTitle();
	
	System.out.println(url);
	System.out.println("==========");
	System.out.println(title);

//		SoftAssert soft = new SoftAssert();
//		
//		String actual = "Actual Result";
//		String expected = "Actual Result";
//		
//		soft.assertEquals(actual, expected ,"Result of soft assert");
//	    soft.assertAll();
	//	Assert.assertEquals(actual, expected);
		
	
	}
	
	
	@AfterMethod
	public void aftermethod() throws IOException {
		System.out.println("after method");
		
		
	}
	
	@AfterClass
	public void afterclass() {
		System.out.println("after class");
	}
	
	
	// It's Most Big Advantage is the , TEstNG not need Mian method to ecxecute the programm .
	// i.e Without main method are you execute any thing .
	// it contains non-static method 
	// to call non-static method do not need object 
	//of class and main method
	// at execution sequence of method are same 
	// while you change sequence then out put 
	//will be the in same sequence
	//BeforeClass
	//BeforeMethod
    //Test
	//AfterMethod
	//AfterClass

	
	
	
	
	
	
	
	
	
	
	
}
