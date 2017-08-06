package mPackage.CucumberDef;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.openqa.selenium.support.PageFactory;
import myPackage.PageFactory.HomePage;
import myPackage.Util.TestBase;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/cucumber/HomePage.feature"},
//		dryRun = true,
plugin = {"pretty", "html:target/cucumber-html"}
)

public class RunCukesTest{
	
//	@Test
//	public void testPageObject() throws Exception {
//	homePage = PageFactory.initElements(driver, HomePage.class);
//	driver.get(baseUrl);
//	chapterSecond = homePage.clickChapterSecond();
//	chapterSecond.clickbut2();
//	chapterSecond.clickRandom();
//	String data = chapterSecond.getTest();
//	homePage = chapterSecond.clickIndex();
//	chapterFirstPage = homePage.clickChapterFirst();
//	chapterFirstPage.clickSecondAjaxButton();
//	chapterFirstPage.clickSecondAjaxButton1(data);
//	chapterFirstPage.selectDropDown("Selenium Core");
//	chapterFirstPage.verifyButton();
//	}
}
