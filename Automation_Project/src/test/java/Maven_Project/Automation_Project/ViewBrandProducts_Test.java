package Maven_Project.Automation_Project;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ViewBrandProducts_Test extends TestBase{
	

  @Test
  public void brandProdectsTest() throws InterruptedException {
	  
	  
	  
	  WebElement productsBtn = driver.findElement(By.xpath("//a[@href='/products']"));
      productsBtn.click();

      WebElement brandsSection = driver.findElement(By.xpath("//h2[text()='Brands']"));
      Assert.assertTrue(brandsSection.isDisplayed(), "Brands section is not visible");

      
      List<WebElement> brandLinks = driver.findElements(By.xpath("//div[@class='brands-name']/ul/li/a"));

      
      WebElement firstBrand = brandLinks.get(0);
      String firstBrandName = firstBrand.getText();
      firstBrand.click();
      
      
      WebElement firstBrandHeader = driver.findElement(By.xpath("/html/body/section/div/div[2]/div[2]/div/h2"));
      Assert.assertTrue(firstBrandHeader.isDisplayed(), "Failed to navigate to " + firstBrandName + " brand page");

      Thread.sleep(3000);
      
      brandsSection = driver.findElement(By.xpath("//h2[text()='Brands']"));
      Assert.assertTrue(brandsSection.isDisplayed(), "Brands section is not visible");

      
      brandLinks = driver.findElements(By.xpath("//div[@class='brands-name']/ul/li/a"));

      WebElement secondBrand = brandLinks.get(1);
      String secondBrandName = secondBrand.getText();
      secondBrand.click();

      
      
      WebElement secondBrandHeader = driver.findElement(By.xpath("/html/body/section/div/div[2]/div[2]/div/h2"));
      Assert.assertTrue(secondBrandHeader.isDisplayed(), "Failed to navigate to " + secondBrandName + " brand page");

      Thread.sleep(3000);
  }
 

}
