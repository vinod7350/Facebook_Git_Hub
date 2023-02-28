package POM_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Intro_Of_POM {
	

	// variable : WebElement : Login Or Sign Up Page
	
	@FindBy (xpath = "xpath xpression") 
	private WebElement emailOrPhoneNo ;
	
	@FindBy (xpath = "xpath xpression") 
	private WebElement password ;
	
	@FindBy (xpath = "xpath xpression") 
	private WebElement loginButton ;
	
	// Constructor : Initialization of WebElement : Login Or Sign Up Page
	
	public  Intro_Of_POM(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	// Methods : Action on WebElements : Login Or Sign Up Page 
	public void emailOrPhoneNo() {
		emailOrPhoneNo.sendKeys("7350627418");
	}
	
	public void password() {
		password.sendKeys("Vinod@123");
	}
	public void loginButton() {
		loginButton.click();
	}
}
