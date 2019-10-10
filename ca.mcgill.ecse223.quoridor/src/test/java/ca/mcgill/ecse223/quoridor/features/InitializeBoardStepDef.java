package ca.mcgill.ecse223.quoridor.features;

import ca.mcgill.ecse223.quoridor.QuoridorApplication;
import ca.mcgill.ecse223.quoridor.controller.QuoridorController;
import ca.mcgill.ecse223.quoridor.model.Board;
import cucumber.api.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class InitializeBoardStepDef {

	@When("The initialization of the board is initiated")
	public void theInitializationOfTheBoardIsInitiated() throws Exception {
		Board board = QuoridorApplication.getQuoridor().getBoard();
		QuoridorController.initializeBoard(board);
	}

	@Then("It shall be white player to move")
	public void itShallBeWhitePlayerToMove() {
		// QuoridorApplication.getQuoridor().getCurrentGame().get
		throw new PendingException();
	}

	@And("White's pawn shall be in its initial position")
	public void whitesPawnShallBeInItsInitialPosition() {

	}

	@And("Black's pawn shall be in its initial position")
	public void blacksPawnShallBeInItsInitialPosition() {

	}

	@And("All of White's walls shall be in stock")
	public void allOfWhitesWallsShallBeInStock() {

	}

	@And("All of Black's walls shall be in stock")
	public void allOfBlacksWallsShallBeInStock() {

	}

	/**
	 * Verify that the clock for the current player is counting down
	 */
	@And("White's clock shall be counting down")
	public void whitesClockShallBeCountingDown() {

	}

	/**
	 * GUI step to verify that it is whites turn
	 */
	@And("It shall be shown that this is White's turn")
	public void itShallBeShownThatThisIsWhitesTurn() {
		// GUI verification, throw pending exception -- TODO later
		throw new PendingException();
	}
}
