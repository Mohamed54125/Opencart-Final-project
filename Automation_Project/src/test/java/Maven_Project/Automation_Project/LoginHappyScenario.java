package Maven_Project.Automation_Project;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;

public class LoginHappyScenario extends TestBase{
	HomePage homeObject = new HomePage(driver);
	LoginPage loginObject = new LoginPage(driver);
	RegisterPage registerObject = new RegisterPage(driver);
	
	@Test (priority = 1)
	public void testLogin_CorrectEmailAndPassword() throws InterruptedException {
		Assert.assertEquals("rgba(255, 165, 0, 1)", homeObject.homeLink.getCssValue("color"));
		homeObject.OpenLoginPage();
		
		Assert.assertEquals("Login to your account", loginObject.loginMessage.getText());
		
		loginObject.userCanLogin("khaled9102001@gmail.com", "123456789");

		Assert.assertEquals("Logout",loginObject.logoutBtn.getText());
		
		registerObject.deleteAccount();
		Assert.assertTrue(registerObject.deleteMessage.getText().equalsIgnoreCase("Account Deleted!"));///third way
	}
}
