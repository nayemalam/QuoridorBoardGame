package ca.mcgill.ecse223.quoridor.features;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Time;

import ca.mcgill.ecse223.quoridor.QuoridorApplication;
import ca.mcgill.ecse223.quoridor.controller.QuoridorController;
import ca.mcgill.ecse223.quoridor.utilities.TimerUtilities;
import ca.mcgill.ecse223.quoridor.model.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * @author Ousmane Baricisse
 * @throws Exception
 */

public class SwitchPlayerStepDefinition {
	private static Player nextPlayer;
	private static Player currentPlayer;
	// ***********************************************
	// Switch Player Feature
	// ***********************************************
	

	@Given("The player to move is {string}")
	public void the_player_to_move_is(String string) throws Exception {
		// Write code here that turns the phrase above into concrete actions
		if(string.equals("white")) {
			Player whitePlayer = QuoridorApplication.getQuoridor().getCurrentGame().getWhitePlayer();
			this.currentPlayer = whitePlayer;
			this.nextPlayer = QuoridorApplication.getQuoridor().getCurrentGame().getBlackPlayer();
			QuoridorApplication.getQuoridor().getCurrentGame().getCurrentPosition().setPlayerToMove(whitePlayer);
		} else {
			Player blackPlayer = QuoridorApplication.getQuoridor().getCurrentGame().getBlackPlayer();
			QuoridorApplication.getQuoridor().getCurrentGame().getCurrentPosition().setPlayerToMove(blackPlayer);
			this.currentPlayer = blackPlayer;
			this.nextPlayer = QuoridorApplication.getQuoridor().getCurrentGame().getWhitePlayer();
		}
		
	}

	@Given("The clock of {string} is running")
	public void the_clock_of_is_running(String string) {
		// Write code here that turns the phrase above into concrete actions
		currentPlayer.setRemainingTime(new Time(180000));
	}

	@Given("The clock of {string} is stopped")
	public void the_clock_of_is_stopped(String string) throws Exception {
		// Write code here that turns the phrase above into concrete actions
		this.nextPlayer.setRemainingTime(new Time(0));
	}

	@When("Player {string} completes his move")
	public void player_completes_his_move(String string) {
		// Write code here that turns the phrase above into concrete actions
		QuoridorController.completeMove();
	}

	@Then("The user interface shall be showing it is {string} turn")
	public void the_user_interface_shall_be_showing_it_is_turn(String string) {
		// Write code here that turns the phrase above into concrete actions
		Player playerToMove = QuoridorApplication.getQuoridor().getCurrentGame().getCurrentPosition().getPlayerToMove();
		assertEquals(this.nextPlayer, playerToMove);
	}

	@Then("The clock of {string} shall be stopped")
	public void the_clock_of_shall_be_stopped(String string) throws Exception {
		// Write code here that turns the phrase above into concrete actions
		assertEquals(0, currentPlayer.getRemainingTime());
	}

	@Then("The clock of {string} shall be running")
	public void the_clock_of_shall_be_running(String string) {
		// Write code here that turns the phrase above into concrete actions
		
		boolean condition = this.nextPlayer.getNextPlayer().getRemainingTime().getTime() > 0;
		assertTrue(condition);
	}

	@Then("The next player to move shall be {string}")
	public void the_next_player_to_move_shall_be(String string) {
		// Write code here that turns the phrase above into concrete actions
		Player playerToMove = QuoridorApplication.getQuoridor().getCurrentGame().getCurrentPosition().getPlayerToMove();
		assertEquals(this.nextPlayer, playerToMove);
		
	}
}
