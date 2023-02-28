package Test123;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import POM_Classes.NewAccCreation;
import POM_Classes.SignUPPage;
import Utils.Utility;

public class Facebook {

	public static void main(String[] args) throws IOException {
		
	System.out.println("hallo");
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver.exe3");	
	WebDriver driver = new ChromeDriver();
	driver.get("https:www.facebook.com");
	driver.manage().timeouts().implicitlyWait(8,TimeUnit.SECONDS);
  //  driver.manage().window().maximize();
    
	SignUPPage signUPPage = new SignUPPage(driver);
	signUPPage.clickoncreateNewAcc();
	
	NewAccCreation newAccCreation= new NewAccCreation(driver);
	String data=Utility.getDataFromexcelSheet("vinod", 1, 2);
	newAccCreation.sendfName(data);
	newAccCreation.sendlName("bhumkar");
	newAccCreation.sendmobNo("7350627418");
	newAccCreation.sendpass();
	newAccCreation.selectDay();
	newAccCreation.selectMonth();
	newAccCreation.selectYear();
	newAccCreation.clickOnMale();
	
	
	}
}
