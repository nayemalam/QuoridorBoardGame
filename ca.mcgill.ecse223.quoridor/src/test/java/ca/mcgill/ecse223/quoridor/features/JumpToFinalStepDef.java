package ca.mcgill.ecse223.quoridor.features;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ca.mcgill.ecse223.quoridor.QuoridorApplication;
import ca.mcgill.ecse223.quoridor.controller.QuoridorController;

import ca.mcgill.ecse223.quoridor.model.*;
import ca.mcgill.ecse223.quoridor.model.Game.GameStatus;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.assertEquals;

public class JumpToFinalStepDef {
	@Given("The game is in replay mode")
	public void the_game_is_in_replay_mode() throws Exception {


		if(QuoridorApplication.getQuoridor().hasCurrentGame()){
			Game curGame = QuoridorApplication.getQuoridor().getCurrentGame();
			assertEquals(curGame.getGameStatus(),"Replay");
		} else {
			QuoridorController.enterReplayMode();
			Game curGame = QuoridorApplication.getQuoridor().getCurrentGame();

			assertEquals(curGame.getGameStatus(),GameStatus.Replay);
		}
	}

	@When("Jump to final position is initiated")
	public void jump_to_final_position_is_initiated() {
	    QuoridorController.jumpToFinal();
	}
}