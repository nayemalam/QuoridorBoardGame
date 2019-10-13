package ca.mcgill.ecse223.quoridor.features;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import ca.mcgill.ecse223.quoridor.QuoridorApplication;
import ca.mcgill.ecse223.quoridor.controller.QuoridorController;
import ca.mcgill.ecse223.quoridor.model.Direction;
import ca.mcgill.ecse223.quoridor.model.Quoridor;
import ca.mcgill.ecse223.quoridor.model.Tile;
import ca.mcgill.ecse223.quoridor.model.Wall;
import ca.mcgill.ecse223.quoridor.model.WallMove;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


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
	@Given("A wall move candidate exists with {string} at position \\({int}, {int})")
	public void a_wall_move_candidate_exists_with_at_position(String string, int int1, int int2) {
		
		//access the system
		Quoridor q = QuoridorApplication.getQuoridor();
		
		// Find tile at position
		Tile aTile = null;
		for(Tile t : q.getBoard().getTiles()){
			if(t.getRow() == int1 && t.getColumn() == int2) aTile = t;
		}
		if(aTile==null) fail("Error initializing board. No tile found with coordinates.");
		
		// Get some wall for the black player.
		Wall aWall = q.getCurrentGame().getBlackPlayer().getWall(0);
		
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
	public void TheWallCandidateIsNotAtTheSideEdgeOfTheBoard(String direction) {
		//access the system
		Quoridor q = QuoridorApplication.getQuoridor();	
		QuoridorController.CheckWallSideEdge(q.getCurrentGame().getBlackPlayer().getWall(0));
	}
	
	/**
	 * Method that initiates the trial for the move of the wall on the side
	 * @author Alexander Legouverneur
	 */
	@When("I try to move the wall {string}")
	public void iTryToMoveTheWallSide(String side) {
		//access system
		Quoridor q = QuoridorApplication.getQuoridor();	
		QuoridorController.VerifyMoveWallOnSide(q.getCurrentGame().getBlackPlayer().getWall(0), side);
	}
	
	/**
	 * Method that initiates the movement of the wall to the new position
	 * @param row
	 * @param col
	 * @author Alexander Legouverneur
	 */
	@Then("The wall shall be moved over the board to position \\({int}, {int})")
	public void the_wall_shall_be_moved_over_the_board_to_position(int int1, int int2) {
		Quoridor q = QuoridorApplication.getQuoridor();	

		Integer row = new Integer(q.getCurrentGame().getBlackPlayer().getWall(11).getMove().getTargetTile().getRow());
		Integer col = new Integer(q.getCurrentGame().getBlackPlayer().getWall(11).getMove().getTargetTile().getColumn());
		assertEquals(int1, q.getCurrentGame().getBlackPlayer().getWall(11).getMove().getTargetTile().getRow());
		assertEquals(int2, q.getCurrentGame().getBlackPlayer().getWall(11).getMove().getTargetTile().getColumn());
		
	}
	/**
	 * Method that checks if the wall was correctly moved over the board position by
	 * checking the coordinates
	 * @author Alexander Legouverneur
	 */
	@And("A wall move candidate shall exist with {string} at position \\({int}, {int})")
	public void a_wall_move_candidate_shall_exist_with_at_position(String string, int int1, int int2) {
		
		Quoridor q = QuoridorApplication.getQuoridor();	
		assertEquals(int1,q.getCurrentGame().getBlackPlayer().getWall(0).getMove().getTargetTile().getRow());
		assertEquals(int2, q.getCurrentGame().getBlackPlayer().getWall(0).getMove().getTargetTile().getColumn());
		assertEquals(string, q.getCurrentGame().getBlackPlayer().getWall(0).getMove().getWallDirection());
	}
	
	/**
	 * Method that verifies that the wall is at the side edge of the board
	 * @author Alexander Legouverneur
	 */
	@And("The wall candidate is at the {string} edge of the board")
	public void TheWallCandidateIsAtTheEdge1(String side) {
		Quoridor q = QuoridorApplication.getQuoridor();	
		QuoridorController.CheckWallSideEdge(q.getCurrentGame().getBlackPlayer().getWall(0));
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
		assertEquals(aString, QuoridorController.IllegalWallMove(q.getCurrentGame().getBlackPlayer().getWall(0)));			
	}
}
