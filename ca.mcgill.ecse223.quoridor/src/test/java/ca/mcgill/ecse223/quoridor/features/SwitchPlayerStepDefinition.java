package ca.mcgill.ecse223.quoridor.features;

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
	// ***********************************************
		// Switch Player Feature
		// ***********************************************
	
		@When("{int}:{int} is set as the thinking time")
		public void is_set_as_the_thinking_time(Integer int1, Integer int2) {
		    // Write code here that turns the phrase above into concrete actions
		    throw new cucumber.api.PendingException();
		}
		
		@Then("Both players shall have {int}:{int} remaining time left")
		public void both_players_shall_have_remaining_time_left(Integer int1, Integer int2) {
		    // Write code here that turns the phrase above into concrete actions
		    throw new cucumber.api.PendingException();
		}
		@Given("The player to move is {string}")
		public void the_player_to_move_is(String string) throws Exception {
		    // Write code here that turns the phrase above into concrete actions
		    QuoridorController.getPlayer(QuoridorApplication.getQuoridor());
		}
		
		@Given("The clock of {string} is running")
		public void the_clock_of_is_running(String string) {
		    // Write code here that turns the phrase above into concrete actions
			QuoridorController.startClock();
		}
		
		@Given("The clock of {string} is stopped")
		public void the_clock_of_is_stopped(String string) throws Exception {
		    // Write code here that turns the phrase above into concrete actions
		    QuoridorController.stopClock();
		}
		
		@When("Player {string} completes his move")
		public void player_completes_his_move(String string) {
		    // Write code here that turns the phrase above into concrete actions
			QuoridorController.completeMove();
		}

		
		@Then("The user interface shall be showing it is {string} turn")
		public void the_user_interface_shall_be_showing_it_is_turn(String string) {
		    // Write code here that turns the phrase above into concrete actions
		    QuoridorController.showPlayerTurn();
		}

		@Then("The clock of {string} shall be stopped")
		public void the_clock_of_shall_be_stopped(String string) throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			QuoridorController.stopClock();
		}

		@Then("The clock of {string} shall be running")
		public void the_clock_of_shall_be_running(String string) {
		    // Write code here that turns the phrase above into concrete actions
			QuoridorController.startClock();
		}
		
		@Then("The next player to move shall be {string}")
		public void the_next_player_to_move_shall_be(String string) {
		    // Write code here that turns the phrase above into concrete actions
			QuoridorController.setNextPlayer();
		}
}
