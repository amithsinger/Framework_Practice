package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalesPage {

	@FindBy(xpath = "//a[.='Sales']")
	private WebElement salesBT;

	public SalesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickonSales() {
		salesBT.click();
	}
}
