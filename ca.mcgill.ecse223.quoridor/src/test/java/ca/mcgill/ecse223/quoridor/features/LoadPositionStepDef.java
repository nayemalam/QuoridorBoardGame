<<<<<<< HEAD
package ca.mcgill.ecse223.quoridor.features;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ca.mcgill.ecse223.quoridor.model.*;
import ca.mcgill.ecse223.quoridor.QuoridorApplication;
import ca.mcgill.ecse223.quoridor.controller.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Class used to encapsulate the step definitions related to LoadPosition
 * feature
 * 
 * @author Nicolas Buisson
 * 
 */
public class LoadPositionStepDef {

	private QuoridorController QC = new QuoridorController();
	private Game game;	
	private Exception thrownException;
	
	//false if invalid position
	//true if valid position

	
	// *********************************************
	//Load position scenario
	// *********************************************

	/**   
	 * @author Nicolas Buisson
	 */
	@When ("I initiate to load a saved game {string}")
	public void IInitiateToLoadASavedGame(String filename) {
		thrownException = null;
		try {
			game = QC.loadSavedGame(filename);
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
		assertEquals(player, game.getCurrentPosition().getPlayerToMove().getUser().getName());
	}
	/**  
	 * @author Nicolas Buisson
	 */
	@And ("{string} shall be at {int}:{int}")
	public void PlayerShallBeAtRowCol(String player, int p_row, int p_col) {

		if(player == "black") {
			assertEquals(p_row, game.getCurrentPosition().getBlackPosition().getTile().getRow());
			
			assertEquals(p_col, game.getCurrentPosition().getBlackPosition().getTile().getColumn());
		}
		else {
			assertEquals(p_row, game.getCurrentPosition().getWhitePosition().getTile().getRow());
			
			assertEquals(p_col, game.getCurrentPosition().getWhitePosition().getTile().getColumn());
		}
	}

	/**  
	 * @author Nicolas Buisson
	 */
	@And ("{string} shall have a vertical wall at {int}:{int}")
	public void PlayerShallHaveAVerticalWallAtRowCol(String player, int pw_row, int pw_col) {

		if(player == "black") {

			assertEquals(Direction.Vertical, game.getCurrentPosition().getBlackWallsOnBoard(0).getMove().getWallDirection());

			assertEquals(pw_row, game.getCurrentPosition().getBlackWallsOnBoard(0).getMove().getTargetTile().getRow());

			assertEquals(pw_col, game.getCurrentPosition().getBlackWallsOnBoard(0).getMove().getTargetTile().getColumn());
		}else {
			
			assertEquals(Direction.Vertical, game.getCurrentPosition().getWhiteWallsOnBoard(0).getMove().getWallDirection());

			assertEquals(pw_row, game.getCurrentPosition().getWhiteWallsOnBoard(0).getMove().getTargetTile().getRow());

			assertEquals(pw_col, game.getCurrentPosition().getWhiteWallsOnBoard(0).getMove().getTargetTile().getColumn());
		}
	}
	
	/**  
	 * @author Nicolas Buisson
	 */
	@And ("{string} shall have a horizontal wall at {int}:{int}")
	public void PlayerShallHaveAHorizontalWallAtRowCol(String player, int pw_row, int pw_col) {

		if(player == "black") {

			assertEquals(Direction.Horizontal, game.getCurrentPosition().getBlackWallsOnBoard(0).getMove().getWallDirection());

			assertEquals(pw_row, game.getCurrentPosition().getBlackWallsOnBoard(0).getMove().getTargetTile().getRow());

			assertEquals(pw_col, game.getCurrentPosition().getBlackWallsOnBoard(0).getMove().getTargetTile().getColumn());
		}else {
			
			assertEquals(Direction.Horizontal, game.getCurrentPosition().getWhiteWallsOnBoard(0).getMove().getWallDirection());

			assertEquals(pw_row, game.getCurrentPosition().getWhiteWallsOnBoard(0).getMove().getTargetTile().getRow());

			assertEquals(pw_col, game.getCurrentPosition().getWhiteWallsOnBoard(0).getMove().getTargetTile().getColumn());
		}
	}

	/**  
	 * @author Nicolas Buisson
	 */
	@And ("Both players shall have {int} in their stacks")
	public void BothPlayersShallHaveRemainingWallsInTheirStacks(int remaining_walls) { 
		assertEquals(remaining_walls, game.getBlackPlayer().numberOfWalls());
		assertEquals(remaining_walls,game.getWhitePlayer().numberOfWalls());
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
	}

	/**  
	 * @author Nicolas Buisson
	 */
	@Then("The load shall return an error")
	public void TheLoadShallReturnAnError() {
		assertNotNull(thrownException);
	}
}
=======
package ca.mcgill.ecse223.quoridor.features;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ca.mcgill.ecse223.quoridor.model.*;
import ca.mcgill.ecse223.quoridor.QuoridorApplication;
import ca.mcgill.ecse223.quoridor.controller.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Class used to encapsulate the step definitions related to LoadPosition
 * feature
 * 
 * @author Nicolas Buisson
 * 
 */
public class LoadPositionStepDef {

	private QuoridorController QC = new QuoridorController();
	private Game game;	
	private Exception thrownException;
	
	//false if invalid position
	//true if valid position

	
	// *********************************************
	//Load position scenario
	// *********************************************

	/**   
	 * @author Nicolas Buisson
	 */
	@When ("I initiate to load a saved game {string}")
	public void IInitiateToLoadASavedGame(String filename) {
		thrownException = null;
		try {
			game = QC.loadSavedGame(filename);
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
		assertEquals(player, game.getCurrentPosition().getPlayerToMove().getUser().getName());
	}
	/**  
	 * @author Nicolas Buisson
	 */
	@And ("{string} shall be at {int}:{int}")
	public void PlayerShallBeAtRowCol(String player, int p_row, int p_col) {

		if(player == "black") {
			assertEquals(p_row, game.getCurrentPosition().getBlackPosition().getTile().getRow());
			
			assertEquals(p_col, game.getCurrentPosition().getBlackPosition().getTile().getColumn());
		}
		else {
			assertEquals(p_row, game.getCurrentPosition().getWhitePosition().getTile().getRow());
			
			assertEquals(p_col, game.getCurrentPosition().getWhitePosition().getTile().getColumn());
		}
	}

	/**  
	 * @author Nicolas Buisson
	 */
	@And ("{string} shall have a vertical wall at {int}:{int}")
	public void PlayerShallHaveAVerticalWallAtRowCol(String player, int pw_row, int pw_col) {

		if(player == "black") {

			assertEquals(Direction.Vertical, game.getCurrentPosition().getBlackWallsOnBoard(0).getMove().getWallDirection());

			assertEquals(pw_row, game.getCurrentPosition().getBlackWallsOnBoard(0).getMove().getTargetTile().getRow());

			assertEquals(pw_col, game.getCurrentPosition().getBlackWallsOnBoard(0).getMove().getTargetTile().getColumn());
		}else {
			
			assertEquals(Direction.Vertical, game.getCurrentPosition().getWhiteWallsOnBoard(0).getMove().getWallDirection());

			assertEquals(pw_row, game.getCurrentPosition().getWhiteWallsOnBoard(0).getMove().getTargetTile().getRow());

			assertEquals(pw_col, game.getCurrentPosition().getWhiteWallsOnBoard(0).getMove().getTargetTile().getColumn());
		}
	}
	
	/**  
	 * @author Nicolas Buisson
	 */
	@And ("{string} shall have a horizontal wall at {int}:{int}")
	public void PlayerShallHaveAHorizontalWallAtRowCol(String player, int pw_row, int pw_col) {

		if(player == "black") {

			assertEquals(Direction.Horizontal, game.getCurrentPosition().getBlackWallsOnBoard(0).getMove().getWallDirection());

			assertEquals(pw_row, game.getCurrentPosition().getBlackWallsOnBoard(0).getMove().getTargetTile().getRow());

			assertEquals(pw_col, game.getCurrentPosition().getBlackWallsOnBoard(0).getMove().getTargetTile().getColumn());
		}else {
			
			assertEquals(Direction.Horizontal, game.getCurrentPosition().getWhiteWallsOnBoard(0).getMove().getWallDirection());

			assertEquals(pw_row, game.getCurrentPosition().getWhiteWallsOnBoard(0).getMove().getTargetTile().getRow());

			assertEquals(pw_col, game.getCurrentPosition().getWhiteWallsOnBoard(0).getMove().getTargetTile().getColumn());
		}
	}

	/**  
	 * @author Nicolas Buisson
	 */
	@And ("Both players shall have {int} in their stacks")
	public void BothPlayersShallHaveRemainingWallsInTheirStacks(int remaining_walls) { 
		assertEquals(remaining_walls, game.getBlackPlayer().numberOfWalls());
		assertEquals(remaining_walls,game.getWhitePlayer().numberOfWalls());
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
	}

	/**  
	 * @author Nicolas Buisson
	 */
	@Then("The load shall return an error")
	public void TheLoadShallReturnAnError() {
		assertNotNull(thrownException);
	}
}
>>>>>>> dev
