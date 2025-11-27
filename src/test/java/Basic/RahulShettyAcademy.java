package Basic;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RahulShettyAcademy {
	WebDriver driver;
	@Test
	public void url() throws InterruptedException {
		String products="ZARA COAT 3";
		driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.cssSelector("input#userEmail")).sendKeys("raghu01@gmail.com");
		driver.findElement(By.cssSelector("input#userPassword")).sendKeys("Raghu@123");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		
	List<WebElement>prod= driver.findElements(By.cssSelector(".card-body"));
	for(int i=0;i<prod.size();i++) {
		String prodname=prod.get(i).findElement(By.cssSelector("b")).getText();
		if(prodname.equals(products))
		{
			prod.get(i).findElement(By.xpath("//button[text()=' Add To Cart']")).click();
			
		
		break;
		}
		
		//System.out.println(prodname);
	}
		//[routerlink*='cart']
		Thread.sleep(3000);
	
	driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
	driver.findElement(By.xpath("//button[text()='Buy Now']")).click();
	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(7));
	//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@value='4542 9931 9292 2299']")))).sendKeys("4542 9931 9292 2293");
	
	/*WebElement month =driver.findElement(By.xpath("//Select[@class='input ddl'][1]"));
	Select selectmonth= new Select(month);
	selectmonth.selectByValue("11");
	
	WebElement days=driver.findElement(By.xpath("[@class='input ddl'][2]"));
	Select selectmonths= new Select(days);
	selectmonths.selectByIndex(5);*/
	
	/*Actions action = new Actions(driver);
	action.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")), "india").build().perform();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
	driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
	*/
	

    // Wait until checkout page loads and country input is visible
    WebElement countryBox = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.cssSelector("input[placeholder='Select Country']")
    ));
    countryBox.sendKeys("Ind");

    // Wait for results to appear
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));

    // Scroll to make sure dropdown is visible
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", countryBox);

    // Find all country items
   List<WebElement> countries = driver.findElements(By.cssSelector(".ta-item"));
    for (WebElement country : countries) {
        String text = country.getText();
        if (text.equalsIgnoreCase("India")) {
            // Wait until it's clickable, then click
            wait.until(ExpectedConditions.elementToBeClickable(country));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", country);
            break;
        }
    }

    // Click Place Order
    WebElement placeOrder = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//a[@class='btnn action__submit ng-star-inserted']") // the red PLACE ORDER button
    ));
    Thread.sleep(1000);
    placeOrder.click();

   String headingName =driver.findElement(By.cssSelector(".hero-primary")).getText();
   System.out.println(headingName);
  // Assert.assertEquals(headingName.trim(), "Thankyou for the order");
	

	
	
	
	
	
    Thread.sleep(5000);
		driver.quit();
		
	}

}

