package ca.mcgill.ecse223.quoridor.features;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.sql.Time;

import ca.mcgill.ecse223.quoridor.QuoridorApplication;
import ca.mcgill.ecse223.quoridor.controller.QuoridorController;
import ca.mcgill.ecse223.quoridor.model.Direction;
import ca.mcgill.ecse223.quoridor.model.GamePosition;
import ca.mcgill.ecse223.quoridor.model.Player;
import ca.mcgill.ecse223.quoridor.model.Quoridor;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * Class used to encapsulate the step definitions related to LoadPosition
 * feature
 * 
 * @author Nicolas Buisson
 * 
 */
public class LoadPositionStepDef {

	
	private QuoridorController QC = new QuoridorController();
	private GamePosition gamePosition;	
	private Exception thrownException;
	private boolean valid;
	private int blackWallsPlacedCounter = 0;
	private int whiteWallsPlacedCounter = 0;
	
	//false if invalid position
	//true if valid position

	
	// *********************************************
	//Load position scenario
	// *********************************************

	/**   
	 * @author Nicolas Buisson
	 */
	@When ("I initiate to load a saved game {string}")
	public void IInitiateToLoadASavedGame(String filename) throws IOException {
		Quoridor q = QuoridorApplication.getQuoridor();
		
		thrownException = null;
		int thinkingTime = 180;
		
		
		Player player1 = new Player(new Time(thinkingTime), q.getUser(0), 9, Direction.Horizontal);
		Player player2 = new Player(new Time(thinkingTime), q.getUser(1), 1, Direction.Horizontal);
		
		try {
			valid = QC.loadSavedPosition(filename, player1, player2);
		} catch (IllegalArgumentException e) {
			thrownException = e;
		}

	}

	/**   
	 * @author Nicolas Buisson
	 */
	@And ("The position to load is valid")
	public void ThePositionToLoadIsValid() {
		assertEquals(null, thrownException);
	}

	/**  
	 * @author Nicolas Buisson
	 */
	@Then("It shall be {string}'s turn")
	public void ItShallBePlayerTurn(String player) {
		gamePosition = QuoridorApplication.getQuoridor().getCurrentGame().getCurrentPosition();
		if(gamePosition.getPlayerToMove().equals(QC.getBlackPlayer())) {
			gamePosition.getPlayerToMove().getUser().setName("black");
			gamePosition.getPlayerToMove().getNextPlayer().getUser().setName("white");
		}else {
			gamePosition.getPlayerToMove().getUser().setName("white");
			gamePosition.getPlayerToMove().getNextPlayer().getUser().setName("black");
		}
		assertEquals(player, gamePosition.getPlayerToMove().getUser().getName());
	
	}
	/**  
	 * @author Nicolas Buisson
	 */
	@And ("{string} shall be at {int}:{int}")
	public void PlayerShallBeAtRowCol(String player, int p_row, int p_col) {
		Player black = QuoridorApplication.getQuoridor().getCurrentGame().getBlackPlayer();
		Player white = QuoridorApplication.getQuoridor().getCurrentGame().getWhitePlayer();
			
		if(black.getUser().getName().equals(player)) {
			assertEquals(p_row, gamePosition.getBlackPosition().getTile().getRow());
			assertEquals(p_col, gamePosition.getBlackPosition().getTile().getColumn());
		}
		else if(white.getUser().getName().equals(player)){
			assertEquals(p_row, gamePosition.getWhitePosition().getTile().getRow());
			assertEquals(p_col, gamePosition.getWhitePosition().getTile().getColumn());
		} else {
			fail("Issue setting up test!");
		}
	}

	/**  
	 * @author Nicolas Buisson
	 */
	@And ("{string} shall have a vertical wall at {int}:{int}")
	public void PlayerShallHaveAVerticalWallAtRowCol(String player, int pw_row, int pw_col) {
		Player black = QuoridorApplication.getQuoridor().getCurrentGame().getBlackPlayer();
		Player white = QuoridorApplication.getQuoridor().getCurrentGame().getWhitePlayer();
		
		if(black.getUser().getName().equals(player)) {
			assertEquals(Direction.Vertical, gamePosition.getBlackWallsOnBoard(blackWallsPlacedCounter).getMove().getWallDirection());
			assertEquals(pw_row, gamePosition.getBlackWallsOnBoard(blackWallsPlacedCounter).getMove().getTargetTile().getRow());
			assertEquals(pw_col, gamePosition.getBlackWallsOnBoard(blackWallsPlacedCounter).getMove().getTargetTile().getColumn());
			blackWallsPlacedCounter++; //increment counter after placing wall
		}else if (white.getUser().getName().equals(player)) {
			assertEquals(Direction.Vertical, gamePosition.getWhiteWallsOnBoard(whiteWallsPlacedCounter).getMove().getWallDirection());
			assertEquals(pw_row, gamePosition.getWhiteWallsOnBoard(whiteWallsPlacedCounter).getMove().getTargetTile().getRow());
			assertEquals(pw_col, gamePosition.getWhiteWallsOnBoard(whiteWallsPlacedCounter).getMove().getTargetTile().getColumn());
			whiteWallsPlacedCounter++; //increment counter after placing wall
		}else {
			fail("Issue setting up test!");
		}
	}
	
	/**  
	 * @author Nicolas Buisson
	 */
	@And ("{string} shall have a horizontal wall at {int}:{int}")
	public void PlayerShallHaveAHorizontalWallAtRowCol(String player, int pw_row, int pw_col) {

		Player black = QuoridorApplication.getQuoridor().getCurrentGame().getBlackPlayer();
		Player white = QuoridorApplication.getQuoridor().getCurrentGame().getWhitePlayer();
		
		if(black.getUser().getName().equals(player)) {
			assertEquals(Direction.Horizontal, gamePosition.getBlackWallsOnBoard(blackWallsPlacedCounter).getMove().getWallDirection());
			assertEquals(pw_row, gamePosition.getBlackWallsOnBoard(blackWallsPlacedCounter).getMove().getTargetTile().getRow());
			assertEquals(pw_col, gamePosition.getBlackWallsOnBoard(blackWallsPlacedCounter).getMove().getTargetTile().getColumn());
			blackWallsPlacedCounter++;
		}else if (white.getUser().getName().equals(player)) {
			assertEquals(Direction.Horizontal, gamePosition.getWhiteWallsOnBoard(whiteWallsPlacedCounter).getMove().getWallDirection());
			assertEquals(pw_row, gamePosition.getWhiteWallsOnBoard(whiteWallsPlacedCounter).getMove().getTargetTile().getRow());
			assertEquals(pw_col, gamePosition.getWhiteWallsOnBoard(whiteWallsPlacedCounter).getMove().getTargetTile().getColumn());
			whiteWallsPlacedCounter++;
		}else {
			fail("Issues setting up test!");
		}
	}

	/**  
	 * @author Nicolas Buisson
	 */
	@And ("Both players shall have {int} in their stacks")
	public void BothPlayersShallHaveRemainingWallsInTheirStacks(int remaining_walls) { 
		assertEquals(remaining_walls, gamePosition.getWhiteWallsInStock().size());
		assertEquals(remaining_walls, gamePosition.getBlackWallsInStock().size());
	}

	// *********************************************
	//Load invalid position scenario
	// *********************************************

	/**  
	 * @author Nicolas Buisson
	 */
	@And ("The position to load is invalid")
	public void ThePositionToLoadIsInvalid() {
		assertNotNull(thrownException);
		//assertEquals(false, valid);
	}

	/**  
	 * @author Nicolas Buisson
	 */
	@Then("The load shall return an error")
	public void TheLoadShallReturnAnError() {
		assertNotNull(thrownException);
	}
}