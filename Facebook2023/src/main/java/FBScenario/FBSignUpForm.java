package FBScenario;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FBSignUpForm {
@FindBy (xpath="(//a[text()='Terms'])[2]")
private WebElement term;
	
@FindBy (xpath="(//a[text()='Privacy Policy'])[2]")
private WebElement privacyPolicy;

@FindBy (xpath="//a[text()='Cookies Policy']")
private WebElement cookiesPolicy;
	
	public FBSignUpForm(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void clickOnTerm() {
		term.click();
	}
	public void clickOnPrivacyPolicy() {
		privacyPolicy.click();
	}
	public void clickOncookiesPolicy() {
		cookiesPolicy.click();
		
	}
	

}
//(//a[text()='Terms'])[2]
//(//a[text()='Privacy Policy'])[2]
//a[text()='Cookies Policy']

