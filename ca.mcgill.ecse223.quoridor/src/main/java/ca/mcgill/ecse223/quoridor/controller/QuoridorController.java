package ca.mcgill.ecse223.quoridor.controller;

import java.sql.Time;

import ca.mcgill.ecse223.quoridor.QuoridorApplication;
import ca.mcgill.ecse223.quoridor.model.*;

public class QuoridorController {

	/**
	 * Method - initializeNewGame(Quoridor quoridor)
	 * 
	 * This method, according to the Gherkin definition, should initialize a new
	 * game in the Quoridor object It should perform the following: 1. Set a name to
	 * White and Black Players 2. Set the total thinking time to both players
	 * 
	 * @param quoridor - Quoridor in which to start new game
	 * @author Tristan Bouchard
	 */
	public static void initializeNewGame(Quoridor quoridor) throws Exception {
		throw new UnsupportedOperationException();
	}

	/**
	 * Method: startClock(Game game) This method, according to the Gherkin
	 * specification files, should: 1. Run the game 2. Initialize the board
	 * 
	 * @param game
	 * @throws Exception
	 * @author Tristan Bouchard
	 */
	public static void startClock(Game game) throws Exception {
		throw new UnsupportedOperationException();
	}

	/**
	 * Method - initializeBoard(Quoridor quoridor)
	 * 
	 * This method, based on the Gherkin definition, should initialize the game
	 * board for the specified quoridor. It should: 1. Set the current player to
	 * white player 2. Set both pawns to their initial position 3. Set all of the
	 * players walls to their stock 4. Start the white player's clock
	 * 
	 * @param board - Board to initialize
	 * @throws Exception
	 * @author Tristan Bouchard
	 */

	public static void initializeBoard(Board board) throws Exception {
		throw new UnsupportedOperationException();
	}

	// 5:30
	// when using Time class [[January 1st 1970]] 00:05:30 
	public static void setThinkingTime(int min, int sec) throws Exception {
		throw new UnsupportedOperationException();
	}
	
	public static void selectExistingUserName(String username) throws Exception {
		throw new UnsupportedOperationException();
	}

	public static void selectNewUserName(String username) throws Exception {
		throw new UnsupportedOperationException();
	}

	/**
	 * Modifier method used to set the name of the white player
	 * 
	 * @param name
	 * @return true if name is set correctly, false otherwise
	 * @author Tristan Bouchard
	 */
	public static Boolean setWhitePlayerUserName(String name) {
		if (!ControllerUtilities.isUserNameValid(name)) {
			return false;
		}
		Player p = getWhitePlayer();
		p.getUser().setName(name);

		return true;
	}

	/**
	 * Modifier method used to set the name of the black player
	 * 
	 * @param name
	 * @return true if name is set correctly, false otherwise
	 * @author Tristan Bouchard
	 */
	public static Boolean setBlackPlayerUserName(String name) {
		if (!ControllerUtilities.isUserNameValid(name)) {
			return false;
		}
		Player p = getBlackPlayer();
		p.getUser().setName(name);
		return true;

	}

	/**
	 * Query method to obtain the white player from the current game
	 * 
	 * @return
	 * @author Tristan Bouchard
	 */
	public static Player getWhitePlayer() {
		return QuoridorApplication.getQuoridor().getCurrentGame().getWhitePlayer();
	}

	/**
	 * Query method to obtain the black player from the current game
	 * 
	 * @return
	 * @author Tristan Bouchard
	 */
	public static Player getBlackPlayer() {
		return QuoridorApplication.getQuoridor().getCurrentGame().getBlackPlayer();
	}

	/**
	 * Modifier method used to set the thinking time for both players
	 * 
	 * @param thinkingTime
	 * @return
	 * @author Tristan Bouchard
	 */
	public static Boolean setTotalThinkingTime(long thinkingTime) {
		if (thinkingTime < 0) {
			return false;
		}
		Boolean successWhite = setWhitePlayerThinkingTime(thinkingTime);
		Boolean successBlack = setBlackPlayerThinkingTime(thinkingTime);
		return successBlack && successWhite;
	}

	/**
	 * Modifier method used to set the thinking time for black player
	 * 
	 * @param thinkingTime
	 * @return
	 * @author Tristan Bouchard
	 */
	public static Boolean setBlackPlayerThinkingTime(long thinkingTime) {
		Player playerBlack = QuoridorApplication.getQuoridor().getCurrentGame().getBlackPlayer();
		if (thinkingTime < 0) {
			return false;
		}
		Boolean success = playerBlack.setRemainingTime(new Time(thinkingTime));
		return success;
	}

	/**
	 * Modifier method used to set the thinking time for white player
	 * 
	 * @param thinkingTime
	 * @return
	 * @author Tristan Bouchard
	 */
	public static Boolean setWhitePlayerThinkingTime(long thinkingTime) {
		Player playerWhite = QuoridorApplication.getQuoridor().getCurrentGame().getWhitePlayer();
		if (thinkingTime < 0) {
			return false;
		}
		Boolean success = playerWhite.setRemainingTime(new Time(thinkingTime));
		return success;
	}
	
	/**
	 * Query method used to verify the correct initialization of the board
	 * @return
	 * @author Tristan Bouchard
	 */
	public static Boolean verifyBoardInitialization() {
		Board board = QuoridorApplication.getQuoridor().getBoard();
		// Verify number of tiles
		Boolean correctNumberOfTiles = ( board.getTiles().size() == ControllerUtilities.TOTAL_NUMBER_OF_TILES );

		// Verify the indices of the tiles only if the total size is correct
		Boolean correctTileIndexing = true;
		for (int row = 0; row < ControllerUtilities.TOTAL_NUMBER_OF_ROWS; row++) {
			for (int col = 0; col < ControllerUtilities.TOTAL_NUMBER_OF_COLS; col++) {
				// Obtain tile in the list and verify that the indices are correct
				int index = ((ControllerUtilities.TOTAL_NUMBER_OF_COLS) * (row) + (col));
				Tile currentTile = board.getTile(index);
				correctTileIndexing = correctTileIndexing && (row == currentTile.getRow());
				correctTileIndexing = correctTileIndexing && (col == currentTile.getColumn());
			}
		}
		return correctNumberOfTiles && correctTileIndexing;
	}
	
	

}
