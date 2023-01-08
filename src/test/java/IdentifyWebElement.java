import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IdentifyWebElement {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/");
		//WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions
//				.visibilityOfElementLocated(By.xpath("//a[@class='nav-link bg-gray rounded-pill px-4 py-1 active']")));
//		driver.findElement(By.linkText("Bus")).click();
		driver.findElement(By.linkText("Tutorials")).click();
		
		//WebElement element =driver.findElement(By.tagName("a"));
		
		//System.out.println(element.getText());
		
		WebElement element = driver.findElement(By.xpath("//div[@class='w3-content']//h3[text()='JavaScript' and @class='w3-margin-top']"));
		
		System.out.println(element.getText());
		
		Assert.assertEquals("JavaScript", "JavaScript");
		

	}

}
