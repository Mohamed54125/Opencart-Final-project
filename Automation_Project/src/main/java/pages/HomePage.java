package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(linkText = "Signup / Login")
	WebElement signUpLoginBtn;
	
	@FindBy(linkText = "Home")
	public WebElement homeLink;
	
	@FindBy(linkText = "Contact us")
	WebElement contactUsBtn;
	
	public void OpenRegisterationPage() {
		signUpLoginBtn.click();
	}
	
	public void OpenLoginPage() {
		signUpLoginBtn.click();
	}
	
	public void openContactUsPage() {
		contactUsBtn.click();
	}

}
