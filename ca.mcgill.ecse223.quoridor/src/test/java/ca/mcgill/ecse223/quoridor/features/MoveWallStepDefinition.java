package ca.mcgill.ecse223.quoridor.features;

import ca.mcgill.ecse223.quoridor.QuoridorApplication;
import ca.mcgill.ecse223.quoridor.model.*;
import ca.mcgill.ecse223.quoridor.controller.QuoridorController;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertEquals;


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
	@Given("A wall move candidate exists with {string} at position \\({int}, {int})")
	public void a_wall_move_candidate_exists_with_at_position(String string, Integer int1, Integer int2) {
		//reinitialize the board and the game
		csd.theGameIsRunning();
		
		//access the system
		Quoridor q = QuoridorApplication.getQuoridor();
		
		//creating walls
		Tile aTile = new Tile(int1, int2,q.getBoard());
		Wall aWall = new Wall(11, q.getCurrentGame().getBlackPlayer());
		if(string == "vertical") {
			WallMove aMove = new WallMove( 1, 1, q.getCurrentGame().getBlackPlayer(), aTile, q.getCurrentGame(), Direction.Vertical, aWall);
			aWall.setMove(aMove);
		}
		if(string == "horizontal") {
			WallMove aMove = new WallMove( 2, 1, q.getCurrentGame().getBlackPlayer(), aTile, q.getCurrentGame(), Direction.Horizontal, aWall);
			aWall.setMove(aMove);
		}
	}
	
	/**
	 * Method that verifies that the wall is not at the side edge of the board
	 * @author Alexander Legouverneur
	 */
	@And("The wall candidate is not at the {string} edge of the board")
	public void TheWallCandidateIsNotAtTheSideEdgeOfTheBoard() {
		//access the system
		Quoridor q = QuoridorApplication.getQuoridor();	
		QuoridorController.CheckWallSideEdge(q.getCurrentGame().getBlackPlayer().getWall(11));
	}
	
	/**
	 * Method that initiates the trial for the move of the wall on the side
	 * @author Alexander Legouverneur
	 */
	@When("I try to move the wall {string}")
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
	@Then("The wall shall be moved over the board to position \\({int}, {int})")
	public void the_wall_shall_be_moved_over_the_board_to_position(Integer int1, Integer int2) {
		Quoridor q = QuoridorApplication.getQuoridor();	
		//Tile aTile= new Tile(nrow, ncol, q.getBoard());
		//WallMove aMove = new WallMove( 1, 1, q.getCurrentGame().getBlackPlayer(), aTile, q.getCurrentGame(),q.getCurrentGame().getBlackPlayer().getWall(11).getMove().getWallDirection(), q.getCurrentGame().getBlackPlayer().getWall(11));
		//q.getCurrentGame().getBlackPlayer().getWall(11).setMove(aMove);
		Integer row = new Integer(q.getCurrentGame().getBlackPlayer().getWall(11).getMove().getTargetTile().getRow());
		Integer col = new Integer(q.getCurrentGame().getBlackPlayer().getWall(11).getMove().getTargetTile().getColumn());
		assertEquals(int1, row);
		assertEquals(int2, col);
		
	}
	/**
	 * Method that checks if the wall was correctly moved over the board position by
	 * checking the coordinates
	 * @author Alexander Legouverneur
	 */
	@Then("A wall move candidate shall exist with {string} at position \\({int}, {int})")
	public void a_wall_move_candidate_shall_exist_with_at_position(String string, Integer int1, Integer int2) {
		
		Quoridor q = QuoridorApplication.getQuoridor();	
		Integer row = new Integer(q.getCurrentGame().getBlackPlayer().getWall(11).getMove().getTargetTile().getRow());
		Integer col = new Integer(q.getCurrentGame().getBlackPlayer().getWall(11).getMove().getTargetTile().getColumn());
		assertEquals(int1,row);
		assertEquals(int2, col);
		assertEquals(string, q.getCurrentGame().getBlackPlayer().getWall(11).getMove().getWallDirection());
	}
	
	/**
	 * Method that verifies that the wall is at the side edge of the board
	 * @author Alexander Legouverneur
	 */
	@And("The wall candidate is at the {string} edge of the board")
	public void TheWallCandidateIsAtTheEdge1(String side) {
		Quoridor q = QuoridorApplication.getQuoridor();	
		QuoridorController.CheckWallSideEdge(q.getCurrentGame().getBlackPlayer().getWall(11));
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
		assertEquals(aString, QuoridorController.IllegalWallMove(q.getCurrentGame().getBlackPlayer().getWall(11)));			
	}
}
