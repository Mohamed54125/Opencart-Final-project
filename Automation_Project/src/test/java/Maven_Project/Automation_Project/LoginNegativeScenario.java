package Maven_Project.Automation_Project;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

public class LoginNegativeScenario extends TestBase{
	HomePage homeObject = new HomePage(driver);
	LoginPage loginObject = new LoginPage(driver);
	
	@Test (priority = 2)
	public void testLogin_InCorrectEmail() throws InterruptedException {
		Assert.assertEquals("rgba(255, 165, 0, 1)", homeObject.homeLink.getCssValue("color"));
		homeObject.OpenLoginPage();
		
		Assert.assertEquals("Login to your account", loginObject.loginMessage.getText());
		
		loginObject.userCanLogin("Khaled111111@gmail.com", "123456789");

		Assert.assertEquals("Your email or password is incorrect!", loginObject.failedMessage.getText());

	}
	
	@Test (priority = 3)
	public void testLogin_CorrectEmailAndInCorrectPassword() throws InterruptedException {
		homeObject.OpenLoginPage();
		
		Assert.assertEquals("Login to your account", loginObject.loginMessage.getText());
		
		loginObject.userCanLogin("khaled9102002@gmail.com", "1234567");

		Assert.assertEquals("Your email or password is incorrect!", loginObject.failedMessage.getText());

	}
}

