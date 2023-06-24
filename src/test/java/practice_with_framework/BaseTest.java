package practice_with_framework;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

	WebDriver driver;

	@BeforeSuite
	public void openapp() {
		Reporter.log("------open the browser-------", true);
//		ChromeOptions chrome = new ChromeOptions();
//		chrome.addArguments("--remote-allow-origins=*");
//		driver = new ChromeDriver(chrome);
		
		ChromeOptions chrome = new ChromeOptions();
		chrome.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(chrome);
		
		driver.get("https://student1.aksharatraining.in/pos/public/#");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterSuite
	public void closeapp() {
		Reporter.log("------Close the browser-------", true);
		driver.quit();
	}
}
