package ca.mcgill.ecse223.quoridor.features;

import static org.junit.Assert.fail;

import ca.mcgill.ecse223.quoridor.model.User;

class HelperMethods {
	
	
	// ***************************************
	// Constants
	public static final int TOTAL_NUMBER_OF_TILES = 81;
	public static final int TOTAL_NUMBER_OF_ROWS = 9;
	public static final int TOTAL_NUMBER_OF_COLS = 9;
	public static final int WHITE_TILE_INDEX = 36;
	public static final int BLACK_TILE_INDEX = 44;
	// ***************************************
	
	public static void validateUser(User user) {
		if(user.equals(null)) {
			fail();
		}
		if (!isUserNameValid(user.getName())) {
			fail();
		}
	}
	/**
	 * Method to verify the validity of a selectedUsername.
	 * @param userName - Name to verify
	 */
	public static Boolean isUserNameValid(String userName) {
		userName = userName.trim();
		return (userName != null && !userName.isEmpty() && !userName.equals("") );
	}
}
