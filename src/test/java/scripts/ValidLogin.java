package scripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import gerics.BaseTest;
import gerics.Excel;
import pages.LoginPage;
import pages.SalesPage;

public class ValidLogin extends BaseTest {
	WebDriver driver;
	@Test(priority = 0)
	public void testlogin() {
		try {
			String un = Excel.getdata("./data/pos.xlsx", "validlogin", 1, 0);
			String pw = Excel.getdata("./data/pos.xlsx", "validlogin", 1, 1);

			LoginPage lp = new LoginPage(driver);
			lp.setUserName(un);
			lp.setPassword(pw);
			lp.loginButton();

			System.out.println("----Login Successfully--------");

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Test(priority = 1)
	public void salesTest() {
		try {
			SalesPage sp = new SalesPage(driver);
			sp.clickonSales();

			WebElement fe1 = driver.findElement(By.xpath("//input[@id='customer']"));
			fe1.click();
			Thread.sleep(1000);
			fe1.sendKeys("s");

			List<WebElement> list1 = driver.findElements(By.xpath("//div[@class='ui-menu-item-wrapper']"));
			int count1 = list1.size();
			System.out.println(count1);

			for (int i = 0; i < count1; i++) {
				String text = list1.get(i).getText();
				System.out.println(text);

				if (text.equals("Sushma Kn")) {
					list1.get(i).click();
				}
			}

			System.out.println("---------------------------------------");
			WebElement findElement = driver.findElement(By.xpath("//input[@id='item']"));
			findElement.click();
			Thread.sleep(1000);
			findElement.sendKeys("w");

			Thread.sleep(1000);

			List<WebElement> list = driver.findElements(By.xpath("//div[@class='ui-menu-item-wrapper']"));
			int count = list.size();
			System.out.println(count);

			for (int i = 0; i < count; i++) {
				String text = list.get(i).getText();
				System.out.println(text);

				if (text.equals("Wickets")) {
					list.get(i).click();
				}
			}
			Thread.sleep(3000);
			driver.findElement(By.id("add_payment_button")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("finish_sale_button")).click();
			Thread.sleep(2000);

			JavascriptExecutor jc = (JavascriptExecutor) driver;
			jc.executeScript("window.scrollBy(0,500)");
			Thread.sleep(1500);
			jc.executeScript("window.scrollBy(0,-500)");
			Thread.sleep(1500);

			driver.findElement(By.id("show_sales_button")).click();
			Thread.sleep(1000);

		} catch (Exception e) {

		}
	}

	@Test(priority = 2)
	public void itemTest() {
		try {

			driver.findElement(By.xpath("//a[@title='Items']")).click();
			Thread.sleep(1000);

			driver.findElement(By.xpath("//button[@title='New Item']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='name']")).sendKeys("T-Shirt");
			Thread.sleep(1000);
			driver.findElement(By.id("category")).sendKeys("Sports");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[.='Submit']")).click();

			Thread.sleep(2000);

			JavascriptExecutor jsc = (JavascriptExecutor) driver;
			jsc.executeScript("window.scrollBy(0,500)");
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//input[@name='btSelectItem'])[12]")).click();
			Thread.sleep(2000);
			jsc.executeScript("window.scrollBy(0,-500)");

			driver.findElement(By.id("delete")).click();
			Thread.sleep(2000);
			String text = driver.switchTo().alert().getText();
			System.out.println(text);
			Thread.sleep(2000);
			driver.switchTo().alert().accept();

			Thread.sleep(2000);
			driver.navigate().back();
			Thread.sleep(2000);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
