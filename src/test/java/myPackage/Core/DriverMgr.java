package myPackage.Core;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import myPackage.Config.PropRdr;

public class DriverMgr {

private Map<String, WebDriver> driverMap = new HashMap<String, WebDriver>();
private WebDriver currentDriver;



	public void createDriver(String driverKey, String appUrl) throws MalformedURLException, URISyntaxException {
		if(driverMap.containsKey(driverKey)){
			WebDriver driver = null;
			driver = driverMap.get(driverKey);
			if(driver!=null){
				driver.close();
				driver.quit();
			}
		}
		WebDriver driver = BrowserMgr.createDriver(appUrl);
		driverMap.put(driverKey, driver);
	}
	
	public void removeDriver(String driverKey){
		driverMap.remove(driverKey);
	}
	
	public void populateCurrentDriver(String driverKey){
		currentDriver = driverMap.get(driverKey);
	}

	public WebDriver getCurrentDriver() {
		return currentDriver;
	}

	public void setCurrentDriver(WebDriver currentDriver) {
		this.currentDriver = currentDriver;
	}

	public void closeAllActiveDriver() {
		if(driverMap!=null){
			for(WebDriver driver : driverMap.values()){
				if(driver!=null){
					driver.close();
					driver.quit();
				}
			}
		}
		
	}


}
