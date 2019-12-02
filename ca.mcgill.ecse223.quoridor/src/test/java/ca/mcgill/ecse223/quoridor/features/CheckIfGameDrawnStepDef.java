package ca.mcgill.ecse223.quoridor.features;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;
import java.util.Map;

import ca.mcgill.ecse223.quoridor.QuoridorApplication;
import ca.mcgill.ecse223.quoridor.controller.QuoridorController;
import ca.mcgill.ecse223.quoridor.model.Direction;
import ca.mcgill.ecse223.quoridor.model.Game;
import ca.mcgill.ecse223.quoridor.model.Move;
import ca.mcgill.ecse223.quoridor.model.Player;
import ca.mcgill.ecse223.quoridor.model.StepMove;
import ca.mcgill.ecse223.quoridor.model.Tile;
import ca.mcgill.ecse223.quoridor.model.Game.GameStatus;
import ca.mcgill.ecse223.quoridor.utilities.ControllerUtilities.MoveDirections;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckIfGameDrawnStepDef {
	
	/**
	 * Method used to set the set of moves previously executed by the players
	 * @param dataTable
	 * @author Tristan Bouchard
	 */
	@Given("The following moves were executed:")
	public void executeTheFollowingMoves(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> valueMaps = dataTable.asMaps();
		
		for (Map<String, String> map : valueMaps) {
			Integer move = Integer.decode(map.get("move"));
			Integer turn = Integer.decode(map.get("turn"));
			Integer row = Integer.decode(map.get("row"));
			Integer col = Integer.decode(map.get("col"));
			
			Player player = turn.equals(1) ? QuoridorController.getWhitePlayer() : QuoridorController.getBlackPlayer();
			Tile targetTile = QuoridorController.getTileAtRowCol(row, col);
			Game game = QuoridorApplication.getQuoridor().getCurrentGame();
			
			// Create pawn move and add to current game
			StepMove pawnMove = new StepMove(move, turn, player, targetTile, game);
		}
	}
	
	/**
	 * Method used to complete the pending move, aka change player
	 * @param player - Specified player to complete move for
	 * @author Tristan Bouchard
	 */
	@Given("Player {string} has just completed his move")
	public void playerHasJustCompletedHisMove(String player) {
		//QuoridorController.switchCurrentPlayer();
		Player currentPlayer = player.equals("white") ? QuoridorController.getWhitePlayer() : QuoridorController.getBlackPlayer();
		QuoridorController.setCurrentPlayer(currentPlayer);
	}
	
	/**
	 * Method used to make sure that the last move is the specified pawn move
	 * @param player - Specified player
	 * @param row - Specified pawn move row
	 * @param col - Specified pawn move column
	 * @author Tristan Bouchard
	 */
	@And("The last move of {string} is pawn move to {int}:{int}")
	public void theLastMoveOfPlayerIsPawnMoveAtRowCol(String playerString, int row, int col) {
		
		//QuoridorController.movePawn(currentPlayer, MoveDirections.left.toString());
		List<Move> moveList = QuoridorApplication.getQuoridor().getCurrentGame().getMoves();
		Move lastMove = moveList.get(moveList.size() - 1);
		Player player = QuoridorController.getCurrentPlayer();
		
		Integer move = lastMove.getMoveNumber();
		Integer turn = player.equals(QuoridorController.getWhitePlayer()) ? 1 : 2;
		
		Tile targetTile = QuoridorController.getTileAtRowCol(row, col);
		Game game = QuoridorApplication.getQuoridor().getCurrentGame();
		
		// Create pawn move and add to current game
		StepMove pawnMove = new StepMove(move + 1, turn, player, targetTile, game);
	}
	
	/**
	 * Method used to initiate the game checking algorithm
	 * @author Tristan Bouchard
	 */
	@When("Checking of game result is initated")
	public void checkGameResultToVerifyIfDrawn() {
		QuoridorController.testing = true;
		QuoridorController.updateGameStatus();
		QuoridorController.testing = false;
	}
	
	/**
	 * Method used to verify the game result as drawn or not
	 * @param result
	 * @author Tristan Bouchard
	 */
	@Then("Game result shall be {string}")
	public void gameResultShallBe(String result) {
		String gameResult = QuoridorApplication.getQuoridor().getCurrentGame().getGameStatus().toString();
		if(gameResult.equals(GameStatus.Running.toString())) {
			gameResult = "Pending";
		}
		if(gameResult.equals(GameStatus.Draw.toString())) {
			gameResult = "Drawn";
		}
		assertEquals(result.toLowerCase(), gameResult.toLowerCase());
	}
	
	/**
	 * Method used to verify that the game is ended.
	 * @author Tristan Bouchard
	 */
	@And("The game shall no longer be running")
	public void verifyGameEndedOnDraw() {
		assertNotEquals(GameStatus.Running, QuoridorApplication.getQuoridor().getCurrentGame().getGameStatus());
	}
	
}
