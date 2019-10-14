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

public class RotateWallFeatureStepDev {
	private CucumberStepDefinitions csd = new CucumberStepDefinitions();
	
	/**
	 * Class used to define the step definitions related to the rotate wall feature
	 * @throws Exception
	 * @author Iyatan Atchoro
	 */
	
	
	 /**
     * Method used to check if a wall move candidate exist
     * @param string, int, int
     */
	
	@Given("A wall move candidate exists with {string} at position \\({int}, {int})")
	public void a_wall_move_candidate_exists_with_at_position(String string, Integer int1, Integer int2) {		
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
     * Method to check that the rotate wall method works
     * @param 
     */
	
	@When("I try to flip the wall")
	public void i_try_to_flip_the_wall() throws Exception {
		QuoridorController.rotateWall();
	}
	 /**
     * Method asserting whether it it properly rotated
     * @param string
     */

	@Then("The wall shall be rotated over the board to {string}")
	public void the_wall_shall_be_rotated_over_the_board_to(String string) {
		// Checking if the board wall is rotated over the board
		Quoridor q = QuoridorApplication.getQuoridor();
		assertEquals(string, q.getCurrentGame().getBlackPlayer().getWall(11).getMove().getWallDirection());	
	}
	/**
     * Method asserting whether it exist at the right position
     * @param string, int, int
     */

	@And("A wall move candidate shall exist with {string} at position \\({int}, {int})")
	public void a_wall_move_candidate_shall_exist_with_at_position(String string, Integer int1, Integer int2) {
	    // Write code here that turns the phrase above into concrete actions
		Quoridor q = QuoridorApplication.getQuoridor();
		assertEquals(string, q.getCurrentGame().getBlackPlayer().getWall(11).getMove().getWallDirection());	
	    
	}
}
