package ca.mcgill.ecse223.quoridor.features;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ca.mcgill.ecse223.quoridor.QuoridorApplication;
import ca.mcgill.ecse223.quoridor.controller.QuoridorController;

import ca.mcgill.ecse223.quoridor.model.*;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.assertEquals;

public class EnterReplayModeStepDef{
	@When("I initiate replay mode")
	public void i_initiate_replay_mode() {
	    QuoridorController.enterReplayMode();
	}
	
	@Given("The game is replay mode")
	public void the_game_is_replay_mode() {
		Game curGame = QuoridorApplication.getQuoridor().getCurrentGame();
		assertEquals(curGame.getGameStatus(),"Replay");
	}

	@Given("The game does not have a final result")
	public void the_game_does_not_have_a_final_result() {
		Game curGame = QuoridorApplication.getQuoridor().getCurrentGame();
		
	}

	@When("I initiate to continue game")
	public void i_initiate_to_continue_game() {
		Game curGame = QuoridorApplication.getQuoridor().getCurrentGame();
		assertEquals(curGame.getGameStatus(),"Replay");
	}

	@Then("The remaining moves of the game shall be removed")
	public void the_remaining_moves_of_the_game_shall_be_removed() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}
	@Then("I shall be notified that finished games cannot be continued")
	public void i_shall_be_notified_that_finished_games_cannot_be_continued() {
		String aString = new String("Finished Game Cannot be continued");
		assertEquals(aString, QuoridorController.finishedGameCannotBeContinued());
	}

	
	
}