package ca.mcgill.ecse223.quoridor.controller;

import ca.mcgill.ecse223.quoridor.model.*;

public class QuoridorController {
	
	/**
	 * Method - initializeNewGame(Quoridor quoridor)
	 * 
	 * This method, according to the Gherkin definition, should initialize a new
	 * game in the Quoridor object It should perform the following: 
	 * 1. Set a name to White and Black Players 
	 * 2. Set the total thinking time to both players
	 * 
	 * @param game - Game to start
	 * @author Tristan Bouchard
	 */
	public static void initializeNewGame(Quoridor quoridor) throws Exception {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Method: startClock(Game game)
	 * This method, according to the Gherkin specification files, should:
	 * 1. Run the game
	 * 2. Initialize the board
	 * @param game
	 * @throws Exception
	 * @author Tristan Bouchard
	 */
	public static void startClock(Game game) throws Exception {
		throw new UnsupportedOperationException();
	}
	/**
	 * Method - initializeBoard(Board board)
	 * 
	 * This method, based on the Gherkin definition, should initialize the game
	 * board for the game to be played. It should:
	 * 1. Set the current player to white player
	 * 2. Set both pawns to their initial position
	 * 3. Set all of the players walls to their stock
	 * 4. Start the white player's clock
	 * @param board - Board to initialize
	 * @throws Exception
	 * @author Tristan Bouchard
	 */
	public static void initializeBoard(Board board) throws Exception{
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Method that initializes the Validation of the position
	 * @param PawnPosition
	 * @throws UnsupportedOperationException
	 * @author Alexander Legouverneur
	 */
	public static boolean InitializeValidatePosition(int row, int col) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Method that validates the new pawn position and returns it as its new position
	 * @param newPos
	 * @throws UnsupportedOperationException
	 * @author Alexander Legouverneur
	 */
	public static String ValidatePawnPosition(int row, int col) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
	/**
	 * Method that initiates the validation of the position
	 * @param wallPos
	 * @param Walldir
	 * @return true/false true for initialized validation
	 * @throws UnsupportedOperationException
	 * @author Alexander Legouverneur
	 */
	public static boolean InitiatePosValidation(Tile wallPos, Direction Walldir) throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Method that returns the direction of the wall after validation
	 * @param aWall
	 * @return direction -of the wall
	 * @throws UnsupportedOperationException
	 * @author Alexander Legouverneur
	 */
	public static Direction ValidateWallDirection(Wall aWall ) throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Returns the Tile of reference of the wall after the position is validated
	 * @param aWall
	 * @return Tile -where the wall starts
	 * @throws UnsupportedOperationException
	 */
	public static Tile ValidateWallTile(int row, int col ) throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}
	
	/**
	 * This method verifies if the given wall exists
	 * @param wallPos
	 * @param Walldir
	 * @return true/false -true for existing
	 * @throws UnsupportedOperationException
	 * @author Alexander Legouverneur
	 */
	public static boolean CheckWallExist(Tile wallPos, Direction Walldir) throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Method that checks if wall Position is valid
	 * @param aWall
	 * @return true/false
	 * @throws UnsupportedOperationException
	 * @author Alexander Legouverneur
	 */
	public static boolean CheckWallValid(Wall aWall) throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}
	
//end of validate position
	/**
	 * Checks if the wall is on the side edge of the board
	 * @param aWall
	 * @return true/false -true if on side edge
	 * @throws UnsupportedOperationException
	 * @author Alexander Legouverneur
	 */
	public static boolean CheckWallSideEdge(Wall aWall) throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}
}
