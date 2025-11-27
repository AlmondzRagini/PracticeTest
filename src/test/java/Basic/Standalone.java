package Basic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Standalone {
	public WebDriver driver;
	@Test()
	public void urlLaunch() throws InterruptedException {
		 driver = new ChromeDriver();
		driver.get("https://demoqa.com/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	//	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
		Thread.sleep(3000);
	//	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[text()='New User']"))));
		//driver.findElement(By.cssSelector("#newUser")).click();
		driver.findElement(By.cssSelector("div.element-group:nth-child(1)")).click();

}
}
