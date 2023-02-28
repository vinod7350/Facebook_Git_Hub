package POM_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewAccCreation {
        // variable
	
	  @FindBy (xpath ="//input[@name='firstname']") 
	  private WebElement fName ;
	
	  @FindBy (xpath ="//input[@name='lastname']") 
	  private WebElement lName ;
	
	  @FindBy (xpath ="//input[@name='reg_email__']") 
	  private WebElement mobNo ;
	
	  @FindBy (xpath ="//input[@id='password_step_input']") 
	  private WebElement pass ;
	
	  @FindBy (xpath ="//select[@id='day']") 
	  private WebElement day ;
	
	  @FindBy (xpath ="//select[@aria-label='Month']") 
	  private WebElement month ;
	
	  @FindBy (xpath ="//select[@id='year']") 
	  private WebElement year ;
	
	  @FindBy (xpath ="(//input[@class='_8esa'])[2]") 
	  private WebElement male ;
	  
	  private WebDriver driver;
	  private WebDriverWait wait;
	  
	  // constructor
	  
	  public NewAccCreation(WebDriver driver) {
		  PageFactory.initElements(driver, this);
		  this.driver= driver;
		  wait = new WebDriverWait(driver,10);  //10 Sec 
	  }
	  
	  // method
	  // explicit Wait are apply
	 
	  public void sendfName(String Fname) {
	//	  WebDriverWait wait = new WebDriverWait(driver,10);  // using global
		  wait.until(ExpectedConditions.visibilityOf(fName));
		  
		  fName.sendKeys(Fname);
	  }
	  public void sendlName(String Fname) {
		  WebDriverWait wait = new WebDriverWait(driver,20); //using local variable
		 // wait.until(ExpectedConditions.visibilityOf(lName));
		  wait.until(ExpectedConditions.visibilityOf(fName));
		  lName.sendKeys( Fname);
	  }
	  public void sendmobNo(String MobNo) {
		  WebDriverWait wait = new WebDriverWait(driver,20); //using local variable
		  wait.until(ExpectedConditions.visibilityOf(mobNo));
		  mobNo.sendKeys( MobNo);
	  }
	  public void sendpass() {
		  pass.sendKeys("Vinod@123");
	  }
	  public void selectDay() {
		 Select s =new Select(day);
		 s.selectByVisibleText("23");
	  }
	  public void selectMonth() {
	    Select s =new Select(month);
		s.selectByVisibleText("Feb");
	  }
	  public void selectYear() {
		Select s =new Select(year);
        s.selectByVisibleText("1998");
	  }
	  public void clickOnMale() {
		  male.click();
	  }
	
}
