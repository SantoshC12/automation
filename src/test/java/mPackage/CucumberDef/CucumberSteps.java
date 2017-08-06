package mPackage.CucumberDef;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import myPackage.Core.DriverMgr;

public class CucumberSteps {

	protected WebDriver driver;
	protected WebDriver dummyDriver;
	DriverMgr driverMgr = null;
	
	@Before
	public void setUp(){
		driverMgr = new DriverMgr();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Given("^I launch the \"([^\"]*)\"$")
	public void i_launch_the(String app) throws Throwable {
		driverMgr.createDriver(app, app);
		driverMgr.populateCurrentDriver(app);
		driver = driverMgr.getCurrentDriver();
	}
	
	
	@After
	public void takeScreenShot(Scenario scenario){
		if(scenario.isFailed()){
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
			}
		driverMgr.closeAllActiveDriver();
		}

}
