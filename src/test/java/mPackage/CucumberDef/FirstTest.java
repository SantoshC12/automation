package mPackage.CucumberDef;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/cucumber/HomePage.feature"},
//		dryRun = true,
plugin = {"pretty", "html:target/cucumber-html"}
)

public class FirstTest{

}
