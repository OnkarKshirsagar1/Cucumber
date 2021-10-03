package StepDefinations;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Feature",glue= {"StepDefinations"},
monochrome =true,  //for step details print in console
//plugin = {"pretty","html:target/reoprts"},
//plugin = {"pretty","json:target/JsonReoprts/report.json"}
//plugin = {"pretty","junit:target/JunitReoprts/report.xml"}
plugin = {"pretty","html:target/HTML/reoprts",
					"json:target/JsonReoprts/report.json",
					"junit:target/JunitReoprts/report.xml"},
tags = "@SmokeTest"
)
public class TestRunner {

}