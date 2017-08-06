package myPackage.PageFactory;

import java.time.LocalDate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	protected WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getCurrentWindowHandle(){
		return driver.getWindowHandle();
	}

	public LocalDate getSysDate(){
		LocalDate today = LocalDate.now();
		return today;
	}
}
