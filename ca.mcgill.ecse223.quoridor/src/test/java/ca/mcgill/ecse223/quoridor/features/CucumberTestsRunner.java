package ca.mcgill.ecse223.quoridor.features;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = "pretty", 
		features = "src/test/resources",
		tags = "@LoadPosition1 or @LoadPosition2 or @SavePosition1 or @SavePosition2 or @SavePosition3",
		glue = "ca.mcgill.ecse223.quoridor.features")
public class CucumberTestsRunner {
}