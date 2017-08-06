package myPackage.Core;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import myPackage.Config.PropRdr;

public class BrowserMgr {

	private static String SELENIUM_HUB_URL;
	private static final String FIREFOX = "Mozilla";
	private static final String IE = "IE";
	
	public static WebDriver createDriver(String appUrl) throws MalformedURLException, URISyntaxException{
		WebDriver driver = null;
		String applicationUrl = "";
		String hubUrl = PropRdr.getHub().getProperty("Selenium_hub").trim();
		String accessKey = PropRdr.getHub().getProperty("ACCESS_KEY").trim();
		String username = PropRdr.getHub().getProperty("USERNAME").trim();
		SELENIUM_HUB_URL = "https://" + username + ":" + accessKey + hubUrl;
//		System.out.println(SELENIUM_HUB_URL);
		String browserName = PropRdr.getConfig().getProperty("BrowserName").trim();
		if(appUrl!=null){
			applicationUrl = PropRdr.getConfig().getProperty("appUrl").trim();
		}
		if(browserName.equalsIgnoreCase(BrowserMgr.IE)){
			DesiredCapabilities caps = DesiredCapabilities.edge();
			caps.setCapability("platform", "Windows 10");
			caps.setCapability("version", "14.14393");
			driver = new RemoteWebDriver(new URL(SELENIUM_HUB_URL), caps);
		}
		else if(browserName.equalsIgnoreCase(BrowserMgr.FIREFOX)){
			DesiredCapabilities caps = DesiredCapabilities.firefox();
			caps.setCapability("platform", "Windows 10");
			caps.setCapability("version", "52.0");
			driver = new RemoteWebDriver(new URL(SELENIUM_HUB_URL), caps);
		}
		driver.get(applicationUrl);
		driver.manage().window().maximize();
		return driver;
		
	}

}
