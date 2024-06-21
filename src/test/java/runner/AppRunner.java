package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions( features = {"src/test/resources/Features/Sample.feature"}, ///AppiumAutomation/src/test/resources/Features/Sample.feature
plugin = {
		"pretty" ,        
        "json:target/cucumber.json",
        "html:target/cucumber-reports/Cucumber.html"
    },
monochrome = true,
glue = {"stepDef"},
tags = "@run")
public class AppRunner {

}
/* /AppiumAutomation/src/test/resources/Features/Sample.feature  */