package ca.mcgill.ecse223.quoridor.features;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.Time;

import ca.mcgill.ecse223.quoridor.QuoridorApplication;
import ca.mcgill.ecse223.quoridor.controller.QuoridorController;
import ca.mcgill.ecse223.quoridor.model.Board;
import ca.mcgill.ecse223.quoridor.model.Game;
import ca.mcgill.ecse223.quoridor.model.Player;
import ca.mcgill.ecse223.quoridor.model.Tile;
import ca.mcgill.ecse223.quoridor.model.User;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StartNewGameFeatureStepDef {

	// Initiate new game scenario
	
	@When("A new game is being initialized")
	public void aNewGameIsBeingInitialized() throws Exception {
		QuoridorController.initializeNewGame(QuoridorApplication.getQuoridor().getCurrentGame());
	}

	@And("White player chooses a username")
	public void whitePlayerHasAUserName() {
		Player p = QuoridorApplication.getQuoridor().getCurrentGame().getWhitePlayer();
		User whiteUser = p.getUser();
		HelperMethods.validateUser(whiteUser);
	}

	@And("Black player chooses a username")
	public void blackPlayerHasAUserName() {
		Game game = QuoridorApplication.getQuoridor().getCurrentGame();
		Boolean userIsInvalidOrNull = game.equals(null) && game.getBlackPlayer().equals(null)
				&& game.getBlackPlayer().getUser().equals(null);
		if (userIsInvalidOrNull) {
			fail();
		}
		User blackUser = game.getBlackPlayer().getUser();
		HelperMethods.validateUser(blackUser);
	}

	@And("Total thinking time is set")
	public void totalThinkingTimeIsSet() {

		Player playerWhite = QuoridorApplication.getQuoridor().getCurrentGame().getWhitePlayer();
		Player playerBlack = QuoridorApplication.getQuoridor().getCurrentGame().getBlackPlayer();

		// Verify player 1 thinking time
		Time thinkingTimeP1 = playerWhite.getRemainingTime();
		if (thinkingTimeP1.equals(null) || thinkingTimeP1.equals(new Time(0))) {
			fail();
		}
		// Verify player 2 thinking time
		Time thinkingTimeP2 = playerBlack.getRemainingTime();
		if (thinkingTimeP2.equals(null) || thinkingTimeP2.equals(new Time(0))) {
			fail();
		}
	}

	@Then("The game shall become ready to start")
	public void theGameShallBecomeReadyToStart() {
		assertEquals(Game.GameStatus.ReadyToStart, QuoridorApplication.getQuoridor().getCurrentGame().getGameStatus());
	}

	// ***************************************************
	// Start clock scenario
	@Given("The game is ready to start")
	public void theGameIsReadyToStart() throws Exception {
		//theGameIsRunning();
	}
	
	@When("I start the clock")
	public void iStartTheClock() throws Exception {
		QuoridorController.startClock(QuoridorApplication.getQuoridor().getCurrentGame());
	}

	@And("The board is initialized")
	public void andTheBoardIsInitialized() {
		Board board = QuoridorApplication.getQuoridor().getBoard();
		// Verify number of times
		assertEquals(HelperMethods.TOTAL_NUMBER_OF_TILES, board.getTiles().size());

		// Verify the indices of the tiles
		for (int row = 0; row < HelperMethods.TOTAL_NUMBER_OF_ROWS; row++) {
			for (int col = 0; col < HelperMethods.TOTAL_NUMBER_OF_COLS; col++) {
				// Obtain tile in the list and verify that the indices are correct
				int index = ((HelperMethods.TOTAL_NUMBER_OF_COLS) * (row) + (col));
				Tile currentTile = board.getTile(index);
				assertEquals(row, currentTile.getRow());
				assertEquals(col, currentTile.getColumn());
			}
		}
	}

	@Then("The game shall be running")
	public void theGameShallBeRunning() {
		assertEquals(Game.GameStatus.Running, QuoridorApplication.getQuoridor().getCurrentGame().getGameStatus());
	}

	@And("The board shall be initialized")
	public void theBoardShallBeInitialized() {

	}
}
