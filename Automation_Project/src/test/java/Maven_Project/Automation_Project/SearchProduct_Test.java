package Maven_Project.Automation_Project;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class SearchProduct_Test extends TestBase{
	
	  
	  @Test
	  public void testBrwoserNavigations() throws InterruptedException {
		  
		 String expectedTitle = "Automation Exercise";
	     String actualTitle = driver.getTitle();
	     Assert.assertTrue(actualTitle.contains(expectedTitle), "Home page is not loaded properly");
 		 Thread.sleep(2000); 
		  
		 WebElement productsBtn = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a"));
		 productsBtn.click();
		 
	 
		 WebElement productsHeader = driver.findElement(By.xpath("//h2[text()='All Products']"));
	     Assert.assertTrue(productsHeader.isDisplayed(), "All Products page header is not visible");
		 
		 
		 WebElement searchTxt = driver.findElement(By.id("search_product"));
		 searchTxt.sendKeys("POLO");
		 Thread.sleep(3000);
		 WebElement searchBtn = driver.findElement(By.xpath("//*[@id=\"submit_search\"]"));
	     searchBtn.click();
		 
	
	     List<WebElement> productList = driver.findElements(By.xpath("//div[@class='productinfo text-center']/p"));
	     Assert.assertTrue(productList.size() > 0, "No searched products found");

	     for (WebElement product : productList) {
	         String productName = product.getText().toLowerCase();
	         Assert.assertTrue(productName.contains("polo"), "Product doesn't match search query: " + productName);
	     }
		 
	     
	     
	     Thread.sleep(3000);
				 
		 driver.navigate().refresh();		 
		 driver.navigate().back();
		 
		 searchTxt = driver.findElement(By.id("search_product"));
		 
		 searchTxt.clear();
		 searchTxt.sendKeys("JEANS");
		 Thread.sleep(3000);
		 
		 searchBtn = driver.findElement(By.xpath("//*[@id=\"submit_search\"]"));
	     searchBtn.click();
		 
	     
	     productList = driver.findElements(By.xpath("//div[@class='productinfo text-center']/p"));
	     Assert.assertTrue(productList.size() > 0, "No searched products found");

	     for (WebElement product : productList) {
	         String productName = product.getText().toLowerCase();
	         Assert.assertTrue(productName.contains("jeans"), "Product doesn't match search query: " + productName);
	     }
	     Thread.sleep(3000);
	
	  }
	  


}
