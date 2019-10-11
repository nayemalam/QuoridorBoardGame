package ca.mcgill.ecse223.quoridor.controller;

/**
 * Class used to group together common utilities and constants used by the application controller methods.
 * @author Tristan Bouchard
 *
 */
public class ControllerUtilities {
	
	
	// ***************************************
	// Constants
	public static final int TOTAL_NUMBER_OF_TILES = 81;
	public static final int TOTAL_NUMBER_OF_ROWS = 9;
	public static final int TOTAL_NUMBER_OF_COLS = 9;
	public static final int WHITE_TILE_INDEX = 36;
	public static final int BLACK_TILE_INDEX = 44;
	public static final int TOTAL_WALL_STOCK_AT_START = 10;
	// ***************************************
	
	// ***************************************
	// Helper methods
	// ***************************************
	
	/**
	 * Method to verify the validity of a selectedUsername.
	 * 
	 * @param userName - Name to verify
	 * @author Tristan Bouchard
	 */
	public static Boolean isUserNameValid(String userName) {
		userName = userName.trim();
		return (userName != null && !userName.isEmpty() && !userName.equals(""));
	}
}
