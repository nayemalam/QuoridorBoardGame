package ca.mcgill.ecse223.quoridor.features;

import static org.junit.Assert.assertEquals;

import java.util.List;

import ca.mcgill.ecse223.quoridor.QuoridorApplication;
import ca.mcgill.ecse223.quoridor.controller.QuoridorController;
import ca.mcgill.ecse223.quoridor.model.Board;
import ca.mcgill.ecse223.quoridor.model.GamePosition;
import ca.mcgill.ecse223.quoridor.model.PlayerPosition;
import ca.mcgill.ecse223.quoridor.model.Tile;
import cucumber.api.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * Class used to encapsulate the step definitions related to the InitializeBoard
 * feature
 * 
 * @author Tristan Bouchard
 *
 */
public class InitializeBoardStepDef {

	// *********************************************
	// Initialize board scenario
	// *********************************************

	/**
	 * Method used to initiate the initialization of the board
	 * 
	 * @throws Exception
	 * @author Tristan Bouchard
	 */
	@When("The initialization of the board is initiated")
	public void theInitializationOfTheBoardIsInitiated() throws Exception {
		Board board = QuoridorApplication.getQuoridor().getBoard();
		// Here, the board could be null. Should I instead pass the quoridor object and
		// associate a new board object within?
		QuoridorController.initializeBoard(board);
	}

	/**
	 * Method used to verify that it is White players turn to move
	 * 
	 * @author Tristan Bouchard
	 */
	@Then("It shall be white player to move")
	public void itShallBeWhitePlayerToMove() {
		// How do I verify which player is the next player to play? How do I find the
		// current player?
		throw new PendingException();
	}

	/**
	 * Method used to verify that the White players' pawn can be found in its
	 * initial position
	 * 
	 * @author Tristan Bouchard
	 */
	@And("White's pawn shall be in its initial position")
	public void whitesPawnShallBeInItsInitialPosition() {
		PlayerPosition whitePos = QuoridorApplication.getQuoridor().getCurrentGame().getCurrentPosition().getWhitePosition();
		Tile whiteInitialTile = QuoridorApplication.getQuoridor().getBoard().getTile(HelperMethods.WHITE_TILE_INDEX);
		assertEquals(whitePos.getTile(), whiteInitialTile);
	}

	/**
	 * Method used to verify that the Black players' pawn can be found in its
	 * initial position
	 * 
	 * @author Tristan Bouchard
	 */
	@And("Black's pawn shall be in its initial position")
	public void blacksPawnShallBeInItsInitialPosition() {
		PlayerPosition whitePos = QuoridorApplication.getQuoridor().getCurrentGame().getCurrentPosition().getBlackPosition();
		Tile blackInitialTile = QuoridorApplication.getQuoridor().getBoard().getTile(HelperMethods.BLACK_TILE_INDEX);
		assertEquals(whitePos.getTile(), blackInitialTile);
	}

	/**
	 * Method used to verify that all of the White players' walls are in his stock
	 * 
	 * @author Tristan Bouchard
	 */
	@And("All of White's walls shall be in stock")
	public void allOfWhitesWallsShallBeInStock() {
		
	}

	/**
	 * Method used to verify that all of the Black players' walls are in his stock
	 * 
	 * @author Tristan Bouchard
	 */
	@And("All of Black's walls shall be in stock")
	public void allOfBlacksWallsShallBeInStock() {

	}

	/**
	 * Method used to verify that the clock for the current player is counting down
	 * 
	 * @author Tristan Bouchard
	 */
	@And("White's clock shall be counting down")
	public void whitesClockShallBeCountingDown() {

	}

	/**
	 * Method used to verify GUI step to verify that it is whites turn
	 * 
	 * @author Tristan Bouchard
	 */
	@And("It shall be shown that this is White's turn")
	public void itShallBeShownThatThisIsWhitesTurn() {
		// GUI verification, throw pending exception -- TODO later
		throw new PendingException();
	}
}
