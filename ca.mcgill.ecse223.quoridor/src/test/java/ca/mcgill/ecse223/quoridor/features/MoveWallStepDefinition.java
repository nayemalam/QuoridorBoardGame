package ca.mcgill.ecse223.quoridor.features;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ca.mcgill.ecse223.quoridor.QuoridorApplication;
import ca.mcgill.ecse223.quoridor.model.*;
import ca.mcgill.ecse223.quoridor.model.Game.GameStatus;
import ca.mcgill.ecse223.quoridor.model.Game.MoveMode;
import cucumber.api.PendingException;
import ca.mcgill.ecse223.quoridor.controller.QuoridorController;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

/**
 * Class that encapsulates all the MoveWall Gherkin features
 * @author Alexander
 *
 */
public class MoveWallStepDefinition {

	/**
	 * Method that verifies if a wall candidate exists with direction and coordinates
	 * @author Alexander Legouverneur
	 */
	@Given("A wall move candidate exists with \"<dir>\" at position (<row>, <col>)")
	public void aWallMoveCandidateExistsWithDirAtPosition() {
		//call controller methods
	}
	
	/**
	 * Method that verifies that the wall is not at the side edge of the board
	 * @author Alexander Legouverneur
	 */
	@And("The wall candidate is not at the \"<side>\" edge of the board")
	public void TheWallCandidateIsNotAtTheSideEdgeOfTheBoard() {
		//call controller methods
	}
	
	/**
	 * Method that verifies that the wall is at the side edge of the board
	 * @author Alexander Legouverneur
	 */
	@And("The wall candidate is at the \"<side>\" edge of the board")
	public void TheWallCandidateIsAtTheEdge() {
		//call controller methods
	}
	
	/**
	 * Method that initiates the trial for the move of the wall on the side
	 * @author Alexander Legouverneur
	 */
	@When("I try to move the wall \"<side>\"")
	public void iTryToMoveTheWallSide() {
		//call controller methods
	}
	
	/**
	 * Method that checks if the wall was correctly moved over the board position by
	 * checking the coordinates
	 * @author Alexander Legouverneur
	 */
	@Then("The wall shall be moved over the board to position (<nrow>, <ncol>)")
	public void TheWallShallBeMovedOverTheBoardToPostion() {
		//call controller methods
	}
	
	/**
	 * Method that verifies if user is notified when trying to do an illegal move
	 * @author Alexander Legouverneur
	 */
	@Then("I shall be notified that my move is illegal")
	public void iShallBeNotifiedThatMyMoveIsIllegal() {
		//call controller methods
	}
	
	/**
	 * Method that verifies if a wall move candidate exists at given direction
	 * and coordinates
	 * @author Alexander Legouverneur
	 */
	@And("A wall move candidate shall exist with \"<dir>\" at position (<nrow>, <ncol>)")
	public void aWallCandidateShallExistWithDirAtPositionNew() {
		//call controller methods
	}	
}
