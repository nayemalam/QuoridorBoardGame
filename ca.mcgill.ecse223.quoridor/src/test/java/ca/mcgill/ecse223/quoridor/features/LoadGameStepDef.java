package ca.mcgill.ecse223.quoridor.features;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

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
	private GamePosition gamePosition;
	private int blackWallsPlacedCounter = 0;
	private int whiteWallsPlacedCounter = 0;

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
		assertEquals(false, QC.checkIfWon(QC.getBlackPlayer()));
		assertEquals(false, QC.checkIfWon(QC.getWhitePlayer()));
	}

	@When("The game has a final result")
	public void the_game_has_a_final_result() {
		Quoridor q = QuoridorApplication.getQuoridor();
		Game g = q.getCurrentGame();
		//check if one of the players won
		if(QC.checkIfWon(QC.getBlackPlayer())) {
			assertEquals(true, QC.checkIfWon(QC.getBlackPlayer()));
		}else if(QC.checkIfWon(QC.getWhitePlayer())) {
			assertEquals(true, QC.checkIfWon(QC.getWhitePlayer()));
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
	
	//LOAD POSITION STEP DEF
	// *********************************************
		//Load position scenario
		// *********************************************

		/**   
		 * @author Nicolas Buisson
		 */
		@When ("I initiate to load a saved game {string}")
		public void IInitiateToLoadASavedGame(String filename) throws IOException {
			Quoridor q = QuoridorApplication.getQuoridor();

			thrownException = null;
			int thinkingTime = 180;


			Player player1 = new Player(new Time(thinkingTime), q.getUser(0), 9, Direction.Horizontal);
			Player player2 = new Player(new Time(thinkingTime), q.getUser(1), 1, Direction.Horizontal);

			if(filename.contains(".dat")) {
				try {
					valid = QC.loadSavedPosition(filename, player1, player2);
				} catch (IllegalArgumentException e) {
					thrownException = e;
				}
			}
			if(filename.contains(".mov")) {
				try {
					valid = QC.loadGame(filename, player1, player2);
				}catch (IllegalArgumentException e) {
					thrownException = e;
				}
			}
		}

		/**   
		 * @author Nicolas Buisson
		 */
		@And ("The position to load is valid")
		public void ThePositionToLoadIsValid() {
			assertEquals(null, thrownException);
		}

		/**  
		 * @author Nicolas Buisson
		 */
		@Then("It shall be {string}'s turn")
		public void ItShallBePlayerTurn(String player) {
			gamePosition = QuoridorApplication.getQuoridor().getCurrentGame().getCurrentPosition();
			if(gamePosition.getPlayerToMove().equals(QC.getBlackPlayer())) {
				gamePosition.getPlayerToMove().getUser().setName("black");
				gamePosition.getPlayerToMove().getNextPlayer().getUser().setName("white");
			}else {
				gamePosition.getPlayerToMove().getUser().setName("white");
				gamePosition.getPlayerToMove().getNextPlayer().getUser().setName("black");
			}
			assertEquals(player, gamePosition.getPlayerToMove().getUser().getName());

		}
		/**  
		 * @author Nicolas Buisson
		 */
		@And ("{string} shall be at {int}:{int}")
		public void PlayerShallBeAtRowCol(String player, int p_row, int p_col) {
			Player black = QuoridorApplication.getQuoridor().getCurrentGame().getBlackPlayer();
			Player white = QuoridorApplication.getQuoridor().getCurrentGame().getWhitePlayer();

			if(black.getUser().getName().equals(player)) {
				assertEquals(p_row, gamePosition.getBlackPosition().getTile().getRow());
				assertEquals(p_col, gamePosition.getBlackPosition().getTile().getColumn());
			}
			else if(white.getUser().getName().equals(player)){
				assertEquals(p_row, gamePosition.getWhitePosition().getTile().getRow());
				assertEquals(p_col, gamePosition.getWhitePosition().getTile().getColumn());
			} else {
				fail("Issue setting up test!");
			}
		}

		/**  
		 * @author Nicolas Buisson
		 */
		@And ("{string} shall have a vertical wall at {int}:{int}")
		public void PlayerShallHaveAVerticalWallAtRowCol(String player, int pw_row, int pw_col) {
			Player black = QuoridorApplication.getQuoridor().getCurrentGame().getBlackPlayer();
			Player white = QuoridorApplication.getQuoridor().getCurrentGame().getWhitePlayer();

			if(black.getUser().getName().equals(player)) {
				assertEquals(Direction.Vertical, gamePosition.getBlackWallsOnBoard(blackWallsPlacedCounter).getMove().getWallDirection());
				assertEquals(pw_row, gamePosition.getBlackWallsOnBoard(blackWallsPlacedCounter).getMove().getTargetTile().getRow());
				assertEquals(pw_col, gamePosition.getBlackWallsOnBoard(blackWallsPlacedCounter).getMove().getTargetTile().getColumn());
				blackWallsPlacedCounter++; //increment counter after placing wall
			}else if (white.getUser().getName().equals(player)) {
				assertEquals(Direction.Vertical, gamePosition.getWhiteWallsOnBoard(whiteWallsPlacedCounter).getMove().getWallDirection());
				assertEquals(pw_row, gamePosition.getWhiteWallsOnBoard(whiteWallsPlacedCounter).getMove().getTargetTile().getRow());
				assertEquals(pw_col, gamePosition.getWhiteWallsOnBoard(whiteWallsPlacedCounter).getMove().getTargetTile().getColumn());
				whiteWallsPlacedCounter++; //increment counter after placing wall
			}else {
				fail("Issue setting up test!");
			}
		}

		/**  
		 * @author Nicolas Buisson
		 */
		@And ("{string} shall have a horizontal wall at {int}:{int}")
		public void PlayerShallHaveAHorizontalWallAtRowCol(String player, int pw_row, int pw_col) {

			Player black = QuoridorApplication.getQuoridor().getCurrentGame().getBlackPlayer();
			Player white = QuoridorApplication.getQuoridor().getCurrentGame().getWhitePlayer();

			if(black.getUser().getName().equals(player)) {
				assertEquals(Direction.Horizontal, gamePosition.getBlackWallsOnBoard(blackWallsPlacedCounter).getMove().getWallDirection());
				assertEquals(pw_row, gamePosition.getBlackWallsOnBoard(blackWallsPlacedCounter).getMove().getTargetTile().getRow());
				assertEquals(pw_col, gamePosition.getBlackWallsOnBoard(blackWallsPlacedCounter).getMove().getTargetTile().getColumn());
				blackWallsPlacedCounter++;
			}else if (white.getUser().getName().equals(player)) {
				assertEquals(Direction.Horizontal, gamePosition.getWhiteWallsOnBoard(whiteWallsPlacedCounter).getMove().getWallDirection());
				assertEquals(pw_row, gamePosition.getWhiteWallsOnBoard(whiteWallsPlacedCounter).getMove().getTargetTile().getRow());
				assertEquals(pw_col, gamePosition.getWhiteWallsOnBoard(whiteWallsPlacedCounter).getMove().getTargetTile().getColumn());
				whiteWallsPlacedCounter++;
			}else {
				fail("Issues setting up test!");
			}
		}

		/**  
		 * @author Nicolas Buisson
		 */
		@And ("Both players shall have {int} in their stacks")
		public void BothPlayersShallHaveRemainingWallsInTheirStacks(int remaining_walls) { 
			assertEquals(remaining_walls, gamePosition.getWhiteWallsInStock().size());
			assertEquals(remaining_walls, gamePosition.getBlackWallsInStock().size());
		}

		// *********************************************
		//Load invalid position scenario
		// *********************************************

		/**  
		 * @author Nicolas Buisson
		 */
		@And ("The position to load is invalid")
		public void ThePositionToLoadIsInvalid() {
			assertNotNull(thrownException);
			//assertEquals(false, valid);
		}

		/**  
		 * @author Nicolas Buisson
		 */
		@Then("The load shall return an error")
		public void TheLoadShallReturnAnError() {
			assertNotNull(thrownException);
		}
	}

