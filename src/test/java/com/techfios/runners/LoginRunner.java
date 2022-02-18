package com.techfios.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
features = "src/test/java/com/techfios/features/techFiosLoginFromDatabase.feature",
glue = "com.techfios.steps",
tags = {"@DbScenario"},
monochrome = true,
dryRun = false,
plugin = {
    "pretty",
    "html:target/cucumber",
    "json:target/cucumber.json"
}
)
public class LoginRunner {

}
