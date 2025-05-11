package Maven_Project.Automation_Project;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.RegisterPage;

public class RegisterHappyScenario extends TestBase{
	HomePage homeObject = new HomePage(driver);
	RegisterPage registerObject = new RegisterPage(driver);
	
  @Test(priority = 1)
  public void Register_NewEmail_MandatoryAndOptional() throws InterruptedException {
	  Assert.assertEquals("rgba(255, 165, 0, 1)", homeObject.homeLink.getCssValue("color"));
	  homeObject.OpenRegisterationPage();
	  
	  Assert.assertEquals("New User Signup!", registerObject.newUserMessage.getText());	  
	  String name ="Sara Abdullwhab";

	  registerObject.userCanRegister(name,"saraabd707@gmail.com");
	  Assert.assertEquals("ENTER ACCOUNT INFORMATION", registerObject.enterAccountMessage.getText());
	  
	  registerObject.enterAccountInformation("123456789",20,"12","2004","Sara","Abdullwhab","ITworx","Sharkia","Sayeda zeinab","United States","California","bbbb","17611","010101033");	  
	  String success = "Account Created!";
	  Assert.assertEquals(success.toUpperCase(), registerObject.successMessage.getText());
	  
	  registerObject.continueAccount();
	  
	  Assert.assertEquals("Logged in as "+name, registerObject.loggedInMessage.getText());
	  registerObject.deleteAccount();
	  Assert.assertTrue(registerObject.deleteMessage.getText().equalsIgnoreCase("Account Deleted!"));
	  registerObject.continueAccount();
  }
}
