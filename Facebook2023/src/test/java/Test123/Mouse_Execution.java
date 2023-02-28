package Test123;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Mouse_Actions.Home_Amazon;
import Mouse_Actions.Language_page;

public class Mouse_Execution { 

public static void main(String[] args) {
	
	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver.exe3");
	  WebDriver driver=new ChromeDriver();// object to call get method  
		
	  driver.get("https://www.amazon.com");//
		driver.manage().timeouts().implicitlyWait(8,TimeUnit.SECONDS);

	Home_Amazon home_Amazon =new Home_Amazon(driver);
	home_Amazon.clickonlang();
	
	Language_page language_page =new Language_page(driver);
	language_page.clickonchange();
	
	
	
	
	
	
    }
}
