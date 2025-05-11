package Maven_Project.Automation_Project;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

public class Logout extends TestBase{
	HomePage homeObject = new HomePage(driver);
	LoginPage loginObject = new LoginPage(driver);
	
	@Test (priority = 1)
	public void testLogout() throws InterruptedException {
		Assert.assertEquals("rgba(255, 165, 0, 1)", homeObject.homeLink.getCssValue("color"));
		homeObject.OpenLoginPage();
		
		Assert.assertEquals("Login to your account", loginObject.loginMessage.getText());
		
		loginObject.userCanLogin("khaled9102002@gmail.com", "123456789");

		Assert.assertEquals("Logout",loginObject.logoutBtn.getText());
		
		loginObject.userCanLogout();
		Assert.assertEquals("Login to your account", loginObject.loginMessage.getText());
	}
}
