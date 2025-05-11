package Maven_Project.Automation_Project;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.RegisterPage;

public class RegisterNegativeScenario extends TestBase{
	HomePage homeObject = new HomePage(driver);
	RegisterPage registerObject = new RegisterPage(driver);
	
  @Test (priority = 2)
  public void Register_ExistEmail() throws InterruptedException {
	  Assert.assertEquals("rgba(255, 165, 0, 1)", homeObject.homeLink.getCssValue("color"));
	  
	  homeObject.OpenRegisterationPage();
	  
	  Assert.assertEquals("New User Signup!", registerObject.newUserMessage.getText());
	  
	  
	  String name ="Sara Abdullwhab";

	  registerObject.userCanRegister(name,"sara1122@gmail.com");
	  
	  Assert.assertEquals("Email Address already exist!", registerObject.failedMessage.getText());
  }
}
