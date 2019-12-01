package ca.mcgill.ecse223.quoridor.features;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.IOException;
import java.sql.Time;

import ca.mcgill.ecse223.quoridor.QuoridorApplication;
import ca.mcgill.ecse223.quoridor.controller.*;
import ca.mcgill.ecse223.quoridor.model.*;
import ca.mcgill.ecse223.quoridor.view.*;

public class LoadGameStepDef {

	private QuoridorController QC = new QuoridorController();
	private boolean valid;
	private Exception thrownException;

	@When("I initiate to load a game in {string}")
	public void i_initiate_to_load_a_game_in(String string) throws IOException {

		Quoridor q = QuoridorApplication.getQuoridor();

		thrownException = null;
		int thinkingTime = 180;


		Player player1 = new Player(new Time(thinkingTime), q.getUser(0), 9, Direction.Horizontal);
		Player player2 = new Player(new Time(thinkingTime), q.getUser(1), 1, Direction.Horizontal);

		try {
			valid = QC.loadGame(string, player1, player2);
		} catch (IllegalArgumentException e) {
			thrownException = e;
		}

	}

	@When("Each game move is valid")
	public void each_game_move_is_valid() {
		assertEquals(null, thrownException);
	}

	@When("The game has no final results")
	public void the_game_has_no_final_results() {
		Quoridor q = QuoridorApplication.getQuoridor();
		Game g = q.getCurrentGame();

		//check both players haven't won
		assertEquals(false, QC.checkIfWon(QC.getBlackPlayer(), g.getCurrentPosition().getBlackPosition().getTile().getRow(), g.getCurrentPosition().getBlackPosition().getTile().getColumn()));
		assertEquals(false, QC.checkIfWon(QC.getWhitePlayer(), g.getCurrentPosition().getWhitePosition().getTile().getRow(), g.getCurrentPosition().getWhitePosition().getTile().getColumn()));
	}

	@When("The game has a final result")
	public void the_game_has_a_final_result() {
		Quoridor q = QuoridorApplication.getQuoridor();
		Game g = q.getCurrentGame();
		//check if one of the players won
		if(QC.checkIfWon(QC.getBlackPlayer(), g.getCurrentPosition().getBlackPosition().getTile().getRow(), g.getCurrentPosition().getBlackPosition().getTile().getColumn())) {
			assertEquals(true, QC.checkIfWon(QC.getBlackPlayer(), g.getCurrentPosition().getBlackPosition().getTile().getRow(), g.getCurrentPosition().getBlackPosition().getTile().getColumn()));
		}else {
			assertEquals(true, QC.checkIfWon(QC.getWhitePlayer(), g.getCurrentPosition().getWhitePosition().getTile().getRow(), g.getCurrentPosition().getWhitePosition().getTile().getColumn()));
		}
	}

	@When("The game to load has an invalid move")
	public void the_game_to_load_has_an_invalid_move() {
		assertNotNull(thrownException);
	}

	@Then("The game shall notify the user that the game file is invalid")
	public void the_game_shall_notify_the_user_that_the_game_file_is_invalid() {
		assertNotNull(thrownException);
	}

	@Then("The game shall be in replay mode")
	public void the_game_shall_be_in_replay_mode() {
		//LoadGamePage loadGamePage = new LoadGamePage(); 
	}
}
