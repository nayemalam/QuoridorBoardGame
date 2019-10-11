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

	private CucumberStepDefinitions csd = new CucumberStepDefinitions();
	
	/**
	 * Method that verifies if a wall candidate exists with direction and coordinates
	 * @author Alexander Legouverneur
	 */
	@Given("A wall move candidate exists with {dir} at position {row}, {col}")
	public void aWallMoveCandidateExistsWithDirAtPosition(int row, int col, Direction dir) {
		//reinitialize the board and the game
		csd.theGameIsRunning();
		
		//access the system
		Quoridor q = QuoridorApplication.getQuoridor();
		
		//creating walls
		Tile aTile = new Tile(row, col,q.getBoard());
		Wall aWall = new Wall(11, q.getCurrentGame().getBlackPlayer());
		WallMove aMove = new WallMove( 1, 1, q.getCurrentGame().getBlackPlayer(), aTile, q.getCurrentGame(), dir, aWall);
		aWall.setMove(aMove);
	}
	
	/**
	 * Method that verifies that the wall is not at the side edge of the board
	 * @author Alexander Legouverneur
	 */
	@And("The wall candidate is not at the \"<side>\" edge of the board")
	public void TheWallCandidateIsNotAtTheSideEdgeOfTheBoard() {
		//access the system
		Quoridor q = QuoridorApplication.getQuoridor();	
		QuoridorController.CheckWallSideEdge(q.getCurrentGame().getBlackPlayer().getWall(11));
	}
	
	/**
	 * Method that initiates the trial for the move of the wall on the side
	 * @author Alexander Legouverneur
	 */
	@When("I try to move the wall {side}")
	public void iTryToMoveTheWallSide(String side) {
		//access system
		Quoridor q = QuoridorApplication.getQuoridor();	
		QuoridorController.VerifyMoveWallOnSide(q.getCurrentGame().getBlackPlayer().getWall(11), side);
	}
	
	/**
	 * Method that initiates the movement of the wall to the new position
	 * @param row
	 * @param col
	 * @author Alexander Legouverneur
	 */
	@Then("The wall shall be moved over the board to position {nrow}, <ncol>)")
	public void TheWallShallBeMovedOverTheBoardToPostion(int nrow, int ncol) {
		Quoridor q = QuoridorApplication.getQuoridor();	
		//Tile aTile= new Tile(nrow, ncol, q.getBoard());
		//WallMove aMove = new WallMove( 1, 1, q.getCurrentGame().getBlackPlayer(), aTile, q.getCurrentGame(),q.getCurrentGame().getBlackPlayer().getWall(11).getMove().getWallDirection(), q.getCurrentGame().getBlackPlayer().getWall(11));
		//q.getCurrentGame().getBlackPlayer().getWall(11).setMove(aMove);
		assertEquals(nrow, q.getCurrentGame().getBlackPlayer().getWall(11).getMove().getTargetTile().getRow());
		assertEquals(ncol, q.getCurrentGame().getBlackPlayer().getWall(11).getMove().getTargetTile().getColumn());
		
	}
	/**
	 * Method that checks if the wall was correctly moved over the board position by
	 * checking the coordinates
	 * @author Alexander Legouverneur
	 */
	@And("A wall move candidate shall exist with {dir} at position {nrow}, {ncol}")
	public void ANewCallCandidateExists(int nrow, int ncol, Direction dir) {
		Quoridor q = QuoridorApplication.getQuoridor();	
		assertEquals(nrow, q.getCurrentGame().getBlackPlayer().getWall(11).getMove().getTargetTile().getRow());
		assertEquals(ncol, q.getCurrentGame().getBlackPlayer().getWall(11).getMove().getTargetTile().getColumn());
		assertEquals(dir, q.getCurrentGame().getBlackPlayer().getWall(11).getMove().getWallDirection());
	}
	
	/**
	 * Method that verifies if a wall candidate exists with direction and coordinates
	 * @author Alexander Legouverneur
	 */
	@Given("A wall move candidate exists with {dir} at position {row}, {col}")
	public void aWallMoveCandidateExistsWithDirAtPosition1(int row, int col, Direction dir) {
		//reinitialize the board and the game
		csd.theGameIsRunning();
		
		//access the system
		Quoridor q = QuoridorApplication.getQuoridor();
		
		//creating walls
		Tile aTile = new Tile(row, col,q.getBoard());
		Wall aWall = new Wall(11, q.getCurrentGame().getBlackPlayer());
		WallMove aMove = new WallMove( 1, 1, q.getCurrentGame().getBlackPlayer(), aTile, q.getCurrentGame(), dir, aWall);
		aWall.setMove(aMove);
	}
	
	/**
	 * Method that verifies that the wall is at the side edge of the board
	 * @author Alexander Legouverneur
	 */
	@And("The wall candidate is at the {side} edge of the board")
	public void TheWallCandidateIsAtTheEdge1(String side) {
		Quoridor q = QuoridorApplication.getQuoridor();	
		QuoridorController.CheckWallSideEdge(q.getCurrentGame().getBlackPlayer().getWall(11));
	}
	
	/**
	 * Method that initiates the trial for the move of the wall on the side
	 * @author Alexander Legouverneur
	 */
	@When("I try to move the wall {side}")
	public void iTryToMoveTheWallSide1(String side) {
		//access system
		Quoridor q = QuoridorApplication.getQuoridor();	
		
		QuoridorController.VerifyMoveWallOnSide(q.getCurrentGame().getBlackPlayer().getWall(11), side);
	}
	
	/**
	 * Method that verifies if user is notified when trying to do an illegal move
	 * @author Alexander Legouverneur
	 */
	@Then("I shall be notified that my move is illegal")
	public void iShallBeNotifiedThatMyMoveIsIllegal() {
		//access system
		String aString = new String("Illegal");
		Quoridor q = QuoridorApplication.getQuoridor();
		assertEquals(aString,QuoridorController.MoveWallOnSide(q.getCurrentGame().getBlackPlayer().getWall(11)) );			
	}
	
	/**
	 * Method that checks if the wall was correctly moved over the board position by
	 * checking the coordinates
	 * @author Alexander Legouverneur
	 */
	@And("A wall move candidate shall exist with {dir} at position {nrow}, {ncol}")
	public void ANewCallCandidateExists1(int nrow, int ncol, Direction dir) {
		Quoridor q = QuoridorApplication.getQuoridor();	
		assertEquals(nrow, q.getCurrentGame().getBlackPlayer().getWall(11).getMove().getTargetTile().getRow());
		assertEquals(ncol, q.getCurrentGame().getBlackPlayer().getWall(11).getMove().getTargetTile().getColumn());
		assertEquals(dir, q.getCurrentGame().getBlackPlayer().getWall(11).getMove().getWallDirection());
	}
	
	
	
	
}
