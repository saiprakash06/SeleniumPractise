import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {

	public static void main(String[] args) throws IOException {

		// Initiating Chrome driver
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.abhibus.com/");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//a[@class='nav-link bg-gray rounded-pill px-4 py-1 active']")));
		List<WebElement> list = new ArrayList<WebElement>();
		list = driver.findElements(By.tagName("a"));
		for (WebElement link : list) {

			try {
				String singleurl = link.getAttribute("href");
				URL url = new URL(singleurl);
				HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
				httpURLConnect.setConnectTimeout(5000);
				httpURLConnect.connect();
				if (httpURLConnect.getResponseCode() >= 400) {
					System.out.println(singleurl + " - " + httpURLConnect.getResponseMessage() + "is a broken link");
				}
				// Fetching and Printing the response code obtained
				else {
					System.out.println(singleurl + " - " + httpURLConnect.getResponseMessage());
				}

			} catch (Exception e) {

			}
			
			

		}

	}

}
