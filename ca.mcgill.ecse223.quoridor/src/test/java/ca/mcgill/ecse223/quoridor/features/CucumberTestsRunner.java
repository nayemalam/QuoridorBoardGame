package ca.mcgill.ecse223.quoridor.features;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import ca.mcgill.ecse223.quoridor.QuoridorApplication;
import ca.mcgill.ecse223.quoridor.controller.QuoridorController;
import ca.mcgill.ecse223.quoridor.model.Direction;
import ca.mcgill.ecse223.quoridor.model.Quoridor;
import ca.mcgill.ecse223.quoridor.model.Tile;
import ca.mcgill.ecse223.quoridor.model.Wall;
import ca.mcgill.ecse223.quoridor.model.WallMove;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = "pretty", 
		features = "src/test/resources",
		tags = "@ValidatePosition or @ValidatePosition2 or @ValidatePosition3 or @ValidatePosition4 or @ValidatePosition5 or @ValidatePosition6 or @MoveWall or @MoveWall1",
		glue = "ca.mcgill.ecse223.quoridor.features")
public class CucumberTestsRunner {
	


}