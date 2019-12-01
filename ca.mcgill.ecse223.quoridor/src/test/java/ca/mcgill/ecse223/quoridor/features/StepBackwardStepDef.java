package ca.mcgill.ecse223.quoridor.features;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

import java.util.List;
import java.util.Map;

import ca.mcgill.ecse223.quoridor.QuoridorApplication;
import ca.mcgill.ecse223.quoridor.controller.QuoridorController;
import ca.mcgill.ecse223.quoridor.model.Direction;
import ca.mcgill.ecse223.quoridor.model.Game;
import ca.mcgill.ecse223.quoridor.model.Move;
import ca.mcgill.ecse223.quoridor.model.Player;
import ca.mcgill.ecse223.quoridor.model.Quoridor;
import ca.mcgill.ecse223.quoridor.model.StepMove;
import ca.mcgill.ecse223.quoridor.model.Tile;
import ca.mcgill.ecse223.quoridor.model.Wall;
import ca.mcgill.ecse223.quoridor.model.WallMove;
import ca.mcgill.ecse223.quoridor.model.Game.GameStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepBackwardStepDef {
	private int moveNumber;
	private int roundNumber;

	@Given("The game is in replay mode")
	public void setGameInReplayMode() {
		Game game = QuoridorApplication.getQuoridor().getCurrentGame();
		GameStatus gameStatus = GameStatus.Replay;
		if(!QuoridorController.isReplay()) game.setGameStatus(gameStatus);
	}

	@When("Step backward is initiated")
	public void initStepForward() {

	}

	@Then("White has <wwallno> on stock")
	public void whiteHasWWallnoOnStock() {
		// Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();
	}

}