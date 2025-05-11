package Maven_Project.Automation_Project;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class ProductDetailPage_Test extends TestBase{
	
	  
	  @Test
	  public void fprodectDetailsTest() throws InterruptedException {
		  
		  String expectedTitle = "Automation Exercise";
	      Assert.assertTrue(driver.getTitle().contains(expectedTitle), "Home page title is incorrect");
	      Thread.sleep(3000);
	      
	      WebElement productsBtn = driver.findElement(By.xpath("//a[@href='/products']"));
	      productsBtn.click();

	   
	      WebElement productsHeader = driver.findElement(By.xpath("//h2[text()='All Products']"));	      
	      Assert.assertTrue(productsHeader.isDisplayed(), "All Products page is not displayed");

	      
	      WebElement productList = driver.findElement(By.xpath("//div[@class='features_items']"));
	      Assert.assertTrue(productList.isDisplayed(), "Product list is not visible");
	      
	      List<WebElement> products = driver.findElements(By.cssSelector(".features_items .product-image-wrapper"));
	      Assert.assertTrue(products.size() > 0, "No products found on the page");
	      Thread.sleep(2000); 	      
	      
	      WebElement firstViewProduct = products.get(0).findElement(By.xpath(".//a[contains(text(),'View Product')]"));
	      firstViewProduct.click();
	      Thread.sleep(3000);
	      
	      WebElement detailSection = driver.findElement(By.cssSelector(".product-information"));
	      Assert.assertTrue(detailSection.isDisplayed(), "Product detail section is not displayed");

	        
	      WebElement name = driver.findElement(By.xpath("//div[@class='product-information']/h2"));
	      WebElement category = driver.findElement(By.xpath("//div[@class='product-information']/p[1]"));
	      WebElement price = driver.findElement(By.xpath("//div[@class='product-information']/span/span"));
	      WebElement availability = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[2]"));
	      WebElement condition = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[3]"));
	      WebElement brand = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[4]"));

	      
	      Assert.assertTrue(name.isDisplayed(), "Product name is not visible");
	      Assert.assertTrue(category.isDisplayed(), "Category is not visible");
	      Assert.assertTrue(price.isDisplayed(), "Price is not visible");
	      Assert.assertTrue(availability.isDisplayed(), "Availability is not visible");
	      Assert.assertTrue(condition.isDisplayed(), "Condition is not visible");
	      Assert.assertTrue(brand.isDisplayed(), "Brand is not visible");
	  }
	  
	

}
