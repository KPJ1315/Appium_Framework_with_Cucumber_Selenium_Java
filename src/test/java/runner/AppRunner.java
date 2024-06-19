package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions( features = {"/AppiumAutomation/src/test/resources/Features/Sample.feature"},
monochrome = true,
glue = {"steps"},
tags = "@run")
public class AppRunner {

}
